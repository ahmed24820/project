package com.example.BookShop.Services;

import com.example.BookShop.Exceptions.FileStorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {
     Logger log =LoggerFactory.getLogger(FileService.class);

     private Path filestoragelocation;

        private final String basePath="E:\\book\\roo";


    public String storeFile(File file, Long id, String pathType) {

        // create uploaded path
        this.filestoragelocation = Paths.get(basePath + pathType).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.filestoragelocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
                    ex);
        }

        String fileName = StringUtils.cleanPath(id + "-" + file.getName());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.filestoragelocation.resolve(fileName);
            InputStream targetStream = new FileInputStream(file);
            Files.copy(targetStream, targetLocation, StandardCopyOption.REPLACE_EXISTING);

         //   updateImagePath(id, pathType, pathType + "/" + fileName);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }



    public File MultiFileConverter(MultipartFile multipartFile) throws FileNotFoundException {
       final File file=new File(multipartFile.getOriginalFilename());
        try (final FileOutputStream outputStream=new FileOutputStream(file))
        {
                outputStream.write(multipartFile.getBytes());
       } catch (IOException e) {
         log.error("there is an error happen >>"+e.getMessage());
        }
           return file;
         }
}
