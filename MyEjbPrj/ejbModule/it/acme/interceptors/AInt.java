package it.acme.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class AInt {
	@AroundInvoke
	public Object around(InvocationContext invCtx) throws Exception{
		System.out.println("#Aint: myHashCode= "+ this.hashCode());
		System.out.println("#Aint: MyName= "+ this.getClass().getName());		
		System.out.println("#Aint: name method intercepted: "+invCtx.getMethod().getName());  
		System.out.println("#Aint: identityHashCode: "+System.identityHashCode(this));
		return invCtx.proceed();		
	}

}
