package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.cdac.dto.GymPackage;
import com.cdac.dto.User;

@Component
public class GymPackageDaoImple implements GymPackageDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void insertPackage(GymPackage gymPackage) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(gymPackage);
				tr.commit();
				session.flush();
				session.close();
				
				return null;
			}
		});
		
	}

	@Override
	public void deletePackage(int pId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.delete(new GymPackage(pId));
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

	@Override
	public GymPackage selectPackage(int pId) {
		GymPackage gymPackage = hibernateTemplate.execute(new HibernateCallback<GymPackage>() {

			@Override
			public GymPackage doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				GymPackage ex = (GymPackage)session.get(GymPackage.class, pId);
				tr.commit();
				session.flush();
				session.close();
				return ex;
			}
			
		});
		return gymPackage;
	}

	@Override
	public void updatePackage(GymPackage gymPackage) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				
				
//				Expense ex = (Expense)session.get(Expense.class, expense.getExpenseId());
//				ex.setItemName(expense.getItemName());
//				ex.setPrice(expense.getPrice());
//				ex.setPurchaseDate(expense.getPurchaseDate()); 
				
			//	User u = (User)session.get(User.class, user.getuId());
				//Query q = session.
				
				session.update(gymPackage);
				
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

	@Override
	public List<GymPackage> selectAll() {
		List<GymPackage> pList = hibernateTemplate.execute(new HibernateCallback<List<GymPackage>>() {

			@Override
			public List<GymPackage> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from GymPackage");
				List<GymPackage> li = q.list();
				System.out.println(li); 
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
			
		});
		return pList;
	}

}
