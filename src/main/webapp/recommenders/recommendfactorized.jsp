<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">ALS Recommenders算法调用</div>  
	<br>
		
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="/user/root/recommenders/parallelALS/output/userRatings"
					id="recommendfactorized_input" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			<tr>
				<td><label for="name">HDFS输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="/user/root/recommenders/recommendfactorized/output"
					id="recommendfactorized_output" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">userFeatures路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="/user/root/recommenders/parallelALS/output/U"
					id="recommendfactorized_userFeatures" data-options="required:true" style="width:400px" />
				</td>
				<td>ParallelALS任务中的用户特征值输出路径</td>
			</tr>
			<tr>
				<td><label for="name">itemFeatures路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="/user/root/recommenders/parallelALS/output/M"
					id="recommendfactorized_itemFeatures" data-options="required:true" style="width:400px" />
				</td>
				<td>ParallelALS任务中的项目特征值输出路径</td>
			</tr>
			<tr>
				<td><label for="name">推荐个数:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="10"
					id="recommendfactorized_num" data-options="required:true" style="width:100px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">maxRating:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="10"
					id="recommendfactorized_maxRating" data-options="required:true" style="width:100px" />
				</td>
				<td>最大的评分值</td>
			</tr>
			
			<tr>
				<td><label for="name">numThreads:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="1"
					id="recommendfactorized_numThreads" data-options="required:true" style="width:100px" />
				</td>
				<td>每个mapper的线程数</td>
			</tr>
			<tr>
				<td><a id="recommendfactorized_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
		</table>
	</div> 
	<script type="text/javascript" src="js/mr_recommenders.js"></script>  
</body>

