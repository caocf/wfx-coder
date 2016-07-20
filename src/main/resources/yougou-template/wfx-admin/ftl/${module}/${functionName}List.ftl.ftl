<#-- 分销包页面  -->
${r'<@compress single_line=compress_single_line?contains("true")>'}
<#-- =========head========-->
${r"<#assign head>"}
${r"</#assign>"}

<#-- =========footer===== -->
${r"<#assign footer>"}
	<!-- this page -->
	<script src="/static/js/manage/${module}/${functionName}List.js"></script>
${r"</#assign>"}

<#-- =========body======= -->
${r"<#assign body>"}
<div id="girdContent" class="row">
	<div class="col-xs-12">
		<button class="btn btn-yougou" onclick="">
        	<i class="ace-icon fa fa-pencil align-top bigger-125"></i>
        	新增
        </button>
        <div class="space-6"></div>
		<div class="row">
			<div class="col-xs-12">
				<!-- 搜索表单，需自定义 -->
				<form class="form-horizontal" id="searchForm">
		            <fieldset>
		                <div class="row">
		                    <div class="col-sm-12">
		                        <div class="form-group">
		                        	<label for="operator" class="col-sm-1 control-label col-xs-12 no-padding-right">id：</label>
									<div class="col-sm-2">
									    <input class="form-control input-sm" name="id" id="id" value="" type="text">
									</div>
									<div class="col-sm-3">
			                            <input type="button" value="搜索" class="btn btn-sm btn-yougou" onclick="doQuery();"/>
									</div>
		                        </div>
		                    </div>
		                </div>
		            </fieldset>
	        	</form>
			</div>
		</div>
	</div>
	
	<div class="space-6"></div>
	<div class="col-xs-12">
		<table id="grid-table" class="mmg"></table>
	    <div id="grid-pager" style="text-align:right;" class=""></div>
    </div>
</div>
${r"</#assign>"}

<#-- =========引入模板======= -->
${r'<#include "/include/pageBuilder.ftl" />'}
${r"</@compress>"}