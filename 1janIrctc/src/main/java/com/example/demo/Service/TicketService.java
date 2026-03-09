package com.example.demo.Service;

import com.example.demo.Entity.Ticket;

public interface TicketService {
	int saveicket(Ticket ticket);
	Ticket getTicket(int tId);
	
}
