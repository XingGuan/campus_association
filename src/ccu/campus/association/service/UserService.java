package ccu.campus.association.service;

import java.util.List;

import ccu.campus.association.pojo.User;

public interface UserService {
	 void addUser(String username,String password);
	 
	 void updateUser(User User);
	 void deleteUserById(User User);
	 User queryUserById(String id);
	 List<User> queryUserList(String keyword);
}
