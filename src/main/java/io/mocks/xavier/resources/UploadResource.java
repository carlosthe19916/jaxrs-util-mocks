package io.mocks.xavier.resources;

import io.mocks.xavier.ReportEvent;
import io.mocks.xavier.ReportEventType;
import io.mocks.xavier.ReportRegistry;
import io.mocks.xavier.model.Report;
import org.apache.commons.io.IOUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

@Path("/api/xavier/upload")
public class UploadResource {

    @ConfigProperty(name = "upload.dir")
    Optional<String> uploadDir;

    @Inject
    ReportRegistry registry;

    @Inject
    @ReportEvent(value = ReportEventType.ADDED)
    Event<Report> addedEvent;

    private File getUploadDir(String fileName) {
        java.nio.file.Path path;
        if (uploadDir.isPresent()) {
            path = Paths.get(uploadDir.get());
        } else {
            String home = System.getProperty("user.home");
            path = Paths.get(home).resolve(".uploads");
        }

        if (!path.toFile().exists()) {
            boolean mkdirs = path.toFile().mkdirs();
        }

        return path.resolve(fileName).toFile();
    }

    private void writeFile(byte[] fileContent, String filename) throws IOException {
        File file = getUploadDir(filename);

        if (!file.exists()) {
            boolean newFile = file.createNewFile();
        }

        FileOutputStream fop = new FileOutputStream(file);

        fop.write(fileContent);
        fop.flush();
        fop.close();
    }

    @POST
    @Consumes("multipart/form-data")
    public Response uploadFile(MultipartFormDataInput input) {
        String fileName = "";

        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> fileInputParts = uploadForm.get("file");

        for (InputPart inputPart : fileInputParts) {
            try {
                MultivaluedMap<String, String> header = inputPart.getHeaders();
                fileName = getFileName(header);

                InputStream is = inputPart.getBody(InputStream.class, null);
                byte[] bytes = IOUtils.toByteArray(is);

                writeFile(bytes, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



        Report report = new Report();
        report.setCustomerId("111111");
        report.setFileName(fileName);
        report.setNumberOfHosts(new Random().nextLong());
        report.setTotalDiskSpace(new Random().nextLong());
        report.setTotalPrice(new Random().nextLong());
        report.setCreationDate(new Date().getTime());

        registry.addReport(report);
        addedEvent.fire(report);


        return Response.status(200).build();
    }

    private String getFileName(MultivaluedMap<String, String> header) {

        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");

                return name[1].trim().replaceAll("\"", "");
            }
        }
        return "unknown";
    }
}
