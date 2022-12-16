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
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "game")
@SequenceGenerator(
    name = "seq_game_id",
    sequenceName = "seq_game_id",
    allocationSize = 1,
)
data class Game(
    @Id
    @GeneratedValue(
        generator = "seq_game_id",
        strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "who_next")
    var whoNext: String
) {
    @OneToMany(mappedBy = "game", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    var chips: MutableList<Chip> = mutableListOf()
}
