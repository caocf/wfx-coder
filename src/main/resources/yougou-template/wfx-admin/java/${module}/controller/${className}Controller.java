<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign functionNameUper = functionName?cap_first>

<#assign api = "I"+table.className+"BackgroundApi">   
<#assign apiLower = className?uncap_first+"BackgroundApi">

package ${basepackage}.manage.${module}.controller;

import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import ${basepackage}.dto.base.PageModel;
import com.yougou.wfx.framework.ajax.JsonResult.StateCode;
import ${basepackage}.framework.base.BaseController;
import ${basepackage}.framework.bean.BeanUtil;
import ${basepackage}.manage.${module}.vo.${className}PageVo;
import ${basepackage}.${module}.api.background.I${className}BackgroundApi;
import ${basepackage}.${module}.dto.input.${className}InputDto;
import ${basepackage}.${module}.dto.input.${className}PageInputDto;
import ${basepackage}.${module}.dto.output.${className}OutputDto;

/**
 * ${className}Controller
 * @author ${author}
 * @Date 创建时间：${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Controller
@RequestMapping("/${module}")
public class ${className}Controller extends BaseController{
	
	@Resource
	private ${api} ${apiLower};
	
	/**
	 * 进入菜单
	 */
	@RequestMapping("/${functionName}List")
	public String ${functionName}List(){
		return "/manage/${module}/${functionName}List";
	}
	
	/**
	 * 分页查询数据，并返回json格式的结果
	 */
	@RequestMapping("/query${functionNameUper}Data")
	@ResponseBody
	public String query${functionNameUper}Data(ModelMap map, ${className}PageVo ${classNameLower}Vo, PageModel<${className}OutputDto> pageModel)throws Exception{
		${className}PageInputDto pageInputDto = (${className}PageInputDto) BeanUtil.convertBean(${classNameLower}Vo, ${className}PageInputDto.class);
		PageModel<${className}OutputDto> result = ${classNameLower}BackgroundApi.findPage(pageInputDto, pageModel);
		return JSONObject.toJSONString(result);
	}
	
	@RequestMapping("/get${functionNameUper}ById")
	@ResponseBody
	public String get${functionNameUper}ById(String id) throws Exception {
		${className}OutputDto ${classNameLower} = new ${className}OutputDto();
		try {
			Assert.hasText(id, "id不能为空！");
			${classNameLower} = ${classNameLower}BackgroundApi.getById(id);
		} catch (Exception e) {
			logger.error("查询数据异常", e);
			return super.jsonResult(StateCode.ERROR, "发生异常,e=" + e.getMessage());
		}
		return super.jsonResult(StateCode.SUCCESS, SUCCESS, ${classNameLower});
	}
	
	@RequestMapping("/remove${functionNameUper}")
	@ResponseBody
	public String remove${functionNameUper}(@RequestParam("id") String id) {
		try {
			Assert.hasText(id, "参数id不能为空");
			${apiLower}.removeById(id);
		} catch (Exception ex) {
			logger.error("删除数据异常", ex);
			return super.jsonResult(StateCode.ERROR, "发生异常,ex=" + ex.getMessage());
		}
		return super.jsonResult(StateCode.SUCCESS, SUCCESS);
	}
	
	@RequestMapping("/save${functionNameUper}")
	@ResponseBody
	public String save${functionNameUper}(${className}InputDto ${classNameLower}) {
		try {
			String id = ${classNameLower}.getId();
			if (StringUtils.isNotBlank(id)) {
				${apiLower}.update(${classNameLower});
			}else{
				${apiLower}.insert(${classNameLower});
			}
		} catch (Exception e) {
			logger.error("保存数据异常", e);
			return super.jsonResult(StateCode.ERROR, "发生异常,ex=" + e.getMessage());
		}
		return super.jsonResult(StateCode.SUCCESS, SUCCESS);
	}
}
