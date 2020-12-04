package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.User;
import com.cdac.dto.UserPack;

@Repository

public class UserPackDaoImple implements UserPackDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void addUserPack(UserPack userPack) {
		// TODO Auto-generated method stub
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(userPack);
				tr.commit();
				session.flush();
				session.close();
				
				return null;
			}
		});
		
	}

	@Override
	public List<UserPack> selectAll(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean selectUserInPack(int uId) {
	
		return true;
	}

}
