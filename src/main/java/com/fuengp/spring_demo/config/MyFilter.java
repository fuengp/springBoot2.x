package com.fuengp.spring_demo.config;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * 过滤器
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter ==> init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        System.out.println("MyFilter ==> doFilter");
        HttpServletRequest request  = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        if(uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith("png") || uri.endsWith("jpg")){
            filterChain.doFilter(request,servletResponse);
            return;
        }
        String ua = request.getHeader("user-agent");
        String ip = request.getRemoteAddr();
        Long st = new Date().getTime();
        filterChain.doFilter(request,servletResponse);
        Long et = new Date().getTime() ;
        System.out.println("ua ==> "+ua+" ip ==> "+ip+" uri ==> " + uri + " time ==> " + (et - st) + "ms");

    }

    @Override
    public void destroy() {
        System.out.println("MyFilter ==> destroy");
    }
}
