package io.nanfeng.common.data.tree.domain

import io.nanfeng.common.data.jpa.domain.BaseEntity
import jakarta.persistence.ConstraintMode
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.OneToMany

@MappedSuperclass
open class BaseTreeEntity<T : BaseTreeEntity<T>> : BaseEntity() {
    @ManyToOne
    var parent: T? = null

    /**
     * 父级路径，以/分割
     */
    var path: String = ""

    @OneToMany
    @JoinColumn(
        name = "parent_id",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT)
    )
    var children: MutableList<T> = mutableListOf()

}