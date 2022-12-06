package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.ForumPost;

import java.util.List;
import java.util.Optional;

public interface ForumPostService {

    public List<ForumPost> showAllPosts();
    public Optional<ForumPost> findPostById(long id);
    public ForumPost savePost(ForumPost post);
    public void deletePost(long id);
}
