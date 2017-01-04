/**
 * 
 */
package com.fz.service;

import com.fz.dao.BaseDAO;
import com.fz.model.HConstants;
import com.fz.util.HUtils;
import com.fz.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库service
 * @author fansy
 * @date 2015-6-10
 */
@Service("dBService")
public class DBService {
	
	private Logger log = LoggerFactory.getLogger(DBService.class);

	@Resource
	private BaseDAO<Object> baseDao;
	
/**
 * 测试表中是否有数据 
 * @param tableName
 * @return
 */
	public boolean getTableData(String tableName){
		String hql ="from "+tableName+" ";
		List<Object> td = baseDao.find(hql);
		if(td.size()>0){
			return true;
		}
		return false;
	}
	/**
	 * 获得tableName的所有数据并返回
	 * @param tableName
	 * @return
	 */
	public List<Object> getTableAllData(String tableName){
		String hql ="from "+tableName+" ";
		List<Object> list = null;
		try{
			list=baseDao.find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
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
		List<Object> list =baseDao.find(hql, new Object[]{}, page, rows);
		Map<String ,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total", baseDao.count(hqlCount));
		jsonMap.put("rows", list);
		return jsonMap;
	}
	
	/**
	 * 保存数据
	 * @param list
	 * @return
	 */
	public boolean saveTableData(List<Object> list	){
		
		try{
			baseDao.saveBatch(list);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean deleteById(String tableName,String id){
		String hql ="delete " + tableName +"  tb where tb.id='"+id+"'";
		try{
			Integer ret = baseDao.executeHql(hql);
			log.info("删除表{},删除了{}条记录！",new Object[]{tableName,ret});
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteTable(String tableName){
		String hql ="delete " + tableName ;
		try{
			Integer ret = baseDao.executeHql(hql);
			log.info("删除表{},删除了{}条记录！",new Object[]{tableName,ret});
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 更新或者插入表
	 * 不用每个表都建立一个方法，这里根据表名自动装配
	 * @param tableName
	 * @param json
	 * @return
	 */
	public boolean updateOrSave(String tableName,String json){
		try{
			// 根据表名获得实体类，并赋值
			Object o = Utils.getEntity(Utils.getEntityPackages(tableName),json);
			baseDao.saveOrUpdate(o);
            if("HConstants".equals(tableName)){
                // 更新HUtils里面的Configuration；
                HUtils.updateConfiguration();
            }
			log.info("保存表{}！",new Object[]{tableName});
		}catch(Exception e){
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 获得Hadoop集群配置
	 * @param key
	 * @return
	 */
	public String getHConstValue(String key){
		HConstants hc=null;
		try{
			 hc = (HConstants) baseDao.find("from HConstants hc where hc.custKey='"+key+"'").get(0);
			if(hc==null){
				log.info("Hadoop基础配置表找不到配置的key：{}",key);
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.info("获取云平台配置信息出错，key："+key);
		}
		return hc.getCustValue();
	}
	
	
	/**
	 * 初始化HConstants
	 * @return
	 */
	public boolean insertHConstants(){
		try{
			baseDao.executeHql("delete HConstants");
            // @TODO 是否需要修改次此配置 ???
			baseDao.save(new HConstants("mapreduce.app-submission.cross-platform","true","是否跨平台提交任务"));
			baseDao.save(new HConstants("fs.defaultFS","hdfs://quickstart:8020","namenode主机及端口"));
			baseDao.save(new HConstants("mapreduce.framework.name","yarn","mapreduce 使用配置"));
			baseDao.save(new HConstants("yarn.resourcemanager.address","quickstart:8032","ResourceManager主机及端口"));
			baseDao.save(new HConstants("yarn.resourcemanager.scheduler.address","quickstart:8030","Scheduler主机及端口"));
			baseDao.save(new HConstants("mapreduce.jobhistory.address","quickstart:10020","JobHistory主机及端口"));
            baseDao.save(new HConstants("platform","cdh","apache或cdh或hdp"));
            baseDao.save(new HConstants("apache.yarn.application.classpath","","apache 集群classpath"));
            baseDao.save(new HConstants("cdh.yarn.application.classpath","$HADOOP_CLIENT_CONF_DIR,$HADOOP_CONF_DIR," +
                    "$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*," +
                    "$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*","cdh 集群classpath"));
            baseDao.save(new HConstants("hdp.yarn.application.classpath","","hdp 集群classpath"));


            baseDao.save(new HConstants("spark.yarn.jar",
                    "hdfs://quickstart:8020/user/root/spark-assembly-1.6.0-cdh5.8.0-hadoop2.6.0-cdh5.8.0.jar",
                    "Spark assemble jar 在HDFS上的地址"));
            baseDao.save(new HConstants("spark.yarn.scheduler.heartbeat.interval-ms",
                    "1000",
                    "Spark 提交任务等待时间"));
//            baseDao.save(new HConstants("spark.yarn.dist.archives",
//                    "hdfs://quickstart:8020/user/root/hadoop-common-2.6.0-cdh5.8.0.jar",
//                    "Spark executor extra jars ,逗号分割"));

            baseDao.save(new HConstants("spark.driver.memory","512M","Spark Driver 内存"));
            baseDao.save(new HConstants("spark.num.executors","2","Spark executor 个数"));
            baseDao.save(new HConstants("spark.executor.memory","256M","Spark executor 内存"));
            baseDao.save(new HConstants("spark.jar","hdfs://quickstart:8020/user/root/mllib.algorithm.1.6.0-1.0-SNAPSHOT.jar",
                    "Spark 算法所在jar包"));
            baseDao.save(new HConstants("spark.files","hdfs://quickstart:8020/user/root/yarn-site.xml",
                    "YARN site 文件所在路径"));
            // 做完更新后，需要更新Configuration
            HUtils.updateConfiguration();
        }catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	/**
	 * 获取分类数据占比
	 * @param k
	 * @return
	 */
	public List<String> getPercent(int k) {
		double[] percents= new double[k];
		double sum=0;
		String hql ="select count(1) from UserGroup ug where ug.groupType=?";
		for(int i=0;i<k;i++){
			percents[i]=baseDao.count(hql, new Object[]{i+1});
			sum+=percents[i];
		}
		List<String> list = new ArrayList<String>();
		for(int i=0;i<k;i++){
			list.add(Utils.obejct2Percent(percents[i]/sum, 2));// 保留两位小数
		}
		return list;
	}
	
}
