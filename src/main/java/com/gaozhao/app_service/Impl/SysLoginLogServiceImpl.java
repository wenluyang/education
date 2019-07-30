package com.gaozhao.app_service.Impl;
import com.gaozhao.app_common.util.Assist;
import com.gaozhao.app_dao.SysLoginLogMapper;
import com.gaozhao.app_pojo.domain.SysLoginLog;
import com.gaozhao.app_service.SysLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService{
    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;
    @Override
    public long getSysLoginLogRowCount(Assist assist){
        return sysLoginLogMapper.getSysLoginLogRowCount(assist);
    }
    @Override
    public List<SysLoginLog> selectSysLoginLog(Assist assist){
        return sysLoginLogMapper.selectSysLoginLog(assist);
    }
    @Override
    public SysLoginLog selectSysLoginLogByObj(SysLoginLog obj){
        return sysLoginLogMapper.selectSysLoginLogByObj(obj);
    }
    @Override
    public SysLoginLog selectSysLoginLogById(Long id){
        return sysLoginLogMapper.selectSysLoginLogById(id);
    }
    @Override
    public int insertSysLoginLog(SysLoginLog value){
        return sysLoginLogMapper.insertSysLoginLog(value);
    }
    @Override
    public int insertNonEmptySysLoginLog(SysLoginLog value){
        return sysLoginLogMapper.insertNonEmptySysLoginLog(value);
    }
    @Override
    public int insertSysLoginLogByBatch(List<SysLoginLog> value){
        return sysLoginLogMapper.insertSysLoginLogByBatch(value);
    }
    @Override
    public int deleteSysLoginLogById(Long id){
        return sysLoginLogMapper.deleteSysLoginLogById(id);
    }
    @Override
    public int deleteSysLoginLog(Assist assist){
        return sysLoginLogMapper.deleteSysLoginLog(assist);
    }
    @Override
    public int updateSysLoginLogById(SysLoginLog enti){
        return sysLoginLogMapper.updateSysLoginLogById(enti);
    }
    @Override
    public int updateSysLoginLog(SysLoginLog value, Assist assist){
        return sysLoginLogMapper.updateSysLoginLog(value,assist);
    }
    @Override
    public int updateNonEmptySysLoginLogById(SysLoginLog enti){
        return sysLoginLogMapper.updateNonEmptySysLoginLogById(enti);
    }
    @Override
    public int updateNonEmptySysLoginLog(SysLoginLog value, Assist assist){
        return sysLoginLogMapper.updateNonEmptySysLoginLog(value,assist);
    }

    public SysLoginLogMapper getSysLoginLogMapper() {
        return this.sysLoginLogMapper;
    }

    public void setSysLoginLogMapper(SysLoginLogMapper sysLoginLogMapper) {
        this.sysLoginLogMapper = sysLoginLogMapper;
    }

}