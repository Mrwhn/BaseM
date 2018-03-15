package com.hnwu.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by 吴会楠 on 2018/1/16.
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private BlogUserDetailService blogUserDetailService;

    @Autowired
    public void setBlogUserDetailService(BlogUserDetailService blogUserDetailService) {
        this.blogUserDetailService = blogUserDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(new String[]{"/self/logon","/self/logon","/bootstrap/**","/common/**","/jquery*/**"})
                .permitAll()
                .antMatchers("/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/self/logon").defaultSuccessUrl("/self/main")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/self/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        System.out.println("开始身份认证..");
        builder.userDetailsService(blogUserDetailService);
        System.out.println("身份认证结束！");
    }
}
