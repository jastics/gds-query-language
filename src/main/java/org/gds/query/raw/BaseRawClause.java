package org.gds.query.raw;

import java.util.Objects;

/**
 * Default implementation of StringClause interface.
 */
public class BaseRawClause implements RawClause {

    private String content;

    public BaseRawClause() {
        this(null);
    }

    public BaseRawClause(String content) {
        this.content = content;
    }

    @Override
    public String content() {
        return content;
    }

    @Override
    public boolean empty() {
        return content() == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseRawClause that = (BaseRawClause) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

}
