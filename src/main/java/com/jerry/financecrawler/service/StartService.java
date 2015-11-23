package com.jerry.financecrawler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Jerry on 2015/9/18.
 */
public class StartService {
    private static final Logger log = LoggerFactory.getLogger(StartService.class);

    public static void main(String[] args) throws Exception {
        //os.name:Mac OS X
        //os.name:Windows Vista
        //String osName = System.getProperties().getProperty("os.name");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext*.xml");
        log.info("服务已经正常启动...");
    }
}