package com.gaozhao.app_service;
import com.gaozhao.app_common.util.Assist;
import com.gaozhao.app_pojo.domain.SysLoginLog;

import java.util.List;
public interface SysLoginLogService{
	/**
	 * 获得SysLoginLog数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getSysLoginLogRowCount(Assist assist);
	/**
	 * 获得SysLoginLog数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<SysLoginLog> selectSysLoginLog(Assist assist);
	/**
	 * 获得一个SysLoginLog对象,以参数SysLoginLog对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    SysLoginLog selectSysLoginLogByObj(SysLoginLog obj);
	/**
	 * 通过SysLoginLog的id获得SysLoginLog对象
	 * @param id
	 * @return
	 */
    SysLoginLog selectSysLoginLogById(Long id);
	/**
	 * 插入SysLoginLog到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertSysLoginLog(SysLoginLog value);
	/**
	 * 插入SysLoginLog中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptySysLoginLog(SysLoginLog value);
	/**
	 * 批量插入SysLoginLog到数据库
	 * @param value
	 * @return
	 */
    int insertSysLoginLogByBatch(List<SysLoginLog> value);
	/**
	 * 通过SysLoginLog的id删除SysLoginLog
	 * @param id
	 * @return
	 */
    int deleteSysLoginLogById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除SysLoginLog
	 * @param assist
	 * @return
	 */
    int deleteSysLoginLog(Assist assist);
	/**
	 * 通过SysLoginLog的id更新SysLoginLog中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateSysLoginLogById(SysLoginLog enti);
 	/**
	 * 通过辅助工具Assist的条件更新SysLoginLog中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateSysLoginLog(SysLoginLog value, Assist assist);
	/**
	 * 通过SysLoginLog的id更新SysLoginLog中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptySysLoginLogById(SysLoginLog enti);
 	/**
	 * 通过辅助工具Assist的条件更新SysLoginLog中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptySysLoginLog(SysLoginLog value, Assist assist);
}