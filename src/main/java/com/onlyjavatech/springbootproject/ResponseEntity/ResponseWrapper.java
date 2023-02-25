package com.onlyjavatech.springbootproject.ResponseEntity;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.onlyjavatech.springbootproject.model.Students;

@SuppressWarnings("deprecation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseWrapper implements Serializable {

	/**
	 * 
	 */
	
	
	
	StatusDescription statusDescriptions;
	Students studentt;
	List<Students> studentts;
	
	

	@Override
	public String toString() {
		final int maxLen = 10;
		return "ResponseWrapper [statusDescriptions=" + statusDescriptions + ", studentt=" + studentt + ", studentts="
				+ (studentts != null ? studentts.subList(0, Math.min(studentts.size(), maxLen)) : null)
				+ ", getStudentts()="
				+ (getStudentts() != null ? getStudentts().subList(0, Math.min(getStudentts().size(), maxLen)) : null)
				+ ", getStudentt()=" + getStudentt() + ", getStatusDescriptions()=" + getStatusDescriptions()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public List<Students> getStudentts() {
		return studentts;
	}

	public void setStudentts(List<Students> studentts) {
		this.studentts = studentts;
	}

	public Students getStudentt() {
		return studentt;
	}

	public void setStudentt(Students studentt) {
		this.studentt = studentt;
	}

	public StatusDescription getStatusDescriptions() {
		return statusDescriptions;
	}

	public void setStatusDescriptions(StatusDescription statusDescriptions) {
		this.statusDescriptions = statusDescriptions;
	}
	

}
