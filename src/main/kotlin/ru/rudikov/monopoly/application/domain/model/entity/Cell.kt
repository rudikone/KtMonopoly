package ru.rudikov.monopoly.application.domain.model.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "cell")
@SequenceGenerator(
    name = "seq_cell_id",
    sequenceName = "seq_cell_id",
    allocationSize = 1,
)
data class Cell(
    @Id
    @GeneratedValue(
        generator = "seq_cell_id",
        strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id")
    val id: Long? = null,

    val name: String,
    val number: Int,
    val salary: Long? = null,
    val renta: Long? = null,
    val price: Long? = null,
    val color: String? = null,

    @ManyToOne
    @JoinColumn(name = "chip_id")
    var chip: Chip
)
