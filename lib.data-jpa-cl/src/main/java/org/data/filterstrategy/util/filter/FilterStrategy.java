package org.data.filterstrategy.util.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FilterStrategy<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Object[]> strategy;
	private T entity;
	
	private int rowCountIndex;
	
	private FilterStrategy(T entity){
		this.entity = entity;
		strategy = new ArrayList<Object[]>();
	}
	
	public static <T> FilterStrategy<T> createStrategy(Class<? extends T> entityClass){
		T entity = null;
		try {
			entity = entityClass.newInstance();
		} catch (Exception ignore) {
			ignore.printStackTrace();
		}
		return new FilterStrategy<T>(entity);
	}

	public List<Object[]> getStrategy() {
		return strategy;
	}

	public void setStrategy(List<Object[]> strategy) {
		this.strategy = strategy;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}	
	
	public FilterStrategy<T> eq(String property, Object value){
		strategy.add(new Object[]{Strategy.EQ,property,value});
		return this;
	}	
	
	public FilterStrategy<T> like(String property, Object value){
		strategy.add(new Object[]{Strategy.LIKE,property,value});
		return this;
	}	
	
	public FilterStrategy<T> ilike(String property, Object value){
		strategy.add(new Object[]{Strategy.ILIKE,property,value});
		return this;
	}
	
	public FilterStrategy<T> between(String property, Object first, Object second){
		strategy.add(new Object[]{Strategy.BETWEEN,property,first,second});
		return this;
	}	
	
	public FilterStrategy<T> maxResults(int maxResults){
		strategy.add(new Object[]{Strategy.MAX_RESULTS,maxResults});
		return this;
	}	
	
	public FilterStrategy<T> max(String property){
		strategy.add(new Object[]{Strategy.MAX, property});
		return this;
	}	
	
	public FilterStrategy<T> firstResult(int firstResult){
		strategy.add(new Object[]{Strategy.FIRST_RESULT,firstResult});
		return this;
	}		
	
	public FilterStrategy<T> isNull(String property){
		strategy.add(new Object[]{Strategy.IS_NULL,property});
		return this;
	}	
	
	public FilterStrategy<T> isNotNull(String property){
		strategy.add(new Object[]{Strategy.IS_NOT_NULL,property});
		return this;
	}	
	
	public FilterStrategy<T> in(String property, Object[] values){
		strategy.add(new Object[]{Strategy.IN,property,values});
		return this;
	}	
	
	public FilterStrategy<T> rowCount(){
		strategy.add(new Object[]{Strategy.ROW_COUNT});
		rowCountIndex = strategy.size()-1;
		return this;
	}
	
	public FilterStrategy<T> addOrderDesc(String property){
		strategy.add(new Object[]{Strategy.ORDER_BY, false, property});
		return this;
	}
	
	public FilterStrategy<T> addOrderAsc(String property){
		strategy.add(new Object[]{Strategy.ORDER_BY, true, property});
		return this;
	}	
	
	public FilterStrategy<T> removeRowCount(){
		strategy.remove(rowCountIndex);
		return this;		
	}
	
	public FilterStrategy<T> greaterThan(String property, Object value){
		strategy.add(new Object[]{Strategy.GREATER_THAN,property,value});
		return this;
	}
	
	public FilterStrategy<T> lessThan(String property, Object value){
		strategy.add(new Object[]{Strategy.LESS_THAN,property,value});
		return this;
	}
	
	public FilterStrategy<T> notEq(String property, Object value){
		strategy.add(new Object[]{Strategy.NOT_EQ,property,value});
		return this;
	}	
	
	
	public FilterStrategy<T> clear(){
		strategy.clear();
		return this;
	}
	
}
