package ru.rudikov.monopoly.application.domain.model.entity

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "chip")
@SequenceGenerator(
    name = "seq_chip_id",
    sequenceName = "seq_chip_id",
    allocationSize = 1,
)
data class Chip(
    @Id
    @GeneratedValue(
        generator = "seq_chip_id",
        strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id")
    val id: Long? = null,

    val name: String,
    val position: Int,
    val balance: Long,
    @Column(name = "is_bankrupt")
    val bankruptFlag: Boolean = false,
    @Column(name = "is_arrested")
    val arrestedFlag: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "game_id")
    var game: Game
) {
    @OneToMany(mappedBy = "chip", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    var cells: MutableList<Cell> = mutableListOf()
}
