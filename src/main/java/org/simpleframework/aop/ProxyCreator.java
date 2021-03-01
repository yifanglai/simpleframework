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
 * #创建日期：2021/3/1
 * #开发单位：中科智城
 * #
 * # @Copyrigh 2017
 * #INSITUTE OF SOFTWARE APPLICATION TECHNOLOGY,GUANGZHOU & CHINESE ACADEMY OF SCIENCES
 * #All right reserved.
 * *************************************************
 */
package org.simpleframework.aop;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @desc
 * @author laijunhong
 * @Create Date 2021/3/1 14:11
 * @version V1.0
 * @Modified By
 * @Modified Date
 * @note
 */
public class ProxyCreator {
	/**
	 * 创建动态代理对象并返回
	 * @param targetClass 被代理的Class对象
	 * @param methodInterceptor 方法拦截器
	 * @return
	 */
	public static Object createProxy(Class<?> targetClass, MethodInterceptor methodInterceptor){
		return Enhancer.create(targetClass,methodInterceptor);
	}
}
