package ua.lviv.lgs.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subscription")
public class Subscriptions implements Serializable{
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name="jornal_id", referencedColumnName="id")
	private Jornals jornal;
	
	
	@Column(name="start")
	private Date start;
	
	
	@Column(name="end")
	private Date end;
	
	public Subscriptions(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Jornals getJornal() {
		return jornal;
	}

	public void setJornal(Jornals jornal) {
		this.jornal = jornal;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jornal == null) ? 0 : jornal.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		Subscriptions other = (Subscriptions) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jornal == null) {
			if (other.jornal != null)
				return false;
		} else if (!jornal.equals(other.jornal))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
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
		return "Subscriptions [id=" + id + ", user=" + user + ", jornal=" + jornal + ", start=" + start + ", end=" + end
				+ "]";
	}
	

}
