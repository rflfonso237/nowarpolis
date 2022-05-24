package edu.ufp.inf.aed2.NoWarPolisTests.Datatypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.DateDuration;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.GeoInfo;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class GeoInfoTest {

    GeoInfo d1,d2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        d1 = new GeoInfo("INFO","TYPE");
        d2 = new GeoInfo(1,2);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void test_01_basic(){
        assertEquals(
                d1.getInformation(),
                "INFO");
        assertEquals(
                d1.getType(),
                "TYPE");

        assertEquals(
                d2.getInformation(),
                "coordinates");

        assertEquals(
                d2.getType(),
                "coordinates");

        assertEquals(
                d2.equals(d2.clone()),
                true);
    }

    @Test
    public void test_02_json() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String output = m.writeValueAsString(d1);
        assertNotNull(output);
        System.out.println(d1.getClass().toString() + " -> " + output);

        GeoInfo cop = m.readValue(output,GeoInfo.class);

        assertEquals(cop.equals(d1), true);
    }
}