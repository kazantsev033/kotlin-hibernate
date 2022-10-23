package repository

import jakarta.persistence.EntityManager
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import model.User
import org.hibernate.cfg.Configuration


class UserRepository {

    private val entityManager: EntityManager = Configuration()
        .configure()
        .addAnnotatedClass(User::class.java)
        .buildSessionFactory()
        .openSession()

    fun getUserById(id: Int): User {
        return entityManager.find(User::class.java, id)
    }

    fun save(user: User): Int {
        entityManager.transaction.begin()
        entityManager.persist(user)
        entityManager.transaction.commit()

        return user.id
    }

    fun getUserByFirstName(firstName: String): User {

        // Criteria API
//        val criteriaBuilder = entityManager.criteriaBuilder
//        val criteriaQuery = criteriaBuilder.createQuery(User::class.java)
//        val root: Root<User> = criteriaQuery.from(User::class.java)
//
//        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get<String>("firstName"), firstName))
//
//        return entityManager.createQuery(criteriaQuery).resultList[0]

        // Native Query
        return entityManager
            .createNativeQuery("SELECT * FROM users WHERE firstName = '$firstName'", User::class.java)
            .resultList[0] as User
    }
}