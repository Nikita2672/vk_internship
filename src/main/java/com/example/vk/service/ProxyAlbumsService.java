package com.example.vk.service;

import com.example.vk.dto.Album;
import com.example.vk.dto.Photo;

import java.util.List;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
public interface ProxyAlbumsService {

    List<Photo> getPhotosByAlbumId(Long albumId);

    List<Album> getAllAlbums();

    Album createAlbum(Album album);

    Album putAlbum(Long albumId, Album album);

    Album patchAlbum(Long albumId, Album album);

    void deleteAlbum(Long albumId);
}
