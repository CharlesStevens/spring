//package com.stevens.spring.annotations.beans;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class MainClass {
//
//	public static void main(String[] args) {
//		MainClass c = new MainClass();
//		c.updateRecords(123456, Arrays.asList(98128L, 98129L,92828282L));
//	}
//
//	public void updateRecords(final long receiptId, final List<Long> voucherId) {
//		List<Employee> fetchedRecords = fetchEmployeeRecords();
//
//		List<Long> updation = voucherId.stream()
//				.filter(t -> !(fetchedRecords.stream()
//						.filter(f -> f.getReceiptId() == receiptId && t == f.getVoucherId()).findAny().isPresent()))
//				.collect(Collectors.toList());
//
//		System.out.println(updation.toString());
//
//	}
//
//	public List<Employee> fetchEmployeeRecords() {
//		return Arrays.asList(new Employee("abhi", 1L, 12345, 98128L), new Employee("Jaichitra", 2L, 12345, 98129L),
//				new Employee("sari", 3L, 12345, 98120L), new Employee("dev", 5L, 12345, 324242L));
//	}
//
//}
