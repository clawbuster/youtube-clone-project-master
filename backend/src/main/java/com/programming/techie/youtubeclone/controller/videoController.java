package com.programming.techie.youtubeclone.controller;

import com.programming.techie.youtubeclone.dto.UploadVideoResponse;
import com.programming.techie.youtubeclone.dto.VideoDto;
import com.programming.techie.youtubeclone.services.videoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class videoController {

    @Autowired
    private videoService vidServ;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UploadVideoResponse uploadVideo(@RequestParam("file")MultipartFile file){

        return vidServ.uploadFile(file);

    }

    @PostMapping("/thumbnail")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadThumbnail(@RequestParam("file")MultipartFile file, @RequestParam("videoId") String videoId){

        return vidServ.uploadThumb(file, videoId);

    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public VideoDto editVideoMetaData(@RequestBody VideoDto videoDto) {
        return vidServ.editVideo(videoDto);
    }

    @GetMapping("/{videoId}")
    @ResponseStatus(HttpStatus.OK)
    public VideoDto getVideoDetails(@PathVariable String videoId){
        return vidServ.getVideoDetails(videoId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VideoDto> getAllVideos() {
        return vidServ.getAllVideos();
    }

}
