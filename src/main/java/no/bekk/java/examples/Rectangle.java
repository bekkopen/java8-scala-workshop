package no.bekk.java.examples;

interface Rectangle {
    Integer width();
    Integer height();
    default Integer surface() { return width() * height();}
}
