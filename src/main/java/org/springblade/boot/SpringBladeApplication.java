package org.springblade.boot;

import org.springblade.boot.common.constant.LauncherConstant;
import org.springblade.core.launch.BladeApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.EnableScheduling;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * @author sonin
 * @date 2020/11/16 19:13
 */
@EnableScheduling
@SpringBootApplication
public class SpringBladeApplication {

	public static void main(String[] args) {
		BladeApplication.run(LauncherConstant.APPLICATION_NAME, SpringBladeApplication.class, args);
	}
}
