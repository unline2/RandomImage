package me.ffis.randomImage.interceptor;

import me.ffis.randomImage.config.ReadListConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 限制白名单的域名才能访问
 * Created by fanfan on 2020/01/07.
 */
public class DomainInterceptor implements HandlerInterceptor {


    @Value("${customize.noReferer}")
    private boolean noReferer;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的referer
        String referer = request.getHeader("referer");
        if (referer == null || "".equals(referer)) {
            //判断是否允许referer为空访问
            if (!noReferer) {
                //referer为空转发到首页
                request.getRequestDispatcher("/index.html").forward(request, response);
                return false;
            }
            //referer为null，跳过白名单验证
            return true;
        }
        //取出域名白名单的list集合
        List<String> list = ReadListConfig.listMap.get("domains.txt");
        //如果domains.txt文件不存在或者文件为空，则不限制访问
        if (list == null || list.isEmpty()) {
            return true;
        }
        //域名在白名单，放行
        for (String domain : list) {
            if (referer.contains(domain)) {
                return true;
            }
        }
        //域名不在白名单，跳转到未授权页面
        response.sendRedirect("/noautho.jpg");
        return false;
    }
}
