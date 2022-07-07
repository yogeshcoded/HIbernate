package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class ProductDAOimpl implements IProductDAO {

	@Override
	public long getTotalRecordsCount() {
		Session sec = HBUtil.getSession();
		try (sec) {
			Query query = sec.createQuery("select count(*) from Product");
			long count = (long) query.getSingleResult();
			return count;
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			throw he;
		}
		
	}// ()

	@Override
	public List<Product> getPageData(int startPosition, int pageSize) {
		Session sec = HBUtil.getSession();
		try (sec) {
			Query query = sec.createQuery("from Product");
			query.setFirstResult(startPosition);
			query.setMaxResults(pageSize);
			List<Product> list = query.getResultList();
			return list;
		} catch (HibernateException he) {
			he.printStackTrace();
			throw he;
		}
	}// method
}// class
