package org.bajiepka.testapplication.services.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.io.IOException;
import java.util.Optional;

public abstract class AbstractSiteParser {

    protected final static String TABLE_ROW = "tr";
    private final String url;

    public AbstractSiteParser(String url) {
        this.url = url;
    }

    protected Document getDocument() {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            String message = "Could not connect to site: " + url;
            throw new IllegalStateException(message);
        }
    }

    protected Element getNestedElement(String elementCssQuery, Document document) {
        Element element = document.select(elementCssQuery).first();
        return Optional
                .ofNullable(element)
                .orElseThrow(() -> new IllegalStateException("No nested elements found."));
    }

    protected String getFirstChildTextValue(Element element) {
        Node node = element.childNodes().iterator().next();
        Attribute firstAttribute = node.attributes().iterator().next();
        return firstAttribute.getValue();
    }

    protected String buildDivByIdQuery(String divId) {
        return "div[id=" + divId + "]";
    }
}
