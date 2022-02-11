package ru.job4j.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

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
}