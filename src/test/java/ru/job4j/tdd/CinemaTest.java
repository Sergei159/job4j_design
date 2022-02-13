package ru.job4j.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Ignore
public class CinemaTest {

    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, 02, 11, 16, 06);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D(account, 1, 1, date)));
    }

    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D("Name1"));
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D("Name1"))));
    }

    @Test
    public void whenAdd() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D("Name1"));
        cinema.add(new Session3D("Name2"));
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList((new Session3D("Name1")), (new Session3D("Name2")))));

    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, 02, 11, 16, 06);
        Ticket ticket = cinema.buy(account, 0, 1, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 02, 11, 16, 06);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPlaceIsOccupied() {
        Account account1 = new AccountCinema();
        Account account2 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date1 = Calendar.getInstance();
        date1.set(2022, 02, 11, 16, 00);
        Ticket ticket1 = cinema.buy(account1, 1, 1, date1);

        Calendar date2 = Calendar.getInstance();
        date2.set(2022, 02, 11, 18, 00);
        Ticket ticket2 = cinema.buy(account2, 1, 1, date2);
    }
}