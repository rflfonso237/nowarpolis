package edu.ufp.inf.aed2.NoWarPolisTests.Datatypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Node;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.MapSymbol;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class MapSymbolTest {

    MapSymbol d1,d2,d3;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        long id = 1;
        d1 = new Node("node",new Tag(id++) );
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void test_01_basic() throws CloneNotSupportedException {
        assertEquals(d1.getName(), "node");
        assertEquals(d1.getTag().getId(),1);
    }

    @Test
    public void test_02_json() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String output = m.writeValueAsString(d1);
        assertNotNull(output);
        System.out.println(d1.getClass().toString() + " -> " + output);
    }
}