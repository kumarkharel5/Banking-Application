package com.veternary.clinic;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Pet p = new Pet();
//		p.getMedList();
//		p.addMedHist();
//		p.removeMedHist();
//		p.addVaccination();
//		p.getVaccinations();
//		p.removeVaccination();
		p.addAppointments();
		p.getAppointments();
		p.resolveAppointment();
	}
}
