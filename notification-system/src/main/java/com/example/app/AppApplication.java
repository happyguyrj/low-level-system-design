package com.example.app;

import com.example.app.delivery.DeliveryFactory;
import com.example.app.domain.DeliveryChannel;
import com.example.app.domain.Notification;
import com.example.app.domain.Priority;
import com.example.app.middleware.*;
import com.example.app.publisher.Publisher;

import java.util.HashMap;
import java.util.Map;

public class AppApplication {

	private static NotificationServer server;

	private static void init() {
		Map<Integer, Publisher> publishers = new HashMap<>();
		publishers.put(1, new Publisher(1, "Rahul", 3));
		publishers.put(2, new Publisher(2, "Mr. jain", 1));

		server = new NotificationServer();
		Middleware middleware = new Validator();
		middleware.linkWith(new Prioritizer(new DeliveryFactory()))
				.linkWith(new PublisherThrottler(publishers))
				.linkWith(new SubscriberThrottler(1))
				.linkWith(new Dispatcher(new DeliveryFactory()));
		server.setMiddleware(middleware);
	}

	public static void main(String[] args) {
		init();

		Notification notification = new Notification(1,1,"HelloWorld!", Priority.HIGH, DeliveryChannel.EMAIL);
		server.sendNotification(notification);

		System.out.println();
		notification = new Notification(1,1,"HelloWorld!", Priority.MEDIUM, DeliveryChannel.EMAIL);
		server.sendNotification(notification);

		System.out.println();
		notification = new Notification(1,1,"HelloWorld!", Priority.MEDIUM, DeliveryChannel.EMAIL);
		server.sendNotification(notification);
	}

}
