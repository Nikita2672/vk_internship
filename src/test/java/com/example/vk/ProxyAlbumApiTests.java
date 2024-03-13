package com.example.vk;

import com.example.vk.client.ProxyAlbumClient;
import com.example.vk.dto.Album;
import com.example.vk.dto.Photo;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpMethod.*;

class ProxyAlbumApiTests extends AbstractTest {

    @Autowired
    private ProxyAlbumClient proxyAlbumClient;

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testGetAllAlbums() throws Exception {
        List<Album> expectedAlbums = proxyAlbumClient.getAllAlbums();
        List<Album> actualAlbums = getResponse("/api/albums", GET, new TypeReference<>() {
        }, null);
        assertEquals(expectedAlbums, actualAlbums);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testGetPhotosByAlbumId() throws Exception {
        List<Photo> expectedPhotos = proxyAlbumClient.getPhotosByAlbumId(DEFAULT_ID);
        List<Photo> actualPhotos = getResponse("/api/albums/" + DEFAULT_ID + "/photos", GET, new TypeReference<>() {
        }, null);
        assertEquals(expectedPhotos, actualPhotos);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testGetAlbumById() throws Exception {
        Album expectedAlbum = proxyAlbumClient.getAlbumById(DEFAULT_ID);
        Album actualAlbum = getResponse("/api/albums/" + DEFAULT_ID, GET, new TypeReference<>() {
        }, null);
        assertEquals(expectedAlbum, actualAlbum);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testCreateAlbum() throws Exception {
        Album album = new Album(DEFAULT_ID, DEFAULT_ID, "simple title");
        Album expectedAlbum = proxyAlbumClient.createAlbum(album);
        Album actualAlbum = getResponse("/api/albums", POST, new TypeReference<>() {
        }, album);
        assertEquals(expectedAlbum, actualAlbum);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testPutAlbum() throws Exception {
        Album album = new Album(DEFAULT_ID, DEFAULT_ID, "simple title");
        Album expectedAlbum = proxyAlbumClient.putAlbum(DEFAULT_ID, album);
        Album actualAlbum = getResponse("/api/albums/" + DEFAULT_ID, PUT, new TypeReference<>() {
        }, album);
        assertEquals(expectedAlbum, actualAlbum);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testPatchAlbum() throws Exception {
        Album album = new Album(DEFAULT_ID, DEFAULT_ID, "simple title");
        Album expectedAlbum = proxyAlbumClient.patchAlbum(DEFAULT_ID, album);
        Album actualAlbum = getResponse("/api/albums/" + DEFAULT_ID, PATCH, new TypeReference<>() {
        }, album);
        assertEquals(expectedAlbum, actualAlbum);
    }
}
