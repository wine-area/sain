package io.nanfeng.common.data.jpa.infrastructure.persistence

import com.querydsl.jpa.JPQLQueryFactory
import org.springframework.data.jpa.repository.JpaRepository

interface QueryDslRepository<T> : JpaRepository<T, Long>, JPQLQueryFactory


