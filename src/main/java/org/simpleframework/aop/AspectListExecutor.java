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
		return null;
	}
}
