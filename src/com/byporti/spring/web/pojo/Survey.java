package com.byporti.spring.web.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.byporti.spring.web.validation.FormValidationGroup;
import com.byporti.spring.web.validation.PersistenceValidationGroup;

@Entity
@Table(name = "surveys")
public class Survey {

	@Id
	@GeneratedValue
	private int id;

	@Size(min = 5, max = 100, groups = { FormValidationGroup.class, PersistenceValidationGroup.class })
	private String name;

//	@Size(min = 5, max = 5000, groups = { FormValidationGroup.class, PersistenceValidationGroup.class })
	private String json;

	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	public Survey() {
		this.user = new User();
	}

	public Survey(User user, String name, String json) {
		this.user = user;
		this.name = name;
		this.json = json;
	}

	public Survey(int id, User user, String name, String json) {
		this.id = id;
		this.user = user;
		this.name = name;
		this.json = json;
	}

	public String getUsername() {
		return user.getUsername();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((json == null) ? 0 : json.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Survey other = (Survey) obj;
		if (id != other.id)
			return false;
		if (json == null) {
			if (other.json != null)
				return false;
		} else if (!json.equals(other.json))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", name=" + name + ", json=" + json + ", user=" + user + "]";
	}

}
