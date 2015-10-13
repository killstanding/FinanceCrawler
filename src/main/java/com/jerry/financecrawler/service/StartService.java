package com.jerry.financecrawler.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Jerry on 2015/9/18.
 */
public class StartService {

    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext*.xml");
        System.out.println("服务已经正常启动...");
    }
}
