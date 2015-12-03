package com.jerry.financecrawler.translate.eastmoney;

import com.jerry.financecrawler.commons.CommonsCharset;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.Span;
import org.htmlparser.util.NodeList;
import org.springframework.stereotype.Component;


/**
 * Created by Jerry on 15/12/2.
 */
@Component
public class HtmlToEastMoneyDetailVo {

    public String HtmlToProductCode(String html) throws Exception {
        String product_code = "";
        Parser parser = new Parser();
        parser.setResource(html);
        parser.setEncoding(CommonsCharset.UTF_8);
        NodeFilter filter = new HasAttributeFilter("class", "fcode");
        NodeList spans = parser.extractAllNodesThatMatch(filter);
        if (spans != null && spans.elementAt(0) != null) {
            Span span = (Span) spans.elementAt(0);
            product_code = span.toPlainTextString();
            //System.out.println("product_code = [" + product_code + "]");
        }
        return product_code;
    }
}
