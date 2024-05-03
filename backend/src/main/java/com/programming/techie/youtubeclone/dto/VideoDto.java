package com.programming.techie.youtubeclone.dto;

import com.programming.techie.youtubeclone.Model.Comment;
import com.programming.techie.youtubeclone.Model.VideoStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoDto {


    private String id;
    private String videoUrl;
    private String thumbnailUrl;
    private String description;
    private String title;
    private Set<String> tags;
    private VideoStatus videoStatus;
    private Integer likeCount;
    private Integer dislikeCount;
    private Integer viewCount;

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public void setVideoStatus(VideoStatus videoStatus) {
        this.videoStatus = videoStatus;
    }


    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getTags() {
        return tags;
    }

    public VideoStatus getVideoStatus() {
        return videoStatus;
    }

    public String getId() {
        return id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(Integer dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }



}
