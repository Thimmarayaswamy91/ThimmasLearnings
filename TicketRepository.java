package com.ticketManagement.ticket.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ticketManagement.ticket.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	public List<Ticket> findAllByName(String name);

	@Query(value = "select *  from ticket  where ticketType='complaint' ", nativeQuery = true)
	public Collection<Ticket> findbyticketType();
}
