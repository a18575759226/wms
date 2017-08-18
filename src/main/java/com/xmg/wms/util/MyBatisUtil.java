package com.xmg.wms.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisUtil {

	private MyBatisUtil() {
	}

	private static SqlSessionFactory fac;
	static {
		try {
			fac = new SqlSessionFactoryBuilder().build(Resources
					.getResourceAsStream("mybatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession openSession() {
		return fac.openSession();
	}
}
