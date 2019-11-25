package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language {

@Id
@GeneratedValue
Long languageId;
String languageName;

public void setLanguageId(Long languageId) {
this.languageId = languageId;
}

public Long getLanguageId() {
return languageId;
}

public void setLanguageName(String languageName) {
this.languageName = languageName;
}

public String getLanguageName() {
return languageName;
}

@Override
public String toString() {
	return "Language [languageId=" + languageId + ", languageName=" + languageName + "]";
}

public Language(Long languageId, String languageName) {
	super();
	this.languageId = languageId;
	this.languageName = languageName;
}

public Language() {
	super();
}

}