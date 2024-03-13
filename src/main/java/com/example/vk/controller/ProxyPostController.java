package com.example.vk.controller;

import com.example.vk.dto.Post;
import com.example.vk.dto.PostComment;
import com.example.vk.service.ProxyPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class ProxyPostController {

    private final ProxyPostService proxyPostService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS_VIEWERS', 'ROLE_POSTS_EDITORS')")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(proxyPostService.posts());
    }

    @GetMapping("/{postId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS_VIEWERS', 'ROLE_POSTS_EDITORS')")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(proxyPostService.postById(postId));
    }

    @GetMapping("/{postId}/comments")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS_VIEWERS', 'ROLE_POSTS_EDITORS')")
    public ResponseEntity<List<PostComment>> getCommentsByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok(proxyPostService.commentsByPostId(postId));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS_EDITORS')")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(proxyPostService.createPost(post));
    }

    @PutMapping("/{postId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS_EDITORS')")
    public ResponseEntity<Post> putPost(@PathVariable Long postId, @RequestBody Post postBody) {
        return ResponseEntity.ok(proxyPostService.putPost(postId, postBody));
    }

    @PatchMapping("/{postId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS_EDITORS')")
    public ResponseEntity<Post> patchPost(@PathVariable Long postId, @RequestBody Post postBody) {
        return ResponseEntity.ok(proxyPostService.patchPost(postId, postBody));
    }

    @DeleteMapping("/{postId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS_EDITORS')")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        proxyPostService.deletePost(postId);
        return ResponseEntity.ok().build();
    }
}
