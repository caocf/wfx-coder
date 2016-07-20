<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>

package ${basepackage}.${module}.api.front;

import com.yougou.wfx.dto.base.PageModel;
import ${basepackage}.${module}.dto.input.${className}InputDto;
import ${basepackage}.${module}.dto.input.${className}PageInputDto;
import ${basepackage}.${module}.dto.output.${className}OutputDto;

/**
 * I${className}FrontApi
 * @author ${author}
 * @Date 创建时间：${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public interface I${className}FrontApi{
	/**
	 * 通过id删除记录
	 */
	public int removeById(String id);
	
	/**
	 * 保存单条记录
	 */
	public String insert(${className}InputDto ${classNameLower}Dto);
	
	/**
	 * 获取分页数据
	 */
	public PageModel<${className}OutputDto> findPage(${className}PageInputDto pageInputDto,PageModel<${className}OutputDto> pageModel);
	
	/**
	 * 更新记录
	 */
	public int update(${className}InputDto ${classNameLower}Dto);
	
	/**
	 * 通过id查询数据
	 */
	public ${className}OutputDto getById(String id);
}

