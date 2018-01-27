package ccu.campus.association.controller;

import org.hibernate.envers.Audited;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ccu.campus.association.service.UserService;
import ccu.campus.association.utils.ResultMap;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public ResultMap register(@RequestParam String username,@RequestParam String password) {
		userService.addUser(username,password);
		return ResultMap.ok();
	}
}
