package edu.ufp.inf.aed2.NoWarPolisTests.Datatypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.GraphWeight;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Log;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class LogTest {

    Log d1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        d1 = new Log("Log ".repeat(100));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void test_01_basic() throws CloneNotSupportedException {
        assertEquals(
                d1.getLog(),
                "Log ".repeat(100));
        assertEquals(
                d1.getD() != null,
                true);

        assertEquals(
                d1.equals(d1.clone()),
                true);
    }

    @Test
    public void test_02_json() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        String output = m.writeValueAsString(d1);
        assertNotNull(output);
        System.out.println(d1.getClass().toString() + " -> " + output);

        Log cop = m.readValue(output,Log.class);

        assertEquals(cop.equals(d1), true);
    }
}