package com.capstone.lockerapi.controllers;

import com.capstone.lockerapi.exceptions.PostNotFoundException;
import com.capstone.lockerapi.models.ForumPost;
import com.capstone.lockerapi.services.ForumPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class ForumPostController {

    @Autowired
    private ForumPostService forumPostService;

    // Mapping to CREATE new post entity.
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/posts/create")
    public ResponseEntity<ForumPost> createPost(@RequestBody ForumPost post) {
        return ResponseEntity.ok().body(forumPostService.savePost(post));
    }

    // Mapping to READ/VIEW all posts in DB.
    @GetMapping("/posts")
    public ResponseEntity<List<ForumPost>> showAllPosts() {
        return ResponseEntity.ok().body(forumPostService.showAllPosts());
    }

    // Mapping to READ/VIEW single post.
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/posts/{id}")
    public ResponseEntity<ForumPost> showSinglePost(@PathVariable long id) {
        return ResponseEntity.ok().body(forumPostService.findPostById(id)
                .orElseThrow(() -> new PostNotFoundException(id)));
    }

    // Mapping to UPDATE/EDIT post.
    @PutMapping("/posts/{id}/edit-post")
    public ResponseEntity<ForumPost> editPost(@RequestBody ForumPost postToEdit, @PathVariable long id) {
            return ResponseEntity.ok().body(forumPostService.findPostById(id)
                    .map(post -> {
                        post.setPostBody(postToEdit.getPostBody());
                        post.setUser(postToEdit.getUser());
                        post.setTeam(postToEdit.getTeam());
                        return forumPostService.savePost(post);
                    }).orElseThrow(() -> new PostNotFoundException(id)));
    }

    // Mapping to DELETE single post.
    @DeleteMapping("/posts/{id}/delete")
    public ResponseEntity<?> deletePost(@PathVariable long id) {
        forumPostService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
