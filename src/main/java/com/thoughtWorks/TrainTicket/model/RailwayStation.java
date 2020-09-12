package com.thoughtWorks.TrainTicket.model;

public enum RailwayStation {

	CHENNAI_BEACH("Chennai Beach", 1), CHENNAI_FORT("Chennai Fort", 2), CHNNEAI_PARK("Chennai Park", 3),
	CHENNAI_EGMORE("Chennai Egmore", 4), CHETPET("Chetpet", 5), NUNGAMBAKKAM("Nungambakkam", 6),
	KODAMBAKKAM("Kodambakkam", 7), MAMBALAM("Mambalam", 8), SAIDAPET("Saidapet", 9), GUINDY("Guindy", 10),
	ST_THOMAS_MOUNT("St. Thomas Mount", 11), PAZHAVANTHANGAL("Pazhavanthangal", 12), MEENAMBAKKAM("Meenambakkam", 13),
	TRISULAM("Trisulam", 14), PALLAVARAM("Pallavaram", 15), CHROMEPET("Chromepet", 16),
	TAMBARAM_SANATORIUM("Tambaram Sanatorium", 17), TAMBARAM("Tambaram", 18);

	String stationName;
	int stationNumber;

	private RailwayStation(String stationName, int stationNumber) {
		this.stationName = stationName;
		this.stationNumber = stationNumber;
	}

	public String getStationName() {
		return stationName;
	}

	public int getStationNumber() {
		return stationNumber;
	}

	public static RailwayStation fromStationName(String stationName) {
		for (RailwayStation e : RailwayStation.values()) {
			if (e.stationName.equals(stationName)) {

				return e;
			}
		}
		return null;
	}
}