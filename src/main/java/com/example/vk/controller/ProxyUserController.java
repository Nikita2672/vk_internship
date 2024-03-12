package com.example.vk.controller;

import com.example.vk.dto.Album;
import com.example.vk.dto.Post;
import com.example.vk.dto.Todo;
import com.example.vk.dto.user.User;
import com.example.vk.service.ProxyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS')")
public class ProxyUserController {

    private final ProxyUserService proxyUserService;

    @GetMapping("/{userId}/albums")
    public ResponseEntity<List<Album>> getAlbumsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(proxyUserService.getAlbumsByUserId(userId));
    }

    @GetMapping("/{userId}/todos")
    public ResponseEntity<List<Todo>> getTodosByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(proxyUserService.getTodosByUserId(userId));
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(proxyUserService.getPostsByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(proxyUserService.getAllUsers());
    }
}
