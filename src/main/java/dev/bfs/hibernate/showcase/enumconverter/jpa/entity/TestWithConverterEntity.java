package dev.bfs.hibernate.showcase.enumconverter.jpa.entity;

import dev.bfs.hibernate.showcase.enumconverter.domain.SinglecharEnum;
import dev.bfs.hibernate.showcase.enumconverter.jpa.converter.SinglecharEnumCharacterAttributeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

@Entity
public class TestWithConverterEntity {
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name="SINGLE_CHAR", length = 1, nullable = false)
    @Convert(converter = SinglecharEnumCharacterAttributeConverter.class)
    private SinglecharEnum singleChar;

    public static TestWithConverterEntity of(@NonNull Long id, @NonNull SinglecharEnum singlecharEnum) {
        TestWithConverterEntity entity = new TestWithConverterEntity();
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

            if (!(o instanceof TestWithConverterEntity other))
                return false;

        return this.id != null &&
                    this.id.equals(other.getId());
        }

        @Override
        public int hashCode() {
            return this.getClass().hashCode();
        }
}
