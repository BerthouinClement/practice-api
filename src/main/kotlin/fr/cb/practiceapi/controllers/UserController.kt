package fr.cb.practiceapi.controllers

import fr.cb.practiceapi.exception.BadRequestException
import fr.cb.practiceapi.models.entities.User
import fr.cb.practiceapi.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @GetMapping
    fun findAll(): List<User> = userService.findAll()

    @GetMapping(path = ["/search"])
    fun search(
        @RequestParam email: String?,
        @RequestParam firstName: String?,
        @RequestParam lastName: String?
    ): List<User> {
        if (email == null && firstName == null && lastName == null) {
            throw BadRequestException("at least one param must be provided : [email, firstName, lastName]")
        }
        return userService.search(email, firstName, lastName)
    }

    @PostMapping
    fun save(@RequestBody user: User): ResponseEntity<String> {
        val savedUser = userService.save(user)
        return ResponseEntity.created(URI.create("/users/${savedUser.id}")).build()
    }
}