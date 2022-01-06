package xyz.tylt.mybatisLearn.tools;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class DBTools {

	 public static SqlSessionFactory sessionFactory;
	    
	    static{
	        try {
	            //使用MyBatis提供的Resources类加载mybatis的配置文件        	
	        	InputStream is = Resources.getResourceAsStream("mybatis.cfg.xml");
	        	//构建sqlSession的工厂
	            sessionFactory = new SqlSessionFactoryBuilder().build(is);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	    }
	    //创建能执行映射文件中sql的sqlSession
	    public static SqlSession getSession(){
	        return sessionFactory.openSession();
	    }
}
