package com.fuengp.spring_demo;

import com.fuengp.spring_demo.model.Emp;
import com.fuengp.spring_demo.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemoApplicationTests {
	@Resource
	EmpService empService ;

	@Test
	public void contextLoads() {
	}

	@Test
	public void empServiceFindById() {

//		empService.findById(99L) ;
//		empService.findById(10L) ;
//		empService.findById(10L) ;
//		empService.findById(10L) ;
//		empService.findById(10L) ;
		Emp emp = empService.findById(99L) ;
		System.out.println(emp.getName());

	}
	@Test
	public void empServiceEmpIdRank() {
		List<Emp> list = empService.empIdRank();
		System.out.println(list.get(list.size() -1).getId());
	}

	@Test
	public void empServiceAdd() {
		empService.addOrUpdate(new Emp(99l,"hello",new Date())) ;
	}

	@Test
	public void empServiceUpdate() {
		empService.addOrUpdate(new Emp(99l,"hello-u",new Date())) ;
	}
	@Test
	public void empServiceDelete() {
		empService.delete(99L);
	}

}
