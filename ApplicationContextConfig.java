package com.niit.collabration2.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collabration2.dao.BlogDAO;
import com.niit.collabration2.dao.BlogDAOImpl;
import com.niit.collabration2.dao.ChatDAO;
import com.niit.collabration2.dao.ChatDAOImpl;
import com.niit.collabration2.dao.EventDAO;
import com.niit.collabration2.dao.EventDAOImpl;
import com.niit.collabration2.dao.ForumDAO;
import com.niit.collabration2.dao.ForumDAOImpl;
import com.niit.collabration2.dao.FriendDAO;
import com.niit.collabration2.dao.FriendDAOImpl;
import com.niit.collabration2.dao.JobDAO;
import com.niit.collabration2.dao.JobDAOImpl;
import com.niit.collabration2.dao.UserDAO;
import com.niit.collabration2.dao.UserDAOImpl;
import com.niit.collabration2.model.Blog;
import com.niit.collabration2.model.Chat;
import com.niit.collabration2.model.Event;
import com.niit.collabration2.model.Forum;
import com.niit.collabration2.model.Friend;
import com.niit.collabration2.model.Job;
import com.niit.collabration2.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
	@Bean(name = "dataSource")                               
	public DataSource getOracleDataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

	    dataSource.setUsername("harsha");
	    dataSource.setPassword("harsha");
	    return dataSource;
	}

	private Properties getHibernateProperties() {
	   

	      Properties connectionProperties=new Properties();

		  connectionProperties.setProperty("hibernate.show_sql", "true");   //to display the queries ,,,,can be given false if u want to hide the queries
		  connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		  connectionProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		  connectionProperties.setProperty("hibernate.jdbc.use_get_generated_keys","true");
		//  connectionProperties.setProperty("hibernate.current_session_context_class", "thread");
		 // dataSource.setConnectionProperties(connectionProperties);
		  return connectionProperties;
		}



	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(Chat.class);
		sessionBuilder.addAnnotatedClass(Friend.class);
		sessionBuilder.addAnnotatedClass(Event.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		return sessionBuilder.buildSessionFactory();
	}

		
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);  //should be same name as bean name of session factory
		return transactionManager;
		}
			@Autowired
			@Bean(name = "UserDAO")
			public UserDAO getUserDAO(SessionFactory sessionFactory) {

			return new UserDAOImpl(sessionFactory);
			}
			@Autowired
			@Bean(name = "user")
			public User getUser (){
			return new User();
			}
			@Autowired
			@Bean(name = "friend")
			public Friend getFriend (){
			return new Friend();
			}
			@Autowired
			@Bean(name = "FriendDAO")
			public FriendDAO getFriendDAO(SessionFactory sessionFactory) {

			return new FriendDAOImpl(sessionFactory);
			}
			@Autowired
			@Bean(name = "blog")
			public Blog getBlog (){
			return new Blog();
			}
			@Autowired
			@Bean(name = "BlogDAO")
			public BlogDAO getBlogDAO(SessionFactory sessionFactory) {

			return new BlogDAOImpl(sessionFactory);
			}
			@Autowired
			@Bean(name = "chat")
			public Chat getChat (){
			return new Chat();
			}
			@Autowired
			@Bean(name = "ChatDAO")
			public ChatDAO getChatDAO(SessionFactory sessionFactory) {

			return new ChatDAOImpl(sessionFactory);
			}
			@Autowired
			@Bean(name = "event")
			public Event getEvent (){
			return new Event();
			}
			@Autowired
			@Bean(name = "EventDAO")
			public EventDAO getEventDAO(SessionFactory sessionFactory) {

			return new EventDAOImpl(sessionFactory);
			}
			@Autowired
			@Bean(name = "forum")
			public Forum getForum (){
			return new Forum();
			}
			@Autowired
			@Bean(name = "ForumDAO")
			public ForumDAO getForumDAO(SessionFactory sessionFactory) {

			return new ForumDAOImpl(sessionFactory);
			}
			@Autowired
			@Bean(name = "job")
			public Job getJob (){
			return new Job();
			}
			@Autowired
			@Bean(name = "JobDAO")
			public JobDAO getJobDAO(SessionFactory sessionFactory) {

			return new JobDAOImpl(sessionFactory);
			}
}

