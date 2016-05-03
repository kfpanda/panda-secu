package com.util.fuzhu;

import org.springframework.web.bind.annotation.RequestMapping;

public class bak {
	@RequestMapping(value = "/index")
	public String index() {
//	public String index(HttpServletRequest request) {
		//返回登录页面
//		List<User> list = new ArrayList<User>();
//		for(int i = 0; i < 5; i++ ){
//			User user = new User();
//			user.setName("哈哈"+i);
//			user.setId(1+i);
//			list.add(user);
//		}
//		request.getSession().setAttribute("userList", list);
//		List<User> list1 = (List<User>) request.getSession().getAttribute("userList");
		return "index";
	}
	
//	User user = new User();
//	user.setName("name");
//	user.setId(1);
//	return JSON.toJSONString(user);
//	return getResult(1, JSON.toJSONString(user));
	
	
//	@RequestMapping(value = "/login")
//	//@ResponseBody
//	public Object login(@RequestParam(value = "name", required = false) String name, 
//			@RequestParam(value = "pwd", required = false) String pwd,
//			HttpServletRequest request) {
//		System.out.println(name);
//		System.out.println(pwd);
		
//		if(GongJu.isNull(name)){
//			return "bb";
////			return getResult(0, "请输入用户名");/
//		}
//		if(GongJu.isNull(pwd)){
//			return "bb";
////			return getResult(0, "请输入密码");
//		}
//		String ret = userService.userLogin(name, pwd, request);
////		return new ModelAndView("aaa") ;
////		return "aaa";
//		if("OK".equals(ret)){
//			//从session中取出用户对象
//			User user = (User)request.getSession().getAttribute("user");
//			request.setAttribute("user", JSON.toJSONString(user));
//			return "aaa";
////			return getResult(1,JSON.toJSONString(user));
//		}else{
//			return "bb";
////			return getResult(0,ret);//login.jsp
//		}
//		request.getSession().setAttribute("user", "11111");
//		return FALSE;
//		return "aaa";
//	}
}
