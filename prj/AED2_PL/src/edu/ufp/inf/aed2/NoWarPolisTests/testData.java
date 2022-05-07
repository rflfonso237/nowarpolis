package edu.ufp.inf.aed2.NoWarPolisTests;

import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Node;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Tag;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.User;

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

    private Node[] Node_set1(){
        Node us[] = {
                new Node("node1",newTag()),
                new Node("node1_2",newTag()),
                new Node("node1_3",newTag()),
                new Node("node2",newTag()),
                new Node("node2_1",newTag()),
                new Node("node2_2",newTag()),
                new Node("node3",newTag()),
        };

        return us;
    }

   
}
