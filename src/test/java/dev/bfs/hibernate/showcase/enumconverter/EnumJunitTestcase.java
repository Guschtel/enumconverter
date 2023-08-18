package dev.bfs.hibernate.showcase.enumconverter;

import dev.bfs.hibernate.showcase.enumconverter.domain.SinglecharEnum;
import dev.bfs.hibernate.showcase.enumconverter.jpa.entity.TestEntity;
import dev.bfs.hibernate.showcase.enumconverter.jpa.entity.TestWithConverterEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * This test demonstrates, that an enum field with a column definition with length of 1 cannot be persisted with Hibernate 6
 * when using the automatic Enum conversion provided by @{@link jakarta.persistence.Enumerated} with {@link jakarta.persistence.EnumType#STRING}.<br />
 * See @{@link TestEntity#getSingleChar()} and {@link SinglecharEnum}
 */
class EnumJunitTestCase {

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
    void enumTestFailsWithEnumConverter() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try (entityManager) {
            entityManager.getTransaction().begin();

            TestEntity entity = TestEntity.of(1L, SinglecharEnum.B);
            entityManager.merge(entity);

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            fail("Should not happen: " + ex.getMessage());
        }
    }

    @Test
    void enumTestOkWithCustomConverter() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try (entityManager) {
            entityManager.getTransaction().begin();

            TestWithConverterEntity entity = TestWithConverterEntity.of(1L, SinglecharEnum.B);
            TestWithConverterEntity merge = entityManager.merge(entity);

            entityManager.getTransaction().commit();

            Assertions.assertNotNull(merge);
        } catch (Exception ex) {
            fail("Should not happen: " + ex.getMessage());
        }
    }
}