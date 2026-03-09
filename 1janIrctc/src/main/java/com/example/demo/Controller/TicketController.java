package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Client.NotificationClient;
import com.example.demo.Entity.Ticket;
import com.example.demo.Service.TicketService;

@RestController
public class TicketController {
	@Autowired
	TicketService ticketService;
	@Autowired
	NotificationClient notificationClient;
	@PostMapping("ticket")
public ResponseEntity<String> addTicket(@RequestBody Ticket ticket){
		int tId = ticketService.saveicket(ticket);
		ResponseEntity<String> res = notificationClient.sendNotification("Hi Ure Ticket is Booked","nikita@gmail.com");
		System.out.println(res);
		return new ResponseEntity("ticket is saved " + tId,HttpStatus.CREATED);
	}
	
	@GetMapping("ticket/{tId}")
	public ResponseEntity<Ticket> getTicket(@PathVariable int tId){
		return new ResponseEntity(ticketService.getTicket(tId),HttpStatus.OK);
	}
}
