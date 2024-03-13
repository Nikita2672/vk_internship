package com.example.vk.service;

import com.example.vk.dto.Album;
import com.example.vk.dto.Post;
import com.example.vk.dto.Todo;
import com.example.vk.dto.user.User;

import java.util.List;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
public interface ProxyUserService {

    List<Album> getAlbumsByUserId(Long userId);

    List<Todo> getTodosByUserId(Long userId);

    List<Post> getPostsByUserId(Long userId);

    List<User> getAllUsers();

    User getUserById(Long userId);

    User createUser(User user);

    User putUser(Long userId, User user);

    User patchUser(Long userId, User user);

    void deleteUser(Long userId);
    
    
}
