package com.rozzer.model;

import com.rozzer.common.AbstractSaved;

import java.time.LocalDate;

/**
 *
 */
public class Film extends AbstractSaved {
    private String title;
    private Scenarist scenarist;
    private Gener gener;
    private LocalDate year;
    private String slogan;
    private String duration;

    public void save() {
        this.setName(title);
    }

    public Film() {
    }

    public Film(String title, Scenarist scenarist, Gener gener, LocalDate year, String slogan, String duration) {
        this.title = title;
        this.scenarist = scenarist;
        this.gener = gener;
        this.year = year;
        this.slogan = slogan;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Scenarist getScenarist() {
        return scenarist;
    }

    public void setScenarist(Scenarist scenarist) {
        this.scenarist = scenarist;
    }

    public Gener getGener() {
        return gener;
    }

    public void setGener(Gener gener) {
        this.gener = gener;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
