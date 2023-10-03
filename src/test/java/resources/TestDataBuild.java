package resources;

import pojo.CreateBooking;

public class TestDataBuild {

	public CreateBooking CreateBooking_Payload(String firstName, String lastName, String totalPrice, String depostPaid,
			 String checkIn, String checkOut, String additionalNeeds) 
	{
		CreateBooking booking = new CreateBooking();
		booking.setFirstname(firstName);
		booking.setLastname(lastName);
		booking.setTotalprice(totalPrice);
		booking.setDepositpaid(depostPaid);
		booking.setCheckin(checkIn);
		booking.setCheckout(checkOut);
		booking.setAdditionalneeds(additionalNeeds);
		return booking;
	}
}
