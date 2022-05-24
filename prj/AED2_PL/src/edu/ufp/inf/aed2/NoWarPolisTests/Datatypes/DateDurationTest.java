package edu.ufp.inf.aed2.NoWarPolisTests.Datatypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.DateDuration;
import org.junit.jupiter.api.Test;


import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class DateDurationTest {

    DateDuration d1,d2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Date tmp = new Date(2021,02,03);
        d1 = new DateDuration(
                new Timestamp(tmp.getTime())
            ,50);

        d2 = new DateDuration(50);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void test_01_basic(){
        assertEquals(d1.getDurantion_s() == d2.getDurantion_s(),true);
    }

    @Test
    public void test_02_json() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String output = m.writeValueAsString(d1);
        assertNotNull(output);
        System.out.println(d1.getClass().toString() + " -> " + output);
    }
}