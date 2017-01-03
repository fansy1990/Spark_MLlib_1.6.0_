/**
 * 
 */
package com.fz.thread.not;

import com.fz.util.HUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 读取HDFS txt文件
 * @author fansy
 * @date 2015年8月5日
 */
public class ReadTxt implements INotMRJob {
	private String input;
	private String lines;


	@Override
	public void setArgs(String[] args) {
		this.input=args[0];
		this.lines=args[1];
	}

	@Override
	public Map<String, Object> runJob() {
		Map<String ,Object> map = new HashMap<String,Object>();
		String txt =null;
		map.put("return_show", "readtxt_return");
		try{
			txt = HUtils.readTxt(input, lines, "<br>");
			txt ="文件的内容是:<br>"+txt;
			map.put("flag", "true");
			
			map.put("return_txt", txt);
		}catch(Exception e){
			e.printStackTrace();
			map.put("flag", "false");
			map.put("monitor", "false");
			map.put("msg", input+"读取失败！");
		}
		return map;
	}

}
