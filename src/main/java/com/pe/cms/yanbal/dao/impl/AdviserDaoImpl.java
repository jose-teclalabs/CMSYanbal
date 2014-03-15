package com.pe.cms.yanbal.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import com.pe.cms.yanbal.dao.AdviserDao;
import com.pe.cms.yanbal.model.AdviserDTO;

public class AdviserDaoImpl implements AdviserDao {

	private static final Log log = LogFactory.getLog(AdviserDaoImpl.class);

	private SessionFactory sessionFactory;

	
	@Transactional
	@Override
	public AdviserDTO getUserYambal(AdviserDTO adviser) {
		return adviser;
		
//		String sql = "select advi_code as code ,advi_name as name from adviser where advi_code = :codeId and advi_status = 1 LIMIT 1";
//		AdviserDTO adviserReturn = null;
//		try {
//			Query squery = entityManager.createNativeQuery(sql.toString());
//			HibernateQuery hibernateQuery = (HibernateQuery) squery;
//			SQLQuery query = (SQLQuery) hibernateQuery.getHibernateQuery();
//			query.setString("codeId", adviser.getCode());
//			query.addScalar("code", StandardBasicTypes.STRING);
//			query.addScalar("name", StandardBasicTypes.STRING);
//			query.setResultTransformer(Transformers.aliasToBean(AdviserDTO.class));
//			adviserReturn = ((AdviserDTO) squery.getSingleResult());
//		} catch (NoResultException e) {
//			return null;
//		} catch (RuntimeException re) {
//			log.error("verify code adviser failed", re);
//			throw re;
//		}
//		return adviserReturn;
	}
	
	 @SuppressWarnings("rawtypes")
	 @Override
	 public List getAllAdviser() {
		 return getSessionFactory().getCurrentSession().createQuery("from AdviserDTO").list();
	}
	 
	 
	 public void addAdviser(AdviserDTO adviser) {
			getSessionFactory().getCurrentSession().save(adviser);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
