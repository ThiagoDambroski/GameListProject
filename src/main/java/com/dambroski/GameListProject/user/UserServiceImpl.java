package com.dambroski.GameListProject.user;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;

	@Override
	public List<User> getAllUser() {
		
		return repository.findAll();
	}

	@Override
	public User getUserById(Long userId) {
		return repository.findById(userId).get();
	}

	@Override
	public User postUser(User user) {
		return repository.save(user);
	}

	@Override
	public String deleteById(long userId) {
		repository.deleteById(userId);
		return "sucess";
	}

	@Override
	public User putUser(long userId, User user) {
		User newUser = repository.findById(userId).get();
		if(Objects.isNull(user.getName()) && !"".equals(user.getName())) {	
			newUser.setName(user.getName());
		}
		if(Objects.isNull(user.getName()) &&  !"".equals(user.getEmail())) {
			newUser.setEmail(user.getEmail());
		}

		return repository.save(newUser);
	}

}
