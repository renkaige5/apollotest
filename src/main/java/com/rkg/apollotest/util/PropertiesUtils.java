package com.rkg.apollotest.util;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

import java.util.Properties;

public class PropertiesUtils {
    private static final String COMMON = "nova1.NovaCommon";
    public static Properties properties = new Properties();

    static {
        Config commonConfig = ConfigService.getConfig(COMMON);
        if (commonConfig != null) {
            for (String key : commonConfig.getPropertyNames()) {
                properties.setProperty(key, commonConfig.getProperty(key, null));
            }
        }
    }


}
