package com.example.vk.service.impl;

import com.example.vk.client.ProxyAlbumClient;
import com.example.vk.dto.Album;
import com.example.vk.dto.Photo;
import com.example.vk.service.ProxyAlbumsService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "album")
public class ProxyAlbumsServiceImpl implements ProxyAlbumsService {

    private final ProxyAlbumClient proxyAlbumClient;

    @Override
    public List<Photo> getPhotosByAlbumId(Long albumId) {
        return proxyAlbumClient.getPhotosByAlbumId(albumId);
    }

    @Override
    public List<Album> getAllAlbums() {
        return proxyAlbumClient.getAllAlbums();
    }

    @Override
    @Cacheable
    public Album getAlbumById(Long albumId) {
        return proxyAlbumClient.getAlbumById(albumId);
    }

    @Override
    @CachePut(key = "#album.id()")
    public Album createAlbum(Album album) {
        return proxyAlbumClient.createAlbum(album);
    }

    @Override
    @CachePut(key = "#albumId")
    public Album putAlbum(Long albumId, Album album) {
        return proxyAlbumClient.putAlbum(albumId, album);
    }

    @Override
    @CachePut(key = "#albumId")
    public Album patchAlbum(Long albumId, Album album) {
        return proxyAlbumClient.patchAlbum(albumId, album);
    }

    @Override
    @CacheEvict
    public void deleteAlbum(Long albumId) {
        proxyAlbumClient.deleteAlbum(albumId);
    }
}
