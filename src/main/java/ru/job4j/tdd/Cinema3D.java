package ru.job4j.tdd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {
    private List<Session> sessions = new ArrayList<>();

    @Override
    public List<Session> find(Predicate<Session> filter) {
        List<Session> result = new ArrayList<>();
        for (Session s : sessions) {
            if (filter.test(s)) {
               result.add(s);
            }
        }
        return result;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        Ticket ticket = new Ticket3D(
                account,
                row,
                column,
                date
        );
        return ticket;
    }

    @Override
    public void add(Session session) {
        sessions.add(session);

    }
}
