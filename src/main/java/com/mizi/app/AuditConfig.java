package com.mizi.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by cyuan on 1/9/2018.
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "createAuditorProvider")
public class AuditConfig {
    @Bean
    public AuditorAware createAuditorProvider() {
        return new FakeAuditor();
    }

    @Bean
    public AuditingEntityListener createAuditingListener() {
        return new AuditingEntityListener();
    }

    public static class FakeAuditor implements AuditorAware {
        @Override
        public String getCurrentAuditor() {
            return null;
        }
    }

}
