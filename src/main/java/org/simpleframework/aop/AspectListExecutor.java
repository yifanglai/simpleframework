/**
 * *************************************************
 * #项目名称：kylin
 * #版本号：V1.0
 * *************************************************
 * #文件说明：
 * #
 * *************************************************
 * #子模块说明：
 * #
 * *************************************************
 * #创建人员：laijunhong
 * #联系邮箱：<laijunhong@iot-cas.com>
 * #创建日期：2021/2/23
 * #开发单位：中科智城
 * #
 * # @Copyrigh 2017
 * #INSITUTE OF SOFTWARE APPLICATION TECHNOLOGY,GUANGZHOU & CHINESE ACADEMY OF SCIENCES
 * #All right reserved.
 * *************************************************
 */
package org.simpleframework.aop;


import lombok.Getter;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.simpleframework.aop.aspect.AspectInfo;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @desc
 * @author laijunhong
 * @Create Date 2021/2/23 19:03
 * @version V1.0
 * @Modified By
 * @Modified Date
 * @note
 */
public class AspectListExecutor implements MethodInterceptor {
	//被代理的类
	private Class<?> targetClass;
	@Getter
	private List<AspectInfo> aspectInfoList;
	public AspectListExecutor(Class<?> targetClass,List<AspectInfo> aspectInfoList){
		this.targetClass = targetClass;
		this.aspectInfoList = sortAspectInfoList(aspectInfoList);

	}

	private List<AspectInfo> sortAspectInfoList(List<AspectInfo> aspectInfoList) {
		Collections.sort(aspectInfoList, new Comparator <AspectInfo>() {
			@Override
			public int compare(AspectInfo o1, AspectInfo o2) {
				return o1.getOrderIndex()-o2.getOrderIndex();
			}
		});
		return aspectInfoList;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object returnValue = null;
		//1.按照order的顺序升序执行完所有Aspect的before方法
		invokeBeforeAdvices(method,args);
		try {
			//2.执行被代理类的方法
			returnValue = proxy.invokeSuper(obj,args);
			//3.如果被代理方法正常返回，则按照order的顺序降序执行完所有Aspect的afterReturn方法
			returnValue = invokeAfterReturningAdvices(method,args,returnValue);
		}catch (Exception e){
			//4.如果被代理方法抛出异常，则按照order的顺序降序执行完所有Aspect的afterThrowing方法
			invokeAfterThrowingAdvices(method,args,e);
		}


		return returnValue;
	}

	//4.如果被代理方法抛出异常，则按照order的顺序降序执行完所有Aspect的afterThrowing方法
	private void invokeAfterThrowingAdvices(Method method, Object[] args, Exception e) throws Throwable {
		for (int i=aspectInfoList.size()-1;i>=0;i--){
			aspectInfoList.get(i).getAspectObject().afterThrowing(targetClass,method,args,e);
		}
	}

	//3.如果被代理方法正常返回，则按照order的顺序降序执行完所有Aspect的afterReturn方法
	private Object invokeAfterReturningAdvices(Method method, Object[] args, Object returnValue) {
		Object result = null;
		for (int i=aspectInfoList.size()-1;i>=0;i--){
			result = aspectInfoList.get(i).getAspectObject().afterReturning(targetClass,method,args,returnValue);
		}
		return result;
	}

	//1.按照order的顺序升序执行完所有Aspect的before方法
	private void invokeBeforeAdvices(Method method, Object[] args) throws Throwable {
		for (AspectInfo aspectInfo : aspectInfoList){
			aspectInfo.getAspectObject().before(targetClass,method,args);
		}
	}
}
