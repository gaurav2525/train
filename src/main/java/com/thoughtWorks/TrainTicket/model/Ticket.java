package com.thoughtWorks.TrainTicket.model;

import java.util.Date;

public class Ticket {
	private String source;
	private String destination;
	private TicketType ticketType;
	private double price;
	private int distance;
	private Date purchaseDateTime;

	@Override
	public String toString() {
		return "Ticket [source=" + source + ", destination=" + destination + ", ticketType=" + ticketType + ", price="
				+ price + ", distance=" + distance + ", purchaseDateTime=" + purchaseDateTime + "]";
	}

	private Ticket() {

	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public double getPrice() {
		return price;
	}

	public int getDistance() {
		return distance;
	}

	public Date getPurchaseDateTime() {
		return purchaseDateTime;
	}

	public static class TicketBuilder {
		Ticket ticket = new Ticket();

		private TicketBuilder() {

		}

		public static TicketBuilder aTicketBuilder() {
			return new TicketBuilder();
		}

		public TicketBuilder withSource(String source) {
			ticket.source = source;
			return this;
		}

		public TicketBuilder withDestination(String destination) {
			ticket.destination = destination;
			return this;
		}

		public TicketBuilder withTicketType(TicketType ticketType) {
			ticket.ticketType = ticketType;
			return this;
		}

		public TicketBuilder withPrice(double price) {
			ticket.price = price;
			return this;
		}

		public TicketBuilder withDistance(int distance) {
			ticket.distance = distance;
			return this;
		}

		public TicketBuilder withPurchaseDateTime(Date purchaseDateTime) {
			ticket.purchaseDateTime = purchaseDateTime;
			return this;
		}

		public Ticket build() {
			return ticket;
		}
	}

}
