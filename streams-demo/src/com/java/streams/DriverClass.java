package com.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.java.streams.model.Book;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the Stream API Demo ");

		List<Book> bookList = new ArrayList<>();

		Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
		Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		Book b4 = new Book(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);

		bookList.add(b1);
		bookList.add(b2);
		bookList.add(b3);
		bookList.add(b4);

		// Printing the bookList using Stream API
		System.out.println("Printing the list of Books using Stream API ");
		bookList.stream().forEach(System.out::println);

		// Collecting the List element as Set
		System.out.println("Printing the Set of Elements from List ");
		Set<Book> bookSet = bookList.stream().collect(Collectors.toSet());
		bookSet.forEach(System.out::println);

		// List of books in sorted way
		System.out.println("Sorted List of Books ");
		bookList.stream().sorted().forEach(System.out::println);

		// Double the Quantity of each book
		System.out.println(" Doubling the quantity of each book in List ");
		// bookList.stream().map(book -> book.getQuantity() * 2).forEach(n ->
		// System.out.println(n));
		List<Book> updList = bookList.stream().map(book -> {
			book.setQuantity(book.getQuantity() * 2);
			return book;
		}).toList();
		updList.forEach(System.out::println);
		
		System.out.println("Original List");
		bookList.forEach(System.out::println);
		/*
		 * // filter the books whose quantity > 10
		 * System.out.println("Books whose quantity > 10 :");
		 * bookList.stream().filter(book -> book.quantity >
		 * 10).forEach(System.out::println);
		 * 
		 * // sum of quantity where books have id < 200
		 * System.out.println("sum of quantity of books where id < 200 : "); int sum =
		 * bookList.stream().filter(book -> book.id < 200).map(book ->
		 * book.quantity).reduce(0, (s, q) -> s + q); System.out.println(sum);
		 */
	}

}
