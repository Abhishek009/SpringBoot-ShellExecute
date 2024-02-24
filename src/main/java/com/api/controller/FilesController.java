package com.api.controller;

import com.api.model.SourceCountry;
import com.api.service.FileService;
import com.api.service.FilesStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@CrossOrigin
public class FilesController {
    @Autowired
    FilesStorageService storageService;

    @Autowired
    FileService fileService;



    @PostMapping("/upload")
    public ResponseEntity<HttpStatus> uploadFile(@RequestParam("OAFile") MultipartFile OAFile,@RequestParam("HdfsFile") MultipartFile HdfsFile) {
        String message = "";
        try {
            storageService.save(OAFile);
            storageService.save(HdfsFile);
            message = "Uploaded the file successfully: " + OAFile.getOriginalFilename();
            System.out.println(message);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            message = "Could not upload the file: " + OAFile.getOriginalFilename() + ". Error: " + e.getMessage();
            System.out.println(message);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    //Execute shell script
    @PostMapping("/executeshell")
    public ResponseEntity executeShell(@RequestBody SourceCountry sourceCountry) {
        System.out.println(sourceCountry.getSourceCountry());
        System.out.println(sourceCountry.getSmName());
        System.out.println(sourceCountry.getSquadName());
        Boolean status=false;
        try {
            fileService.executeShell();
            status=true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(status){
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }

    }

}
