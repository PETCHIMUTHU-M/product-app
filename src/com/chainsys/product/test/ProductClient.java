package com.chainsys.product.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;
import com.chainsys.product.service.ProductService;
import com.chainsys.product.service.ProductServiceImpl;

public class ProductClient {
	public static void main(String[] args) {

		Set<Product> productSet;
		ProductService service = new ProductServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		String name;
		List<String> namelist;
		List<Integer> idlist;
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Products");
			productSet = service.findAll();
			System.out.println(productSet);
			break;
			
		case 2:
			System.out.println("Find All Products Name");
			namelist = service.findAllName();
			System.out.println(namelist);
			break;
			
		case 3:
			System.out.println("Find All Products Id");
			idlist = service.findAllId();
			System.out.println(idlist);
			break;
			
		case 4:
			System.out.println("Find the Product By Id");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				Product product = service.findById(id);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 5:
			System.out.println("Find the Product By Name");
			System.out.println("Enter the Product Name");
			name= scanner.next();
			try {
				Product product = service.findByName(name);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
			
		case 6:
			System.out.println("Find the Product By ExpiryDate");
			System.out.println("Enter the Product ExpiryDate");
			date= scanner.next();
			try {
				Product product = service.findByDate(date);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
			
		case 7:
			System.out.println("Update the Product Name Based on the Id");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updateProduct = new Product(2, "Pencil", LocalDate.parse(date, dateFormat));
			try {
				service.update(updateProduct);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
		case 8:
			System.out.println("Adding a Product");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product newProduct = new Product(4, "book", LocalDate.parse(date, dateFormat));
			service.save(newProduct);
			productSet = service.findAll();
			System.out.println(productSet);
			break;
			
		case 9:
			System.out.println("Update the Product Expiry date Based on the Id");
			date = "02/21/2023";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updateProduct1 = new Product(3, "Milk", LocalDate.parse(date, dateFormat));
			try {
				service.update_expire(updateProduct1 );
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
		
		case 10:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				service.delete(id);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
			
		case 11:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Name");
			name = scanner.next();
			try {
				service.delete(name);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
			
		case 12:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product ExpiryDate");
			date = scanner.next();
			try {
				service.delete(date);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
			
		default:
			break;
		}
		scanner.close();
	}

}