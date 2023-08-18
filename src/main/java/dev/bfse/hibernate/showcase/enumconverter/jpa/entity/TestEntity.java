package dev.bfse.hibernate.showcase.enumconverter.jpa.entity;

import dev.bfse.hibernate.showcase.enumconverter.domain.SinglecharEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

@Entity
public class TestEntity {
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name="SINGLE_CHAR", length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private SinglecharEnum singleChar;

    public static TestEntity of(@NonNull Long id, @NonNull SinglecharEnum singlecharEnum) {
        TestEntity entity = new TestEntity();
        entity.setId(id);
        entity.setSingleChar(singlecharEnum);
        return entity;
    }

    public SinglecharEnum getSingleChar() {
        return singleChar;
    }

    public void setSingleChar(SinglecharEnum singleChar) {
        this.singleChar = singleChar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (!(o instanceof TestEntity))
                return false;

            TestEntity other = (TestEntity) o;

            return this.id != null &&
                    this.id.equals(other.getId());
        }

        @Override
        public int hashCode() {
            return this.getClass().hashCode();
        }
}
