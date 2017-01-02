/**
 * 
 */
package com.fz.service;

import com.fz.dao.BaseDAO;
import com.fz.model.JobInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JobInfo service
 * @author fansy
 * @date 2017-1-2
 */
@Service("currentJobInfoService")
public class CurrentJobInfoService {
	
	private Logger log = LoggerFactory.getLogger(CurrentJobInfoService.class);

	@Resource
	private BaseDAO<JobInfo> baseDao;
	

	
	/**
	 * 分页获取tableName 所有数据
	 * @param tableName:类实体名
	 * @param rows
	 * @param page
	 * @return
	 */
	public Map<String,Object> getTableData(String tableName,int rows,int page){
		String hql = "from "+tableName;
		String hqlCount = "select count(1) from "+tableName;
		List<JobInfo> list =baseDao.find(hql, new Object[]{}, page, rows);
		Map<String ,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total", baseDao.count(hqlCount));
		jsonMap.put("rows", list);
		return jsonMap;
	}
	
	/**
	 * 保存数据
	 * @param jobInfo
	 * @return
	 */
	public boolean save(JobInfo jobInfo	){
		
		try{
			baseDao.save(jobInfo);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	

	/**
	 * 更新或者插入表
	 *
	 * @param jobInfo
	 * @return
	 */
	public boolean updateOrSave(JobInfo jobInfo){
		try{
			baseDao.saveOrUpdate(jobInfo);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
}
