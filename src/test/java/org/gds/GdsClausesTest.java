package org.gds;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GdsClausesTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testClauses() throws Exception {
        // Given
        String gdsQuery = "select col1,col2 where col1=1 order by col1,col3";
        List<String> expected = Arrays.asList("col1,col2", "col1=1", "col1,col3");

        // When
        GdsClauses unit = new GdsClauses(gdsQuery);
        List<String> actual = unit.clauses();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void testClausesWithComplicated() throws Exception {
        // Given
        String gdsQuery = "select " +
                "col1,col2, sum(col3), sum(col4) " +
                "where (col1=1 and (col3=43 and col23='value' or col67=4)) " +
                "order by col1,col3";
        List<String> expected = Arrays.asList(
                "col1,col2, sum(col3), sum(col4)",
                "(col1=1 and (col3=43 and col23='value' or col67=4))",
                "col1,col3"
        );

        // When
        GdsClauses unit = new GdsClauses(gdsQuery);
        List<String> actual = unit.clauses();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void testClausesWithInvalidQuery() throws Exception {
        // Given
        String gdsQuery = "selesssct col1,col2 where col1=1 order by col1,col3";
        List<String> expected = Arrays.asList("col1,col2", "col1=1", "col1,col3");

        // When
        exception.expect(RuntimeException.class);
        exception.expectMessage("Invalid query: selesssct col1,col2 where col1=1 order by col1,col3");

        GdsClauses unit = new GdsClauses(gdsQuery);
        List<String> actual = unit.clauses();

        // Then
        assertEquals(expected, actual);
    }
}