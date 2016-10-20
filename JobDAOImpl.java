package com.niit.collabration2.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.niit.collabration2.model.Job;

@EnableTransactionManagement
@Repository(value = "jobDAO")
public class JobDAOImpl implements JobDAO {
	public JobDAOImpl() {
		System.out.println("in JobDAO Impl");
	}

	@Autowired
	private SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	public boolean save(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Job job) {
		try {
			sessionFactory.getCurrentSession().delete(job);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Job get(int jobid) {
		String hql = "from job where jobid=" + "'" + jobid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Job> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	public List<Job> list() {
		String hql = "from jobz";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}

