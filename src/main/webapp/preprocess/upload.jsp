<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">本地文件上传到HDFS或Demo文件上传</div>  
	<br>
	
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	    <h4> 注意：<br>
            1. src/main/data/里面的数据上传到HDFS；<br>

            2. 启动Tomcat的用户需要对上传的目录具有写入权限；<br>
            3. 数据初始化：选择一个数据源，上传数据到HDFS上,路径为/user/algorithm/input/data.dat; <br>
        </h4>
        <table>
		<!--  统一命名：
			上传HDFS文件：/user/algorithm/algorithm.dat ; 其中 algorithm为算法名，如
			/user/algorithm/logistic.dat
		 -->
			<tr>
				<td><label >本地路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="d:/splitDataset.txt"
					id="upload_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			<tr>
				<td><label >HDFS路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				value="/user/algorithm/test/input.txt"
					id="upload_output" data-options="required:true" style="width:300px" />
				</td>
				<td><a id="upload_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">上传</a></td>
			</tr>
			
			<tr>
				<td>数据初始化:</td>
				<td><select id="prepare_select" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="logistic.dat">logistic</option>
						<option value="svm.dat">svm</option>
						<option value="split.txt">split</option>

				</select></td>

				<td><a id="upload_prepare_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">初始化</a>
				</td>
			</tr>

			
		</table>
        <br>
	<div id="upload_return" style="padding-left: 30px;font-size: 14px;padding-top:10px;"></div>
	</div> 
	<script type="text/javascript" src="js/preprocess.js"></script>  

</body>

