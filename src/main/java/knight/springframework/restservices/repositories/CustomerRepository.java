package knight.springframework.restservices.repositories;

import knight.springframework.restservices.api.v1.mod.CustomerDTO;
import knight.springframework.restservices.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
