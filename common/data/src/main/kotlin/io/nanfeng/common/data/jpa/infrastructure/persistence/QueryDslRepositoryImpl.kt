package io.nanfeng.common.data.jpa.infrastructure.persistence

import com.querydsl.core.Tuple
import com.querydsl.core.dml.DeleteClause
import com.querydsl.core.dml.InsertClause
import com.querydsl.core.dml.UpdateClause
import com.querydsl.core.types.EntityPath
import com.querydsl.core.types.Expression
import com.querydsl.jpa.JPQLQuery
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.data.jpa.repository.support.JpaEntityInformation
import org.springframework.data.jpa.repository.support.SimpleJpaRepository


class QueryDslRepositoryImpl<T>(
    entityInformation: JpaEntityInformation<T, Long>,
    entityManager: EntityManager
) : SimpleJpaRepository<T, Long>(entityInformation, entityManager), QueryDslRepository<T> {
    private val queryFactory: JPAQueryFactory

    init {
        queryFactory = JPAQueryFactory(entityManager)
    }

    override fun query(): JPQLQuery<*> {
        return queryFactory.query()
    }

    override fun delete(path: EntityPath<*>): DeleteClause<*> {
        return queryFactory.delete(path)
    }

    override fun <T : Any> select(expr: Expression<T>): JPQLQuery<T> {
        return queryFactory.select(expr)
    }

    override fun select(vararg exprs: Expression<*>): JPQLQuery<Tuple> {
        return queryFactory.select(*exprs)
    }

    override fun <T : Any> selectDistinct(expr: Expression<T>): JPQLQuery<T> {
        return queryFactory.selectDistinct(expr)
    }

    override fun selectDistinct(vararg exprs: Expression<*>): JPQLQuery<Tuple> {
        return queryFactory.selectDistinct(*exprs)
    }

    override fun selectOne(): JPQLQuery<Int> {
        return queryFactory.selectOne()
    }

    override fun selectZero(): JPQLQuery<Int> {
        return queryFactory.selectZero()
    }

    override fun <T : Any> selectFrom(from: EntityPath<T>): JPQLQuery<T> {
        return queryFactory.selectFrom(from)
    }

    override fun from(from: EntityPath<*>): JPQLQuery<*> {
        return queryFactory.from(from)
    }

    override fun from(vararg from: EntityPath<*>): JPQLQuery<*> {
        return queryFactory.from(*from)
    }

    override fun update(path: EntityPath<*>): UpdateClause<*> {
        return queryFactory.update(path)
    }

    override fun insert(path: EntityPath<*>): InsertClause<*> {
        return queryFactory.insert(path)
    }


}