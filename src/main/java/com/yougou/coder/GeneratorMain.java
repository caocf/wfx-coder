package com.yougou.coder;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorFacade.GeneratorContext;

/**
 * 
 * @author wuyang
 */
public class GeneratorMain {

	private static void setContext() {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("sysTime", df.format(new Date()));
		GeneratorContext.setContext(map);
	}

	public static void main(String[] args) throws Exception {
		setContext();
		GeneratorFacade g = new GeneratorFacade();
		//g.printAllTableNames(); //打印数据库中的表名称
		g.deleteOutRootDir(); //删除生成器的输出目录
		//g.deleteByTable("tbl_demo_table", "yougou-template"); // 删除生成的文件
//		g.generateByTable("tbl_wfx_discover_article", "yougou-template"); // 通过数据库表生成文件,template为模板的根目录
//		g.generateByTable("tbl_wfx_discover_carousel_figure", "yougou-template"); // 通过数据库表生成文件,template为模板的根目录
		g.generateByTable("tbl_wfx_discover_channel", "yougou-template"); // 通过数据库表生成文件,template为模板的根目录
		//g.generateByAllTable("yougou-template");//自动搜索数据库中的所有表并生成文件,template为模板的根目录
		// g.generateByClass(Blog.class,"template_clazz");
		// 打开文件夹 by windows
		// Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));
	}
}
