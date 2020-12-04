package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.cdac.dto.Admin;
import com.cdac.dto.User;

@Component
public class UserDaoImple implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public void insertUser(User user) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(user);
				tr.commit();
				session.flush();
				session.close();
				
				return null;
			}
		});
		// TODO Auto-generated method stub
	}

	@Override
	public User loginUser(User user) {
		User u1 = hibernateTemplate.execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from User where uEmail = ? and uPass = ?");
				q.setString(0, user.getuEmail());
				q.setString(1, user.getuPass());
				List<User> li = q.list();
				if(li.isEmpty()) {
					//System.out.println("userrrrrrrrrrr");
					return null;
				}
				User u = li.get(0);
				//System.out.println("user-------------------"+u);
				tr.commit();
				session.flush();
				session.close();
				if(u != null) {
					user.setuId(u.getuId());
					return u;
					
				}
				
				return null;
			}
			
			
		});
		return u1;
		
		


	
	}


	@Override
	public List<User> selectAll() {
		
		List<User> uList = hibernateTemplate.execute(new HibernateCallback<List<User>>() {

			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from User");
				List<User> li = q.list();
				
				System.out.println(li); 
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
			
		});
		return uList;
	}

	@Override
	public void deleteUser(int uId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.delete(new User(uId));
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}

	@Override
	public User selectUser(int uId) {
		User user = hibernateTemplate.execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				User ex = (User)session.get(User.class, uId);
				tr.commit();
				session.flush();
				session.close();
				return ex;
			}
			
		});
		return user;
	}

	@Override
	public void updateUser(User user) {
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
				System.out.println(user.getuId());
				System.out.println("hiiiiiii");

				session.update(user);
				System.out.println("byyiiiiii");
				System.out.println(user.toString());
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

	@Override
	public void newUpdate(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				System.out.println("In updatee");
				System.out.println(user);

//				Expense ex = (Expense)session.get(Expense.class, expense.getExpenseId());
//				ex.setItemName(expense.getItemName());
//				ex.setPrice(expense.getPrice());
//				ex.setPurchaseDate(expense.getPurchaseDate()); 
				
			//	User u = (User)session.get(User.class, user.getuId());
//				int uId = (int)session.get(User.class, user.getuId());
//				System.out.println(user.getuId());
//				Query q = session.createQuery("update user set uAge = ?, uBloodGroup = ?, uCity = ?, uDate = ?, uEmail = ?, uName = ?, uNum = ?, uPass = ? where uId = ?");
//				System.out.println(user.getuId());
//				System.out.println("hiiiiiii");
//				q.setInteger(0, user.getuAge());
//				q.setString(1, user.getuBloodGroup());
//				q.setString(2, user.getuCity());
//				q.setString(3, user.getuDate());
//				q.setString(4, user.getuEmail());
//				q.setString(5, user.getuName());
//				q.setInteger(6, user.getuNum());
//				q.setString(7, user.getuPass());
				
				session.update(user);
				System.out.println("byyiiiiii");
				System.out.println(user.toString());
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

	@Override
	public boolean removePack(int uId) {
		boolean flag = hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Transaction tr = session.beginTransaction();
				SQLQuery q = session.createSQLQuery("update user set pId = ? where uId = ?");
				q.setInteger(0, 0);
				q.setInteger(1, uId);
				int row = 	q.executeUpdate();
				tr.commit();
				session.flush();
				session.close();
				if(row>0) {
					return true;
				}
				return false;
			}
		});
		return flag;
	}

	@Override
	public String forgotPassword(String uEmail) {
		String password = hibernateTemplate.execute(new HibernateCallback<String>() {

			@Override
			public String doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from User where uEmail = ?");
				q.setString(0, uEmail);
				List<User> li = q.list();
				String pass = null;
				if(!li.isEmpty())
					pass = li.get(0).getuPass();
				tr.commit();
				session.flush();
				session.close();
				return pass;
			}
			
		});
		return password;
	}

	
	
}
