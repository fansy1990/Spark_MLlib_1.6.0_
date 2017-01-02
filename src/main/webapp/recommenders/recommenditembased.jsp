<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">recommenditembased算法调用</div>  
	<br>
		<div style="padding-left: 30px;font-size: 15px;padding-top:10px;"><br>
		拷贝mahout的lib下面的：lucene-core-4.6.1.jar 到hadoop lib目录
	  </div>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="/user/root/recommenders/recommenditembased/input.csv"
					id="recommenditembased_input" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			<tr>
				<td><label for="name">HDFS输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="/user/root/recommenders/recommenditembased/output"
					id="recommenditembased_output" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">ItemSimilarity输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="/user/root/recommenders/recommenditembased/output_similarityMatrix"
					id="recommenditembased_opfsm" data-options="required:true" style="width:400px" />
				</td>
				<td>项目相似度矩阵输出路径</td>
			</tr>
			
			<tr>
				<td><label for="name">推荐个数:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="10"
					id="recommenditembased_num" data-options="required:true" style="width:100px" />
				</td>
			</tr>
			<tr>
				<td><label for="name">输入数据是否包含评分值:</label>
				</td>
				<td>
				<select id="recommenditembased_b" class="easyui-combobox" 
					style="width:200px;">
						<option value="true">包含</option>
						<option value="false">不包含</option>

				</select>
				</td>
			</tr>
			
			<tr>
				<td><label for="name">maxPrefsPerUser:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="10"
					id="recommenditembased_mxp" data-options="required:true" style="width:100px" />
				</td>
				<td>每个用户在最后的推荐阶段的最大参考数</td>
			</tr>
			
			<tr>
				<td><label for="name">minPrefsPerUser:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="1"
					id="recommenditembased_mp" data-options="required:true" style="width:100px" />
				</td>
				<td>在计算相似度时，用户最小的参考数，如果用户的参考数低于此数值，用户将会被忽略</td>
			</tr>
			<tr>
				<td><label for="name">maxSimilaritiesPerItem:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="100"
					id="recommenditembased_m" data-options="required:true" style="width:100px" />
				</td>
				<td>每个项目最大的相似度个数</td>
			</tr>
			
			<tr>
				<td><label for="name">maxPrefsInItemSimilarity:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="500"
					id="recommenditembased_mpiis" data-options="required:true" style="width:100px" />
				</td>
				<td>在计算项目相似度时，每个用户或项目最大的参考个数，大于此值将会被采样处理</td>
			</tr>
			
			<tr>
				<td><label for="name">相似度算法:</label>
				</td>
				<td>
				<select id="recommenditembased_s" class="easyui-combobox" 
					style="width:300px;">
						<option value="SIMILARITY_COOCCURRENCE">SIMILARITY_COOCCURRENCE</option>
						<option value="SIMILARITY_LOGLIKELIHOOD">SIMILARITY_LOGLIKELIHOOD</option>
						<option value="SIMILARITY_TANIMOTO_COEFFICIENT">SIMILARITY_TANIMOTO_COEFFICIENT</option>
						<option value="SIMILARITY_CITY_BLOCK">SIMILARITY_CITY_BLOCK</option>
						<option value="SIMILARITY_COSINE">SIMILARITY_COSINE</option>
						<option value="SIMILARITY_PEARSON_CORRELATION">SIMILARITY_PEARSON_CORRELATION</option>
						<option value="SIMILARITY_EUCLIDEAN_DISTANCE">SIMILARITY_EUCLIDEAN_DISTANCE</option>

				</select>
				</td>
			</tr>
			<tr>
				<td><label for="name">输出序列化否:</label>
				</td>
				<td>
				<select id="recommenditembased_seq" class="easyui-combobox" 
					style="width:200px;">
						<option value="false">文本</option>
						<option value="true">序列化</option>

				</select>
				</td>
			</tr>
			<tr>
				<td><a id="recommenditembased_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
	
	</div> 
	<script type="text/javascript" src="js/mr_recommenders.js"></script>  

</body>

