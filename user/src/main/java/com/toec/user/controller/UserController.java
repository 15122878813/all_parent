package com.toec.user.controller;

import com.toec.common.vo.JsonResult;
import com.toec.pojo.UserPwd;
import com.toec.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	/*
	登录界面的登录
	 */
	 @RequestMapping("/doLogin")
	 @ResponseBody
	   public JsonResult doLogin(String username,
			   String password,boolean isRememberMe,
								 HttpServletResponse response){
		   //1.获取Subject对象
		   Subject subject= SecurityUtils.getSubject();
		   System.out.println("-------------"+username);
		   //2.通过Subject提交用户信息,交给shiro框架进行认证操作
		   //2.1对用户进行封装
		   UsernamePasswordToken token=
		   new UsernamePasswordToken(
				   username,//身份信息
				   password);//凭证信息
		   if(isRememberMe) {
			   token.setRememberMe(true);
		   }
		   //2.2对用户信息进行身份认证
		   subject.login(token);
		   
		   //将使用的username存入到cookie中，并为之后的工作奠定基础
		   Cookie cookie = new Cookie("user_name", username);
//		   Cookie cookie1 = new Cookie("username1", "1");
		   
		   cookie.setMaxAge(-1);
		   cookie.setPath("/");
		   response.addCookie(cookie);
//		   response.addCookie(cookie1);
		   //分析:
		   //1)token会传给shiro的SecurityManager
		   //2)SecurityManager将token传递给认证管理器
		   //3)认证管理器会将token传递给realm

		   return new JsonResult("login ok");
	   }
	 
	 @RequestMapping("doSaveObject")
	 @ResponseBody
	 public JsonResult doSaveObject(UserPwd entity) {
		 userService.SaveObject(entity);
		 return new JsonResult("save ok");
	 }
	 
	 @RequestMapping("doSavePassword")
	 @ResponseBody
	 public JsonResult doSavePassword(UserPwd entity) {
		 userService.SavePassword(entity);
		 return new JsonResult("save ok");
	 }
	 
	 //以下进行用户名是否存在的验证
	 @RequestMapping("/wxYanZheng")
	 @ResponseBody
	 public JsonResult towxYanZheng(String wx) {
		 UserPwd findPwdObjects = userService.findPwdObjects(wx);
		 return new JsonResult();
	 }
}
