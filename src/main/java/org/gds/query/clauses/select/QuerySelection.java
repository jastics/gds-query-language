package org.gds.query.clauses.select;

import org.gds.query.column.Column;
import org.gds.query.column.SimpleColumn;

import java.util.List;

/**
 * @since 4/23/16
 */
public interface QuerySelection {

    /**
     * Method, which answer the question "If there any aggregated columns in the query"
     * @return boolean result, aggregated, or no.
     */
    boolean aggregated();

    /**
     * Returns simple columns, with no aggregation.
     * Mostly, this method is required for forming group by clause.
     * @return list of simple columns.
     */
    List<SimpleColumn> simpleColumns();

    /**
     * Return list of columns in select clause.
     * @return list of all columns
     */
    List<Column> columns();

    /**
     * Ready, well formed select clause
     * @return method returns ready, formatted select clause.
     */
    String result();

}
