package org.ejb.service.util;

import it.cassaddpp.eas.exception.ServiceException;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * 
 * @author Gerina Fabrizio fabrizio.gerina@capgemini.com
 * 
 * */
@SuppressWarnings("rawtypes")
public class BeanDeepDescriber {
	
	public static Map<String, Object> describe(Object bean) throws ServiceException {
		Map<String, Object> cache = new HashMap<String, Object>();
		return describe(bean, null, cache);
	}
	
	private static Map<String, Object> describe(Object bean, String prefix, Map<String, Object> cache) throws ServiceException {
		prefix = (prefix != null) ? prefix + "." : "";
		Map<String, Object> described = null;
		try {
			described = PropertyUtils.describe(bean);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		for (Entry<String, Object> entry : described.entrySet()) {
			Object value = entry.getValue();
			String key = entry.getKey();

			if (key.equals("class"))
				continue;

			value = describeIfNecessary(value, prefix+key, cache);
			if(!(value instanceof Map))cache.put(prefix+key, value);
		}

		return cache;
	}

	private static Object describeIfNecessary(Object value, String prefix, Map<String, Object> cache) throws ServiceException {
		if (value == null) {
			return null;
		}

		if (isPrimitiveWrapperOrString(value)) {
			return value;
		}

		if (value.getClass().isArray()) {
			return arrayDescribe((Object[]) value, prefix, cache);
		}

		if (value instanceof Collection<?>) {
			return collectionDescribe((Collection<?>) value, prefix, cache);
		}

		return describe(value, prefix, cache);
	}

	private static Object[] arrayDescribe(Object[] values, String prefix, Map<String, Object> cache) throws ServiceException {
		Object[] described = new Object[values.length];

		for (int i = 0; i < values.length; i++) {
			Object value = values[i];
			value = describeIfNecessary(value, prefix, cache);
			described[i] = value;
		}
		return described;
	}

	private static Collection<?> collectionDescribe(Collection<?> value, String prefix, Map<String, Object> cache)
			throws ServiceException {

		if (value instanceof List) {
			return listDescribe((List) value, prefix, cache);
		}

		throw new UnsupportedOperationException(value.getClass().toString()
				+ ", can not describe.");
	}

	@SuppressWarnings("unchecked")
	private static List listDescribe(List list, String prefix, Map<String, Object> cache) throws ServiceException {
		list = new ArrayList(list);

		for (int i = 0; i < list.size(); i++) {
			Object value = list.get(i);
			value = describeIfNecessary(value, prefix, cache);
			list.set(i, value);
		}
		return list;
	}

	private static boolean isPrimitiveWrapperOrString(Object value) {
		Class<? extends Object> clazz = value.getClass();

		if (clazz.equals(Boolean.class))
			return true;
		if (clazz.equals(Character.class))
			return true;
		if (clazz.equals(Byte.class))
			return true;
		if (clazz.equals(Short.class))
			return true;
		if (clazz.equals(Integer.class))
			return true;
		if (clazz.equals(Long.class))
			return true;
		if (clazz.equals(Float.class))
			return true;
		if (clazz.equals(Double.class))
			return true;
		if (clazz.equals(String.class))
			return true;

		return false;
	}
}
