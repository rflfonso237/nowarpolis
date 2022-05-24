package edu.ufp.inf.aed2.NoWarPolis.Datatypes;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class DateDuration
{

    private Timestamp t;
    private float durantion_s;

    public DateDuration(Timestamp t, float duration_s){
        this.t = t;
        this.durantion_s = duration_s;
    }

    public DateDuration(float duration_s){
        this.t = Timestamp.from(Instant.now());
        this.durantion_s = duration_s;
    }

    public boolean isDateDurationBetween(Date init, Date end){
        Date date=new Date(this.t.getTime());

        return date.compareTo(init) >= 0 && date.compareTo(end) <= 0;
    }

    public Timestamp getT() {
        return t;
    }

    public float getDurantion_s() {
        return durantion_s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateDuration that = (DateDuration) o;
        return Float.compare(that.durantion_s, durantion_s) == 0 && t.equals(that.t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, durantion_s);
    }

    @Override
    public String toString() {
        return "DateDuration{" +
                "t=" + t +
                ", durantion_s=" + durantion_s +
                '}';
    }
}
