package io.skai.okta.internshipstreamingserviceparserxml.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

class ContentReader {
    private ContentReader() {
    }

    public static String getURLContent(String link) throws IOException {
        URLConnection connection = new URL(link).openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder fileContent = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            fileContent.append(line).append("\n");
        }
        bufferedReader.close();

        return fileContent.toString();
    }

}
