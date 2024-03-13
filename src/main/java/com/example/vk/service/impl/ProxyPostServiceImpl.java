package com.example.vk.service.impl;

import com.example.vk.client.ProxyPostClient;
import com.example.vk.dto.PostComment;
import com.example.vk.service.ProxyPostService;
import com.example.vk.dto.Post;
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
@CacheConfig(cacheNames = "post")
public class ProxyPostServiceImpl implements ProxyPostService {

    private final ProxyPostClient proxyPostClient;

    @Override
    public List<Post> posts() {
        return proxyPostClient.getAllPosts();
    }

    @Override
    @Cacheable
    public Post postById(Long postId) {
        return proxyPostClient.postById(postId);
    }

    @Override
    public List<PostComment> commentsByPostId(Long postId) {
        return proxyPostClient.commentsByPostId(postId);
    }

    @Override
    @CachePut(key = "#post.id()")
    public Post createPost(Post post) {
        return proxyPostClient.createPost(post);
    }

    @Override
    @CachePut(key = "#postId")
    public Post putPost(Long postId, Post post) {
        return proxyPostClient.putPost(postId, post);
    }

    @Override
    @CachePut(key = "#postId")
    public Post patchPost(Long postId, Post post) {
        return proxyPostClient.patchPost(postId, post);
    }

    @Override
    @CacheEvict
    public void deletePost(Long postId) {
        proxyPostClient.deletePost(postId);
    }
}
