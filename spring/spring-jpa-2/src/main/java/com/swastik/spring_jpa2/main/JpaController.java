//package com.swastik.spring_jpa2.main;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.swastik.spring_jpa2.dao.AddressService;
//import com.swastik.spring_jpa2.dao.EmployeeService;
//import com.swastik.spring_jpa2.model.Address;
//import com.swastik.spring_jpa2.model.Employee;
//
//@RestController
//public class JpaController {
//
//	@Autowired
//	EmployeeService empService;
//
//
//	@GetMapping(value = "/executeone")
//	public void executeMono() {
//		System.out.println("Execute Mono Called");
//		Employee e = new Employee("Abhishek", "Sales", 3 * 1000, "Hyderabad");
//		empService.saveEmployee(e);
//	}
//	
//	@GetMapping(value = "/executeonea")
//	public void executeMonoa() {
//		System.out.println("Execute Monoa Called");
//		
//		Address a  = new Address("mdfasfe");
//		addService.saveAddress(a);
//	}
//
//	@GetMapping(value = "/executeBatch")
//	public void executeBatch(@RequestParam("number") String number) {
//		System.out.println("Execute Batch Called");
//		int i = Integer.valueOf(number);
//		for (int m = 0; m < i; m++) {
//			Employee e = new Employee("Abhishek", "Sales", 3 * 1000, "Hyderabad");
//			empService.saveEmployee(e);
//		}
//	}
//	
//	@GetMapping(value = "/executeBatcha")
//	public void executeBatcha(@RequestParam("number") String number) {
//		System.out.println("Execute Batcha Called");
//		int i = Integer.valueOf(number);
//		for (int m = 0; m < i; m++) {
//			Address a  = new Address("mdfasfe");
//			addService.saveAddress(a);
//		}
//	}
//}
