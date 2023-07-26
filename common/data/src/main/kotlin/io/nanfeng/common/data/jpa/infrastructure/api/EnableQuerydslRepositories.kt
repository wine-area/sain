package io.nanfeng.common.data.jpa.infrastructure.api

import io.nanfeng.common.data.jpa.infrastructure.persistence.QueryDslRepositoryImpl
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@EnableJpaRepositories(
    repositoryBaseClass = QueryDslRepositoryImpl::class,
)
annotation class EnableQuerydslRepositories(
)

