package knight.springframework.restservices.api.v1.mapper;

import knight.springframework.restservices.api.v1.mod.CategoryDTO;
import knight.springframework.restservices.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    CategoryDTO categoryToCategoryDTO(Category category);

}
