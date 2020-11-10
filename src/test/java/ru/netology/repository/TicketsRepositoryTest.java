package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.exception.notFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TicketsRepositoryTest {
    private TicketsRepository repository = new TicketsRepository();
    private Ticket first = new Ticket(1, 24000, "ROV", "VKO", 110);
    private Ticket second = new Ticket(2, 18000, "ROV", "VKO", 110);
    private Ticket third = new Ticket(3, 30000, "DME", "BCN", 275);

    @BeforeEach
    public void setUp() {
        repository = new TicketsRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldFindAllTickets() {
        Ticket[] expected = new Ticket[]{first, second, third};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfExist() {
        int idToFind = 3;

        Ticket expected = third;
        Ticket actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfNotExist() {
        int idToFind = 4;
        Ticket expected = null;
        Ticket actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfExist() {
        int idToRemove = 2;

        repository.removeById(idToRemove);

        Ticket[] expected = {first, third};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfNotExist() {
        assertThrows(notFoundException.class, () -> repository.removeById(4));
    }
}