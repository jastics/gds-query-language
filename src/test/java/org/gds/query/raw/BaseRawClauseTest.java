package org.gds.query.raw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BaseRawClauseTest {

    @Test
    public void testEmpty() throws Exception {
        // Given
        // When
        RawClause unit = new BaseRawClause(null);
        boolean actual = unit.empty();

        // Then
        assertEquals(true, actual);
    }

    @Test
    public void testEmptyWithContent() throws Exception {
        // Given
        // When
        RawClause unit = new BaseRawClause("col1, col2");
        boolean actual = unit.empty();

        // Then
        assertEquals(false, actual);
    }
}