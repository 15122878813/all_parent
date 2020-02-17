package com.toec.register.config;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;

@SuppressWarnings("unused")
@Configuration   //bean
public class ShiroConfig {

	/**shiro的核心管理器对象(负责提供认证和授权操作)*/
	@Bean
	public SecurityManager securityManager(@Autowired Realm realm) {
		DefaultWebSecurityManager sm=
				new DefaultWebSecurityManager();
		sm.setRealm(realm);
		sm.setRememberMeManager(newRememberMeManager());
		sm.setSessionManager(newSessionManager());
		return sm;
	}



	/**负责创建过滤器工厂,通过此工厂创建过滤器*/
	@Bean("shiroFilterFactory")
	public ShiroFilterFactoryBean newShirofFactoryBean(
			SecurityManager securityManager) {
		ShiroFilterFactoryBean fBean=
				new ShiroFilterFactoryBean();
		fBean.setSecurityManager(securityManager);
		fBean.setLoginUrl("/doLoginUI");
		LinkedHashMap<String,String> filterMap=
				new LinkedHashMap<>();
		filterMap.put("/bower_components/**", "anon");
		filterMap.put("/build/**", "anon");//anon表示允许匿名访问
		filterMap.put("/dist/**", "anon");
		filterMap.put("/plugins/**", "anon");
		filterMap.put("/doLogin","anon");
		filterMap.put("/zhuce", "anon");
		filterMap.put("/toAddPwd", "anon");
		filterMap.put("/redishandle", "anon");
		
		filterMap.put("/alipay/notify", "anon");
		filterMap.put("/alipay/page/gotoPayPage", "anon");
		filterMap.put("/alipay/page/returnUrl", "anon");
		filterMap.put("/toAddUser", "anon");
		filterMap.put("/wxYanZheng", "anon");
		filterMap.put("/toOut","logout");
		filterMap.put("/**", "authc");//authc表示要认证才可访问
		fBean.setFilterChainDefinitionMap(filterMap);
		return fBean;
	}
	@Bean("lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor
	newLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	@DependsOn("lifecycleBeanPostProcessor")
	@Bean
	public DefaultAdvisorAutoProxyCreator newDefaultAdvisorAutoProxyCreator() {
		return new DefaultAdvisorAutoProxyCreator();
	}
	@Bean
	public AuthorizationAttributeSourceAdvisor 
	newAuthorizationAttributeSourceAdvisor(
			@Autowired SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor=
				new AuthorizationAttributeSourceAdvisor();
		return advisor;
	}

	@Bean
	public CacheManager newCacheManager() {
		return new MemoryConstrainedCacheManager();
	}

	@Bean
	public SimpleCookie newCookie() {
		SimpleCookie c=new SimpleCookie("rememberMe");
		c.setMaxAge(10*60);
		return c;
	}

	public CookieRememberMeManager newRememberMeManager() {
		CookieRememberMeManager cManager=
				new CookieRememberMeManager();
		cManager.setCookie(newCookie());
		return cManager;
	}
	@Bean
	public SecurityManager newSecurityManager(
			@Autowired Realm realm,
			@Autowired CacheManager cacheManager) {
		DefaultWebSecurityManager sManager=
				new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		sManager.setCacheManager(cacheManager);
		sManager.setRememberMeManager(newRememberMeManager());
		return sManager;
	}
	public DefaultWebSessionManager newSessionManager() {
		DefaultWebSessionManager sManager=
				new DefaultWebSessionManager();
		sManager.setGlobalSessionTimeout(60*60*1000);
		return sManager;
	}
}
