package com.eafrey.backend.controller;

import com.eafrey.backend.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class FileUploadApi {

    private final FileUploadService fileUploadService;

    public FileUploadApi(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(Model model, @RequestParam("path") MultipartFile file) {
        try {
            fileUploadService.uploadImage(file);
        } catch (Exception exception) {
//            log.error("image upload failed for: {}", exception.getMessage());
        }
        return ResponseEntity.ok("ok");
    }

}
