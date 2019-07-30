package com.gaozhao.app_security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@Configuration
@ConfigurationProperties(prefix = "gaozhao.security")
//@EnableConfigurationProperties(SecurityMainProperties.class)
public class SecurityMainProperties {

    /**
     * 后台登陆属性配置
     */
    private SysProperties sys = new SysProperties();

    /**
     * pc端属性配置
     */
    private PcProperties pc = new PcProperties();

    /**
     * 移动端属性配置
     */
    private MobileProperties mb=new MobileProperties();

    /**
     * 通用属性配置
     */
    private CommonProperties common=new CommonProperties();

    /**
     * es-sso相关的配置
     */
    private EsSsoProperties esSso=new EsSsoProperties();

    public SysProperties getSys() {
        return sys;
    }

    public void setSys(SysProperties sys) {
        this.sys = sys;
    }

    public PcProperties getPc() {
        return pc;
    }

    public void setPc(PcProperties pc) {
        this.pc = pc;
    }

    public MobileProperties getMb() {
        return mb;
    }

    public void setMb(MobileProperties mb) {
        this.mb = mb;
    }

    public CommonProperties getCommon() {
        return common;
    }

    public void setCommon(CommonProperties common) {
        this.common = common;
    }

    public EsSsoProperties getEsSso() {
        return esSso;
    }

    public void setEsSso(EsSsoProperties esSso) {
        this.esSso = esSso;
    }
}
