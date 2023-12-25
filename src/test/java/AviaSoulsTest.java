import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void sortFewTicket() {
        AviaSouls manager = new AviaSouls();


        Ticket ticket1 = new Ticket("Msk", "Spb", 200, 10, 12);
        Ticket ticket2 = new Ticket("Msk", "Spb", 120, 10, 12);
        Ticket ticket3 = new Ticket("Spb", "Msk", 300, 20, 22);
        Ticket ticket4 = new Ticket("Sch", "Msk", 350, 8, 11);
        Ticket ticket5 = new Ticket("Msk", "Sch", 300, 14, 17);
        Ticket ticket6 = new Ticket("Spb", "Kz", 500, 10, 22);
        Ticket ticket7 = new Ticket("Spb", "Msk", 500, 20, 22);
        Ticket ticket8 = new Ticket("Msk", "Spb", 340, 15, 17);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("Msk", "Spb");
        Ticket[] expected = {ticket2, ticket1, ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortZeroTicket() {
        AviaSouls manager = new AviaSouls();


        Ticket ticket1 = new Ticket("Msk", "Spb", 200, 10, 12);
        Ticket ticket2 = new Ticket("Msk", "Spb", 120, 10, 12);
        Ticket ticket3 = new Ticket("Spb", "Msk", 300, 20, 22);
        Ticket ticket4 = new Ticket("Sch", "Msk", 350, 8, 11);
        Ticket ticket5 = new Ticket("Msk", "Sch", 300, 14, 17);
        Ticket ticket6 = new Ticket("Spb", "Kz", 500, 10, 22);
        Ticket ticket7 = new Ticket("Spb", "Msk", 500, 20, 22);
        Ticket ticket8 = new Ticket("Msk", "Spb", 340, 15, 17);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("Msk", "La");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOneTicket() {
        AviaSouls manager = new AviaSouls();


        Ticket ticket1 = new Ticket("Msk", "Spb", 200, 10, 12);
        Ticket ticket2 = new Ticket("Msk", "Spb", 120, 6, 10);
        Ticket ticket3 = new Ticket("Spb", "Msk", 300, 20, 22);
        Ticket ticket4 = new Ticket("Sch", "Msk", 350, 8, 11);
        Ticket ticket5 = new Ticket("Msk", "Sch", 300, 14, 17);
        Ticket ticket6 = new Ticket("Spb", "Kz", 500, 10, 22);
        Ticket ticket7 = new Ticket("Spb", "Msk", 500, 20, 21);
        Ticket ticket8 = new Ticket("Msk", "Spb", 340, 15, 17);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("Spb", "Kz");
        Ticket[] expected = {ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTimeTicket() {
        AviaSouls manager = new AviaSouls();


        Ticket ticket1 = new Ticket("Msk", "Spb", 200, 10, 12);
        Ticket ticket2 = new Ticket("Msk", "Spb", 120, 6, 10);
        Ticket ticket3 = new Ticket("Spb", "Msk", 300, 20, 22);
        Ticket ticket4 = new Ticket("Sch", "Msk", 350, 8, 11);
        Ticket ticket5 = new Ticket("Msk", "Sch", 300, 14, 17);
        Ticket ticket6 = new Ticket("Spb", "Kz", 500, 10, 22);
        Ticket ticket7 = new Ticket("Spb", "Msk", 500, 20, 21);
        Ticket ticket8 = new Ticket("Msk", "Spb", 340, 15, 16);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] actual = manager.search("Msk", "Spb", comparator);
        Ticket[] expected = {ticket8, ticket1, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTimeOneTicket() {
        AviaSouls manager = new AviaSouls();


        Ticket ticket1 = new Ticket("Msk", "Spb", 200, 10, 12);
        Ticket ticket2 = new Ticket("Msk", "Spb", 120, 6, 10);
        Ticket ticket3 = new Ticket("Spb", "Msk", 300, 20, 22);
        Ticket ticket4 = new Ticket("Sch", "Msk", 350, 8, 11);
        Ticket ticket5 = new Ticket("Msk", "Sch", 300, 14, 17);
        Ticket ticket6 = new Ticket("Spb", "Kz", 500, 10, 22);
        Ticket ticket7 = new Ticket("Spb", "Msk", 500, 20, 21);
        Ticket ticket8 = new Ticket("Msk", "Spb", 340, 15, 16);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] actual = manager.search("Msk", "Sch", comparator);
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTimeZeroTicket() {
        AviaSouls manager = new AviaSouls();


        Ticket ticket1 = new Ticket("Msk", "Spb", 200, 10, 12);
        Ticket ticket2 = new Ticket("Msk", "Spb", 120, 6, 10);
        Ticket ticket3 = new Ticket("Spb", "Msk", 300, 20, 22);
        Ticket ticket4 = new Ticket("Sch", "Msk", 350, 8, 11);
        Ticket ticket5 = new Ticket("Msk", "Sch", 300, 14, 17);
        Ticket ticket6 = new Ticket("Spb", "Kz", 500, 10, 22);
        Ticket ticket7 = new Ticket("Spb", "Msk", 500, 20, 21);
        Ticket ticket8 = new Ticket("Msk", "Spb", 340, 15, 16);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] actual = manager.search("Msk", "La", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}


