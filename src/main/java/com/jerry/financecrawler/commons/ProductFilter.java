package com.jerry.financecrawler.commons;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 15/11/9.
 */
public class ProductFilter {

    public static final List<String> typeList = new ArrayList<String>(); //类型集合
    public static final List<String> nameList = new ArrayList<String>(); //类型集合
    static{
        //typeList
        typeList.add("套利型");
        typeList.add("市场中性");
        typeList.add("量化对冲");
        //nameList
        nameList.add("量化");
        nameList.add("对冲");
        nameList.add("阿尔法");
        nameList.add("CTA");
        nameList.add("高频");
        nameList.add("套利");
        nameList.add("alpha");
        nameList.add("程序化");
    }

    //过滤type
    public static Boolean filterType(String type){
        boolean result = false;
        if(!StringUtil.isEmpty(type)){
            for (int i = 0; i < nameList.size(); i++) {
                String midName = nameList.get(i);
                if(type.toUpperCase().indexOf(midName.toUpperCase()) != -1){
                    result = true;
                    break;
                }
            }
            if(result == false) result = typeList.contains(type);
        }
        return result;
    }

    public static boolean filterName(String name){
        boolean result = false;
        if(!StringUtil.isEmpty(name)){
            for (int i = 0; i < nameList.size(); i++) {
                String midName = nameList.get(i);
                if(name.toUpperCase().indexOf(midName.toUpperCase()) != -1){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean filter(String type, String name){
        boolean result = false;
        if(filterType(type)) result = true;
        if(filterName(name)) result = true;
        return result;
    }
}
