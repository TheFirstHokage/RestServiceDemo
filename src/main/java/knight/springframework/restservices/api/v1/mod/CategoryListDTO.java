package knight.springframework.restservices.api.v1.mod;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryListDTO {


    private List<CategoryDTO> categories;



}
