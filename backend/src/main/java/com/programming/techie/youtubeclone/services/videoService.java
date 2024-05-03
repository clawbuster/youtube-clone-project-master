package com.programming.techie.youtubeclone.services;

import com.programming.techie.youtubeclone.Model.Video;
import com.programming.techie.youtubeclone.dto.UploadVideoResponse;
import com.programming.techie.youtubeclone.dto.VideoDto;
import com.programming.techie.youtubeclone.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class videoService {


    @Autowired
    private s3Service s3service;

    @Autowired
    private VideoRepository vidRepo;

    private VideoDto mapToVideoDto(Video videoById) {
        VideoDto videoDto = new VideoDto();
        videoDto.setVideoUrl(videoById.getVideoUrl());
        videoDto.setThumbnailUrl(videoById.getThumbnailUrl());
        videoDto.setId(videoById.getId());
        videoDto.setTitle(videoById.getTitle());
        videoDto.setDescription(videoById.getDescription());
        videoDto.setTags(videoById.getTags());
        videoDto.setVideoStatus(videoById.getVideoStatus());
//        videoDto.setLikeCount(videoById.getLikes().get());
//        videoDto.setDislikeCount(videoById.getDisLikes().get());
//        videoDto.setViewCount(videoById.getViewCount().get());
        return videoDto;
    }

    public List<VideoDto> getAllVideos() {
        return vidRepo.findAll().stream().map(this::mapToVideoDto).toList();
    }

    public UploadVideoResponse uploadFile(MultipartFile file){

        //upload to aws
        String videoUrl = s3service.uploadFile(file);
        var video = new Video();
        video.setVideoUrl(videoUrl);

        //save vid to db
        var curVid = vidRepo.save(video);
        return new UploadVideoResponse(curVid.getId(), curVid.getVideoUrl());
    }


    public VideoDto editVideo(VideoDto videoDto){
        //get id

        var curVid = getVideoId(videoDto.getId());

        //map the vidDto fields to current video
        curVid.setTitle(videoDto.getTitle());
        curVid.setDescription(videoDto.getDescription());
        curVid.setTags(videoDto.getTags());
        curVid.setThumbnailUrl(videoDto.getThumbnailUrl());
        curVid.setVideoStatus(videoDto.getVideoStatus());

        vidRepo.save(curVid);

        return videoDto;

    }



    Video getVideoId(String vidId){
        return vidRepo.findById(vidId).orElseThrow(()->new IllegalArgumentException("cannot find the video with id: "+vidId));
    }

    public String uploadThumb(MultipartFile file, String vidId) {
        var curVid = getVideoId(vidId);

        //since the uploadFile is a function that does the uploading working of any file type (generic function )
        String thumbUrl = s3service.uploadFile(file);
        curVid.setThumbnailUrl(thumbUrl);
        vidRepo.save(curVid);

        return thumbUrl;
    }

    public VideoDto getVideoDetails(String videoId) {
        Video curVid = getVideoId(videoId);
        VideoDto vidDto = new VideoDto();
        vidDto.setVideoUrl(curVid.getVideoUrl());
        vidDto.setDescription(curVid.getDescription());
        vidDto.setVideoStatus(curVid.getVideoStatus());
        vidDto.setTitle(curVid.getTitle());
        vidDto.setTags(curVid.getTags());
        vidDto.setThumbnailUrl(curVid.getThumbnailUrl());
        vidDto.setId(curVid.getId());

        return vidDto;
    }
}
