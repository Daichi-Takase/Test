package com.example.demo3.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.Destination;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import static com.ninja_squad.dbsetup.Operations.*;

public class TargetSampleTest {

    private static Destination destination;
    public static final Operation DELETE_ALL = deleteAllFrom("section");
    public static final Operation CLEAR_ID = sql("ALTER TABLE section AUTO_INCREMENT = 1;");

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        destination = new DriverManagerDestination("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        Operation operation
                = sequenceOf(
                        DELETE_ALL,
                        CLEAR_ID,
                        insertInto("section")
                                .columns("name")
                                .values("General Affairs Department")
                                .values("Human Resources Division")
                                .values("Accounting Department")
                                .values("Development Department")
                                .build());
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        DbSetup dbSetup = new DbSetup(destination, DELETE_ALL);
        dbSetup.launch();
    }

    @Test
    public void getAllPeopleTest() {
        try {
            List<Section> results = TargetSample.getAllSections();
            assertNotNull(results);
            assertEquals(4, results.size());

            Section result;
            results.sort((x1, x2) -> x1.id.compareTo(x2.id));

            result = results.get(0);
            assertEquals(1L, result.id.longValue());
            assertEquals("General Affairs Department", result.name);

            result = results.get(1);
            assertEquals(2L, result.id.longValue());
            assertEquals("Human Resources Division", result.name);

            result = results.get(2);
            assertEquals(3L, result.id.longValue());
            assertEquals("Accounting Department", result.name);

            result = results.get(3);
            assertEquals(4L, result.id.longValue());
            assertEquals("Development Department", result.name);

        } catch (Exception e) {
            fail("Exception...");
            e.printStackTrace();
        }
    }
}
