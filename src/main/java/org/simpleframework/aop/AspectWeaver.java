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


import org.simpleframework.aop.annotation.Aspect;
import org.simpleframework.aop.annotation.Order;
import org.simpleframework.aop.aspect.AspectInfo;
import org.simpleframework.aop.aspect.DefaultAspect;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @desc
 * @author laijunhong
 * @Create Date 2021/3/1 14:18
 * @version V1.0
 * @Modified By
 * @Modified Date
 * @note
 */
public class AspectWeaver {
	private BeanContainer beanContainer;
	public AspectWeaver(){
		this.beanContainer = BeanContainer.getInstance();
	}

	public void doAop(){
		//1.获取所有的切面类
		Set<Class<?>> aspectSet = beanContainer.getClassesByAnnotation(Aspect.class);
//		//2.将切面类按照不同的织入目标进行切分
//		Map<Class<? extends Annotation>, List<AspectInfo>> categorizedMap = new HashMap <>();
//		if (ValidationUtil.isEmpty(aspectSet)){return;}
//		for (Class<?> aspectClass : aspectSet){
//			if (verifyAspect(aspectClass)){
//				categorizeAspect(categorizedMap,aspectClass);
//			}else{
//				throw new RuntimeException("切面不合法");
//			}
//		}
//		//3.按照不同的织入目标分别去按序织入Aspect的逻辑
//		if (ValidationUtil.isEmpty(categorizedMap)){return;}
//		for (Class<? extends Annotation> category:categorizedMap.keySet()){
//			weaveByCategory(category,categorizedMap.get(category));
//		}
		if (ValidationUtil.isEmpty(aspectSet)){
			return;
		}
		//2.拼装AspectInfoList
		List<AspectInfo> aspectInfoList = packAspectInfoList(aspectSet);
		//3.遍历容器里的类
		Set<Class<?>> classSet = beanContainer.getClasses();
		for (Class<?> targetClass:classSet){
			//排除AspectClass自身
			if (targetClass.isAnnotationPresent(Aspect.class)){
				continue;
			}
			//4.粗筛符合条件的Aspect
			List<AspectInfo> roughMatchedAspectList = collectRoughMatchAspectListForSpecificClass(aspectInfoList);
			//5.尝试进行Aspect的织入
			wrapIfNecessary(roughMatchedAspectList,targetClass);
		}
	}

	private List<AspectInfo> collectRoughMatchAspectListForSpecificClass(List<AspectInfo> aspectInfoList) {
		return null;
	}

	private void wrapIfNecessary(List<AspectInfo> roughMatchedAspectList, Class<?> targetClass) {
	}

	private List<AspectInfo> packAspectInfoList(Set<Class<?>> aspectSet) {
		List<AspectInfo> aspectInfoList=null;
		return aspectInfoList;
	}


//	private void weaveByCategory(Class<? extends Annotation> category, List<AspectInfo> aspectInfoList) {
//		//1.获取被代理类的集合
//		Set<Class<?>> classSet = beanContainer.getClassesByAnnotation(category);
//		if (ValidationUtil.isEmpty(classSet)){return;}
//		//2.遍历被代理类，分别为每个被代理类生成动态代理实例
//		for (Class<?> targetClass:classSet){
//			//创建动态代理对象
//			AspectListExecutor aspectListExecutor = new AspectListExecutor(targetClass,aspectInfoList);
//			Object proxyBean = ProxyCreator.createProxy(targetClass,aspectListExecutor);
//			//3.将动态代理对象实例添加到容器里，取代未被代理前的类实例
//			beanContainer.addBean(targetClass,proxyBean);
//		}
//		//3.将动态代理对象实例添加到容器里，取代未被代理前的类实例
//	}

//	private void categorizeAspect(Map<Class<? extends Annotation>, List<AspectInfo>> categorizedMap, Class<?> aspectClass) {
//		Order orderTag = aspectClass.getAnnotation(Order.class);
//		Aspect aspectTag = aspectClass.getAnnotation(Aspect.class);
//		DefaultAspect aspect = (DefaultAspect)beanContainer.getBean(aspectClass);
//		AspectInfo aspectInfo = new AspectInfo(orderTag.value(),aspect);
//		if (!categorizedMap.containsKey(aspectTag.value())){
//			List<AspectInfo> aspectInfoList = new ArrayList <>();
//			aspectInfoList.add(aspectInfo);
//			categorizedMap.put(aspectTag.value(),aspectInfoList);
//		}else {
//			List<AspectInfo> aspectInfoList = categorizedMap.get(aspectTag.value());
//			aspectInfoList.add(aspectInfo);
//		}
//	}

	/**
	 * 有@Aspect和@Order标签规范，必须继承自DefaultAspect.class，
	 * @Aspect的属性值不能是它本身
	 * @param aspectClass
	 * @return
	 */
//	private boolean verifyAspect(Class<?> aspectClass) {
//		return aspectClass.isAnnotationPresent(Aspect.class)&&
//				aspectClass.isAnnotationPresent(Order.class)&&
//				DefaultAspect.class.isAssignableFrom(aspectClass)&&
//				aspectClass.getAnnotation(Aspect.class).value()!=Aspect.class;
//	}
}
