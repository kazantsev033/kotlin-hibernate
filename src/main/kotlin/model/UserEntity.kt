package model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    var firstName: String,
    var lastName: String,
    var middleName: String
)