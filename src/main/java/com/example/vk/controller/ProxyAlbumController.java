package com.example.vk.controller;

import com.example.vk.dto.Album;
import com.example.vk.dto.Photo;
import com.example.vk.service.ProxyAlbumsService;
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
@RequestMapping("/api/albums")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ALBUMS')")
public class ProxyAlbumController {

    private final ProxyAlbumsService proxyAlbumsService;

    @GetMapping("/{albumId}/photos")
    public ResponseEntity<List<Photo>> getPhotosByAlbumId(@PathVariable Long albumId) {
        return ResponseEntity.ok(proxyAlbumsService.getPhotosByAlbumId(albumId));
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums() {
        return ResponseEntity.ok(proxyAlbumsService.getAllAlbums());
    }


}
