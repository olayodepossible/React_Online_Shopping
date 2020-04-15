package com.possible.onlinestore.utils;

import com.possible.onlinestore.models.CategoryEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoryEnumConverter implements AttributeConverter<CategoryEnum, String> {


        @Override
        public String convertToDatabaseColumn(CategoryEnum category) {
            if (category == null) {
                return null;
            }
            return category.getCode();
        }


    @Override
        public CategoryEnum convertToEntityAttribute(String code) {
            if (code == null) {
                return null;
            }

            return Stream.of(CategoryEnum.values())
                    .filter(c -> c.getCode().equals(code))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
}
