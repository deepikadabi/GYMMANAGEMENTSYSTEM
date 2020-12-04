package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Admin;

@Repository
public class AdminDaoImple implements AdminDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void addAdmin(Admin admin) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(admin);
				tr.commit();
				session.flush();
				session.close();
				
				return null;
			}
		});
	}

	@Override
	public void deleteAdmin(int aId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> selectAll(int aId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgotPassword(String aEmail) {
		String password = hibernateTemplate.execute(new HibernateCallback<String>() {

			@Override
			public String doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Admin where aEmail = ?");
				q.setString(0, aEmail);
				List<Admin> li = q.list();
				String pass = null;
				if(!li.isEmpty())
					pass = li.get(0).getaPass();
				tr.commit();
				session.flush();
				session.close();
				return pass;
			}
			
		});
		return password;
	}
	
	@Override
	public boolean loginAdmin(Admin admin) {
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Admin where aEmail = ? and aPass = ?");
				q.setString(0, admin.getaEmail());
				q.setString(1, admin.getaPass());
				System.out.println(admin.getaEmail()+"---"+admin.getaPass());
				List<Admin> li = q.list();
				if(li.isEmpty()) {
					return false;
				}
				Admin u = (Admin)li.get(0);
				
				
				tr.commit();
				session.flush();
				session.close();
				if(u != null) {
					admin.setaId(u.getaId());
					System.out.println(admin.getaEmail()+"--111-"+admin.getaPass());

					return true;
					
				}
				
				return false;
			}
			
		});
	}
}


