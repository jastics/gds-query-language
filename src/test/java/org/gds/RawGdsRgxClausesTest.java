package org.gds;

import org.gds.query.raw.BaseRawClause;
import org.gds.query.raw.RawClause;
import org.gds.query.raw.RawGdsRgxClauses;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RawGdsRgxClausesTest {

    @Test
    public void testClauses() throws Exception {
        // Given
        String query = "select col1, col2 where col1=1 order by col1";
        RawClause expectedSelect = new BaseRawClause("col1, col2");
        RawClause expectedWhere = new BaseRawClause("col1=1");
        RawClause expectedOrderBy = new BaseRawClause("col1");

        // When
        RawGdsRgxClauses unit = new RawGdsRgxClauses(query);
        RawClause actualSelect = unit.select();
        RawClause actualWhere = unit.where();
        RawClause actualOrderBy = unit.orderBy();

        // Then
        assertEquals(expectedSelect, actualSelect);
        assertEquals(expectedWhere, actualWhere);
        assertEquals(expectedOrderBy, actualOrderBy);
    }

    @Test
    public void testClausesV1() throws Exception {
        // Given
        String query = "select col1, col2";
        RawClause expectedSelect = new BaseRawClause("col1, col2");
        RawClause expectedWhere = new BaseRawClause();
        RawClause expectedOrderBy = new BaseRawClause();

        // When
        RawGdsRgxClauses unit = new RawGdsRgxClauses(query);
        RawClause actualSelect = unit.select();
        RawClause actualWhere = unit.where();
        RawClause actualOrderBy = unit.orderBy();

        // Then
        assertEquals(expectedSelect, actualSelect);
        assertEquals(expectedWhere.empty(), actualWhere.empty());
        assertEquals(expectedOrderBy.empty(), actualOrderBy.empty());
    }

    @Test
    public void testClausesWithOrderBy() throws Exception {
        // Given
        String query = "select col1, col2 order by col1";
        RawClause expectedSelect = new BaseRawClause("col1, col2");
        RawClause expectedWhere = new BaseRawClause();
        RawClause expectedOrderBy = new BaseRawClause("col1");

        // When
        RawGdsRgxClauses unit = new RawGdsRgxClauses(query);
        RawClause actualSelect = unit.select();
        RawClause actualWhere = unit.where();
        RawClause actualOrderBy = unit.orderBy();

        // Then
        assertEquals(expectedSelect, actualSelect);
        assertEquals(expectedOrderBy, actualOrderBy);
        assertEquals(expectedWhere.empty(), actualWhere.empty());
        assertEquals(expectedOrderBy.empty(), actualOrderBy.empty());
    }
}