package com.capstone.lockerapi.controllers;

import com.capstone.lockerapi.exceptions.PostNotFoundException;
import com.capstone.lockerapi.models.Post;
import com.capstone.lockerapi.services.ForumPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    private ForumPostService forumPostService;

    // Mapping to CREATE new post entity.
    @PostMapping("/posts/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok().body(forumPostService.savePost(post));
    }

    // Mapping to READ/VIEW all posts in DB.
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> showAllPosts() {
        return ResponseEntity.ok().body(forumPostService.showAllPosts());
    }

    // Mapping to READ/VIEW single post.
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> showSinglePost(@PathVariable long id) {
        return ResponseEntity.ok().body(forumPostService.findPostById(id)
                .orElseThrow(() -> new PostNotFoundException(id)));
    }

    // Mapping to UPDATE/EDIT post.
    @PutMapping("/posts/{id}/edit-post")
    public ResponseEntity<Post> editPost(@RequestBody Post postToEdit, @PathVariable long id) {
            return ResponseEntity.ok().body(forumPostService.findPostById(id)
                    .map(post -> {
                        post.setPostBody(postToEdit.getPostBody());
                        post.setUser(postToEdit.getUser());
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
