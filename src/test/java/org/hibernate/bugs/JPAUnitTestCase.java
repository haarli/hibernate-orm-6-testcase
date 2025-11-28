package org.hibernate.bugs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.bugs.pojo2.User;
import org.hibernate.bugs.pojo2.Organization;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */

class JPAUnitTestCase {

    private final static Logger LOGGER = LogManager.getLogger(JPAUnitTestCase.class);

	private EntityManagerFactory entityManagerFactory;

	@BeforeEach
	void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@AfterEach
	void destroy() {
		entityManagerFactory.close();
	}


	@Test
	void findUserBeforeOrganization() throws Exception {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User user1 = entityManager.find(User.class, "user_1");
        Organization ou3 = entityManager.find(Organization.class, "ou_3");

        entityManager.getTransaction().commit();
        entityManager.close();

        //ou 3 must have no parent!
        Assertions.assertTrue(ou3.getParentOrganization()==null, "Parent of ou_3 is null");
        Assertions.assertTrue(ou3.getPredecessorOrganizations().size()==0, "Predecessors of ou_3 is empty");

	}

    @Test
    void findOrganizationOnly() throws Exception {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Organization ou3 = entityManager.find(Organization.class, "ou_3");

        entityManager.getTransaction().commit();
        entityManager.close();

        Assertions.assertTrue(ou3.getParentOrganization()==null, "Parent of ou_3 is null");
        Assertions.assertTrue(ou3.getPredecessorOrganizations().size()==0, "Predecessor of ou_3 is empty");


    }

}
