package com.example.vk;

import com.example.vk.client.ProxyPostClient;
import com.example.vk.dto.Post;
import com.example.vk.dto.PostComment;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpMethod.*;


class ProxyPostApiTest extends AbstractTest {

    @Autowired
    private ProxyPostClient proxyPostClient;

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testGetAllPosts() throws Exception {
        List<Post> expectedPosts = proxyPostClient.getAllPosts();
        List<Post> actualPosts = getResponse("/api/posts", GET, new TypeReference<>() {
        }, null);
        assertEquals(expectedPosts, actualPosts);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testGetPostById() throws Exception {
        Post expectedPost = proxyPostClient.postById(DEFAULT_ID);
        Post actualPost = getResponse("/api/posts/" + DEFAULT_ID, GET, new TypeReference<>() {
        }, null);
        assertEquals(expectedPost, actualPost);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testGetCommentsByPostId() throws Exception {
        List<PostComment> expectedComments = proxyPostClient.commentsByPostId(DEFAULT_ID);
        List<PostComment> actualComments = getResponse("/api/posts/" + DEFAULT_ID + "/comments", GET, new TypeReference<>() {
        }, null);
        assertEquals(expectedComments, actualComments);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testCreatePost() throws Exception {
        Post post = getTestPost();
        Post expectedPost = proxyPostClient.createPost(post);
        Post actualPost = getResponse("/api/posts", POST, new TypeReference<>() {
        }, post);
        assertEquals(expectedPost, actualPost);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testPutPost() throws Exception {
        Post post = getTestPost();
        Post expectedPost = proxyPostClient.putPost(DEFAULT_ID, post);
        Post actualPost = getResponse("/api/posts/" + DEFAULT_ID, PUT, new TypeReference<>() {
        }, post);
        assertEquals(expectedPost, actualPost);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testPatchPost() throws Exception {
        Post post = getTestPost();
        Post expectedPost = proxyPostClient.patchPost(DEFAULT_ID, post);
        Post actualPost = getResponse("/api/posts/" + DEFAULT_ID, PATCH, new TypeReference<>() {
        }, post);
        assertEquals(expectedPost, actualPost);
    }

    private Post getTestPost() {
        return new Post(
                DEFAULT_ID,
                DEFAULT_ID,
                "title",
                "body"
        );
    }
}
