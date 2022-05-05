package edu.ufp.inf.aed2.main;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.princeton.cs.algs4.*;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Log;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Tag;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.User;
import edu.ufp.inf.aed2.NoWarPolis.MapDatabase;

import java.io.File;

public class MainClass {

    /**
     * Main function
     * @param args the command line arguments
     */
    public static void main(String[] args) {


    try {
        MapDatabase m = new MapDatabase();
        User u1 = new User("user1",new Tag(1),"Admin");
        User u2 = new User("user2",new Tag(2),"Admin");

        m.insert(u1);
        m.insert(u2);

        m.save("filesave");

    }catch(Exception e){
        e.printStackTrace();
    }
    }


}
