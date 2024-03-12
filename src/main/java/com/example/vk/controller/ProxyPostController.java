package com.example.vk.controller;

import com.example.vk.dto.Post;
import com.example.vk.dto.PostComment;
import com.example.vk.service.ProxyPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS')")
public class ProxyPostController {

    private final ProxyPostService proxyPostService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(proxyPostService.posts());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(proxyPostService.postById(postId));
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<PostComment>> getCommentsByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok(proxyPostService.commentsByPostId(postId));
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(proxyPostService.createPost(post));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> putPost(@PathVariable Long postId, @RequestBody Post postBody) {
        return ResponseEntity.ok(proxyPostService.putPost(postId, postBody));
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<Post> patchPost(@PathVariable Long postId, @RequestBody Post postBody) {
        return ResponseEntity.ok(proxyPostService.patchPost(postId, postBody));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        proxyPostService.deletePost(postId);
        return ResponseEntity.ok().build();
    }
}
