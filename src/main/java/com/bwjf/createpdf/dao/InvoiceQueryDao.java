package com.bwjf.createpdf.dao;

import com.bwjf.createpdf.entity.InvoiceBean;
import com.bwjf.createpdf.entity.InvoiceQueryBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*@Component
@Repository("invoiceQueryDao")*/
@Mapper
public interface InvoiceQueryDao {
	List<InvoiceQueryBean> getInvoice(InvoiceQueryBean querybean);

	int queryCount(InvoiceQueryBean querybean);
	
	List<InvoiceQueryBean> getInvoiceInfoByQpm(InvoiceQueryBean querybean);
	
	InvoiceBean getInvoiceEmail(String id);
}
