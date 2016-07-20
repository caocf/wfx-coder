<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign entity = className + "Entity">
<#assign entityLower = classNameLower + "Entity">

package ${basepackage}.${module}.api.background.impl;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import com.yougou.wfx.dto.base.PageModel;
import com.yougou.wfx.framework.bean.BeanUtil;
import com.yougou.wfx.framework.utils.RowBoundUtils;

import ${basepackage}.${module}.api.background.I${className}BackgroundApi;
import ${basepackage}.${module}.dto.input.${className}InputDto;
import ${basepackage}.${module}.dto.input.${className}PageInputDto;
import ${basepackage}.${module}.dto.output.${className}OutputDto;
import ${basepackage}.${module}.model.${className}Entity;
import ${basepackage}.${module}.service.I${className}Service;

/**
 * I${className}BackgroundApi实现
 * @author ${author}
 * @Date 创建时间：${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Service
public class ${className}BackgroundApiImpl implements I${className}BackgroundApi{
	
	@Resource
	I${className}Service ${classNameLower}Service;
	
	@Override
	public int removeById(String id) {
		return ${classNameLower}Service.remove(id);
	}

	@Override
	public String insert(${className}InputDto ${classNameLower}Dto) {
		return ${classNameLower}Service.insert(this.dtoToEntity(${classNameLower}Dto));
	}

	@Override
	public PageModel<${className}OutputDto> findPage(${className}PageInputDto pageInputDto,PageModel<${className}OutputDto> pageModel) {
		${className}Entity ${classNameLower}Entity = (${className}Entity) BeanUtil.convertBean(pageInputDto,${className}Entity.class);
		RowBounds rowBounds = RowBoundUtils.rowBounds(pageModel);

		int totalCount = ${classNameLower}Service.findPageCount(${classNameLower}Entity);
		List<${className}Entity> lst${className}s = ${classNameLower}Service.findPage(${classNameLower}Entity, rowBounds);

		return new PageModel<${className}OutputDto>(pageModel.getPage(),pageModel.getLimit(), totalCount,(List<${className}OutputDto>) BeanUtil.convertBeanList(lst${className}s,${className}OutputDto.class));
	}

	@Override
	public int update(${className}InputDto ${classNameLower}Dto) {
		return ${classNameLower}Service.update(this.dtoToEntity(${classNameLower}Dto));
	}

	@Override
	public ${className}OutputDto getById(String id) {
		${className}Entity ${classNameLower}Entity = ${classNameLower}Service.getById(id);
		return this.entityToDto(${classNameLower}Entity);
	}
	
	private ${className}Entity dtoToEntity(Object obj){
		return (${className}Entity) BeanUtil.convertBean(obj,${className}Entity.class);
	}
	
	private ${className}OutputDto entityToDto(Object obj){
		return (${className}OutputDto) BeanUtil.convertBean(obj,${className}OutputDto.class);
	}
}
