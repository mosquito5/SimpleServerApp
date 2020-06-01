package pl.jakub.moskal.SimpleServerApp.service;

import org.springframework.web.multipart.MultipartFile;

public interface ZipService {
    boolean saveXmlZip(MultipartFile zip);
}
