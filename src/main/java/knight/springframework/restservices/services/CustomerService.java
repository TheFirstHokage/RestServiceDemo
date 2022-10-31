package knight.springframework.restservices.services;

import knight.springframework.restservices.api.v1.mod.CategoryDTO;
import knight.springframework.restservices.api.v1.mod.CustomerDTO;
import knight.springframework.restservices.model.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO findCustomerById(Long id);

   CustomerDTO createNewCustomer(CustomerDTO customerDTO);

   CustomerDTO saveCustomerByDTO(Long id,CustomerDTO customerDTO);

   CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

   void deleteCustomerById(Long id);
}
