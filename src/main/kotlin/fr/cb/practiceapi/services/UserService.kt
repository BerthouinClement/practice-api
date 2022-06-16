package fr.cb.practiceapi.services

import fr.cb.practiceapi.exception.NotFoundException
import fr.cb.practiceapi.models.entities.User
import fr.cb.practiceapi.repositories.UserRepository
import fr.cb.practiceapi.repositories.specifications.UserSpecifications
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}
@Service
class UserService(val userRepository: UserRepository) {

    fun save(user: User) = userRepository.save(user)

    fun findById(id: Int): User =
        userRepository.findById(id).orElseThrow { NotFoundException("Can't find user for id $id") }

    fun search(email: String?, firstName: String?, lastName: String?): List<User> {
        logger.debug { "searching users by email, firstName, lastName : [$email, $firstName, $lastName]" }
        val users = userRepository.findAll(UserSpecifications().globalSearch(email, firstName, lastName))
        logger.debug { "${users.size} user(s) found : $users" }
        return users
    }

    fun findAll(): List<User> = userRepository.findAll()
}