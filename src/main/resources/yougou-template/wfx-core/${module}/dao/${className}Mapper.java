<#include "/macro.include"/>
<#include "/java_copyright.include">
package ${basepackage}.${module}.dao;
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign entity = className + "Entity">
<#assign entityLower = classNameLower + "Entity">

import java.util.List;
import org.apache.ibatis.session.RowBounds;
import ${basepackage}.${module}.model.${entity};

/**
 * ${className}Mapper
 * @author ${author}
 * @Date 创建时间：${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public interface ${className}Mapper{
	
	int findPageCount(${entity} ${entityLower});

	List<${entity}> findPage(${entity} ${entityLower},RowBounds rowBounds);
	
	int insert(${entity} ${entityLower});
	
	int update(${entity} ${entityLower});
	
	int remove(String id);
	
	${entity} getById(String id);
}
