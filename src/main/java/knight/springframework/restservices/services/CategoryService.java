package knight.springframework.restservices.services;

import knight.springframework.restservices.api.v1.mod.CategoryDTO;
import knight.springframework.restservices.model.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    List<CategoryDTO> findAllCategories();
    CategoryDTO getCategoryByName(String name);



}
