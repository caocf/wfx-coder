<#include "/macro.include"/>
<#include "/java_copyright.include">
package ${basepackage}.${module}.dto.input;
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign entity = className + "PageInputDto">
<#assign entityLower = classNameLower + "PageInputDto">

import java.util.Date;
import com.yougou.tools.common.utils.DatetimeUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.yougou.wfx.dto.base.InputDto;

/**
 * ${className}PageInputDto
 * @author ${author}
 * @Date 创建时间：${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public class ${className}PageInputDto extends InputDto{

	private static final long serialVersionUID = 1L;

<#list table.columns as column>
	/**
	 * ${column.columnAlias}
	 */
	private ${column.javaType} ${column.columnNameLower};
</#list>
	
<@generateConstructor entity/>
<@generateJavaColumns/>
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
	
<#macro generateJavaColumns>
	<#list table.columns as column>
	public void set${column.columnName}(${column.javaType} value) {
		<#if column.javaType == 'Integer'>
		value = value == null ? 0 : value;
		</#if>
		this.${column.columnNameLower} = value;
	}
	
	public ${column.javaType} get${column.columnName}() {
		<#if column.javaType == 'String'>
		return this.${column.columnNameLower} == null ? null : this.${column.columnNameLower}.trim();
			<#elseif column.javaType == 'Integer'>
		return this.${column.columnNameLower} == null ? 0 : this.${column.columnNameLower};
			<#else>
		return this.${column.columnNameLower};
		</#if>
	}
	<#if column.javaType == 'Date'>
	
	public String getString${column.columnName}() {
		if(this.${column.columnNameLower} == null){
		return null;
		}
		return DatetimeUtil.DateToString(this.${column.columnNameLower}, DatetimeUtil.LONG_DATE_TIME_PATTERN);
	}
	</#if>
	</#list>
</#macro>