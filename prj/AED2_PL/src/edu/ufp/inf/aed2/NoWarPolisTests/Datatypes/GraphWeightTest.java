package edu.ufp.inf.aed2.NoWarPolisTests.Datatypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.princeton.cs.algs4.Graph;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.GeoInfo;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.GraphWeight;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class GraphWeightTest {

    GraphWeight d1,d2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        d1 = new GraphWeight("name",1);
        d2 = new GraphWeight("name2",2);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void test_01_basic() throws CloneNotSupportedException {
        assertEquals(
                d1.getName(),
                "name");
        assertEquals(
                d2.getName(),
                "name2");

        assertEquals(
                d1.getValue() == 1,
                true);

        assertEquals(
                d2.getValue() == 2,
                true);

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

        GraphWeight cop = m.readValue(output,GraphWeight.class);

        assertEquals(cop.equals(d1), true);
    }
}