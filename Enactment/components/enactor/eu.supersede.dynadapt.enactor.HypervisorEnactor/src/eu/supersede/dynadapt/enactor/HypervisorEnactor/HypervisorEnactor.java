package eu.supersede.dynadapt.enactor.HypervisorEnactor;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;
import org.junit.Assert;

public class HypervisorEnactor implements IEnactor{
	private final Logger log = LogManager.getLogger(this.getClass());
	private static List<String> arguments = new ArrayList<String>();
	private Path temp = null;
	
	public HypervisorEnactor () throws IOException {
		//Create Temporary directory to store models 
		temp = createTemporaryDirectory();
		
		//Shutdown hook to clean up temporary folder
		Runtime.getRuntime().addShutdownHook(new Thread() {
		    public void run() {
		        try {
		        	if (temp != null){
		        		Files.walk(temp)
		        	    .sorted(Comparator.reverseOrder())
		        	    .map(Path::toFile)
		        	    .peek(System.out::println)
		        	    .forEach(File::delete);
		        	}
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		});
	}
	
	public void serializeVMConfigurationScriptsInFolder (String absoluteHypervisorModelPath, String absoluteTargetFolderPath) throws IOException{
		URI modelURI = URI.createFileURI(absoluteHypervisorModelPath);
		File targetFolder = new File (absoluteTargetFolderPath);
		eu.supersede.dynadapt.enactor.HypervisorEnactor.Main generator = 
			new eu.supersede.dynadapt.enactor.HypervisorEnactor.Main(modelURI, targetFolder, arguments);
		
		generator.doGenerate(new BasicMonitor());
	}

	@Override
	public List<Path> enactAdaptedModel(Model adaptedModel) throws IOException {
		log.debug("Enacting adapted model: " + adaptedModel.getModel().getName());
		
		List<Path> enactedArtefacts = null;
		//Store model in temporary folder for models
		URI adaptedModelURI = saveModelInTemporaryFolder(adaptedModel, ".uml");
		
		//Create a temporary folder for serialization
		Path temporaryFolder = createTemporaryDirectoryInFolder(temp);
		
		//Serialize Hypervisor artifacts  in temporary folder
		serializeVMConfigurationScriptsInFolder (adaptedModelURI.toString(), temporaryFolder.toString());
		
		//Return list of generated artefacts
		enactedArtefacts = findFilesInFolderWithExtension (temporaryFolder, "ps1");
				
		return enactedArtefacts;
	}
	
	@Override
	public List<Path> enactAdaptedModel(Model adaptedModel, Model originalModel) throws IOException {
		//TODO Compute model differences
		Set<Element> diffElements = computeDiffBetweenModels (adaptedModel, originalModel);
		
		//Enact adapted Model
		List<Path> enactedArfifacts = enactAdaptedModel(adaptedModel);
		
		//TODO Select enactment artifacts associated to model differences
		enactedArfifacts = selectDiffArtefacts (enactedArfifacts, diffElements);
		
		return enactedArfifacts;
	}
	
	//TODO Move Model Comparator stuff to ModelManager helper class
	private List<Path> selectDiffArtefacts(List<Path> enactedArfifacts, Set<Element> diffElements) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public Set<Element> computeDiffBetweenModels(Model adaptedModel, Model originalModel) {
		// TODO Compare models traversing elements from root model and comparing element QNames
		Set<Element> inDifferences = compareModels (adaptedModel.getModel(), originalModel.getModel());
		Set<Element> outDifferences = compareModels (originalModel.getModel(), adaptedModel.getModel());
		
		//Reporting
		reportDifferences(inDifferences, outDifferences);
		
		Set<Element> differences = new LinkedHashSet<>();
		differences.addAll(inDifferences);
		differences.addAll(outDifferences);
		
		return differences;
	}

	private void reportDifferences(Set<Element> inDifferences, Set<Element> outDifferences) {
		System.out.println ("Differences in adapted model not occurring in original model");
		for (Element e: inDifferences){
			reportDifference(e);
		}
		
		System.out.println ("Differences in original model not occurring in adapted model");
		for (Element e: outDifferences){
			reportDifference(e);
		}
	}

	private void reportDifference(Element e) {
		if (e instanceof Slot){
			Slot s = (Slot)e;
			System.out.println ("\t Slot: " + s.getDefiningFeature().getName() + " of type: " + s.getDefiningFeature().getType().getName() + " with value " + getValueSpecificationValue (s.getValues().get(0)));
		}else if (e instanceof InstanceSpecification){
			InstanceSpecification ie = (InstanceSpecification)e;
			System.out.println ("\t InstanceSpecification: " + ie.getName() + " of type: " + ie.getClassifiers().get(0).getName());
		}
	}
	
	private String getValueSpecificationValue(ValueSpecification ve) {
		if (ve instanceof InstanceValue){
			return ((InstanceValue)ve).getInstance().getName();
		}else if (ve instanceof LiteralString ){
			return ((LiteralString)ve).getValue();
		}else if (ve instanceof LiteralReal){
			return Double.toString(((LiteralReal)ve).getValue());
		}else if (ve instanceof LiteralInteger){
			return Integer.toString(((LiteralInteger)ve).getValue());
		}else{
			return "";
		}
	}

	private Set<Element> compareModels(Model adaptedModel, Model originalModel) {
		// TODO Compare models traversing elements from root model and comparing element QNames
		Set<Element> diffElements = new LinkedHashSet<>();
		
		for (PackageableElement element: originalModel.getPackagedElements()){
			diffElements.addAll (compareElementInAnotherModelContainer (element, (PackageableElement)adaptedModel));
		}
		
		return diffElements;
	}

	private Collection<? extends Element> compareElementInAnotherModelContainer(NamedElement element,
			Element container) {
		Set<Element> diffElements = new LinkedHashSet<>();
		
		Element elementMatch = matchElementInContainer(element, container);
		
		System.out.println ("Element: " + element.getName() + " of type: " + element.getClass() + (elementMatch!=null?" found ": " not found ") + " in model");
		
		if (elementMatch != null){
			for (Element child: element.getOwnedElements()){
				if (child instanceof NamedElement){
					diffElements.addAll (compareElementInAnotherModelContainer ((NamedElement) child, elementMatch));
				}else if (child instanceof Slot && elementMatch instanceof InstanceSpecification){
					diffElements.addAll (compareSlotInAnotherModelContainer ((Slot) child, (InstanceSpecification)elementMatch));
				}else{
					//FIXME Support comparison of not NamedElemnts
					log.debug("Compare element of type: " + child.getClass());
				}
			}
		}else{ //Found difference
			diffElements.add (element);
		}
		
		return diffElements;
	}

	private Collection<? extends Element> compareSlotInAnotherModelContainer(Slot slot,
			InstanceSpecification instance) {
		Set<Element> diffElements = new LinkedHashSet<>();
		
		Slot slotMatch = matchSlotInInstance(slot, instance);
		
		System.out.println ("Slot " + slot.getDefiningFeature().getName() + (slotMatch!=null?" found ": " not found ") + " in instance: " + instance.getName());
		
		if (slotMatch == null){
			diffElements.add (slot);
		}
		
		return diffElements;
	}

	private Slot matchSlotInInstance(Slot slot, InstanceSpecification instance) {
		Slot found = null;
		for (Slot child: instance.getSlots()){
			if (compareSlot (slot, child)){
				found = child;
				break;
			}
		}
		return found;
	}

	private boolean compareSlot(Slot slot, Slot child) {
		boolean result = false;
		result = compareQName(slot.getDefiningFeature(), child.getDefiningFeature());
		result = result && compareQName(slot.getDefiningFeature().getType(), child.getDefiningFeature().getType());
		result = result && (slot.getValues().size() == child.getValues().size());
		if (slot.getValues().size()>0){
			result = result && compareValues (slot.getValues().get(0), child.getValues().get(0));
		}
		
		return result;
	}

	private boolean compareValues(ValueSpecification iv1, ValueSpecification iv2) {
		if (iv1 instanceof InstanceValue && iv2 instanceof InstanceValue){
			return compareQName(((InstanceValue)iv1).getInstance(), ((InstanceValue)iv2).getInstance());
		}else if (iv1 instanceof LiteralString && iv2 instanceof LiteralString){
			return ((LiteralString)iv1).getValue().equals(((LiteralString)iv2).getValue());
		}else if (iv1 instanceof LiteralReal && iv2 instanceof LiteralReal){
			return ((LiteralReal)iv1).getValue() == (((LiteralReal)iv2).getValue());
		}else if (iv1 instanceof LiteralInteger && iv2 instanceof LiteralInteger){
			return ((LiteralInteger)iv1).getValue() == (((LiteralInteger)iv2).getValue());
		}else{
			return false;
		}
	}

	private Element matchElementInContainer(NamedElement element, Element container) {
		Element found = null;
		for (Element child: container.getOwnedElements()){
			if (child.getClass() != element.getClass()){
				//Disjoint types
				continue;
			}
			if (element instanceof Manifestation){
				log.debug("Required to match a manifestation");
				if (areEquivalentManifestations ((Manifestation)element, (Manifestation)child)){
					found = child;
					break;
				}
					
			}else if (child instanceof NamedElement){
				NamedElement namedChild = (NamedElement) child;
				if (element.getQualifiedName()==null || namedChild.getQualifiedName()==null){
					log.debug ("Trying to match namedElement with a null qualified name. " 
						+ "Element type: " + element.getClass()
						+ "Child type: " + namedChild.getClass());
					continue;
				}
				if (compareQName (element, namedChild)){
					found = child;
					break;
				}
			}
		}
		return found;
	}
	
	private boolean compareQName (NamedElement e1, NamedElement e2){
		String e1QName = e1.getQualifiedName().substring(e1.getQualifiedName().indexOf("::"));
		String e2QName = e2.getQualifiedName().substring(e2.getQualifiedName().indexOf("::"));
		return e1QName.equals(e2QName);
	}

	private boolean areEquivalentManifestations(Manifestation element, Manifestation child) {
		boolean result = false;
		if (element.getSuppliers().size() == child.getSuppliers().size() && element.getSuppliers().size()>0){
			result = compareQName(element.getSuppliers().get(0), child.getSuppliers().get(0));
		}
		result = result && compareQName (element.getUtilizedElement(), child.getUtilizedElement())
				&& compareQName(element.getSuppliers().get(0), child.getSuppliers().get(0));
		return result;
	}

	private List<Path> findFilesInFolderWithExtension(Path temporaryFolder, String extension) throws IOException {
		List<Path> files = new ArrayList<>();
		Files.walkFileTree(temporaryFolder, new SimpleFileVisitor<Path>() { 
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                throws IOException
            {
            	if (file.getFileName().toString().endsWith(extension)){
            		files.add (file);
            	}
                return FileVisitResult.CONTINUE;
            }
        }); 
		return files;
	}

	//FIXME Move common methods to helper class (taken form Model Manager)
	private URI saveModelInTemporaryFolder(Model model, String suffixe) throws IOException {
		if (temp == null){
			temp = createTemporaryDirectory();
		}
		URI uri = createTemporaryURI (model.getName() + suffixe);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(model);
		try {
			resource.save(null); // no save options needed
		} catch (IOException ioe) {
			throw ioe;
		}
		
		return uri;
	}
	
	private Path createTemporaryDirectory() throws IOException{
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir);
		Path temp = Files.createTempDirectory(path, "");
		Assert.assertNotNull("There was a problem creating a temporary directory", temp);
		return temp;
	}
	
	private Path createTemporaryDirectoryInFolder(Path folder) throws IOException{
		Path temp = Files.createTempDirectory(folder, "");
		Assert.assertNotNull("There was a problem creating a temporary directory", temp);
		return temp;
	}
	
	private URI createTemporaryURI (String surl){
		Path file = Paths.get(temp.toString(), surl);
		return URI.createURI(file.toString());
	}


}
