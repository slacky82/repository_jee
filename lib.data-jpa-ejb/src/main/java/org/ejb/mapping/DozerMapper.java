/**
 * 
 */
package org.ejb.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * @author Gerina Fabrizio fabrizio.gerina@capgemini.com
 * 
 *         CLASS WRAPPER DozerBeanMapper
 */
public class DozerMapper {

	private static Mapper mapper;
    private static Map<String, Mapper> synchronizedMap = Collections.synchronizedMap(new HashMap<String, Mapper>());


	/**
	 * WRAPPER per ottenere un OBJ di tipo mapper (LIBRERIA DOZER Version: 5.2.2
	 * ) f.g.
	 * 
	 * @return mapper
	 */
	public static Mapper getMapper(String dozerMapperFile) {
		mapper = synchronizedMap.get(dozerMapperFile);
		if(mapper == null){
			mapper = new DozerBeanMapper(Arrays.asList(new String[] { dozerMapperFile }));
			synchronizedMap.put(dozerMapperFile, mapper);
		}
		return mapper;
	}

	public static <T, U> List<U> mapList(final List<T> source,
			final Class<U> destType, String dozerMapperFile) {

		final List<U> dest = new ArrayList<U>();

		for (T element : source) {
			if (element == null) {
				continue;
			}
			dest.add(getMapper(dozerMapperFile).map(element, destType));
		}

		List s1 = new ArrayList();
		s1.add(null);
		dest.removeAll(s1);

		return dest;
	}
	
	public static String getMappedProperty(Class source, Class destination, String property){
		return ((DozerBeanMapper)mapper).getMappingMetadata().getClassMapping(source, destination).getFieldMappingByDestination(property).getSourceName();
	}

}
