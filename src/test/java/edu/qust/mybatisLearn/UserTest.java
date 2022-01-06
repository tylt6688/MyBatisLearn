package edu.qust.mybatisLearn;

import org.apache.ibatis.session.SqlSession;

import xyz.tylt.mybatisLearn.beans.UserBean;
import xyz.tylt.mybatisLearn.mapper.UserMapper;
import xyz.tylt.mybatisLearn.tools.DBTools;

public class UserTest {

	public static void main(String[] args) {
		 UserTest.insert();
//		UserTest.selectUserById();
//		UserTest.updateUserById();
	}

	public static void insert() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserBean user = new UserBean("懿", "1314520", 7000.0);
		try {
			mapper.insertUser(user);
			System.out.println(user.toString());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		session.close();
	}

	private static void selectUserById() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			UserBean user = mapper.selectUserById(2);
			System.out.println(user.toString());

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	private static void updateUserById() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			UserBean user = mapper.selectUserById(1);
			System.out.println(user.toString());
			user.setUsername("777");
			System.out.println(user.toString());
			mapper.updateUser(user);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

}
