package com.niit.collabration2.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collabration2.model.Forum;
import com.niit.collabration2.model.Job;

@Repository
public interface JobDAO {


	public boolean save(Job job);

	public boolean update(Job job);

	public boolean delete(Job job);

	public Job get(int jobid);

	public List<Job> list();
}
