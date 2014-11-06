package it.helloWorld.enterprise.mappings.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class DozerImpl {
	private static DozerBeanMapper mapperInstance;
	
	
	private DozerImpl(){	}
	
	public static synchronized DozerBeanMapper getDozerBeanMapper(){
		 if (mapperInstance == null) {
			 mapperInstance = new DozerBeanMapper();
			 List myMappingFiles=new ArrayList();
			 myMappingFiles.add("/META-INF/dozerMapping.xml");
			 //myMappingFiles.add("someOtherDozerBeanMappings.xml");
			 mapperInstance.setMappingFiles(myMappingFiles);		
		 }
	        return mapperInstance;
	}
	
	public static <U, T> List<U> mapList(final List<T> source,	final Class<U> destType) {

		final List<U> dest = new ArrayList<U>();

		for (T element : source) {
			if (element == null) {
				continue;
			}
			dest.add(getDozerBeanMapper().map(element, destType));
		}

		List s1 = new ArrayList();
		s1.add(null);
		dest.removeAll(s1);

		return dest;
	}
	
	
	
	
	
	
	
	
	/*DestinationObject destObject = 
	 mapper.map(sourceObject, DestinationObject.class);
	 */


}
