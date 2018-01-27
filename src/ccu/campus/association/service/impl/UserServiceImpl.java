package ccu.campus.association.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ccu.campus.association.dao.UserDao;
import ccu.campus.association.pojo.User;
import ccu.campus.association.service.UserService;
import ccu.campus.association.utils.IDUtils;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao UserDao;
	@Override
	public void addUser(String username, String password) {
		User user=new User();
		user.setId(IDUtils.genUserId());
		user.setPassword(password);
		user.setUsername(username);
		UserDao.addUser(user);
		
	}

	@Override
	public void updateUser(User User) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(User User) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User queryUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> queryUserList(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
