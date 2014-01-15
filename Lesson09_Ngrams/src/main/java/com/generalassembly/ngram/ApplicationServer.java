package com.generalassembly.ngram;

import static spark.Spark.*;

import org.apache.commons.fileupload.*;

import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.util.Scanner;

public class ApplicationServer {

    private static final String UPLOADED_FILENAME = "fileselect";
    private static final String RESULTS_TEXT_PARAM_NAME = "text";

    public static void main(String[] args) {

        staticFileLocation("/public");

        post(new Route("/upload") {
            @Override
            public Object handle(Request request, Response response) {
                InputStream fileInputStream = null;
                RequestFileParser parser = new RequestFileParser(UPLOADED_FILENAME);

                try {
                    fileInputStream = parser.parse(request);
                } catch (FileUploadException e) {
                    return "Error parsing uploaded file!";
                } catch (IOException e) {
                    return "Error parsing file contents!";
                }

                Scanner fileScanner = new Scanner(new InputStreamReader(fileInputStream));
                NGramTextGenerator textGenerator = new NGramTextGenerator();
                while (fileScanner.hasNext()) {
                    textGenerator.addWord(fileScanner.next());
                }

                String randomText = textGenerator.randomText();

                try {
                    response.redirect("/results?" + RESULTS_TEXT_PARAM_NAME + "=" + URLEncoder.encode(randomText, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    return "Error URL encoding random text!";
                }

                return null;
            }
        });

        get(new FreeMarkerRoute("/results") {
            @Override
            public Object handle(Request request, Response response) {
                Map<String, Object> attributes = new HashMap<String, Object>();
                Object text = request.queryParams(RESULTS_TEXT_PARAM_NAME);
                attributes.put("responseText", text);
                return modelAndView(attributes, "layout.ftl");
            }
        });
    }
}
