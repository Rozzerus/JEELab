package com.rozzer.model;

public enum Gener {
    BIOGRAPHICAL("biographical","биографический"),
    MILITANT	("militant", 	"боевик"),
    WESTERN		("Western", 	"вестерн"),
    MILITARY	("military", 	"военный"),
    DETECTIVE	("detective", 	"детектив"),
    CHILD		("child", 		"детский"),
    DOCUMENTARY	("documentary", "документальный"),
    DRAMA		("drama", 		"драма"),
    HISTORICAL	("historical", 	"исторический"),
    COMEDY		("comedy", 		"комедия"),
    SHORT		("short", 		"короткометражный"),
    KRIMINAL	("kriminal", 	"криминал"),
    MELODRAMA	("melodrama", 	"мелодрама"),
    MYSTICISM	("mysticism", 	"мистика"),
    CARTOON		("cartoon", 	"мультфильм"),
    MUSICAL		("musical", 	"мюзикл"),
    SCIENTIFIC	("scientific", 	"научный"),
    ADVENTURES	("adventures", 	"приключения"),
    FAMILY		("family", 		"семейный"),
    SPORT		("sport", 		"спорт"),
    THRILLER	("thriller", 	"триллер"),
    HORRORS		("horrors", 	"ужасы"),
    FICTION		("fiction", 	"фантастика"),
    FILM_NOIR	("film Noir", 	"фильм-нуар"),
    FANTASY		("fantasy", 	"фэнтези");

    private String ru;
    private String eng;
    private Gener(String ru, String eng){this.ru = ru; this.eng = eng;}

    public String ru() {
        return ru;
    }

    public String eng() {
        return eng;
    }
}
