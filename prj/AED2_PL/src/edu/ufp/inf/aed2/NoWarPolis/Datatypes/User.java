package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import java.util.*;

public class User extends MapSymbol{

    private String profile;
    private HashMap<DateDuration, POI> historyVisits;

    public User(String name, Tag t, String profile){
        super(name, t);
        this.profile = profile;
        this.historyVisits = new HashMap<DateDuration, POI>();
    }
    public User(User u, Date init, Date end){
        super(u.getName(), u.getTag());
        this.profile = u.getProfile();
        this.historyVisits = new HashMap<DateDuration, POI>();

        //Filter per dates
        for(DateDuration dd: this.historyVisits.keySet()){
            if(dd.isDateDurationBetween(init,end) == true){
                this.historyVisits.put(dd,this.historyVisits.get(dd));
            }
        }

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


    public static ArrayList<User> getAllUsersWithVisitsWithinRange(ArrayList<User> all,Date init, Date end){
        ArrayList<User> ret = new ArrayList<User>();
        for(User u: all){
            User filtered = new User(u,init,end);
            if(filtered.getHistoryVisits().size() > 0){
                ret.add(filtered);
            }
        }

        Collections.sort(ret,sortUserBynVisits);

        return ret;
    }

    private static Comparator<User>  sortUserBynVisits = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return o1.historyVisits.size() - o2.historyVisits.size();
        }
    };

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
