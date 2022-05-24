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

class TagTest {

    Tag d1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        long id = 1;
        d1 = new Tag(id);

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void test_01_basic() throws CloneNotSupportedException {
        assertEquals(d1.getId(), 1);
    }


}