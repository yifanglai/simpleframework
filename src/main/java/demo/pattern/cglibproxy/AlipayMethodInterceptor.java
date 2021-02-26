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
package demo.pattern.cglibproxy;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @desc
 * @author laijunhong
 * @Create Date 2021/2/23 17:18
 * @version V1.0
 * @Modified By
 * @Modified Date
 * @note
 */
public class AlipayMethodInterceptor implements MethodInterceptor {
	/**
	 * All generated proxied methods call this method instead of the original method.
	 * The original method may either be invoked by normal reflection using the Method object,
	 * or by using the MethodProxy (faster).
	 *
	 * @param obj    "this", the enhanced object
	 * @param method intercepted Method
	 * @param args   argument array; primitive types are wrapped
	 * @param proxy  used to invoke super (non-intercepted method); may be called
	 *               as many times as needed
	 * @return any value compatible with the signature of the proxied method. Method returning void will ignore this value.
	 * @throws Throwable any exception may be thrown; if so, super method will not be invoked
	 * @see MethodProxy
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		before();
		Object result = proxy.invokeSuper(obj,args);
		after();
		return result;
	}

	public void before(){
		System.out.println("before");
	}

	public void after(){
		System.out.println("after");
	}

}
