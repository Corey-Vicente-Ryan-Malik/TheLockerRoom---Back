package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.ForumPost;
import com.capstone.lockerapi.repositories.ForumPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForumPostServiceImpl implements ForumPostService {

    @Autowired
    private ForumPostRepository forumPostRepository;

    @Override
    public List<ForumPost> showAllPosts() {
        return forumPostRepository.findAll();
    }

    @Override
    public Optional<ForumPost> findPostById(long id) {
        return forumPostRepository.findById(id);
    }

    @Override
    public ForumPost savePost(ForumPost post) {
        return forumPostRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
        forumPostRepository.deleteById(id);
    }
}
