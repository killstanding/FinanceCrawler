package com.jerry.financecrawler.commons;

/**
 * Created by Jerry on 2015/10/12.
 */
public class StringUtil {

    public static final String SYMBOL_ASTERISK = "*";
    public static final String SYMBOL_QUESTION_MARK = "?";
    public static final String SYMBOL_PERCENT = "%";
    public static final String SYMBOL_WRAP = "\n";





    public static String filterSymbol(String str,String symbol){
        return str.replace(symbol, "");
    }

    public static String filterAllSymbol(String str){
        String result = str.replace(SYMBOL_ASTERISK , "");
        result = result.replace(SYMBOL_WRAP , "");
        return result.replace(SYMBOL_PERCENT, "");
    }

    public static double StringToDouble(String str) throws ClassCastException{

        return Double.parseDouble(str);
    }
}
