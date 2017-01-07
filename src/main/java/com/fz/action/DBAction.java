package com.fz.action;

import com.alibaba.fastjson.JSON;
import com.fz.service.DBService;
import com.fz.utils.HUtils;
import com.fz.utils.Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("dBAction")
public class DBAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger log = LoggerFactory.getLogger(DBAction.class);
	@Resource
	private DBService dBService;
	private int rows;
	private int page;
	private String tableName;
	
	private String id;
	
	private String json;

    private int records; // 获取JobInfo中的总个数

    /**
     * 获取JobInfo表数据，
     * 规则：
     * 1. 获取JobInfo中最新的records条记录；
     * 2. 查找其中isFinished字段为false的数据；
     * 3. 根据2中查找的数据，去YARN获取其实时状态，并更新1中的数据，然后存入数据库中；
     * 4. 根据row和page字段分页返回JSON数据；
     */
    public void getJobInfo(){
        Map<String ,Object> jsonMap = new HashMap<String,Object>();
        // 1.
        List<Object> jobInfos = dBService.getLastNRows("JobInfo","jobId",true,records);
        // 2,3
        List<Object> list = null;
        try {
            list = HUtils.updateJobInfo(jobInfos);
            dBService.updateTableData(list);
        }catch (Exception e){
            e.printStackTrace();
            Utils.simpleLog("更新任务状态异常！");
            jsonMap.put("total", 0);
            jsonMap.put("rows", null);
            Utils.write2PrintWriter(JSON.toJSONString(jsonMap));
            return ;
        }
        // 4.
        jsonMap.put("total",list.size());
        jsonMap.put("rows",Utils.getSubList(list,page,rows));
        Utils.write2PrintWriter(JSON.toJSONString(jsonMap));
    }

	/**
	 * 根据tableName分页获取表数据
	 */
	public void getTableData(){
		Map<String,Object> list = dBService.getTableData(tableName,rows, page);
		String json =JSON.toJSONString(list);
		log.info(json);
		Utils.write2PrintWriter(json);
	}
	
	
	/**
	 * 安装id删除表中数据
	 */
	public void deleteById(){
		boolean delSuccess =dBService.deleteById(tableName, id);
		String msg="fail";
		if(delSuccess){
			msg="success";
		}
		log.info("删除表"+tableName+(delSuccess?"成功":"失败"+"!"));
		Utils.write2PrintWriter(msg);
	}
	
	/**
	 * 更新或者保存数据
	 */
	public void updateOrSave(){
		boolean delSuccess =dBService.updateOrSave(tableName, json);
		String msg="fail";
		if(delSuccess){
			msg="success";
		}
		log.info("保存表"+tableName+(delSuccess?"成功":"失败"+"!"));
		Utils.write2PrintWriter(msg);
	}
	/**
	 * 初始化表 
	 */
	public void initialTable(){
		boolean initRet = false;
        try {
            if ("LoginUser".equals(tableName)) {
//			initRet=dBService.insertLoginUser();
            } else if ("HConstants".equals(tableName)) {
                initRet = dBService.insertHConstants();
            } else {
//			initRet = dBService.insertUserData();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
		Utils.write2PrintWriter(initRet);
	}

	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}


	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}


	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}


    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }
}
