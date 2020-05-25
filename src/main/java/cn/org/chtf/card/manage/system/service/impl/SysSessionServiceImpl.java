package cn.org.chtf.card.manage.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.org.chtf.card.manage.system.dao.SysSessionMapper;
import cn.org.chtf.card.manage.system.model.SysSession;
import cn.org.chtf.card.manage.system.service.SysSessionService;
import cn.org.chtf.card.support.util.CryptographyUtil;

/**
 * 届次信息ServiceImpl
 * @author lm
 */
@Service
public class SysSessionServiceImpl implements SysSessionService {

    @Autowired
    private SysSessionMapper sysSessionDao;

    /**
     * 查询届次信息列表
     */
    @Override
    public List<SysSession> list(Map<String, Object> map) {
        return sysSessionDao.list(map);
    }
    
    /**
     * 数量届次信息
     */
    @Override
    public int listcount(Map<String, Object> map) {
        return sysSessionDao.listcount(map);
    }


    /**
     * 通过id查询单个届次信息
     */
    @Override
    public SysSession findById(Integer id) {
        return sysSessionDao.findById(id);
    }

    /**
     * 通过map查询单个届次信息
     */
    @Override
    public SysSession findByMap(Map<String, Object> map) {
        return sysSessionDao.findByMap(map);
    }

    /**
     * 新增届次信息
     */
    @Override
    public int save(SysSession sysSession) {
        return sysSessionDao.save(sysSession);
    }

    /**
     * 修改届次信息
     */
    @Override
    public int update(SysSession sysSession) {
        return sysSessionDao.update(sysSession);
    }

    /**
     * 删除届次信息
     */
    @Override
    public int deleteById(Integer id) {
        return sysSessionDao.deleteById(id);
    }

	@Override
	public String getSessionID(HttpServletRequest request) {
		String url= CryptographyUtil.GeCurrenttUrl(request);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("url", url);
		return sysSessionDao.getSessionID(map);
	}

}
