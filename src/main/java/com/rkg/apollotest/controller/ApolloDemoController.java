package com.rkg.apollotest.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.rkg.apollotest.util.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;
import java.util.Set;

@RestController
@RequestMapping("/apollo")
public class ApolloDemoController {
    private static Logger logger = LoggerFactory.getLogger(ApolloDemoController.class);
    /**
     * 从apollo获取配置信息
     */
    @ApolloConfig
    private Config config;

    @GetMapping("/read_demo")
    public Properties apolloReadDemo() {
        /**
         * 得到当前app.id中的配置
         * */
        Set<String> set = config.getPropertyNames();
        for (String key : set) {
            PropertiesUtils.properties.setProperty(key, config.getProperty(key, null));
        }
        for (String key : PropertiesUtils.properties.stringPropertyNames()) {
            System.out.println(key + ">>>" + PropertiesUtils.properties.getProperty(key));
        }
        return PropertiesUtils.properties;
    }


    @GetMapping("abc")
    public String hi(String name) {

        logger.debug("debug log...");
        logger.info("info log...");
        logger.warn("warn log...");

        return "hi " + name + " ,i am from port:" ;
    }

}
