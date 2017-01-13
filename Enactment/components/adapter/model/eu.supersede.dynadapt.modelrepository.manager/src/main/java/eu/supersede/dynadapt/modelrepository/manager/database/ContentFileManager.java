package eu.supersede.dynadapt.modelrepository.manager.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import eu.supersede.dynadapt.modelrepository.model.IModel;

public class ContentFileManager implements IContentFileManager {

	private String storagePath;
	
	public ContentFileManager(String modelStorageRootPath) {
		this.storagePath = modelStorageRootPath;
	}

	@Override
	public String saveModelContent(IModel model) throws Exception {
		String path = generatePath(model);
		File file = new File(path);
		file.getParentFile().mkdirs();
		if (!file.exists()) file.createNewFile();
		try(PrintWriter out = new PrintWriter(file)) {
				out.println( model.getValue("modelContent") );
		}
		return path;
	}

	@Override
	public String loadModelContent(IModel model) throws Exception {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(generatePath(model)));
		} catch (FileNotFoundException e) {
			return null;
		}
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	            if (line != null) sb.append("\n");
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}

	@Override
	public void deleteModelContent(IModel model) throws Exception {
		File file = new File(generatePath(model));
		file.delete();
	}

	private String generatePath(IModel model) throws Exception {
		String path = storagePath 
				+ "/" + model.getClass().getSimpleName()
				+ "/" + model.getValue("systemId");
		String fileName = model.getValue("id") + model.getValue("fileExtension");
		return path + "/" + fileName;
	}
	
	
	
}
