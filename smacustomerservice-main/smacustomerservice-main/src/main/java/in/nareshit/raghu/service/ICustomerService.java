/*
 * package in.nareshit.raghu.service;
 * 
 * import java.util.List;
 * 
 * import in.nareshit.raghu.entity.Customer;
 * 
 * public interface ICustomerService {
 * 
 * Long saveCustomer(Customer cust); Customer getOneCustomer(Long id); Customer
 * getOneCustomerByEmail(String email); Customer getOneCustomerByPanCard(String
 * panCard); Customer getOneCustomerByMobile(String mobile); Customer
 * getOneCustomerByAadhar(String aadhar);
 * 
 * List<Customer> getAllCustomers(); }
 */

//////////////////////////////////
package in.nareshit.raghu.service;

import java.util.List;

import in.nareshit.raghu.entity.Customer;

public interface ICustomerService {

    Long saveCustomer(Customer customer);
    Customer getOneCustomer(Long id);
    Customer getOneCustomerByEmail(String email);
    Customer getOneCustomerByPanCard(String panCard);
    Customer getOneCustomerByAadhar(String aadhar);
    Customer getOneCustomerByMobile(String mobile);
    List<Customer> getAllCustomers();
    void deleteCustomer(Long id);
}
