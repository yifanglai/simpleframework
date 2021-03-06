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
package org.simpleframework.aop.aspect;


import java.lang.reflect.Method;

/**
 * @desc
 * @author laijunhong
 * @Create Date 2021/2/23 18:49
 * @version V1.0
 * @Modified By
 * @Modified Date
 * @note
 */
public abstract class DefaultAspect {
	public void before(Class<?> targetClass, Method method,Object[] args) throws Throwable{

	}

	public Object afterReturning(Class<?> targetClass, Method method,Object[] args,Object returnValue){
		return returnValue;
	}

	public void afterThrowing(Class<?> targetClass, Method method,Object[] args,Throwable e) throws Throwable{

	}

}
