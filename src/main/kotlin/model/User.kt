package model

import jakarta.persistence.*
import org.hibernate.cfg.AccessType

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    var firstName: String,
    var lastName: String,
    var middleName: String
)