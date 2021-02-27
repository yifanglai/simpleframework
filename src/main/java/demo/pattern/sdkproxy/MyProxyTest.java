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
package demo.pattern.sdkproxy;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @desc
 * @author laijunhong
 * @Create Date 2021/2/23 15:54
 * @version V1.0
 * @Modified By
 * @Modified Date
 * @note
 */
public class MyProxyTest {
	public static void main(String[] args)
			throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
		// =========================第一种==========================
		// 1、生成$Proxy0的class文件
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		// 2、获取动态代理类
		Class proxyClazz = Proxy.getProxyClass(IHello.class.getClassLoader(),IHello.class);
		// 3、获得代理类的构造函数，并传入参数类型InvocationHandler.class
		Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
		// 4、通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
		IHello iHello1 = (IHello) constructor.newInstance(new MyInvocationHandler(new HelloImpl()));
		// 5、通过代理对象调用目标方法
		iHello1.sayHello();

		// ==========================第二种=============================
		/**
		 * Proxy类中还有个将2~4步骤封装好的简便方法来创建动态代理对象，
		 *其方法签名为：newProxyInstance(ClassLoader loader,Class<?>[] instance, InvocationHandler h)
		 */
		IHello  iHello2 = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(), // 加载接口的类加载器
				new Class[]{IHello.class}, // 一组接口
				new MyInvocationHandler(new HelloImpl())); // 自定义的InvocationHandler
		iHello2.sayHello();
	}

}
