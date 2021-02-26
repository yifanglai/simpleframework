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
package demo.pattern.proxy;


import demo.pattern.proxy.impl.AlipayToB;
import demo.pattern.proxy.impl.AlipayToC;
import demo.pattern.proxy.impl.ToBPayment;
import demo.pattern.proxy.impl.ToCPayment;

/**
 * @desc
 * @author laijunhong
 * @Create Date 2021/2/23 14:50
 * @version V1.0
 * @Modified By
 * @Modified Date
 * @note
 */
public class ProxyDemo {

	public static void main(String[] args) {
		ToPayment alipayToC = new AlipayToC(new ToCPayment());
		alipayToC.pay();
		ToPayment alipayToB = new AlipayToB(new ToBPayment());
		alipayToB.pay();
	}
}
