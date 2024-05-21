//package com.model.service.impl;
//
//import com.model.service.UploadService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.ServletContext;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//@Service
//public class UploadServiceImpl implements UploadService {
//    private final Path rootLocation;
//
//    @Autowired
//    public UploadServiceImpl(UploadProperties properties) {
//
//        if(properties.getLocation().trim().length() == 0){
//            throw new StorageException("File upload location can not be Empty.");
//        }
//
//        this.rootLocation = Paths.get(properties.getLocation());
//    }
//
//    @Override
//    public void save(MultipartFile file, String folder) {
//        try {
//            if (file.isEmpty()) {
//                throw new StorageException("Failed to store empty file.");
//            }
//            Path destinationFile = this.rootLocation.resolve(
//                            Paths.get(file.getOriginalFilename()))
//                    .normalize().toAbsolutePath();
//            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
//                // This is a security check
//                throw new StorageException(
//                        "Cannot store file outside current directory.");
//            }
//            try (InputStream inputStream = file.getInputStream()) {
//                Files.copy(inputStream, destinationFile,
//                        StandardCopyOption.REPLACE_EXISTING);
//            }
//        }
//        catch (IOException e) {
//            throw new StorageException("Failed to store file.", e);
//        }
//
//
//
//
//
//        if (file.isEmpty()) {
//
//        }
//        try {
//            var fileName = file.getOriginalFilename();
//            var is = file.getInputStream();
//            Files.copy(is, Paths.get("/DANT/src/main/resources/static/assets/"+ folder + "/" + fileName),
//                    StandardCopyOption.REPLACE_EXISTING);
//            File savedFile = new File("/assets/"+ folder, fileName);
//            return savedFile;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
