package org.gds;

import org.gds.query.clauses.select.QuerySelection;
import org.junit.Test;

public class GdsRegexPostgresStringTest {

    @Test
    public void testSelect() throws Exception {
        // Given
        String gdsQuery = "select col1,col2 where col1 = 'custom_val' and col2=1 order by 1";

        // When
        GdsRegexPostgresString unit = new GdsRegexPostgresString(gdsQuery);
        QuerySelection actual = unit.select();

        // Then

    }
}