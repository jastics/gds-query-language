package org.gds.query.raw;

/**
 * gds query consist of different parts(clauses).
 * It's an interface, which declares some methods for work with
 * raw string.
 */
public interface RawClause {

    /**
     * Declares content for appropriate keyword
     * @return raw
     */
    String content();

    /**
     * Is it empty ? Avoids null's constructions.
     * @return boolean value
     */
    boolean empty();

}
