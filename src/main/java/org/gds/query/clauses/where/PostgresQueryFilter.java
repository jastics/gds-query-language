package org.gds.query.clauses.where;

/**
 * @since 4/23/16
 */
public class PostgresQueryFilter implements QueryFilter {

    private final String rawClauses;

    public PostgresQueryFilter(String rawClauses) {
        this.rawClauses = rawClauses;
    }
}
