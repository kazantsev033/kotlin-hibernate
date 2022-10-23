package repository

import model.User
import org.hibernate.Session
import org.hibernate.cfg.Configuration
import org.junit.jupiter.api.Test

class UserRepositoryTests {

    private val userRepository = UserRepository()

    @Test
    fun saveUser(){
        val user = User(
            firstName = "Петр",
            lastName = "Петров",
            middleName = "Петрович"
        )

        userRepository.save(user)
    }

    @Test
    fun getUserById() {
        val expectedUser = User(
            firstName = "Петр",
            lastName = "Петров",
            middleName = "Петрович"
        )

        val id = userRepository.save(expectedUser)

        val user = userRepository.getUserById(id)
        println(user)
    }

    @Test
    fun getUserByFirstName(){
        val expectedUser = User(
            firstName = "Иван",
            lastName = "Петров",
            middleName = "Петрович"
        )

        userRepository.save(expectedUser)

        val user = userRepository.getUserByFirstName("Иван")
        println(user)
    }
}