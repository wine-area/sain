package io.nanfeng.common.data.repo

import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository

interface QBaseRepository<T> : CrudRepository<T, Long>, QuerydslPredicateExecutor<T> {
}