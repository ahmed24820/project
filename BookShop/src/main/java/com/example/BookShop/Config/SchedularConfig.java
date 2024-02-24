package com.example.BookShop.Config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.hibernate.annotations.Bag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.sql.DataSource;

@Configuration
@EnableScheduling
@EnableAsync
@ConditionalOnProperty(name = "Schedule.value",matchIfMissing = true)    // this is used to check the properties file for the name u will pass to value
@EnableSchedulerLock(defaultLockAtMostFor = "10m") //default time for the process
public class SchedularConfig {
    Logger log= LoggerFactory.getLogger(SchedularConfig.class);
//    int x =10,y=5;
//    @Scheduled(fixedRate = 2000)
//   @Async
//    @SchedulerLock(name = "first_task",lockAtMostFor = "1m")
//    public void run() throws InterruptedException {
//        log.info("the summation is >> "+(x+y));
//        log.error("the subtraction is >>"+(x-y));
//         Thread.sleep(5000);
//    }

    @Bean
    public LockProvider lockProvider(DataSource dataSource) {
        return new JdbcTemplateLockProvider(
                JdbcTemplateLockProvider.Configuration.builder()
                        .withJdbcTemplate(new JdbcTemplate(dataSource))
                        .usingDbTime() // Works on Postgres, MySQL, MariaDb, MS SQL, Oracle, DB2, HSQL and H2
                        .build()
        );
    }
}
