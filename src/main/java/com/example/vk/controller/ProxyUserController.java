package com.example.vk.controller;

import com.example.vk.dto.Album;
import com.example.vk.dto.Post;
import com.example.vk.dto.Todo;
import com.example.vk.dto.user.User;
import com.example.vk.service.ProxyUserService;
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
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class ProxyUserController {

    private final ProxyUserService proxyUserService;

    @GetMapping("/{userId}/albums")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS_VIEWERS', 'ROLE_USERS_EDITORS')")
    public ResponseEntity<List<Album>> getAlbumsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(proxyUserService.getAlbumsByUserId(userId));
    }

    @GetMapping("/{userId}/todos")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS_VIEWERS', 'ROLE_USERS_EDITORS')")
    public ResponseEntity<List<Todo>> getTodosByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(proxyUserService.getTodosByUserId(userId));
    }

    @GetMapping("/{userId}/posts")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS_VIEWERS', 'ROLE_USERS_EDITORS')")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(proxyUserService.getPostsByUserId(userId));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS_VIEWERS', 'ROLE_USERS_EDITORS')")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(proxyUserService.getAllUsers());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS_EDITORS')")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(proxyUserService.createUser(user));
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS_EDITORS')")
    public ResponseEntity<User> putUser(@PathVariable Long userId, @RequestBody User user) {
        return ResponseEntity.ok(proxyUserService.putUser(userId, user));
    }

    @PatchMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS_EDITORS')")
    public ResponseEntity<User> patchUser(@PathVariable Long userId, @RequestBody User user) {
        return ResponseEntity.ok(proxyUserService.patchUser(userId, user));
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS_EDITORS')")
    public void deleteUser(@PathVariable Long userId) {
        proxyUserService.deleteUser(userId);
    }
}
