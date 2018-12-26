package cn.coolwind.shiro.core.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                //从subject里获取已登入用户信息
                Subject subject = getSubject(request, response);
                String loginUser = (String) subject.getPrincipal();
                //获取本次登录用户
                String username = getUsername(request);
                //注销原用户
                if (username != null && loginUser != null) {
                    subject.logout();
                }
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }
}
