package com.programming.techie.youtubeclone.services;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

// aws part
@Service
@RequiredArgsConstructor
public class s3Service implements fileService{

    public static final String BUCKET_NAME = "bucketofjojo";

    @Autowired
    private AmazonS3Client awsS3Client;

//    public s3Service(AmazonS3Client awsS3Client) {
//        this.awsS3Client = awsS3Client;
//    }


    @Override
    public String uploadFile(MultipartFile file){

        //key
        var fileExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        var key = UUID.randomUUID().toString() + "." + fileExtension;

        var metaData = new ObjectMetadata();
        metaData.setContentLength(file.getSize());
        metaData.setContentType(file.getContentType());

        try{
            awsS3Client.putObject(BUCKET_NAME, key, file.getInputStream(), metaData);
        }catch(IOException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "file dhang se daal re");
        }

        awsS3Client.setObjectAcl(BUCKET_NAME, key, CannedAccessControlList.PublicRead);
        return awsS3Client.getResourceUrl(BUCKET_NAME, key);
    }

}
