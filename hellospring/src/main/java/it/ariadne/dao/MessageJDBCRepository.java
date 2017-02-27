package it.ariadne.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import it.ariadne.model.Message;

@Repository
public class MessageJDBCRepository extends JdbcDaoSupport implements MessageRepository {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);		
	}
	
	@Override
	public List<Message> findMessages(long maxValue, int count) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Message> messageList = new ArrayList<>();
		
		try {
			
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("SELECT * from messages");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				String author = rs.getString("author");
				String text = rs.getString("text");
				System.out.println(rs.getString("author"));
				System.out.println(rs.getString("text"));
				
				Message m = new Message(text, new Date(), 0L);
				
				messageList.add(m);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {			
			try {
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {			
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return messageList;
		
	}

	
	
	
	
	
	
	
	
		
	//@Override
	public List<Message> findMessagesOld(long maxValue, int count) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Message> messages = new ArrayList<>();
		try {
		conn = dataSource.getConnection();
		stmt = conn.prepareStatement("SELECT * FROM MESSAGES");
		ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
				System.out.println(rs.getString("author"));
				System.out.println(rs.getString("text"));
				Message m = new Message(rs.getString("text"), new java.util.Date(), 0L);
				messages.add(m);
			}
		} catch (SQLException e) {
			// do something...not sure what, though
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			// I'm even less sure about what to do here
			}
	
		}
		
		return messages;
	}
	
	public List<String> getMessageTitles() {
		 
        String sql = "Select m.text from messages m ";
 
        // queryForList(String sql, Class<T> elementType)
        List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
 
        return list;
    }












}
