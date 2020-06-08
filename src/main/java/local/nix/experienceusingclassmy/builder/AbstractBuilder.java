package local.nix.experienceusingclassmy.builder;

import local.nix.experienceusingclassmy.util.BundleUtil;

import java.util.Map;

public interface AbstractBuilder {

    default Map<String, String> getKeyValueMapByBundleProperties(String lang) {
        return BundleUtil.getBundleProperties(lang);
    }

    void buildDataList();
}
