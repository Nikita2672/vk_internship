package com.example.vk.controller;

import com.example.vk.dto.Album;
import com.example.vk.dto.Photo;
import com.example.vk.service.ProxyAlbumsService;
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
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class ProxyAlbumController {

    private final ProxyAlbumsService proxyAlbumsService;

    @GetMapping("/{albumId}/photos")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ALBUMS_VIEWERS', 'ROLE_ALBUMS_EDITOR')")
    public ResponseEntity<List<Photo>> getPhotosByAlbumId(@PathVariable Long albumId) {
        return ResponseEntity.ok(proxyAlbumsService.getPhotosByAlbumId(albumId));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ALBUMS_VIEWERS', 'ROLE_ALBUMS_EDITOR')")
    public ResponseEntity<List<Album>> getAllAlbums() {
        return ResponseEntity.ok(proxyAlbumsService.getAllAlbums());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ALBUMS_EDITOR')")
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        return ResponseEntity.ok(proxyAlbumsService.createAlbum(album));
    }

    @PutMapping("/{albumId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ALBUMS_EDITOR')")
    public ResponseEntity<Album> putAlbum(@PathVariable Long albumId, @RequestBody Album album) {
        return ResponseEntity.ok(proxyAlbumsService.putAlbum(albumId, album));
    }

    @PatchMapping("/{albumId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ALBUMS_EDITOR')")
    public ResponseEntity<Album> patchAlbum(@PathVariable Long albumId, @RequestBody Album album) {
        return ResponseEntity.ok(proxyAlbumsService.patchAlbum(albumId, album));
    }

    @DeleteMapping("/{albumId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ALBUMS_EDITOR')")
    public void deleteAlbum(@PathVariable Long albumId) {
        proxyAlbumsService.deleteAlbum(albumId);
    }
}
