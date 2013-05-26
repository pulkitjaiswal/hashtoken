package org.apache.lucene.search;

public class TermRangeLengthQuery extends MultiTermQueryTermEnumLengthFilter {

    private final int minLength;

    private final int maxLength;

    public TermRangeLengthQuery(String field, String lowerTerm, String upperTerm, boolean includeLower, boolean includeUpper, int minLength, int maxLength) {
        super(new TermRangeQuery(field, lowerTerm, upperTerm, includeLower, includeUpper), minLength, maxLength);
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public String toString(String field) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(getFilteredQuery().toString(field));
        buffer.append("{length:");
        buffer.append(minLength);
        buffer.append(" TO ");
        buffer.append(maxLength);
        buffer.append('}');
        return buffer.toString();
    }

}
