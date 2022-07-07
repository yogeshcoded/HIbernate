package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class TicketBokkingOperation implements Runnable {

	@Override
	public void run() {
				// create session object
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try  {
					// being transaction
				tx = sec.beginTransaction();
				// prepare entity object
				Product pr = new Product();
				// set values
				// pr.setPid(102);
				pr.setPname("monkey");
				pr.setPrice(1800);
				pr.setQty(15);

				// save object
				Integer IdVal = (Integer) sec.save(pr);
				tx.commit();
				System.out.println("id is::" + IdVal);
				System.out.println("object is saved");

	}//try
		catch(HibernateException he) {
				tx.rollback();
				System.out.println("object is not saved ");
			}
		

}//run()
}//class
