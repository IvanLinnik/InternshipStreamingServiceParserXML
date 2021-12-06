package io.skai.okta.internshipstreamingserviceparserxml.util;

import java.io.IOException;

public class Parser {
    private static final String LINK = "https://www.lostfilm.tv/rss.xml";

    public static void main(String[] args) throws IOException {
        System.out.println(ContentReader.getURLContent(LINK));
    }

}
