package org.gds.query.clauses.orderby;

/**
 * @since 4/23/16
 */
public class PostgresQuerySort implements QuerySort {

    private final String rawOrderByCols;

    public PostgresQuerySort(String rawOrderByCols) {
        this.rawOrderByCols = rawOrderByCols;
    }
}
