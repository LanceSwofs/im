package com.ovuwork.im.framework.application.runner;

import com.ovuwork.im.mobileimsdk.server.ServerLauncherImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component//被spring容器管理
@Order(999)//如果多个自定义ApplicationRunner，用来标明执行顺序
@Slf4j
public class MobileIMSDKApplicationRunner implements ApplicationRunner {

    @Autowired
    private ServerLauncherImpl serverLauncherImpl;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("================MobileIMSDK Startup====================");
        serverLauncherImpl.startup();//MobileIMSDK 启动
        // 加一个钩子，确保在JVM退出时释放netty的资源
        Runtime.getRuntime().addShutdownHook(new Thread(() -> serverLauncherImpl.shutdown()));
    }
}
