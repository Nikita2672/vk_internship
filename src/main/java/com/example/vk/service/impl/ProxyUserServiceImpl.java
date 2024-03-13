package com.example.vk.service.impl;

import com.example.vk.client.ProxyUserClient;
import com.example.vk.dto.Album;
import com.example.vk.dto.Post;
import com.example.vk.dto.Todo;
import com.example.vk.dto.user.User;
import com.example.vk.service.ProxyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "user")
public class ProxyUserServiceImpl implements ProxyUserService {

    private final ProxyUserClient proxyUserClient;

    @Override
    public List<Album> getAlbumsByUserId(Long userId) {
        return proxyUserClient.getAlbumsByUserId(userId);
    }

    @Override
    public List<Todo> getTodosByUserId(Long userId) {
        return proxyUserClient.getTodosByUserId(userId);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return proxyUserClient.getPostsByUserId(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return proxyUserClient.getAllUsers();
    }

    @Override
    @Cacheable
    public User getUserById(Long userId) {
        return proxyUserClient.getUserById(userId);
    }

    @Override
    @CachePut(key = "#user.id()")
    public User createUser(User user) {
        return proxyUserClient.createUser(user);
    }

    @Override
    @CachePut(key = "#userId")
    public User putUser(Long userId, User user) {
        return proxyUserClient.putUser(userId, user);
    }

    @Override
    @CachePut(key = "#userId")
    public User patchUser(Long userId, User user) {
        return proxyUserClient.patchUser(userId, user);
    }

    @Override
    @CacheEvict
    public void deleteUser(Long userId) {
        proxyUserClient.deleteUser(userId);
    }
}
