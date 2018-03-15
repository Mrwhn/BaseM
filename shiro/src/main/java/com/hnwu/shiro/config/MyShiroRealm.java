package com.hnwu.shiro.config;

import com.hnwu.shiro.rbac.user.entity.UserEntity;
import com.hnwu.shiro.rbac.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 吴会楠 on 2018/1/19.
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        UserEntity userEntity = (UserEntity)principals.getPrimaryPrincipal();
        String roles = userEntity.getRoles();
        String[] role = roles.split(",");
        for (int i = 0; i < role.length; i++) {
            simpleAuthorizationInfo.addRole(role[i]);
            for(int j = 0; j < 2; j++){
                simpleAuthorizationInfo.addStringPermission("P" + j);
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取用户的输入的账号
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());

        //获取输入密码
        String password = new String((char[])token.getCredentials());
        System.out.println(password);

        UserEntity userEntity = userService.queryUserByName(username);
        System.out.println(username + "----->>userInfo=" + userEntity);
        if(userEntity == null){
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
          userEntity.getUsername(),
                userEntity.getPassword(),
                ByteSource.Util.bytes(userEntity.getUsername()+""),
                getName()
        );

        // 当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", userEntity);
        session.setAttribute("userSessionId", userEntity.getId());

        return simpleAuthenticationInfo;
    }
}
