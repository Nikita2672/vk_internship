package com.example.vk.client;

import com.example.vk.dto.Post;
import com.example.vk.dto.PostComment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        value = "proxyPostClient",
        url = "https://jsonplaceholder.typicode.com/posts",
        configuration = MyClientConfiguration.class
)
public interface ProxyPostClient {

    @RequestMapping(method = RequestMethod.GET, value = "")
    List<Post> getAllPosts();

    @RequestMapping(method = RequestMethod.GET, value = "/{postId}")
    Post postById(@PathVariable Long postId);

    @RequestMapping(method = RequestMethod.GET, value = "/{postId}/comments")
    List<PostComment> commentsByPostId(@PathVariable Long postId);

    @RequestMapping(method = RequestMethod.POST, value = "")
    Post createPost(@RequestBody Post post);

    @RequestMapping(method = RequestMethod.PUT, value = "/{postId}")
    Post putPost(@PathVariable Long postId, @RequestBody Post post);

    @RequestMapping(method = RequestMethod.PATCH, value = "/{postId}")
    Post patchPost(@PathVariable Long postId, @RequestBody Post post);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{postId}")
    void deletePost(@PathVariable Long postId);
}
