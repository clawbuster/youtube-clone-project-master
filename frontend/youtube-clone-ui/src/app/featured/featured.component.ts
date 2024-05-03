import { Component, OnInit } from '@angular/core';
import { VideoService } from '../video.service';
import { VideoDto } from '../video-dto';

@Component({
  selector: 'app-featured',
  templateUrl: './featured.component.html',
  styleUrls: ['./featured.component.css']
})
export class FeaturedComponent implements OnInit {
  featuredVideos: Array<VideoDto> = [];
  filteredVideos: Array<VideoDto> = [];
  searchTerm: string = '';

  constructor(private videoService: VideoService) {}

  ngOnInit(): void {
    this.videoService.getAllVideos().subscribe(response => {
      this.featuredVideos = response;
      this.filteredVideos = response; // Initialize filteredVideos with all videos
    });
  }


  search(): void {
    if (!this.searchTerm) {
      this.filteredVideos = this.featuredVideos; // If search term is empty, show all videos
      return;
    }
    // Filter videos whose title includes the search term
    this.filteredVideos = this.featuredVideos.filter(video =>
      video.title && video.title.toLowerCase().includes(this.searchTerm.toLowerCase())
    );
  }


}
