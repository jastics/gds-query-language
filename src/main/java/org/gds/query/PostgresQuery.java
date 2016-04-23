package org.gds.query;

import org.gds.GdsRegexPostgresString;
import org.gds.query.clauses.groupby.GroupBy;
import org.gds.query.clauses.orderby.QuerySort;
import org.gds.query.clauses.select.QuerySelection;
import org.gds.query.clauses.where.QueryFilter;

/**
 * @since 4/23/16
 */
public class PostgresQuery implements Query {

    private final QuerySelection select;

    private final QueryFilter where;

    private final QuerySort orderBy;

    public PostgresQuery(GdsRegexPostgresString rgxString) {
        this(rgxString.select(), rgxString.where(), rgxString.orderBy());
    }

    public PostgresQuery(QuerySelection select, QueryFilter where, QuerySort orderBy) {
        this.select = select;
        this.where = where;
        this.orderBy = orderBy;
    }

    @Override
    public QuerySelection select() {
        return select;
    }

    @Override
    public QueryFilter where() {
        return where;
    }

    @Override
    public QuerySort orderBy() {
        return orderBy;
    }

    @Override
    public GroupBy groupBy() {
        // todo: it should be generated from select
        return null;
    }

}
