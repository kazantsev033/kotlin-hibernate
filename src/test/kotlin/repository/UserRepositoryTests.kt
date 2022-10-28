package repository

import model.UserEntity
import org.junit.jupiter.api.Test

class UserRepositoryTests {

    private val userRepository = UserRepository()

    @Test
    fun saveUser(){
        val userEntity = UserEntity(
            firstName = "Петр",
            lastName = "Петров",
            middleName = "Петрович"
        )

        userRepository.save(userEntity)
    }

    @Test
    fun getUserById() {
        val expectedUserEntity = UserEntity(
            firstName = "Петр",
            lastName = "Петров",
            middleName = "Петрович"
        )

        val id = userRepository.save(expectedUserEntity)

        val user = userRepository.getUserById(id)
        println(user)
    }

    @Test
    fun getUserByFirstName(){
        val expectedUserEntity = UserEntity(
            firstName = "Иван",
            lastName = "Петров",
            middleName = "Петрович"
        )

        userRepository.save(expectedUserEntity)

        val user = userRepository.getUserByFirstName("Иван")
        println(user)
    }
}