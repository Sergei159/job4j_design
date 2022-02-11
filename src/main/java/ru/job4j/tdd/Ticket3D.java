package ru.job4j.tdd;

import java.util.Calendar;
import java.util.Objects;

public class Ticket3D implements Ticket {

    private Account visitor;
    private int row;
    private int column;
    private Calendar date;

    public Ticket3D() {

    }

    public Ticket3D(Account visitor, int row, int column, Calendar date) {
        this.visitor = visitor;
        this.row = row;
        this.column = column;
        this.date = date;
    }

    public Account getVisitor() {
        return visitor;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Calendar getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket3D ticket3D = (Ticket3D) o;
        return row == ticket3D.row
                && column == ticket3D.column
                && Objects.equals(visitor, ticket3D.visitor)
                && Objects.equals(date, ticket3D.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitor, row, column, date);
    }
}
