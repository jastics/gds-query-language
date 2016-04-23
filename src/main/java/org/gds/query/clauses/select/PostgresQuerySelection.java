package org.gds.query.clauses.select;

import org.gds.query.column.Column;
import org.gds.query.column.SimpleColumn;

import java.util.List;

/**
 * @since 4/23/16
 */
public class PostgresQuerySelection implements QuerySelection {

    private final String rawColumns;

    public PostgresQuerySelection(String rawColumns) {
        this.rawColumns = rawColumns;
    }

    @Override
    public boolean aggregated() {
        return false;
    }

    @Override
    public List<SimpleColumn> simpleColumns() {
        return null;
    }

    @Override
    public List<Column> columns() {
        return null;
    }

    @Override
    public String result() {
        return null;
    }
}
