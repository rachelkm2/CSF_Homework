package com.generalassembly.ngram;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import spark.Request;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RequestFileParser {

    private final String fieldName;

    /**
     * @param fieldName The filename to look for in the file (optional)
     */
    public RequestFileParser(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Returns the text of the file attached to the request.
     * @param request The request to be parsed.
     * @return An input stream for the attached file
     * @throws FileUploadException Thrown in the event that the parsing of the file upload request fails.
     * @throws IOException Thrown in the event that the parsing of the file's input stream fails.
     */
    public InputStream parse(Request request) throws FileUploadException, IOException {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload    = new ServletFileUpload(factory);

        if (ServletFileUpload.isMultipartContent(request.raw())) {
            // We hit a multipart POST! Now look for the file that we care about
            List<FileItem> fileList = null;
            fileList = fileUpload.parseRequest(request.raw());

            for (FileItem item : fileList) {
                if (this.fieldName == null || item.getFieldName().equals(this.fieldName)) {
                    return item.getInputStream();
                }
            }
        }
        return null;
    }
}
