package com.example.vk;

import com.example.vk.client.ProxyUserClient;
import com.example.vk.dto.Album;
import com.example.vk.dto.Post;
import com.example.vk.dto.Todo;
import com.example.vk.dto.user.Address;
import com.example.vk.dto.user.Company;
import com.example.vk.dto.user.Geo;
import com.example.vk.dto.user.User;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpMethod.PATCH;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
class ProxyUserApiTest extends AbstractTest {


    @Autowired
    private ProxyUserClient proxyUserClient;

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testGetAlbumByUserId() throws Exception {
        List<Album> expectedAlbums = proxyUserClient.getAlbumsByUserId(DEFAULT_ID);
        List<Album> actualAlbums = getResponse("/api/users/" + DEFAULT_ID + "/albums", GET, new TypeReference<>() {
        }, null);
        assertEquals(expectedAlbums, actualAlbums);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testGetTodosByUserId() throws Exception {
        List<Todo> expectedTodos = proxyUserClient.getTodosByUserId(DEFAULT_ID);
        List<Todo> actualTodos = getResponse("/api/users/" + DEFAULT_ID + "/todos", GET, new TypeReference<>() {
        }, null);
        assertEquals(expectedTodos, actualTodos);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testGetPostsByUserId() throws Exception {
        List<Post> expectedPosts = proxyUserClient.getPostsByUserId(DEFAULT_ID);
        List<Post> actualPosts = getResponse("/api/users/" + DEFAULT_ID + "/posts", GET, new TypeReference<>() {
        }, null);
        assertEquals(expectedPosts, actualPosts);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testGetAllUsers() throws Exception {
        List<User> expectedUsers = proxyUserClient.getAllUsers();
        List<User> actualUsers = getResponse("/api/users", GET, new TypeReference<>() {
        }, null);
        assertEquals(expectedUsers, actualUsers);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testCreateUser() throws Exception {
        User user = getTestUser();
        User expectedUser = proxyUserClient.createUser(user);
        User actualUser = getResponse("/api/users", POST, new TypeReference<>() {
        }, user);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testPutUser() throws Exception {
        User user = getTestUser();
        User expectedUser = proxyUserClient.putUser(DEFAULT_ID, user);
        User actualUser = getResponse("/api/users/" + DEFAULT_ID, PUT, new TypeReference<>() {
        }, user);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testPatchUser() throws Exception {
        User user = getTestUser();
        User expectedUser = proxyUserClient.patchUser(DEFAULT_ID, user);
        User actualUser = getResponse("/api/users/" + DEFAULT_ID, PATCH, new TypeReference<>() {
        }, user);
        assertEquals(expectedUser, actualUser);
    }


    private User getTestUser() {
        return new User(
                DEFAULT_ID,
                "name",
                "username",
                "email",
                new Address(
                        "street",
                        "suite",
                        "city",
                        "zipcode",
                        new Geo(
                                2344.0,
                                -344.0
                        )
                ),
                "phone",
                "website",
                new Company(
                        "name",
                        "catchPlace",
                        "bs"
                )
        );
    }
}
