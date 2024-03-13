package com.example.vk.client;

import com.example.vk.dto.Album;
import com.example.vk.dto.Photo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
@FeignClient(
        value = "proxyAlbumClient",
        url = "https://jsonplaceholder.typicode.com/albums",
        configuration = MyClientConfiguration.class
)
public interface ProxyAlbumClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{albumId}/photos")
    List<Photo> getPhotosByAlbumId(@PathVariable Long albumId);

    @RequestMapping(method = RequestMethod.GET, value = "")
    List<Album> getAllAlbums();

    @RequestMapping(method = RequestMethod.GET, value = "/{albumId}")
    Album getAlbumById(@PathVariable Long albumId);

    @RequestMapping(method = RequestMethod.POST, value = "")
    Album createAlbum(@RequestBody Album album);

    @RequestMapping(method = RequestMethod.PUT, value = "/{albumId}")
    Album putAlbum(@PathVariable Long albumId, @RequestBody Album album);

    @RequestMapping(method = RequestMethod.PATCH, value = "/{albumId}")
    Album patchAlbum(@PathVariable Long albumId, @RequestBody Album album);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{albumId}")
    void deleteAlbum(@PathVariable Long albumId);
}
