package com.lti.repository;

import java.util.List;

import com.lti.model.Language;

public interface LanguageDao {
	public List<Language> listLanguages();

	public List<Language> getLanguageByLanguageId(Long languageId);
}
