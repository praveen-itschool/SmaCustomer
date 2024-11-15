/*
 * package in.nareshit.raghu.impl;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import in.nareshit.raghu.entity.Customer; import
 * in.nareshit.raghu.exception.CustomerNotFoundException; import
 * in.nareshit.raghu.repo.CustomerRepository; import
 * in.nareshit.raghu.service.ICustomerService;
 * 
 * @Service public class CustomerServiceImpl implements ICustomerService {
 * 
 * @Autowired private CustomerRepository repo;
 * 
 * public Long saveCustomer(Customer cust) { return repo.save(cust).getId(); }
 * 
 * public Customer getOneCustomer(Long id) { Optional<Customer> opt =
 * repo.findById(id); return validateInput(opt, id.toString()); }
 * 
 * public Customer getOneCustomerByEmail(String email) { Optional<Customer> opt
 * = repo.findByEmail(email); return validateInput(opt, email); }
 * 
 * public Customer getOneCustomerByPanCard(String panCard) { Optional<Customer>
 * opt = repo.findByPanCardId(panCard); return validateInput(opt, panCard); }
 * 
 * public Customer getOneCustomerByMobile(String mobile) { Optional<Customer>
 * opt = repo.findByMobile(mobile); return validateInput(opt, mobile); }
 * 
 * public Customer getOneCustomerByAadhar(String aadhar) { Optional<Customer>
 * opt = repo.findByAadharId(aadhar); return validateInput(opt, aadhar); }
 * 
 * public List<Customer> getAllCustomers() { return repo.findAll(); }
 * 
 * private Customer validateInput(Optional<Customer> opt,String input) { if
 * (opt.isEmpty()) { throw new CustomerNotFoundException("Customer '" + input +
 * "' not found"); } else { return opt.get(); } //JDK 8 return opt.orElseThrow(
 * ()-> new CustomerNotFoundException( "Customer '" + input + "' not found") );
 * }
 * 
 * 
 * }
 */


///////////////////
package in.nareshit.raghu.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.nareshit.raghu.entity.Customer;
import in.nareshit.raghu.exception.CustomerNotFoundException;
import in.nareshit.raghu.repo.CustomerRepository;
import in.nareshit.raghu.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository repo;

    @Override
    public Long saveCustomer(Customer cust) {
        logger.info("Saving customer: {}", cust);
        return repo.save(cust).getId();
    }

    @Override
    public Customer getOneCustomer(Long id) {
        Optional<Customer> opt = repo.findById(id);
        return validateInput(opt, id.toString());
    }

    @Override
    public Customer getOneCustomerByEmail(String email) {
        Optional<Customer> opt = repo.findByEmail(email);
        return validateInput(opt, email);
    }

    @Override
    public Customer getOneCustomerByPanCard(String panCard) {
        Optional<Customer> opt = repo.findByPanCardId(panCard);
        return validateInput(opt, panCard);
    }

    @Override
    public Customer getOneCustomerByAadhar(String aadhar) {
        Optional<Customer> opt = repo.findByAadharId(aadhar);
        return validateInput(opt, aadhar);
    }

    @Override
    public Customer getOneCustomerByMobile(String mobile) {
        Optional<Customer> opt = repo.findByMobile(mobile);
        return validateInput(opt, mobile);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = getOneCustomer(id);
        repo.delete(customer);
    }

    private Customer validateInput(Optional<Customer> opt, String input) {
        return opt.orElseThrow(() -> new CustomerNotFoundException("Customer '" + input + "' not found"));
    }
}
