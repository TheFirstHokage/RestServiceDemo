package knight.springframework.restservices.services;

import knight.springframework.restservices.api.v1.mapper.CustomerMapper;
import knight.springframework.restservices.api.v1.mod.CustomerDTO;
import knight.springframework.restservices.controllers.v1.CustomerController;
import knight.springframework.restservices.model.Customer;
import knight.springframework.restservices.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(customer -> {
            CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
            customerDTO.setCustomerUrl("/api/v1/customer/"+customer.getId());
            return customerDTO;
        }).collect(Collectors.toList());

    }

    @Override
    public CustomerDTO findCustomerById(Long id) {
        return customerRepository.findById(id).map(customerMapper::customerToCustomerDTO).orElseThrow(RuntimeException::new);
    }


    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
       return saveAndReturnDTO(customerMapper.customerDTOToCustomer(customerDTO));


    }


    private CustomerDTO saveAndReturnDTO(Customer customer)  {
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO returnedDto = customerMapper.customerToCustomerDTO(savedCustomer);
        returnedDto.setCustomerUrl(getCustomerUrl(savedCustomer.getId()));
        return returnedDto;
    }


    @Override
    public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setId(id);
        return saveAndReturnDTO(customer);
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            if (customerDTO.getFirstName() != null){
                customer.setFirstName(customerDTO.getFirstName());
            }

            if (customerDTO.getLastName() != null){
                customer.setLastName(customerDTO.getLastName());
            }

            CustomerDTO theCustomer =customerMapper.customerToCustomerDTO(customerRepository.save(customer));
            theCustomer.setCustomerUrl(getCustomerUrl(id));

            return theCustomer;
        }).orElseThrow(ResourceNotFoundException::new);


    }


    private String getCustomerUrl(Long id){
        return CustomerController.BASE_URL+"/"+id;
    }


    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
