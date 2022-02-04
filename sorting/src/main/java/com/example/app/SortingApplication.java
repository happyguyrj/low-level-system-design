package com.example.app;

import com.example.app.comparatorImpl.UserComparator;
import com.example.app.domain.User;
import com.example.app.sortingImpl.BubbleSortImpl;
import com.example.app.sortingImpl.SelectionSortImpl;
import com.example.app.staticSorts.SelectionSort;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SortingApplication {

	public static void main(String[] args) {
		User user1 = new User("A", 21);
		User user2 = new User("B", 23);
		User user3 = new User("C", 20);
		User user4 = new User("D", 20);
		User user5 = new User("E", 20);
		User user6 = new User("F", 2);
		User user7 = new User("G", 24);
		User user8 = new User("H", 25);
		User user9 = new User("I", 29);
		User user10 = new User("J", 30);
		User user11 = new User("K", 10);
		User user12 = new User("L", 0);

		User[] users = {user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12};

		Sort<User> bubbleSort = new BubbleSortImpl<>();
		Sort<User> selectionSort = new SelectionSortImpl<>();

		bubbleSort.sort(users, new UserComparator());
		selectionSort.sort(users, new UserComparator());
	}

}
