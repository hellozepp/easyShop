package com.cy.sys.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.sys.dao.UserDao;
import com.cy.common.vo.User;


@Service
public class ShiroUserRealm extends AuthorizingRealm{
	@Autowired
	private UserDao userDao;
	@Override
	public void setCredentialsMatcher(
	    CredentialsMatcher credentialsMatcher) {
		//构建凭证匹配对象
		HashedCredentialsMatcher cMatcher=
		new HashedCredentialsMatcher();
		//设置加密算法
		cMatcher.setHashAlgorithmName("MD5");
		//设置加密次数
		cMatcher.setHashIterations(10);
		super.setCredentialsMatcher(cMatcher);
	}
	/**
	 * 通过此方法完成认证数据的获取及封装,系统
	 * 底层会将认证数据传递认证管理器，由认证
	 * 管理器完成认证操作。
	 */
	/**负责认证信息的获取及封装
	 * @param token 包含用户名和密码*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//1.获取用户名
		UsernamePasswordToken upToken=
		(UsernamePasswordToken)token;
		String username=upToken.getUsername();
		//2.基于用户名查询数据库
		User user=
		userDao.finddenglu(username);
		//3.判定用户是否存在
		if(user==null)
		throw new UnknownAccountException();
		//5.封装用户信息并返回
		ByteSource credentialsSalt=
		ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info=
		new SimpleAuthenticationInfo(
				user,//principal用户身份
				user.getPassword(), //hashedCredentials 已加密的密码
				credentialsSalt,
				getName());//返回给SecurityManager(本身认证和授权功能)
		return info;
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

}
