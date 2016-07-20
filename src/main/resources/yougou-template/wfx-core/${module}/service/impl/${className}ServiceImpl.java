<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign entity = className + "Entity">
<#assign entityLower = classNameLower + "Entity">

package ${basepackage}.${module}.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.annotation.Resource;

import ${basepackage}.${module}.service.I${className}Service;
import ${basepackage}.${module}.dao.${className}Mapper;
import ${basepackage}.${module}.model.${entity};

import com.yougou.wfx.framework.base.BaseService;
import com.yougou.wfx.framework.utils.UUIDGenerator;

/**
 * I${className}Service实现
 * @author ${author}
 * @Date 创建时间：${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Service
public class ${className}ServiceImpl extends BaseService implements I${className}Service {
	
	@Resource
	private ${className}Mapper ${classNameLower}Mapper;

	@Override
	public int findPageCount(${entity} ${entityLower}){
		return ${classNameLower}Mapper.findPageCount(${entityLower});
	}

	@Override
	public List<${entity}> findPage(${entity} ${entityLower},RowBounds rowBounds){
		return ${classNameLower}Mapper.findPage(${entityLower},rowBounds);
	}
	
	@Override
	@Transactional
	public String insert(${entity} ${entityLower}){
		String strId = UUIDGenerator.get32LowCaseUUID();
		${entityLower}.setId(strId);
		${classNameLower}Mapper.insert(${entityLower});
		return strId;
	}
	
	@Override
	@Transactional
	public int update(${entity} ${entityLower}){
		return  ${classNameLower}Mapper.update(${entityLower});
	}
	
	@Override
	@Transactional
	public int remove(String id){
		return ${classNameLower}Mapper.remove(id);
	}
	
	@Override
	public ${entity} getById(String id){
		return ${classNameLower}Mapper.getById(id);
	} 
}