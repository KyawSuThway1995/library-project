package com.jdc.library.settings;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.library.model.repo.BaseRepoImpl;

@Configuration
@EnableJpaRepositories(basePackages = "com.jdc.library.model.repo",repositoryBaseClass = BaseRepoImpl.class)
public class JpaConfig {

}
