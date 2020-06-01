package pl.jakub.moskal.SimpleServerApp.service;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ZipServiceImpl implements ZipService {

    private static final String FILE_TYPE = "application/zip";

    @Override
    public boolean saveXmlZip(MultipartFile zip) {
        if (zip.getContentType().equals(FILE_TYPE)) {
            File file = convert(zip);
            try {
                ZipFile zipFile = new ZipFile(file);
                zipFile.extractAll("/home/kuba/studia/up/java sieciowa/test");
            } catch (ZipException e) {
                e.printStackTrace();
            }
        } else
            return false;
        return false;
    }

    private File convert(MultipartFile file) {
        File convFile = new File(file.getOriginalFilename());
        try {
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convFile;
    }
}
