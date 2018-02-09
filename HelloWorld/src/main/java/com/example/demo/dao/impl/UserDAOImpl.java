package com.example.demo.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserDAO;
import com.example.demo.domain.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory factory;

	@Override
	public List<User> findByEmail(String email) {
		Session session = this.factory.getCurrentSession();
		Query query = session.getNamedQuery("findByEmail");
		query.setString("email", email);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByEmailAndPassword(String email, String password) {
		Session session = this.factory.getCurrentSession();
		List<User> users = session.createCriteria(User.class)
		.add(Restrictions.eq("email", email))
		.add(Restrictions.eq("password", password))
		.list();
		return users;
	}

	@Override
	public User save(User user) {
		Session session = this.factory.getCurrentSession();
		session.beginTransaction();
		Serializable userId = session.save(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	@Override
	public void update(User user) {
		Session session = this.factory.getCurrentSession();
		User persistanceUser = session.load(User.class, Integer.valueOf(user.getId()));
		Transaction transaction = session.beginTransaction();
		persistanceUser.setFirstname(user.getFirstname());
		persistanceUser.setLastname(user.getLastname());
		session.update(persistanceUser);
		transaction.commit();
	}

}
