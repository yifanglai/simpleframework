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
package demo.pattern.proxy.impl;


import demo.pattern.proxy.ToPayment;

/**
 * @desc
 * @author laijunhong
 * @Create Date 2021/2/23 14:45
 * @version V1.0
 * @Modified By
 * @Modified Date
 * @note
 */
public class ToBPayment implements ToPayment {



	@Override
	public void pay() {
		System.out.println("toBPayment");
	}
}
