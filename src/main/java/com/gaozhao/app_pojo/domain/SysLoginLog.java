package com.gaozhao.app_pojo.domain;
public class SysLoginLog implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;//主键
    private String loginIpAddress;//登录IP地址
    private Integer loginType;//登录类型(0.PC,1.APP)
    private String loginUserName;//登录用户名
    private java.util.Date loginTime;//登录时间
    private Long fkCode;//外键
    public SysLoginLog() {
        super();
    }
    public SysLoginLog(Long id,String loginIpAddress,Integer loginType,String loginUserName,java.util.Date loginTime,Long fkCode) {
        super();
        this.id = id;
        this.loginIpAddress = loginIpAddress;
        this.loginType = loginType;
        this.loginUserName = loginUserName;
        this.loginTime = loginTime;
        this.fkCode = fkCode;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginIpAddress() {
        return this.loginIpAddress;
    }

    public void setLoginIpAddress(String loginIpAddress) {
        this.loginIpAddress = loginIpAddress;
    }

    public Integer getLoginType() {
        return this.loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public String getLoginUserName() {
        return this.loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public java.util.Date getLoginTime() {
        return this.loginTime;
    }

    public void setLoginTime(java.util.Date loginTime) {
        this.loginTime = loginTime;
    }

    public Long getFkCode() {
        return this.fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

}
