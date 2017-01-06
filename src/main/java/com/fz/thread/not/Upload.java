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
		String local=null;
		String hdfs=null;
		if(flag!=null&& "initial".equals(flag)){// initial上传,指的是本地示例文件上传到HDFS
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
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("return_show", "upload_return");
        try {
             if( HUtils.upload(local, hdfs)) {
                 ret.put("return_txt", local + "上传至" + hdfs + "成功!");

                 ret.put("flag", "true");
                 ret.put("msg", "上传至 HDFS:'" + hdfs + "'" + "成功！");

                 Utils.simpleLog(hdfs + "上传至" + hdfs + "成功");
             }
        }catch(Exception e){
            ret.put("flag", "false");
            ret.put("msg", e.getMessage().substring(0,Utils.EXCEPTIONMESSAGELENGTH));
            e.printStackTrace();
        }

        return ret;
	}

}
