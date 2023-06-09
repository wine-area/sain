package io.nanfeng.common.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface QBaseRepository<T> : JpaRepository<T, Long>, QuerydslPredicateExecutor<T> {

}