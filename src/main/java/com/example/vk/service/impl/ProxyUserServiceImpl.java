package com.example.vk.service.impl;

import com.example.vk.client.ProxyUserClient;
import com.example.vk.dto.Album;
import com.example.vk.dto.Post;
import com.example.vk.dto.Todo;
import com.example.vk.service.ProxyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
@Service
@RequiredArgsConstructor
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
}
