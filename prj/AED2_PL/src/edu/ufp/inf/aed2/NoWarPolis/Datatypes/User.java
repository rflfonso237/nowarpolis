package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import java.util.HashMap;
import java.util.Objects;

public class User extends MapSymbol{

    private String profile;
    private HashMap<DateDuration, POI> historyVisits;

    public User(String name, Tag t, String profile){
        super(name, t);
        this.profile = profile;
        this.historyVisits = new HashMap<DateDuration, POI>();
    }

    public void addVisit(POI p, float duration_sec){
        DateDuration dd = new DateDuration((duration_sec));
        this.historyVisits.put(dd,p);
    }

    public String getProfile() {
        return profile;
    }

    public HashMap<DateDuration, POI> getHistoryVisits() {
        return historyVisits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(profile, user.profile) && Objects.equals(historyVisits, user.historyVisits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), profile, historyVisits);
    }

    @Override
    public String toString() {
        return "User{" +
                "profile='" + profile + '\'' +
                ", historyVisits=" + historyVisits +
                '}';
    }
}
