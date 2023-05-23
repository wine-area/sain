package io.nanfeng.common.data.entity

import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.OneToMany

@MappedSuperclass
open class BaseTreeEntity<T : BaseTreeEntity<T>> : BaseEntity() {
    lateinit var parent: T

    /**
     * 父级路径，以/分割
     */
    var path: String = ""

    @OneToMany
    @JoinColumn(
        name = "parent_id",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "none")
    )
    var children: MutableList<T> = mutableListOf()

}