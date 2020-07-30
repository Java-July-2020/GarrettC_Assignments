package com.dojoSurvey.garrett.models;

public class survey {
	private String name;
	private String location;
	private String language;
	private String comment;
	
	public survey(String name, String location, String language, String comment) {
		this.name = name;
		this.setLocation(location);
		this.setLanguage(language);
		this.setComment(comment);
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
