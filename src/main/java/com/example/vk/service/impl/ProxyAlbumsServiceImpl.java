package com.example.vk.service.impl;

import com.example.vk.client.ProxyAlbumClient;
import com.example.vk.dto.Photo;
import com.example.vk.service.ProxyAlbumsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
@Service
@RequiredArgsConstructor
public class ProxyAlbumsServiceImpl implements ProxyAlbumsService {

    private final ProxyAlbumClient proxyAlbumClient;

    @Override
    public List<Photo> getPhotosByAlbumId(Long albumId) {
        return proxyAlbumClient.getPhotosByAlbumId(albumId);
    }
}
