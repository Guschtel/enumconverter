package dev.bfs.hibernate.showcase.enumconverter.jpa.repository;

import dev.bfs.hibernate.showcase.enumconverter.jpa.entity.TestWithConverterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestWithConverterRepository extends JpaRepository<TestWithConverterEntity, Long> {
}
