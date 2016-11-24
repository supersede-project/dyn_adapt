package cz.zcu.yafmt.clang;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * Registry containing descriptors of all constraint language extensions.
 * 
 * @author Jan Pikl
 */
public class ConstraintLanguageRegistry {

    private static final String EXTENSION_POINT_ID = "cz.zcu.yafmt.clang";

    private Map<String, ConstraintLanguageDescriptor> registry = new HashMap<String, ConstraintLanguageDescriptor>();

    public ConstraintLanguageRegistry() {
        for(IConfigurationElement element: Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID)) {
            try {
                ConstraintLanguageDescriptor descriptor = new ConstraintLanguageDescriptor(element);
                registry.put(descriptor.getId(), descriptor);
            }
            catch(Exception ex) {
                ConstraintLanguagePlugin.getDefault().logError("Invalid " + EXTENSION_POINT_ID + " extension point element.", ex);
            }
        }
    }

    public Collection<ConstraintLanguageDescriptor> getDescriptors() {
        return Collections.unmodifiableCollection(registry.values());
    }

    public ConstraintLanguageDescriptor getDescriptor(String id) {
        return registry.get(id);
    }

    public IConstraintLanguage getLanguage(String id) {
        ConstraintLanguageDescriptor descriptor = registry.get(id);
        return (descriptor == null) ? null : descriptor.getLanguage();
    }

}
