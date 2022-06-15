package fr.cb.practiceapi.services

import fr.cb.practiceapi.exception.NotFoundException
import fr.cb.practiceapi.models.entities.User
import fr.cb.practiceapi.repositories.UserRepository
import fr.cb.practiceapi.repositories.specifications.UserSpecifications
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun save(user: User) = userRepository.save(user)

    fun findById(id: Int): User =
        userRepository.findById(id).orElseThrow { NotFoundException("Can't find user for id $id") }

    fun search(email: String?, firstName: String?, lastName: String?): List<User> {
        return userRepository.findAll(UserSpecifications().globalSearch(email, firstName, lastName))
    }

}