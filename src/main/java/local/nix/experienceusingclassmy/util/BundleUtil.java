package local.nix.experienceusingclassmy.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class BundleUtil {

    private static final ResourceBundle RESOURCE_GUESTS_EN = ResourceBundle.getBundle("guests_en");
    private static final ResourceBundle RESOURCE_GUESTS_RU = ResourceBundle.getBundle("guests_ru");

    public static Map<String, String> getBundleProperties(String lang) {
        return convertResourceBundleToMap(getBundle(lang));
    }

    private static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, resource.getString(key));
        }
        return map;
    }

    private static ResourceBundle getBundle(String lang) {
        if (lang.isBlank() || lang.equals("en")) {
            return RESOURCE_GUESTS_EN;
        } else {
            return RESOURCE_GUESTS_RU;
        }
    }
}
