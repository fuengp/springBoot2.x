package com.fuengp.spring_demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.fuengp.spring_demo.config.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * 此类是springBoot入口，直接运行就可启动springBoot
 * 会自动扫描可以被注入的类，并且初始化
 */
@SpringBootApplication
//入口类启动的时候加载制定配置文件
@PropertySource("classpath:config.properties")
//启用SpringCache缓存，springCache会根据底层引用的jar包决定缓存的类型
@EnableCaching
public class SpringDemoApplication {
	@Resource
	DataSource dataSource ;

	//注册过滤器
	@Bean //会将方法中返回的对象再springBoot启动的时候放入IOC容器
	public FilterRegistrationBean filterRegis(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		//创建并注册过滤器
		filterRegistrationBean.setFilter(new MyFilter());
		//对路径/下所有请求进行过滤
		filterRegistrationBean.addUrlPatterns("/*");
		//过滤器名字
		filterRegistrationBean.setName("fuengp_myFilter");
		//过滤器排序，数字越小越靠前执行
		filterRegistrationBean.setOrder(1);
		System.out.println("dataSource ======>  " + dataSource);
		return filterRegistrationBean ;

	}

//	@Bean
//	public DataSource dataSource(){
//		DruidDataSource druidDataSource = new DruidDataSource();
//		druidDataSource.setInitialSize(5);
//		System.out.println(druidDataSource);
//		return druidDataSource;
//	}

	public static void main(String[] args) {

		//启动springBoot并初始化相关组件
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
