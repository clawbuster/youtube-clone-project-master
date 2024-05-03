package com.programming.techie.youtubeclone.services;

import org.springframework.web.multipart.MultipartFile;

public interface fileService {
    String uploadFile(MultipartFile file);
}
