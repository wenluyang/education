package com.gaozhao.app_pojo.domain;
public class SysUser implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;//主键
    private String salt;//盐值
    private java.util.Date createTime;//创建时间
    private Long creatorFkCode;//创建者的fk_code
    private Integer delStatus;//删除状态
    private java.util.Date expiredDate;//Token过期时间
    private String token;//移动端登录时设置的Token(使用UUID)
    private java.util.Date updateTime;//更新时间
    private Long phone;//绑定的手机号，APP端可以代替账号用来登录
    private Integer identity;//用户的身份(1学生，2校长，3教职工，4教育局用户,5学校管理员,6超级管理员)，根据个人的身份连表查询的表就不一样
    private Long userFkCode;//用户关联的用户fk_code(相当于Basic_Worker_Infor表和Basic_Student_Infor表里的Fk_Code)
    private String userAccount;//用户账号
    private Long fkCode;//外键唯一标识
    private String pwd;//用户密码
    public SysUser() {
        super();
    }
    public SysUser(Long id,String salt,java.util.Date createTime,Long creatorFkCode,Integer delStatus,java.util.Date expiredDate,String token,java.util.Date updateTime,Long phone,Integer identity,Long userFkCode,String userAccount,Long fkCode,String pwd) {
        super();
        this.id = id;
        this.salt = salt;
        this.createTime = createTime;
        this.creatorFkCode = creatorFkCode;
        this.delStatus = delStatus;
        this.expiredDate = expiredDate;
        this.token = token;
        this.updateTime = updateTime;
        this.phone = phone;
        this.identity = identity;
        this.userFkCode = userFkCode;
        this.userAccount = userAccount;
        this.fkCode = fkCode;
        this.pwd = pwd;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreatorFkCode() {
        return this.creatorFkCode;
    }

    public void setCreatorFkCode(Long creatorFkCode) {
        this.creatorFkCode = creatorFkCode;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public java.util.Date getExpiredDate() {
        return this.expiredDate;
    }

    public void setExpiredDate(java.util.Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getPhone() {
        return this.phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Integer getIdentity() {
        return this.identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Long getUserFkCode() {
        return this.userFkCode;
    }

    public void setUserFkCode(Long userFkCode) {
        this.userFkCode = userFkCode;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Long getFkCode() {
        return this.fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", salt='" + salt + '\'' +
                ", createTime=" + createTime +
                ", creatorFkCode=" + creatorFkCode +
                ", delStatus=" + delStatus +
                ", expiredDate=" + expiredDate +
                ", token='" + token + '\'' +
                ", updateTime=" + updateTime +
                ", phone=" + phone +
                ", identity=" + identity +
                ", userFkCode=" + userFkCode +
                ", userAccount='" + userAccount + '\'' +
                ", fkCode=" + fkCode +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
