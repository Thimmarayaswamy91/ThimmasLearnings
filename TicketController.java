package com.ticketManagement.ticket.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketManagement.ticket.model.Ticket;
import com.ticketManagement.ticket.repository.TicketRepository;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	TicketRepository ticketRepo;

	@GetMapping
	public String hello() {
		return "hello";
	}

	@GetMapping("/getAllTickets")
	public List<Ticket> getAllTickets() {
		return ticketRepo.findAll();
	}

	@GetMapping("/getAllTicketsByName/{name}")
	public List<Ticket> getAllTicketsByName(@PathVariable String name) {
		return ticketRepo.findAllByName(name);
	}

	@GetMapping("/getAllTicketsByPriorit")
	public Collection<Ticket> getAllTicketsByPriority() {
		return ticketRepo.findbyticketType();
	}

	@PostMapping("/createTicket")
	public Ticket create(@RequestBody Ticket ticket) {
		return ticketRepo.save(ticket);
	}

}
