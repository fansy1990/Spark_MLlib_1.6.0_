/**
 * 
 */
package com.fz.utils;

//import java.util.HashMap;

import com.fz.model.AlgoType;
import com.fz.model.ObjectInterface;
import com.fz.service.DBService;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.*;

/**
 * 工具类
 * @author fansy
 * @date 2015-6-8
 */
public class Utils {

    public static final int EXCEPTIONMESSAGELENGTH = 30;// 异常字符串截取长度
    public static final int SUBMIT2APPIDTIMEOUT = 50;// 提交任务最长时间阈值

    private static Logger logger = LoggerFactory.getLogger(Utils.class);
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
     * 不采用Utils日志，而在每个类中加入日志
	 * @param msg
	 */
//	public static void simpleLog(String msg){
////		System.out.println(new java.util.Date()+":"+msg);
//	    logger.info(msg);
//    }
//
//    public static void simpleWarnLog(String msg){
////		System.out.println(new java.util.Date()+":"+msg);
//        logger.warn(msg);
//    }

    /**
     * 更新map值，用于返回前台
     * @param map
     * @param flagStr
     * @param msgStr
     * @param return_showStr
     * @param return_txtStr
     */
    public static void updateMap(Map<String,Object> map , String flagStr,String msgStr,
                                 String return_showStr,String return_txtStr){
        map.put("flag", flagStr);
        map.put("msg", msgStr);
        map.put("return_show",return_showStr);
        map.put("return_txt",return_txtStr);
        return ;
    }

    /**
     * 更新map值，用于返回前台 return_txt 和msg内容一样
     * @param map
     * @param flagStr
     * @param msgStr
     * @param return_showStr
     */
    public static void updateMap(Map<String,Object> map , String flagStr,String msgStr,
                                 String return_showStr){
        updateMap(map,flagStr,msgStr,return_showStr,msgStr);
        return ;
    }

    public static void updateMap(Map<String,Object> map , String flagStr,Exception e,
                                 String return_showStr){
        String msgStr = "没有信息！";
        if(e == null || e.getMessage() == null){

        }else if(e.getMessage().length() < Utils.EXCEPTIONMESSAGELENGTH){
            msgStr = e.getMessage();
        }else if(e.getMessage().length() >= Utils.EXCEPTIONMESSAGELENGTH){
            msgStr = e.getMessage().substring(0,Utils.EXCEPTIONMESSAGELENGTH);
        }
        updateMap(map,flagStr,msgStr,return_showStr,msgStr);
        return ;
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

    /**
     * 打印map
     * @param map
     */
    public static void print(Map<String, Object> map) {
        System.out.println("print map==============================");
        for(Map.Entry kv : map.entrySet()){
            System.out.println("key:"+kv.getKey()+"->"+ kv.getValue());
        }
    }

    /**
     * 获取List中的某页数据值
     * @param list
     * @param page
     * @param rows
     * @return
     */
    public static Object getSubList(List<Object> list, int page, int rows) {
        int start = (page-1) *rows ;
        int end = page * rows ;
        end = end > list.size() ? list.size() : end ;
        System.out.println("start:"+start+",end:"+end);
        return list.subList(start, end);
    }

    /**
     * 根据算法名获取类名
     * @param algorithm 算法名是包名+类名
     * @return
     */
    public static String algorithm2ShowId(String algorithm) {
        try {
            String[] alg_class = algorithm.split("\\.");
            return alg_class[alg_class.length - 1];
        }catch(Exception e){
            logger.warn("算法：" + algorithm + "类名变换异常!");
        }
        return null;
    }

    /**
     * 算法名映射到类名，再映射到JobName
     * @param algorithm
     * @return
     */
    public static String algorithm2JobName(String algorithm){
        try{
          return  getKey(algorithm2ShowId(algorithm),dbOrFile);
        }catch (Exception e){
            logger.warn("算法："+ algorithm + "类名转化为JobName异常!");
        }
        return null;
    }
    private static  Map<String,AlgoType> algoTypeMap = new HashMap<String,AlgoType>();

    /**
     * 算法名映射为 算法类型
     * 主要用于判断两个算法是否可以对比
     * @param algorithm
     * @return
     */
    public static AlgoType algorithm2Type(String algorithm) {
        try {
            if(algoTypeMap.size() == 0){
                algoTypeMap.put("LogisticCallable",AlgoType.CLASSIFICATION);
                algoTypeMap.put("SVMCallable",AlgoType.CLASSIFICATION);
            }
            return algoTypeMap.get(algorithm2ShowId(algorithm));
        }catch(Exception e){
            logger.warn("算法："+ algorithm +" 获取算法类型异常！");
        }
        return null ;
    }
}
