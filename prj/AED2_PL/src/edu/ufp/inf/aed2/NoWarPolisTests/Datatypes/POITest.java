package edu.ufp.inf.aed2.NoWarPolisTests.Datatypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class POITest {

    POI d1,d2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        long id = 1;
        d1 = new POI("POI1",new Tag(id++),"type",new Node("way",new Tag(id++)));
        d1.getLogs().put(Timestamp.from(Instant.now()),new Log("log1 ".repeat(100)));
        d1.getLogs().put(Timestamp.from(Instant.now()),new Log("log2 ".repeat(100)));

        d1.getSupportedVehicles().add(new Vehicle("vehicle1"));
        d1.getSupportedVehicles().add(new Vehicle("vehicle2"));
        d1.getSupportedVehicles().add(new Vehicle("vehicle3"));

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void test_01_basic() throws CloneNotSupportedException {
        assertEquals(d1.getType(), "type");
        Assertions.assertEquals(d1.getLogs().size(), 0);
    }

    @Test
    public void test_02_json() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String output = m.writeValueAsString(d1);
        assertNotNull(output);

        System.out.println(d1.getClass().toString() + " -> " + output);
    }
}