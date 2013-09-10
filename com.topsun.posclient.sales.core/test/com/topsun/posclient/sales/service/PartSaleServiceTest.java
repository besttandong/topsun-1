package com.topsun.posclient.sales.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import junit.framework.TestCase;

import com.topsun.posclient.common.LocalDataProcessor;
import com.topsun.posclient.common.POSException;
import com.topsun.posclient.datamodel.Retail;
import com.topsun.posclient.datamodel.RetailM;
import com.topsun.posclient.datamodel.RetailMP;
import com.topsun.posclient.datamodel.RetailP;
import com.topsun.posclient.datamodel.dto.RetailDTO;
import com.topsun.posclient.sales.core.service.IPartSaleService;
import com.topsun.posclient.sales.core.service.impl.PartSaleServiceImpl;

/**
 * @author Dong
 *
 */
public class PartSaleServiceTest extends TestCase {
	
	IPartSaleService saleService = new PartSaleServiceImpl();
	
	LocalDataProcessor localProcessor = new LocalDataProcessor();
	
	public void testApplyPromotion(){
		RetailDTO retailDTO = getData();
		for(Retail retail : retailDTO.getRetailList()){
			
			try {
				retail = saleService.applyPromotion(retail);
			} catch (POSException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void aaaa(){
		RetailDTO retailDTO = getData();
		File file = new File("D:\\data_PartSales_"+ System.currentTimeMillis() + ".xml");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
			JAXBContext context = JAXBContext.newInstance(retailDTO.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(retailDTO, fos);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String content = localProcessor.getDataFileContent(file);
		System.out.println(content);
	}
	
	
	
	public RetailDTO getData(){
		RetailP retailP1 = new RetailP();
		retailP1.setID(1);
		retailP1.setDocNum("1010101");
		RetailP retailP2 = new RetailP();
		retailP2.setID(2);
		retailP2.setDocNum("1010101");
		
		RetailMP retailMP1 = new RetailMP();
		retailMP1.setID(1);
		retailMP1.setDocNum("1010101");
		RetailMP retailMP2 = new RetailMP();
		retailMP2.setID(2);
		retailMP2.setDocNum("1010101");
		
		RetailM retailM1 = new RetailM();
		retailM1.setID(1);
		retailM1.setDocNum("1010101");
		retailM1.setItemId(1);
		retailM1.setItemCode("0202");
		retailM1.setItemType("0303");
		
		RetailM retailM2 = new RetailM();
		retailM2.setID(2);
		retailM2.setDocNum("1010101");
		retailM2.setItemId(1);
		retailM2.setItemCode("0202");
		retailM2.setItemType("0303");
		
		List<RetailM> retailMList = new ArrayList<RetailM>();
		retailMList.add(retailM1);
		retailMList.add(retailM2);
		
		List<RetailMP> retailMPList = new ArrayList<RetailMP>();
		retailMPList.add(retailMP1);
		retailMPList.add(retailMP2);
		
		List<RetailP> retailPList = new ArrayList<RetailP>();
		retailPList.add(retailP1);
		retailPList.add(retailP2);
		
		List<Retail> retailList = new ArrayList<Retail>();
		Retail retail1 = new Retail();
		retail1.setID(1);
		retail1.setDocNum("1010101");
		retail1.setAccountData(new Date());
		retail1.setRetailMList(retailMList);
		retail1.setRetailMPList(retailMPList);
		retail1.setRetailPList(retailPList);
		retailList.add(retail1);
		
		RetailDTO retailDTO = new RetailDTO();
		retailDTO.setRetailList(retailList);
		return retailDTO;
	}
	
}
