package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket(
            "Екат",
            "Нск",
            5_600,
            8,
            10
    );

    Ticket ticket2 = new Ticket(
            "Екат",
            "Нск",
            5_000,
            10,
            13
    );

    Ticket ticket3 = new Ticket(
            "Екат",
            "Мск",
            5_000,
            10,
            12
    );


    @Test
    public void testCompareToFirstLessSecond() {
        Ticket[] tickets = {ticket1, ticket2};

        int expected = -1;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);

//        System.out.println(ticket2.compareTo(ticket1));
    }
//____________________________________________________________________________________________________________________

    @Test
    public void testSearchSortingIncreasePrices() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);

        String from = "Екат";
        String to = "Нск";

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = avia.search(from, to);
        Assertions.assertArrayEquals(expected, actual);


    }
//_____________________________________________________________________________________________________________________

    @Test
    public void testTicketTimeComparator() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket2};

        int expected = -1;
        int actual = timeComparator.compare(ticket1,ticket2);
        Assertions.assertEquals(expected, actual);

//        System.out.println(timeComparator.compare(ticket1,ticket2));
    }
//__________________________________________________________________________________________________________________

    @Test
    public void testSearchSortingFlyightTimeComparator() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);

        String from = "Екат";
        String to = "Нск";

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = avia.searchAndSortBy(from, to, timeComparator);
        Assertions.assertArrayEquals(expected, actual);


    }


}
