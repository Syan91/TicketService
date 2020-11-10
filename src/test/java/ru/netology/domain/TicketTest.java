package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    private Ticket first = new Ticket(1, 24000, "ROV", "VKO", 110);
    private Ticket second = new Ticket(2, 18000, "ROV", "VKO", 110);
    private Ticket third = new Ticket(3, 30000, "DME", "BCN", 275);

    @Test
    public void shouldSortTicketsByPrice() {
        Ticket[] expected = new Ticket[]{second, first, third};
        Ticket[] actual = new Ticket[]{first, second, third};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }
}