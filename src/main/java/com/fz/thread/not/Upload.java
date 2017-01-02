/**
 * 
 */
package com.fz.thread.not;

import com.fz.util.HUtils;
import com.fz.util.Utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据上传
 * 统一命名：
			上传本地文件：src/main/data/<algorithm_type>/<algorithm>.<extendtion>
			上传HDFS文件：/user/root/<algorithm_type>/<algorithm>/input.<extendtion>
 * @author fansy
 * @date 2015年8月5日
 */
public class Upload implements INotMRJob {

	private String select_value;
	private String algorithm;
	private String flag;
	@Override
	public void setArgs(String[] args) {
		this.select_value=args[0];
		this.algorithm=args[1];
		this.flag=args[2];
	}

	@Override
	public Map<String, Object> runJob() {
		Map<String ,Object> map = new HashMap<String,Object>();
		String local=null;
		String hdfs=null;
		if(flag!=null&& "initial".equals(flag)){// initial上传
			// arg1-> select_value, arg2->algorithm ;arg3->'initial'
			String filename = select_value;

            local=HUtils.LOCALPRE+select_value;

            local = Utils.getRootPathBasedPath(local);
			hdfs=HUtils.HDFSPRE+"/"+filename;
		}else{
			local=select_value;
			hdfs = algorithm;
		}
		
		//  arg1-> input (local), arg2-> hdfs
		
		map = HUtils.upload(local, hdfs);
		return map;
	}

}
