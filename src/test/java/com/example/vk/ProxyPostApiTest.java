package com.example.vk;

import com.example.vk.client.ProxyPostClient;
import com.example.vk.dto.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpMethod.*;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
class ProxyPostApiTest extends AbstractTest {

    @Autowired
    private ProxyPostClient proxyPostClient;


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
