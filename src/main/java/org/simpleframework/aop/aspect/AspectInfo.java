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
package org.simpleframework.aop.aspect;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.simpleframework.aop.PointcutLocator;

/**
 * @desc
 * @author laijunhong
 * @Create Date 2021/2/23 19:05
 * @version V1.0
 * @Modified By
 * @Modified Date
 * @note
 */
@AllArgsConstructor
@Getter
public class AspectInfo {
	private int orderIndex;
	private DefaultAspect aspectObject;
	private PointcutLocator pointcutLocator;
}
