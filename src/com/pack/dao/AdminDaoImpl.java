package com.pack.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.entity.Login;

@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public String loginAdmin(Login login) {
		// TODO Auto-generated method stub
		String page=null;
		Session s=this.sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		Query q=s.createQuery("from Login l where l.username=:username and l.password=:password");
		q.setParameter("username", login.getUsername());
		q.setParameter("password", login.getPassword());
		System.out.println("SATI"+q);
		Login l1=(Login)q.uniqueResult();
		System.out.println("SAHA"+l1);
		if(l1!=null)
			page="Home";
		else
			page="denied";
		t.commit();
		return page;
	}
	
}
