package com.api.controller;

import com.api.repository.FileInfoRepository;
import com.api.service.FilesStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
public class FilesController {
    @Autowired
    FilesStorageService storageService;

    @Autowired
    FileInfoRepository fileInfoRepository;

    @PostMapping("/upload")
    public ResponseEntity<HttpStatus> uploadFile(@RequestParam("OAFile") MultipartFile OAFile,@RequestParam("HdfsFile") MultipartFile HdfsFile) {
        String message = "";
        try {
            storageService.save(OAFile);
            storageService.save(HdfsFile);
            message = "Uploaded the file successfully: " + OAFile.getOriginalFilename();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            message = "Could not upload the file: " + OAFile.getOriginalFilename() + ". Error: " + e.getMessage();
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
