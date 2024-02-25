package com.api.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class FilesStorageService {

    private final Path root = Paths.get("uploads");


    public void save(MultipartFile file) {
        try {
            System.out.println("File Name:"+file.getOriginalFilename());


            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()),REPLACE_EXISTING);
            System.out.println("Uploaded the file successfully:"+file.getOriginalFilename());
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }
}
