package com.thoughtWorks.TrainTicket.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.thoughtWorks.TrainTicket.model.RailwayStation;
import com.thoughtWorks.TrainTicket.model.Ticket;
import com.thoughtWorks.TrainTicket.model.Ticket.TicketBuilder;
import com.thoughtWorks.TrainTicket.model.TicketType;

@Service
public class TrainTicketService {
	TicketBuilder ticket;

	public Ticket getTicket(String source, String destination, int age, String name, boolean twoWay) {

		int distance = getDistance(source, destination);

		if (distance == -1)
			return ticket.build();

		Date purchaseDateTime = new Date();

		double price = ticketPriceGenerator(distance, age, twoWay);

		ticket = Ticket.TicketBuilder.aTicketBuilder();

		ticket = ticket.withSource(source).withDestination(destination)
				.withTicketType(twoWay ? TicketType.TWOWAY : TicketType.ONEWAY).withPrice(price).withDistance(distance)
				.withPurchaseDateTime(purchaseDateTime);

		return ticket.build();

	}

	private int getDistance(String source, String destination) {
		// TODO Auto-generated method stub

		RailwayStation sourceStation = RailwayStation.fromStationName(source);
		RailwayStation destinationStation = RailwayStation.fromStationName(destination);

		if (sourceStation != null && destinationStation != null) {
			return Math.abs(destinationStation.getStationNumber() - sourceStation.getStationNumber());
		}

		return -1;
	}

	double ticketPriceGenerator(int distance, int age, boolean twoWay) {

		double ticketPrice = 0;

		if (age < 3)
			return ticketPrice;

		if (distance == 17)
			return 20;

		ticketPrice = 10;

		while (distance > 5) {
			ticketPrice += 5;
			distance -= 5;
		}

		if (twoWay) {
			ticketPrice = ticketPrice * 1.75;
		}

		if (age < 10) {
			ticketPrice *= 0.75;
		}

		return ticketPrice;

	}

}
