package cz.zcu.yafmt.ui.util;

import org.eclipse.jface.dialogs.IDialogSettings;

public class SettingsUtil {

    public static boolean getBoolean(IDialogSettings settings, String key, boolean defaultValue) {
        if(settings.get(key) == null)
            return defaultValue;
        return settings.getBoolean(key);
    }

    public static int getInteger(IDialogSettings settings, String key, int defaultValue) {
        try {
            return settings.getInt(key);
        }
        catch(NumberFormatException ex) {
            return defaultValue;
        }
    }

    public static String getString(IDialogSettings settings, String key, String defaultValue) {
        String value = settings.get(key);
        return (value != null) ? value : defaultValue;
    }

}
