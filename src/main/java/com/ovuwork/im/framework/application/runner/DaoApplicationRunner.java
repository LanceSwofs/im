package com.ovuwork.im.framework.application.runner;

import com.ovuwork.im.common.dao.InitDao;
import com.ovuwork.im.common.service.RedisService;
import com.ovuwork.im.framework.config.DruidDBConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
public class DaoApplicationRunner implements ApplicationRunner {

    @Autowired
    private RedisService redisService;

    @Autowired
    private DruidDBConfig dbConfig;

    @Autowired
    private InitDao initDao;

    @Value("${show_sql}")
    private boolean show_sql;

    @Value("${db_dialect}")
    private String db_dialect;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("================Init DAO====================");
        //初始化DAO
        initDao.InitServerliteDao(dbConfig.dataSource(), db_dialect, show_sql);
    }
}
