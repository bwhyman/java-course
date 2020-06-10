package com.experiment07.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class TrainOutlet {
    private String name;
    private List<Ticket> tickets = new LinkedList<>();
    private static Random random = new Random();

    public Ticket sell() {
        Ticket ticket = TrainDepartment.getTicket();
        if (ticket != null) {
            try {
                Thread.sleep(random.nextInt(50));
                tickets.add(ticket);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ticket;
    }

    public int getCount() {
        return tickets.size();
    }
}
