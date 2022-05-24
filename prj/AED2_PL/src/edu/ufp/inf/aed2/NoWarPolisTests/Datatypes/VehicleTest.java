package edu.ufp.inf.aed2.NoWarPolisTests.Datatypes;

import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Tag;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.User;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class VehicleTest {

    Vehicle d1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        long id = 1;
        d1 = new Vehicle("v1");

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void test_01_basic() throws CloneNotSupportedException {
        assertEquals(d1.getName(), "v1");
    }


}