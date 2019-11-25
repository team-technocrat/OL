package com.lti.services;

import java.util.List;

import com.lti.model.Language;

public interface LanguageService {
	public List<Language> listLanguages();

	public List getLanguageByLanguageId(Long languageId);

	}
