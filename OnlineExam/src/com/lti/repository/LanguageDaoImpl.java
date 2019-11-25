package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.Language;

@Repository("languageDao")
public class LanguageDaoImpl implements LanguageDao {
	@Autowired
	
	@PersistenceContext
	EntityManager em;

	public List<Language> listLanguages() {
		String q1="select q from Questions q";
		javax.persistence.TypedQuery<Language> query=em.createQuery(q1,Language.class);
		List<Language> l=query.getResultList();
		
		for(Language b:l)
		{
			System.out.println("\n\n----------"+b);
		}
			/*System.out.println("in dao");
			String ql = " from Users";
			Query q = em.createQuery(ql);
			return q.getResultList();*/
		
	return l;
	}

	
	@Override
	public List<Language> getLanguageByLanguageId(Long languageId)
	 {
		return em.createQuery(
				"from Language where languageId=:languageId").setParameter(
				"languageId", languageId).getResultList();
	}
}
