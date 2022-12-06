package com.capstone.lockerapi.controllers;

import com.capstone.lockerapi.exceptions.UserNotFoundException;
import com.capstone.lockerapi.models.ForumPost;
import com.capstone.lockerapi.models.User;
import com.capstone.lockerapi.services.ForumPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class ForumPostController {

    @Autowired
    private ForumPostService forumPostService;

    @GetMapping
    public List<ForumPost> showAllPosts() {
        return forumPostService.showAllPosts();
    }

    @GetMapping("/{id}")
    public Optional<ForumPost> showSinglePost(@PathVariable long id) {
        return forumPostService.findPostById(id);
    }

    @PostMapping("/create")
    public ForumPost createPost(@RequestBody ForumPost post) {
        return forumPostService.savePost(post);
    }

    @PutMapping("/edit-post/{id}")
    public ForumPost editPost(@RequestBody ForumPost postToEdit, @PathVariable long id) {
            return forumPostService.findPostById(id)
                    .map(post -> {
                        post.setPostBody(postToEdit.getPostBody());
                        post.setUser(postToEdit.getUser());
                        post.setTeam(postToEdit.getTeam());
                        return forumPostService.savePost(post);
                    }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable long id) {
        forumPostService.deletePost(id);
        return "Post has been deleted.";
    }
}
