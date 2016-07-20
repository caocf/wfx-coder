<#assign functionNameUper = functionName?cap_first>
/*************
	${table.tableAlias}
**************/
// 操作列动作
var actionFixed = function(val,item,rowIndex){
	var html = [];
	html.push('<a href="javascript:void(0);" action="select">查看</a>&nbsp;&nbsp;');
	html.push('<a href="javascript:void(0);" action="edit">编辑</a>&nbsp;&nbsp;');
	html.push('<a href="javascript:void(0);" action="delete">删除</a>&nbsp;&nbsp;');
    return html.join('');
};

// 列集合
var cols = [
<#list table.columns as column>
<#if column.columnNameLower != 'id'>
	<#if column.javaType == 'Integer'||column.javaType == 'Double'>
	{ title:'${column.columnAlias}', name:'${column.columnNameLower}', align:'center'},
	<#elseif column.javaType == 'Date'>
	{ title:'${column.columnAlias}', name:'${column.columnNameLower}', align:'center', renderer: YouGou.Util.timeFixed},
	<#else>
	{ title:'${column.columnAlias}', name:'${column.columnNameLower}', align:'left'},
	</#if>
</#if>
</#list>
	{ title:'操作', name:'' ,width:200, align:'center',lockWidth:true, renderer: actionFixed},
    { title:'ID', name:'id', hidden: true}
];

//分页器
var mmPaginator = $('#grid-pager').mmPaginator({});
// 搜索表单属性
var mmFormParams = new MMSearchFormParams("searchForm");

// 表格	
var mmGrid = $('#grid-table').mmGrid({
	height: 'auto',
	cols: cols,
	url: '/${module}/query${functionNameUper}Data.sc',
	fullWidthRows: true,
	autoLoad: true,
	plugins: [mmPaginator,mmFormParams]
});

// 表格事件
mmGrid.on('cellSelected', function(e, item, rowIndex, colIndex){
	var action = $(e.target).attr("action");
    //编辑
    if(action == "edit"){
    	YouGou.UI.Dialog.alert({message:"编辑"});
    }else if(action == "delete"){// 删除
   		YouGou.UI.Dialog.confirm({
   			message : "确定要删除吗？"
   		},function(result){
   			if(result) {
                remove${functionNameUper}(item.id);
            }
   		});
    }else if(action == "select"){//查看
    	YouGou.UI.Dialog.alert({message:"查看"});
    }
    e.stopPropagation();  //阻止事件冒泡
});

function remove${functionNameUper}(id){
	YouGou.Ajax.doPost({
		successMsg: '删除成功！',
		url: '/${module}/remove${functionNameUper}.sc',
	  	data: { "id" : id },
	  	success : function(data){
  			mmGrid.load();
		}
	});
}

function doQuery(){
	mmGrid.load();
}