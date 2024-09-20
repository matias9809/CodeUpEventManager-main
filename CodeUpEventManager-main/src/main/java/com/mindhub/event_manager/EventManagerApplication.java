package com.mindhub.event_manager;

import com.mindhub.event_manager.enums.ReactionType;
import com.mindhub.event_manager.models.*;
import com.mindhub.event_manager.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ReactionRepository reactionRepository,CustomerRepository customerRepository, EventRepository eventRepository, CommentRepository commentRepository, EventLocationRepository eventLocationRepository, LocationRepository locationRepository, CustomerEventLocationRepository customerEventLocationRepository){
		return args -> {
			Customer customer1 = new Customer();
			Event event1 = new Event();
			Comment comment1 = new Comment();
			Location location1 = new Location();
			EventLocation eventLocation1 = new EventLocation();
			CustomerEventLocation customerEventLocation1 = new CustomerEventLocation();

			customer1.addCustomerEvent(customerEventLocation1);
			customer1.addComment(comment1);
			customer1.addEvent(event1);

			eventLocation1.addCustomerEvent(customerEventLocation1);

			event1.addEventLocation(eventLocation1);
			event1.addComment(comment1);

			location1.addEventLocation(eventLocation1);

			customerRepository.save(customer1);
			eventRepository.save(event1);


			commentRepository.save(comment1);
			locationRepository.save(location1);

			eventLocationRepository.save(eventLocation1);
			customerEventLocationRepository.save(customerEventLocation1);

			Reaction reaction=new Reaction(ReactionType.Like);

			customer1.addReaction(reaction);

			event1.addReaction(reaction);

			reactionRepository.save(reaction);

			System.out.println("customer id: "+customer1.getCustomer_id());
			System.out.println("customer event location id: "+customerEventLocation1.getCustomerEvent_id());
		};
	}
}
