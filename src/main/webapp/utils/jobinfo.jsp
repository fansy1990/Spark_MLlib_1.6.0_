<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <body>
  <div  data-options="region:'north',border:false" style="height:60px;padding:50px 50px 10px 50px;">
  <h1> 获取最新任务记录数：
      <select id="jobinfo_records" class="easyui-combobox"
              style="width:200px;">
          <option value="10">10</option>
          <option value="20">20</option>
          <option value="30">30</option>
          <option value="40">40</option>
          <option value="50">50</option>
          <option value="60">60</option>
      </select>
      任务日志信息：
  <a id="checkId" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'">刷新</a>
  </h1>
  <br><hr><br>
  </div>
    <table id="jobinfoId" class ="easyui-datagrid">
	
	</table>
	
	
	<script type="text/javascript" src="js/mr_monitor.js"></script>
  </body>

 