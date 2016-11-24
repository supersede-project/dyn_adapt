package cz.zcu.yafmt.clang;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

/**
 * Descriptor of a constraint language extension.
 * 
 * @author Jan Pikl
 */
public class ConstraintLanguageDescriptor {

    private IConfigurationElement element;

    private String id;
    private String name;
    private String shortName;
    private IConstraintLanguage language;

    public ConstraintLanguageDescriptor(IConfigurationElement element) {
        this.element = element;

        id = element.getAttribute("id");
        if(id == null)
            throw new IllegalArgumentException("Id attribute is missing.");

        name = element.getAttribute("name");
        if(name == null)
            throw new IllegalArgumentException("Name attribute is missing.");

        shortName = element.getAttribute("shortName");
        if(shortName == null)
            shortName = name;

        if(element.getAttribute("class") == null)
            throw new IllegalArgumentException("Class attribute is missing.");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public IConstraintLanguage getLanguage() {
        if(language == null) {
            try {
                language = (IConstraintLanguage) element.createExecutableExtension("class");
            }
            catch(CoreException ex) {
                ConstraintLanguagePlugin.getDefault().logError("Unable to instantiate constraint language class for " + id + ".", ex);
            }
        }

        return language;
    }

}
