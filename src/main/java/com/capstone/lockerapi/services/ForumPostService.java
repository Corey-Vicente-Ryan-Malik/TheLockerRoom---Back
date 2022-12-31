package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.Post;

import java.util.List;
import java.util.Optional;

public interface ForumPostService {

    public List<Post> showAllPosts();
    public Optional<Post> findPostById(long id);
    public Post savePost(Post post);
    public void deletePost(long id);
}
