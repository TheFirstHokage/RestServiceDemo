package knight.springframework.restservices.bootstrap;

import knight.springframework.restservices.model.Category;
import knight.springframework.restservices.model.Customer;
import knight.springframework.restservices.repositories.CategoryRepository;
import knight.springframework.restservices.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository,CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }





    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();

    }


    private  void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(dried);
        categoryRepository.save(nuts);
        System.out.println("categories saved "+categoryRepository.count());
    }


    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Jeff");
        customer1.setLastName("Hardy");
        customerRepository.save(customer1);

        Customer customer2= new Customer();
        customer2.setId(2L);
        customer2.setLastName("Randy");
        customer2.setFirstName("Orton");
        customerRepository.save(customer2);
        System.out.println(customerRepository.count());
    }

}
