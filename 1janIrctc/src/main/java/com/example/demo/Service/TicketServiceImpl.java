package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Ticket;
import com.example.demo.Repository.TicketRepo;
@Service
public class TicketServiceImpl implements TicketService{
@Autowired
TicketRepo ticketRepo;
	@Override
	public int saveicket(Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket t = ticketRepo.save(ticket);
		return t.getId();	}

	@Override
	public Ticket getTicket(int tId) {
		
		return ticketRepo.findById(tId).get();
	}

}
