<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign entity = className + "Entity">
<#assign entityLower = classNameLower + "Entity">

package ${basepackage}.${module}.service;

import org.apache.ibatis.session.RowBounds;
import ${basepackage}.${module}.model.${entity};
import java.util.List;

/**
 * I${className}Service接口
 * @author ${author}
 * @Date 创建时间：${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public interface I${className}Service {
	
	/**
	 * 获取总条数
	 */
	public int findPageCount(${entity} ${entityLower});

	/**
	 * 获取分页数据
	 */
	public List<${entity}> findPage(${entity} ${entityLower},RowBounds rowBounds);
	
	/**
	 * 保存单条记录
	 */
	public String insert(${entity} ${entityLower});
	
	/**
	 * 更新记录
	 */
	public int update(${entity} ${entityLower});
	
	/**
	 * 通过id删除记录
	 */
	public int remove(String id);
	
	/**
	 * 通过id查询数据
	 */
	public ${entity} getById(String id); 
}