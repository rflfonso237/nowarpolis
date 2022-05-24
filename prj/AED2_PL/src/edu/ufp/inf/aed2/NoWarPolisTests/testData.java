package edu.ufp.inf.aed2.NoWarPolisTests;

import edu.ufp.inf.aed2.NoWarPolis.Datatypes.*;
import edu.ufp.inf.aed2.NoWarPolis.MapDatabase;

public class testData {

    private long tagCounter = 0;

    public testData(){

    }
    private Tag newTag(){
        return new Tag(tagCounter++);
    }

    private User[] User_set1(){
        User us[] = {
                new User("admin1", newTag(), "Admin"),
                new User("admin2", newTag(), "Admin"),
                new User("user1", newTag(), "User"),
                new User("user2", newTag(), "User"),
                new User("user3", newTag(), "User"),
                new User("user4", newTag(), "User")
        };
        return us;
    }

    private Way[] Way_set1(){
        Way us[] = {
                new Way("way1_2",newTag()),
                new Way("way1_3",newTag()),
                new Way("way2_3",newTag()),
        };
        return us;
    }
    private Node[] Node_set1(){
        Node us[] = {
                new Node("node1",newTag()),
                new Node("node2",newTag()),
                new Node("node3",newTag()),
        };

        return us;
    }
    private void setWay(Way w, Node s, Node e){
        s.setInOutWay(w);
        e.setInOutWay(w);
        w.setNodeStart(s);
        w.setNodeEnd(e);
    }

    private void loadSymbols(MapDatabase db, MapSymbol s[]){
        for(MapSymbol k: s){
            db.insert(k);
        }
    }
    public MapDatabase db1(){
        MapDatabase r = new MapDatabase();
        Node[] n = this.Node_set1();
        Way[] w = this.Way_set1();
        User[] u = this.User_set1();

        //way 1_2
        setWay(w[0],n[0],n[1]);

        //way 1_3
        setWay(w[1],n[0],n[2]);

        //way 2_3
        setWay(w[2],n[1],n[2]);

        loadSymbols(r,n);
        loadSymbols(r,w);
        loadSymbols(r,u);

        return r;
    }
}
