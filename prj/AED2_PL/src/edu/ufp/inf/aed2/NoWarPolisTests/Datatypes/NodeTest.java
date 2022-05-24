package edu.ufp.inf.aed2.NoWarPolisTests.Datatypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Node;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.MapSymbol;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Tag;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Way;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class NodeTest {

    Node d1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        long id = 1;
        d1 = new Node("way",new Tag(id++) );
        d1.setInOutWay(new Way("way1",new Tag(id++)));
        d1.setInOutWay(new Way("way2",new Tag(id++)));
        d1.setInOutWay(new Way("way3",new Tag(id++)));
        d1.setInWay(new Way("way4",new Tag(id++)));
        d1.setOutWay(new Way("way4",new Tag(id++)));


    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void test_01_basic() throws CloneNotSupportedException {
        assertEquals(d1.getName(), "way");
        assertEquals(d1.getInOutWays().size(),3);
        assertEquals(d1.getInOnlyWays().size(),1);
        assertEquals(d1.getOutOnlyWays().size(),1);
    }

    @Test
    public void test_02_json() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String output = m.writeValueAsString(d1);
        assertNotNull(output);
        System.out.println(d1.getClass().toString() + " -> " + output);

    }

    @Test
    public void test_03_json_complex() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        HashMap<Long,Node> c = new HashMap<Long,Node>();
        c.put(d1.getTag().getId(),d1);
        String output = m.writeValueAsString(c);
        assertNotNull(output);
        System.out.println(c.getClass().toString() + " -> " + output);


    }
}