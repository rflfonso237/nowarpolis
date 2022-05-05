package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public class Log {

    private Timestamp d;
    private String log;

    public Log(String log){
        this.d = Timestamp.from(Instant.now());
        this.log = log;
    }

    public Timestamp getD() {
        return d;
    }

    public String getLog() {
        return log;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log1 = (Log) o;
        return Objects.equals(d, log1.d) && Objects.equals(log, log1.log);
    }

    @Override
    public int hashCode() {
        return Objects.hash(d, log);
    }

    @Override
    public String toString() {
        return "Log{" +
                "d=" + d +
                ", log='" + log + '\'' +
                '}';
    }
}
