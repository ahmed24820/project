package com.example.BookShop.Controller;

import com.example.BookShop.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;
    @PostMapping("/upload")
     public ResponseEntity<?>UploadFile(@RequestParam long id, @RequestParam String pathway, @RequestParam MultipartFile multipartFile) throws FileNotFoundException {
        String file=  fileService.storeFile(fileService.MultiFileConverter(multipartFile),id,pathway);
        return ResponseEntity.ok(file);
     }

}
