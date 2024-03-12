package com.example.vk.client;

import com.example.vk.dto.Album;
import com.example.vk.dto.Post;
import com.example.vk.dto.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
@FeignClient(
        value = "proxyUserClient",
        url = "https://jsonplaceholder.typicode.com/users",
        configuration = MyClientConfiguration.class
)
public interface ProxyUserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/albums")
    List<Album> getAlbumsByUserId(@PathVariable Long userId);

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/todos")
    List<Todo> getTodosByUserId(@PathVariable Long userId);

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/posts")
    List<Post> getPostsByUserId(@PathVariable Long userId);
}
