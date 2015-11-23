package com.jerry.financecrawler.commons;

import java.util.Date;

/**
 * Created by Jerry on 2015/10/9.
 */
public class IdTools {

    /**
     * 通过时间截取11位数字id
     * @return
     */
    public static int getID(){
        Date now = new Date();
        long l = now.getTime();
        String str = l + "";
        int  id = Integer.parseInt(str.substring(5));
        return id;
    }
}
