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


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.simpleframework.aop.aspect.AspectInfo;
import org.simpleframework.aop.mock.Mock1;
import org.simpleframework.aop.mock.Mock2;
import org.simpleframework.aop.mock.Mock3;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc
 * @author laijunhong
 * @Create Date 2021/2/23 19:22
 * @version V1.0
 * @Modified By
 * @Modified Date
 * @note
 */
public class AspectListExecutorTest {
	@Test
	@DisplayName("aspect sort")
	public void sortTest(){
		List <AspectInfo> aspectInfoList = new ArrayList <>();
		aspectInfoList.add(new AspectInfo(3,new Mock1()));
		aspectInfoList.add(new AspectInfo(2,new Mock2()));
		aspectInfoList.add(new AspectInfo(1,new Mock3()));
		AspectListExecutor aspectListExecutor = new AspectListExecutor(AspectListExecutorTest.class,aspectInfoList);
		List<AspectInfo> sortedAspectInfoList = aspectListExecutor.getAspectInfoList();
		for (AspectInfo aspectInfo : sortedAspectInfoList){
			System.out.println(aspectInfo.getAspectObject().getClass().getName());
		}
	}
}
