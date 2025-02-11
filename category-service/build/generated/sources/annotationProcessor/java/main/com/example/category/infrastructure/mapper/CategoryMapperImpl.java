package com.example.category.infrastructure.mapper;

import com.example.category.domain.model.Category;
import com.example.category.infrastructure.entities.CategoryEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-09T15:51:55-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.jar, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryEntity categoryToCategoryEntity(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setNit( category.getNit() );
        categoryEntity.setName( category.getName() );
        categoryEntity.setAddress( category.getAddress() );
        categoryEntity.setNumberPhone( category.getNumberPhone() );

        return categoryEntity;
    }

    @Override
    public Category categoryEntityToCategory(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Category category = new Category();

        category.setNit( categoryEntity.getNit() );
        category.setName( categoryEntity.getName() );
        category.setAddress( categoryEntity.getAddress() );
        category.setNumberPhone( categoryEntity.getNumberPhone() );

        return category;
    }
}
