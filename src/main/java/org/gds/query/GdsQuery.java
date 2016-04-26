package org.gds.query;

import org.gds.query.raw.RawGdsRgxClauses;

public class GdsQuery {

    private final String query;

    public GdsQuery(String query) {
        this.query = query;
    }

    Query content() {
        RawGdsRgxClauses rgxClauses = new RawGdsRgxClauses(query);
        return null;
    }

}
