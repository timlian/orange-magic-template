package com.orange.magic.web.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.orange.magic.web.Twitter;

@Repository
public class JdbcTwitterRepository implements TwitterRepository {

	private JdbcOperations jdbc;
	
	@Autowired
	public JdbcTwitterRepository(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public Twitter save(Twitter twitter) {
		jdbc.update("insert into twitter (username, password, first_name, last_name, email) values (?, ?, ?, ?, ?)", 
			twitter.getUsername(),
			twitter.getPassword(),
			twitter.getFirstName(),
			twitter.getLastName(),
			twitter.getEmail());
		return twitter;
	}

	@Override
	public Twitter findByUsername(String username) {
		return jdbc.queryForObject("select id, username, null, first_name, last_name, email from twitter where username=?", new TwitterRowMapper(), username);
	}
	
	private static class TwitterRowMapper implements RowMapper<Twitter> {

		@Override
		public Twitter mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Twitter(
				rs.getLong("id"), 
				rs.getString("username"), 
				null, 
				rs.getString("first_name"), 
				rs.getString("last_name"), 
				rs.getString("email"));
		}
		
	}
}
