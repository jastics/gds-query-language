package org.gds;

import org.gds.query.clauses.orderby.EmptyQuerySort;
import org.gds.query.clauses.orderby.QuerySort;
import org.gds.query.clauses.select.DefaultQuerySelection;
import org.gds.query.clauses.select.QuerySelection;
import org.gds.query.clauses.where.EmptyQueryFilter;
import org.gds.query.clauses.where.QueryFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An essense, which is used to simplify all operations with raw query.
 * @since 4/23/16
 * @author ivanursul
 */
public class GdsRegexPostgresString {

    private final Matcher matcher;

    /**
     * Overloaded constuctor, which asks only for query, then
     * the default constructor is used.
     * @param gdsQuery Google Data Source query.
     */
    public GdsRegexPostgresString(String gdsQuery) {
        this(
                Pattern.compile("^select\\s(((?!(\\sorder\\sby\\s|\\swhere\\s)).)*)(\\swhere\\s(((?!order by).)*))?(\\sorder by\\s(.*))?$").matcher(gdsQuery)
        );
    }

    public GdsRegexPostgresString(Matcher matcher) {
        this.matcher = matcher;

        if (!matcher.matches()) {
            // todo: replace with good exception
            throw new RuntimeException("Invalid query");
        }
    }

    public QuerySort orderBy() {
        return matcher.group(5) != null ?
                null :
                new EmptyQuerySort();
    }

    public QueryFilter where() {
        return matcher.group(3) != null ?
                null :
                new EmptyQueryFilter();
    }

    public QuerySelection select() {
        if (matcher.group(1) == null) {
            // todo: create custom exception
            throw new RuntimeException("Select should be present in query");
        }

        return new DefaultQuerySelection(matcher.group(1));
    }
}
