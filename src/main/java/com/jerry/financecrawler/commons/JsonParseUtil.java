package com.jerry.financecrawler.commons;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jerry on 15/12/3.
 */
public class JsonParseUtil {

    public static Double getDouble(JSONObject obj, String key){
        Double d;
        try {
            d = obj.getDouble(key);
        } catch (JSONException e) {
            d = 0d;
        }
        return d;
    }
}
