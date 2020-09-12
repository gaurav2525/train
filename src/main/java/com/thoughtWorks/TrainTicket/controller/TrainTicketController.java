package com.thoughtWorks.TrainTicket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtWorks.TrainTicket.model.Ticket;
import com.thoughtWorks.TrainTicket.service.TrainTicketService;

@RestController
public class TrainTicketController {

	@Autowired
	TrainTicketService trainTicketService;

	@GetMapping(value = "/getTicket", produces = "application/json")
	public Ticket ticketGenerator(@RequestParam String source, @RequestParam String destination, @RequestParam int age,
			@RequestParam String name, @RequestParam boolean twoWay) {

		Ticket ticket = trainTicketService.getTicket(source, destination, age, name, twoWay);
		return ticket;

	}

}