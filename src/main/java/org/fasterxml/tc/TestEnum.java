

package org.fasterxml.tc;

/**
 * Example enum
 */
public enum TestEnum {

    value1("comment1");

    private final String comment;

    private TestEnum(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public static TestEnum lookupByComment(String code) {
        if ("comment1".equals(code)) {
            return value1;
        } else {
            throw new IllegalArgumentException("Invalid");
        }
    }
}
