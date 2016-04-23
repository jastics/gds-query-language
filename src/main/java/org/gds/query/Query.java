package org.gds.query;

import org.gds.query.clauses.groupby.GroupBy;
import org.gds.query.clauses.orderby.QuerySort;
import org.gds.query.clauses.select.QuerySelection;
import org.gds.query.clauses.where.QueryFilter;

/**
 * @since 4/23/16
 */
public interface Query {

    QuerySelection select();

    QueryFilter where();

    QuerySort orderBy();

    GroupBy groupBy();

}
