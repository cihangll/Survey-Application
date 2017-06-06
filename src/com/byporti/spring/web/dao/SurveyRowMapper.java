package com.byporti.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.byporti.spring.web.pojo.Survey;
import com.byporti.spring.web.pojo.User;

public class SurveyRowMapper implements RowMapper<Survey> {

	@Override
	public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		user.setAuthority(rs.getString("authority"));
		user.setEmail(rs.getString("email"));
		user.setEnabled(true);

		Survey survey = new Survey();
		survey.setId(rs.getInt("id"));
		survey.setName(rs.getString("name"));
		survey.setJson(rs.getString("json"));
		survey.setUser(user);

		return survey;
	}

}
