package cn.org.chtf.card.manage.system.dao;

import cn.org.chtf.card.manage.system.model.SysSession;

import java.util.List;
import java.util.Map;


/**
 * 届次信息DAO
 * @author lm
 */
public interface SysSessionMapper {

    /**
     * 通过id查询单个届次信息
     */
    SysSession findById(Integer id);

    /**
     * 通过map查询单个届次信息
     */
    SysSession findByMap(Map<String, Object> map);

    /**
     * 查询届次信息列表
     */
    List<SysSession> list(Map<String, Object> map);

    /**
     * 新增届次信息
     */
    int save(SysSession sysSession);

    /**
     * 修改届次信息
     */
    int update(SysSession sysSession);

    /**
     * 删除届次信息
     */
    int deleteById(Integer id);

	/**
     * 通过map查询单个届次信息
     */
    int listcount(Map<String, Object> map);

	String getSessionID(Map<String, Object> map);

}
