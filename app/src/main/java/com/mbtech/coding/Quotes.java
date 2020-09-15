package com.mbtech.coding;

public class Quotes {

    private String quoteString;
    private String author;

    public Quotes(String quoteString, String author) {
        this.quoteString = quoteString;
        this.author = author;
    }

    public String getQuoteString() {
        return quoteString;
    }

    public String getAuthor() {
        return author;
    }
}
