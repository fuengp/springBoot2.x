package com.fuengp.spring_demo.service;

import com.fuengp.spring_demo.model.Emp;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmpService {
    //对于默认情况下，Redis对象的序列化是使用JDK序列化，所以实体类必须实现Serializable接口
    //Cacheable 会将方法的返回值序列化后存储到redis中，key就是参数执行的字符串
    //Cacheable 的用途就是在执行此方法的时候检查key是否存在，如果存在则不再执行，返回redis存储的数据
    //没有对应的key会执行方法并序列化存储到redis
    //condition参数的代表条件成立才会缓存  unless参数代表条件不成立的时候才会缓存
    @Cacheable(value = "emp",key = "#id",condition = "#id != 10")
    public Emp findById(Long id){
        System.err.println("EmpService: findById");
        return new Emp(10l,"FUENGP",new Date());
    }

    @Cacheable(value = "emp:id:rank")
    public List<Emp> empIdRank(){
        List<Emp> list = new ArrayList<Emp>();
        System.err.println("EmpService: empIdRank");
        for (int i = 0 ; i < 10 ; i ++){
            list.add(new Emp(50l+i,"FUENGP",new Date()));
        }
        return list;
    }

    //@CachePut 作用是不管redis缓存内是否存在key，都会对数据进行更新
    @CachePut(value = "emp",key = "#emp.id")
    public Emp addOrUpdate(Emp emp){
        System.err.println("EmpService: addOrUpdate");
        return emp ;
    }

    @CacheEvict(value = "emp",key = "#empId")
    public void delete(Long empId){
        System.err.println("EmpService: delete");
    }

}
