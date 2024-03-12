package com.example.vk.service;

import com.example.vk.dto.Post;
import com.example.vk.dto.PostComment;

import java.util.List;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
public interface ProxyPostService {

    List<Post> posts();

    Post postById(Long postId);

    List<PostComment> commentsByPostId(Long postId);

    Post createPost(Post post);

    Post putPost(Long postId, Post post);

    Post patchPost(Long postId, Post post);

    void deletePost(Long postId);
}
