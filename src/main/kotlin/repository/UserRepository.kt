package repository

import jakarta.persistence.EntityManager
import model.UserEntity
import org.hibernate.cfg.Configuration


class UserRepository {

    private val entityManager: EntityManager = Configuration()
        .configure()
        .addAnnotatedClass(UserEntity::class.java)
        .buildSessionFactory()
        .openSession()

    fun getUserById(id: Int): UserEntity {
        return entityManager.find(UserEntity::class.java, id)
    }

    fun save(userEntity: UserEntity): Int {
        entityManager.transaction.begin()
        entityManager.persist(userEntity)
        entityManager.transaction.commit()

        return userEntity.id
    }

    fun getUserByFirstName(firstName: String): UserEntity {

        // Criteria API
//        val criteriaBuilder = entityManager.criteriaBuilder
//        val criteriaQuery = criteriaBuilder.createQuery(User::class.java)
//        val root: Root<User> = criteriaQuery.from(User::class.java)
//
//        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get<String>("firstName"), firstName))
//
//        return entityManager.createQuery(criteriaQuery).resultList[0]

        // HQL
        return entityManager
            .createQuery("from UserEntity where firstName = :firstName", UserEntity::class.java)
            .setParameter("firstName", firstName)
            .resultList[0]

        // Native Query
//        return entityManager
//            .createNativeQuery("SELECT * FROM users WHERE firstName = '$firstName'", User::class.java)
//            .resultList[0] as User
    }
}