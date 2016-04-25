package org.gds.query.clauses.select;

import org.gds.query.column.Column;
import org.gds.query.column.SimpleColumn;

import java.util.List;

/**
 * Created by ivanursul on 4/25/16.
 */
public class DefaultQuerySelection implements QuerySelection {


    public DefaultQuerySelection(String rawSelect) {

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
