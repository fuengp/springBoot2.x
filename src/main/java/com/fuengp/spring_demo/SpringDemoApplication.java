package com.fuengp.spring_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 此类是springBoot入口，直接运行就可启动springBoot
 * 会自动扫描可以被注入的类，并且初始化
 */
@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		//启动springBoot并初始化相关组件
		SpringApplication.run(SpringDemoApplication.class, args);
	}
}
