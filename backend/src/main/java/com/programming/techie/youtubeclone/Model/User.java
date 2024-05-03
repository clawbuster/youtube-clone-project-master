package com.programming.techie.youtubeclone.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(value="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private Set<String> subbedUsers;
    private Set<String> subscribers;
    private List<String> videoHist;
    private Set<String> likedVids;
    private Set<String> dislikedVids;

}
