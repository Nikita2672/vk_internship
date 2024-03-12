package com.example.vk.service;

import com.example.vk.dto.Photo;

import java.util.List;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
public interface ProxyAlbumsService {

    List<Photo> getPhotosByAlbumId(Long albumId);
}
