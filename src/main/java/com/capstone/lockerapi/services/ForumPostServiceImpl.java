package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.Post;
import com.capstone.lockerapi.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForumPostServiceImpl implements ForumPostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> showAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findPostById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}
