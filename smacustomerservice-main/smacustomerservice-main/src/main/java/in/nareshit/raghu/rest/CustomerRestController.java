/*
 * package in.nareshit.raghu.rest;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import in.nareshit.raghu.entity.Customer; import
 * in.nareshit.raghu.exception.CustomerNotFoundException; import
 * in.nareshit.raghu.service.ICustomerService;
 * 
 * @RestController
 * 
 * @RequestMapping("/customer") public class CustomerRestController {
 * 
 * @Autowired private ICustomerService service;
 * 
 * //1. save customer
 * 
 * @PostMapping("/create") public ResponseEntity<String> createCustomer(
 * 
 * @RequestBody Customer customer ) { ResponseEntity<String> response = null;
 * 
 * Long id = service.saveCustomer(customer); response =
 * ResponseEntity.ok("Customer '"+id+"' Created!");
 * 
 * return response; }
 * 
 * //2. fetch all customers
 * 
 * @GetMapping("/all") public ResponseEntity<List<Customer>> getAllCustomers() {
 * ResponseEntity<List<Customer>> response = null; List<Customer> list =
 * service.getAllCustomers(); response = ResponseEntity.ok(list); return
 * response; }
 * 
 * 
 * //3. fetch one customer by email
 * 
 * @GetMapping("/find/{mail}") public ResponseEntity<Customer>
 * getOneCustomerByEmail(
 * 
 * @PathVariable String mail ) { ResponseEntity<Customer> response = null; try {
 * Customer cust = service.getOneCustomerByEmail(mail); response = new
 * ResponseEntity<Customer>(cust,HttpStatus.OK); } catch
 * (CustomerNotFoundException cnfe) { cnfe.printStackTrace(); throw cnfe; }
 * return response; }
 * 
 * //4. fetch one customer by pancard //5. fetch one customer by aadharId //6.
 * fetch one customer by mobile
 * 
 * }
 */

/////////////////////////////////////
package in.nareshit.raghu.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import in.nareshit.raghu.entity.Customer;
import in.nareshit.raghu.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    private ICustomerService service;

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        Long id = service.saveCustomer(customer);
        return ResponseEntity.ok("Customer '" + id + "' created!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> list = service.getAllCustomers();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/find/email/{email}")
    public ResponseEntity<Customer> getOneCustomerByEmail(@PathVariable String email) {
        Customer customer = service.getOneCustomerByEmail(email);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/find/pancard/{panCard}")
    public ResponseEntity<Customer> getOneCustomerByPanCard(@PathVariable String panCard) {
        Customer customer = service.getOneCustomerByPanCard(panCard);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/find/aadhar/{aadhar}")
    public ResponseEntity<Customer> getOneCustomerByAadhar(@PathVariable String aadhar) {
        Customer customer = service.getOneCustomerByAadhar(aadhar);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/find/mobile/{mobile}")
    public ResponseEntity<Customer> getOneCustomerByMobile(@PathVariable String mobile) {
        Customer customer = service.getOneCustomerByMobile(mobile);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.ok("Customer '" + id + "' deleted!");
    }
}
