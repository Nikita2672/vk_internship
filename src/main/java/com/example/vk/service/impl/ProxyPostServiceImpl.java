package com.example.vk.service.impl;

import com.example.vk.client.ProxyPostClient;
import com.example.vk.dto.PostComment;
import com.example.vk.service.ProxyPostService;
import com.example.vk.dto.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
@Service
@RequiredArgsConstructor
public class ProxyPostServiceImpl implements ProxyPostService {

    private final ProxyPostClient proxyPostClient;

    @Override
    public List<Post> posts() {
        return proxyPostClient.getAllPosts();
    }

    @Override
    public Post postById(Long postId) {
        return proxyPostClient.postById(postId);
    }

    @Override
    public List<PostComment> commentsByPostId(Long postId) {
        return proxyPostClient.commentsByPostId(postId);
    }

    @Override
    public Post createPost(Post post) {
        return proxyPostClient.createPost(post);
    }

    @Override
    public Post putPost(Long postId, Post post) {
        return proxyPostClient.putPost(postId, post);
    }

    @Override
    public Post patchPost(Long postId, Post post) {
        return proxyPostClient.patchPost(postId, post);
    }

    @Override
    public void deletePost(Long postId) {
        proxyPostClient.deletePost(postId);
    }
}
