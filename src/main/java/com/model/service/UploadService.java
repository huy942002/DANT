package com.model.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;

@Service
public interface UploadService {
    File save(MultipartFile file) ;

    Resource loadAsResource(String filename);

    Path load(String filename);
}
