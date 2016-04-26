package org.gds.query.raw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An essense, which is used to simplify all operations with raw query.
 * @since 4/23/16
 * @author ivanursul
 */
public class RawGdsRgxClauses {

    private final String query;
    private final Matcher matcher;

    /**
     * Overloaded constuctor, which asks only for query, then
     * the default constructor is used.
     * @param gdsQuery Google Data Source query.
     */
    public RawGdsRgxClauses(String gdsQuery) {
        this(
                gdsQuery,
                Pattern.compile("^select\\s(((?!(\\sorder\\sby\\s|\\swhere\\s)).)*)(\\swhere\\s(((?!order by).)*))?(\\sorder by\\s(.*))?$").matcher(gdsQuery)
        );
    }

    public RawGdsRgxClauses(String gdsQuery, Matcher matcher) {
        this.query = gdsQuery;
        this.matcher = matcher;

        if (!matcher.matches()) {
            // todo: replace with good exception
            throw new RuntimeException(String.format("Invalid query: %s", query));
        }
    }

    public RawClause select() {
        return new BaseRawClause(matcher.group(1));
    }

    public RawClause where() {
        return new BaseRawClause(matcher.group(5));
    }

    public RawClause orderBy() {
        return new BaseRawClause(matcher.group(8));
    }
}
