package knight.springframework.restservices.controllers.v1;

import knight.springframework.restservices.api.v1.mod.CategoryDTO;
import knight.springframework.restservices.api.v1.mod.CategoryListDTO;
import knight.springframework.restservices.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

   public static final String BASE_URL = "/api/v1/categories/";
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories(){

        return new CategoryListDTO(categoryService.findAllCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryDTOByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }


}
