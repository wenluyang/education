package com.gaozhao.app_service.Impl;
import java.util.List;
import com.gaozhao.app_dao.SysUserMapper;
import com.gaozhao.app_pojo.domain.SysUser;
import com.gaozhao.app_common.util.Assist;
import com.gaozhao.app_service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public long getSysUserRowCount(Assist assist){
        return sysUserMapper.getSysUserRowCount(assist);
    }
    @Override
    public List<SysUser> selectSysUser(Assist assist){
        return sysUserMapper.selectSysUser(assist);
    }
    @Override
    public SysUser selectSysUserByObj(SysUser obj){
        return sysUserMapper.selectSysUserByObj(obj);
    }
    @Override
    public SysUser selectSysUserById(Long id){
        return sysUserMapper.selectSysUserById(id);
    }
    @Override
    public int insertSysUser(SysUser value){
        return sysUserMapper.insertSysUser(value);
    }
    @Override
    public int insertNonEmptySysUser(SysUser value){
        return sysUserMapper.insertNonEmptySysUser(value);
    }
    @Override
    public int insertSysUserByBatch(List<SysUser> value){
        return sysUserMapper.insertSysUserByBatch(value);
    }
    @Override
    public int deleteSysUserById(Long id){
        return sysUserMapper.deleteSysUserById(id);
    }
    @Override
    public int deleteSysUser(Assist assist){
        return sysUserMapper.deleteSysUser(assist);
    }
    @Override
    public int updateSysUserById(SysUser enti){
        return sysUserMapper.updateSysUserById(enti);
    }
    @Override
    public int updateSysUser(SysUser value, Assist assist){
        return sysUserMapper.updateSysUser(value,assist);
    }
    @Override
    public int updateNonEmptySysUserById(SysUser enti){
        return sysUserMapper.updateNonEmptySysUserById(enti);
    }
    @Override
    public int updateNonEmptySysUser(SysUser value, Assist assist){
        return sysUserMapper.updateNonEmptySysUser(value,assist);
    }

    public SysUserMapper getSysUserMapper() {
        return this.sysUserMapper;
    }

    public void setSysUserMapper(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

}