package edu.ufp.inf.aed2.NoWarPolisTests;

import edu.ufp.inf.aed2.NoWarPolis.MapDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDatabaseTest {

    MapDatabase db;
    testData t = new testData();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        db = t.db1();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void test(){
        
    }

}