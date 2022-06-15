package fr.cb.practiceapi.repositories

import fr.cb.practiceapi.models.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int>, JpaSpecificationExecutor<User> {
}