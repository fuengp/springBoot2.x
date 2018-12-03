package com.fuengp.spring_demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

//被springBoot扫描的组件
@Component
//将所有app前缀的属性赋值给对应Bean属性
@ConfigurationProperties(prefix = "app")
public class Config {
    private String name ;
    private String version;
    private Date createDate ;
    private Integer timeout ;
    private boolean showAct ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public boolean isShowAct() {
        return showAct;
    }

    public void setShowAct(boolean showAct) {
        this.showAct = showAct;
    }
}
