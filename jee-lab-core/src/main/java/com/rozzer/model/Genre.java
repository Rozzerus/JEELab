package com.rozzer.model;

public enum Genre {
    /**
     * I think it need to be eng version, but my QA lead give me rus version and I do it.
     */
    EPIC("epic"), FABLE("fable"), BALLAD("ballad"), MYTH("myth"), STORY("story"), NOVEL("novel"), FAIRY("fairy"),
    LIRIC("liric"), ODE("ode"), MESSAGE("message"), ELEGY("elegy"), EPIGRAM("epigram"), POEM("poem"),
    DRAMA("drama"), COMEDY("comedy"), TRAGEDY("tragedy");

    private String name;

    Genre(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
