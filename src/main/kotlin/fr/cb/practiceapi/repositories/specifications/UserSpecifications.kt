package fr.cb.practiceapi.repositories.specifications

import fr.cb.practiceapi.models.entities.User
import org.springframework.data.jpa.domain.Specification

class UserSpecifications {

    private fun containsUserEmail(userEmail: String?): Specification<User> {
        return Specification<User> { root, _, builder ->
            if (!userEmail.isNullOrBlank()) {
                builder.like(builder.lower(root.get(User::email.name)), "%${userEmail.lowercase()}%")
            } else {
                null
            }
        }
    }

    private fun containsLasName(lastName: String?): Specification<User> {
        return Specification<User> { root, _, builder ->
            if (!lastName.isNullOrBlank()) {
                builder.like(builder.lower(root.get(User::lastName.name)), "%${lastName.lowercase()}%")
            } else {
                null
            }
        }
    }

    private fun containsFirstName(firstName: String?): Specification<User> {
        return Specification<User> { root, _, builder ->
            if (!firstName.isNullOrBlank()) {
                builder.like(builder.lower(root.get(User::firstName.name)), "%${firstName.lowercase()}%")
            } else {
                null
            }
        }
    }

    fun globalSearch(email: String?, firstName: String?, lastName: String?): Specification<User> {
        return containsUserEmail(email).and(containsFirstName(firstName)).and(containsLasName(lastName))
    }
}