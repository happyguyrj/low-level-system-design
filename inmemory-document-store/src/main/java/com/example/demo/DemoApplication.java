package com.example.demo;

import com.example.demo.service.DocumentService;

public class DemoApplication {

	public static void main(String[] args) {
		DocumentService documentService = new DocumentService();
		documentService.createDataset("Fruits");

		documentService.createDocument("An Apple is a fruit", "Fruits", "Doc1");
		documentService.createDocument("An Apple is good for health", "Fruits", "Doc2");
		documentService.createDocument("An Apple Apple", "Fruits", "Doc3");

		System.out.println(documentService.searchDocuments("Fruits", "Apple"));
		System.out.println(documentService.searchDocuments("Vegetable", "Apple"));
		System.out.println(documentService.searchDocuments("Fruits", "Banana"));


	}

}
