package com.topsun.posclient.sales.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import junit.framework.TestCase;

import com.topsun.posclient.common.LocalDataProcessor;
import com.topsun.posclient.datamodel.OldGold;
import com.topsun.posclient.datamodel.dto.OldGoldDTO;
import com.topsun.posclient.sales.core.service.IOldGoldSaleService;
import com.topsun.posclient.sales.core.service.impl.OldGoldSaleServiceImpl;

/**
 * @author Dong
 *
 */
public class OldGoldServiceTest extends TestCase {
	
	IOldGoldSaleService goldSaleService = new OldGoldSaleServiceImpl();
	
	LocalDataProcessor localProcessor = new LocalDataProcessor();
	
	public void test(){
		List<OldGold> oldGoldList = new ArrayList<OldGold>();
		OldGold oldGold1 = new OldGold();
		oldGold1.setID(1);
		oldGold1.setDocNum("1010101");
		oldGoldList.add(oldGold1);
		
		OldGoldDTO oldGoldDTO = new OldGoldDTO();
		oldGoldDTO.setOldGoldList(oldGoldList);
		
		File file = new File("D:\\data_OldGold_"+ System.currentTimeMillis() + ".xml");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
			JAXBContext context = JAXBContext.newInstance(oldGoldDTO.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(oldGoldDTO, fos);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String content = localProcessor.getDataFileContent(file);
		System.out.println(content);
	}
	
}
