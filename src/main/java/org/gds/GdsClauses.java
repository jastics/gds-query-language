package org.gds;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An essense, which is used to simplify all operations with raw query.
 * @since 4/23/16
 * @author ivanursul
 */
public class GdsClauses {

    private final String query;
    private final Matcher matcher;

    /**
     * Overloaded constuctor, which asks only for query, then
     * the default constructor is used.
     * @param gdsQuery Google Data Source query.
     */
    public GdsClauses(String gdsQuery) {
        this(
                gdsQuery,
                Pattern.compile("^select\\s(((?!(\\sorder\\sby\\s|\\swhere\\s)).)*)(\\swhere\\s(((?!order by).)*))?(\\sorder by\\s(.*))?$").matcher(gdsQuery)
        );
    }

    public GdsClauses(String gdsQuery, Matcher matcher) {
        this.query = gdsQuery;
        this.matcher = matcher;

        if (!matcher.matches()) {
            // todo: replace with good exception
            throw new RuntimeException(String.format("Invalid query: %s", query));
        }
    }

    public List<String> clauses() {
        return Arrays.asList(matcher.group(1), matcher.group(5), matcher.group(8));
    }
}
