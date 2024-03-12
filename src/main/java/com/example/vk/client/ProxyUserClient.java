package com.example.vk.client;

import com.example.vk.dto.Album;
import com.example.vk.dto.Post;
import com.example.vk.dto.Todo;
import com.example.vk.dto.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(method = RequestMethod.GET, value = "")
    List<User> getAllUsers();

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    void deleteUserById(@PathVariable Long userId);

    @RequestMapping(method = RequestMethod.POST, value = "")
    User createUser(@RequestBody User user);

    @RequestMapping(method = RequestMethod.PUT, value = "/{userId}")
    User putUser(@PathVariable Long userId, @RequestBody User user);

    @RequestMapping(method = RequestMethod.PATCH, value = "/{userId}")
    User patchUser(@PathVariable Long userId, @RequestBody User user);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    void deleteUser(@PathVariable Long userId);
}
