package com.dambroski.GameListProject.user;

import java.util.List;

public interface UserService {

	List<User> getAllUser();

	User getUserById(Long userId);

	User postUser(User user);

	String deleteById(long userId);

	User putUser(long userId, User user);

}
