package fr.cb.practiceapi.models.entities

import javax.persistence.*

@Entity
@Table(name = "[user]")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    val firstName: String,

    @Column(nullable = false)
    val lastName: String,

    @Column(nullable = false)
    var email: String,
) {
    @PrePersist
    fun emailToLowerCase() {
        email = email.lowercase()
    }
}
