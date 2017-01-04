/**
 * 
 */
package com.fz.util;

//import java.util.HashMap;

import com.fz.model.ObjectInterface;
import com.fz.service.DBService;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.context.ContextLoader;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 工具类
 * @author fansy
 * @date 2015-6-8
 */
public class Utils {

	// hadoop 常量
    public static boolean dbOrFile = false; // get configuration from db or file
    // ,true : db,false:file
	//
	public static String baseServicePacakges="com.fz.service.*";
	public static final String THREADPACKAGES ="com.fz.thread.";
	public static final String THREADNOTPACKAGES ="com.fz.thread.not.";
	
	
//	private static Map<String,String> HADOOPCONSTANTS=new HashMap<String,String>();
	private static ResourceBundle resb = null;
	private static PrintWriter  writer=null;
	
	private static int counter=0;// 在任务运行时返回递增的点字符串
	
	/**
	 * 初始化登录表数据
	 */
//	static{// 这种方式不行
//		dBService.insertLoginUser();
//		System.out.println(new java.util.Date()+"：初始化登录表完成！");
//	}
	
	public static String getKey(String key,boolean dbOrFile){
		if(dbOrFile){
			DBService dbService =(DBService)SpringUtil.getBean("dBService");
			return dbService.getHConstValue(key);
		}
		if(resb==null){
			Locale locale = new Locale("zh", "CN"); 
            resb = ResourceBundle.getBundle("util", locale); 
		}
        return resb.getString(key);
	}
	
	/**
	 * 向PrintWriter中输入数据
	 * @param info
	 */
	public static void write2PrintWriter(String info){
		try{
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			writer= ServletActionContext.getResponse().getWriter();
			
			writer.write(info);//响应输出
			//释放资源，关闭流
			writer.flush();
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @param flag
	 */
	public static void write2PrintWriter(boolean flag) {
			write2PrintWriter(String.valueOf(flag));
	}

	/**
	 * 根据类名获得实体类
	 * @param tableName
	 * @param json
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws java.io.IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@SuppressWarnings("unchecked")
	public static Object getEntity(String tableName, String json) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JsonParseException, JsonMappingException, IOException {
		Class<?> cl = Class.forName(tableName);
		ObjectInterface o = (ObjectInterface)cl.newInstance();
		Map<String,Object> map = new HashMap<String,Object>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			//convert JSON string to Map
			map = mapper.readValue(json, Map.class);
			return o.setObjectByMap(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *  获得表的实体类的全路径
	 * @param tableName
	 * @return
	 */
	public static String getEntityPackages(String tableName){
		return "com.fz.model."+tableName;
	}
	public static String getThreadPackages(String thread){
		return "com.fz.thread."+thread;
	}
	/**
	 * 获得根路径
	 * @return
	 */
	private static String getRootPath(){
        String rootPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
//        System.out.println("Root Path:" +rootPath);
		return rootPath ;
	}
	
	/**
	 * 获得根路径下面的subPath路径
	 * @param subPath
	 * @return
	 */
	public static String getRootPathBasedPath(String subPath){
		return getRootPath()+subPath;
	}

	/**
	 * 获得递增点字符串
	 * @return
	 */
	public static String getDotState(String pre){
		counter++;
		StringBuffer buff =new StringBuffer();
		for(int i=0;i<counter;i++){
			buff.append("~");
		}
		if(counter>=7){
			counter=0;
		}
		return pre+buff.toString();
	}

	
	
	/**
	 * 简单日志
	 * @param msg
	 */
	public static void simpleLog(String msg){
		System.out.println(new java.util.Date()+":"+msg);
	}


	
	/**
	 * double 或者float或者int转为百分数
	 * @param dou
	 * @param dotNum
	 * @return
	 */
	public static String obejct2Percent(Object dou,int dotNum){
		double dd= (Double)dou;
		//百分数格式化
		NumberFormat fmt = NumberFormat.getPercentInstance();
		fmt.setMaximumFractionDigits(dotNum);//最多dotNum位百分小数
		return fmt.format(dd);
	}

	/**
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static Object getClassByName(String thread) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class<?> cl = Class.forName(thread);
		Object o = cl.newInstance();
		return o;
	}
	
	public static void printStringArr(String[] args){
		System.out.println("args：");
		for(int i=0;i<args.length;i++){
			System.out.print(args[i]+",");
		}
		System.out.println();
	}
	
	
	public static String getFileName(String file){
		return new File(file).getName();
	}
}
