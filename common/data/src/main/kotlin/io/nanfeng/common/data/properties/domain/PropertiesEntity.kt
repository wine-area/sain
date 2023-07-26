package io.nanfeng.common.data.properties.domain

import io.nanfeng.common.data.jpa.domain.BaseEntity


/**
 * todo 配置实体
 * 很多业务场景中，都有这么一个需求：
 * 网站有全局的配置，但是针对某个用户，又有这个用户单独的配置
 */
abstract class PropertiesEntity : BaseEntity() {
    abstract val key: String
}