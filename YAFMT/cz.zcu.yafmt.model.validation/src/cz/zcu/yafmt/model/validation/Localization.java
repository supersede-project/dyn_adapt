package cz.zcu.yafmt.model.validation;


public class Localization {

    public static String getMessage(String key) {
        return FeatureModelValidationPlugin.INSTANCE.getPluginResourceLocator().getString(key);
    }
    
    public static String getMessage(String key, Object substitution) {
        return getMessage(key, new Object[] { substitution });
    }
    
    public static String getMessage(String key, Object substitution1, Object substitution2) {
        return getMessage(key, new Object[] { substitution1, substitution2 });
    }
    
    public static String getMessage(String key, Object[] substitutions) {
        return FeatureModelValidationPlugin.INSTANCE.getPluginResourceLocator().getString(key, substitutions);
    }
    
}
