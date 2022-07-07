package com.nt.service;

import java.util.List;

import com.nt.dao.IProductDAO;
import com.nt.dao.ProductDAOimpl;
import com.nt.entity.Product;

public class ProductServiceImpl implements IProductService {
	private IProductDAO dao;
	public ProductServiceImpl() {
		dao= new ProductDAOimpl();
	}

	@Override
	public long getPagesCount(int pageSize) {
		//get total no of record
		long recordsCount=dao.getTotalRecordsCount();
		//get pageCount
		long pageCount=recordsCount/pageSize;
		if(recordsCount%pageSize!=0)
			pageCount++;
		return pageCount;
	}

	@Override
	public List<Product> getPageData(int pageNo, int pageSize) {
		// Find out start position
		int startPosition=(pageNo*pageSize)-pageSize;
		//use DAO to get the given page Data
		List<Product>list=dao.getPageData(startPosition, pageSize);
		return list;
	}

}
