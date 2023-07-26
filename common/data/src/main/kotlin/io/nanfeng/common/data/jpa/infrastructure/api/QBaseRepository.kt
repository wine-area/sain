package io.nanfeng.common.data.jpa.infrastructure.api

import io.nanfeng.common.data.jpa.infrastructure.persistence.QueryDslRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface QBaseRepository<T> : QueryDslRepository<T>, QuerydslPredicateExecutor<T> {


}