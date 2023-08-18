package dev.bfse.hibernate.showcase.enumconverter.jpa.converter;

import dev.bfse.hibernate.showcase.enumconverter.domain.SinglecharEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.lang.NonNull;

@Converter
public class SinglecharEnumCharacterAttributeConverter implements AttributeConverter<SinglecharEnum, Character> {
    @Override
    public Character convertToDatabaseColumn(@NonNull SinglecharEnum attribute) {
        return attribute.name().charAt(0);
    }

    @Override
    public SinglecharEnum convertToEntityAttribute(Character dbData) {
        return SinglecharEnum.valueOf(dbData.toString());
    }
}
