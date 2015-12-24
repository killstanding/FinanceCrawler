package com.jerry.financecrawler.commons;


import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.InputTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 * Created by Jerry on 15/12/4.
 */
public class HtmlParserUtil {

    public static NodeList filterTargetNode(String html,String charset,String property, String key) throws ParserException {
        Parser parser = new Parser();
        parser.setResource(html);
        parser.setEncoding(charset);
        NodeFilter filter = new HasAttributeFilter(property, key);
        NodeList nodes = parser.extractAllNodesThatMatch(filter);
        return nodes;
    }

    public static NodeList filterTargetNode(String html,String charset,String key) throws ParserException {
        Parser parser = new Parser();
        parser.setResource(html);
        parser.setEncoding(charset);
        NodeFilter filter = new TagNameFilter(key);
        NodeList nodes = parser.extractAllNodesThatMatch(filter);
        return nodes;
    }


    public static NodeList filterNode(Node node, String key){
        NodeList nodes = new NodeList();
        NodeFilter filter = new TagNameFilter(key);
        node.collectInto(nodes, filter);
        return nodes;
    }
    public static NodeList filterNode(Node node,String property, String key){
        NodeList nodes = new NodeList();
        NodeFilter filter = new HasAttributeFilter(property, key);
        node.collectInto(nodes, filter);
        return nodes;
    }


    public static String getPlainTextString(Node node){
        String val = node.toPlainTextString();
        String fVal = StringUtil.filterAllSymbol(val).trim();//过滤特殊符号
        return fVal;
    }

    public static String getPlainTextStringWithoutFilter(Node node){
        String val = node.toPlainTextString();
        String fVal =val.trim();
        return fVal;
    }



    public static String getInputAttribute(Node node, String key){
        InputTag inputTag = (InputTag)node;
        String value = inputTag.getAttribute(key);
        return value;
    }

    public static String getLinkAttribute(Node node, String key){
        LinkTag inputTag = (LinkTag)node;
        String value = inputTag.getAttribute(key);
        return value;
    }


}
