package com.programming.techie.youtubeclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UploadVideoResponse {
    private String videoId;
    private String videoUrl;

    public UploadVideoResponse(String id, String vidUrl) {
        this.videoId=id;
        this.videoUrl=vidUrl;
    }
}
