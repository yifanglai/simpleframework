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
package com.imooc.aspect;


import lombok.extern.slf4j.Slf4j;
import org.simpleframework.aop.annotation.Aspect;
import org.simpleframework.aop.annotation.Order;
import org.simpleframework.aop.aspect.DefaultAspect;
import org.simpleframework.core.annotation.Controller;

import java.lang.reflect.Method;

/**
 * @desc
 * @author laijunhong
 * @Create Date 2021/3/1 17:24
 * @version V1.0
 * @Modified By
 * @Modified Date
 * @note
 */
@Slf4j
@Aspect(value = Controller.class)
@Order(0)
public class ControllerTimeCalculatorAspect extends DefaultAspect {
	private long timestampCache;
	@Override
	public void before(Class <?> targetClass, Method method, Object[] args) throws Throwable {
		super.before(targetClass, method, args);
		log.info("开发计时，执行的类是[{}],执行的方法是[{}],参数是[{}]",targetClass.getSimpleName(),method.getName(),args);
		timestampCache=System.currentTimeMillis();
	}

	@Override
	public Object afterReturning(Class <?> targetClass, Method method, Object[] args, Object returnValue) {
		long endTime = System.currentTimeMillis();
		long costTime = endTime - timestampCache;
		log.info("结束计时，执行的类是[{}],执行的方法是[{}],参数是[{}],返回值是[{}],时间为[{}]ms",targetClass.getSimpleName(),method.getName(),args,returnValue,costTime);
		return returnValue;
	}

	@Override
	public void afterThrowing(Class <?> targetClass, Method method, Object[] args, Throwable e) throws Throwable {
		super.afterThrowing(targetClass, method, args, e);
	}
}
