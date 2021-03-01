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


import com.imooc.controller.superadmin.HeadLineOperationController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.DependencyInjector;

/**
 * @desc
 * @author laijunhong
 * @Create Date 2021/3/1 17:22
 * @version V1.0
 * @Modified By
 * @Modified Date
 * @note
 */
public class AspectWeaverTest {
	@DisplayName("测试doAop")
	@Test
	public void doAopTest(){
		BeanContainer beanContainer = BeanContainer.getInstance();
		beanContainer.loadBeans(("com.imooc"));
		new AspectWeaver().doAop();
		new DependencyInjector().doIoc();
		HeadLineOperationController headLineOperationController = (HeadLineOperationController) beanContainer.getBean(HeadLineOperationController.class);
		headLineOperationController.addHeadLine(null,null);
	}
}
