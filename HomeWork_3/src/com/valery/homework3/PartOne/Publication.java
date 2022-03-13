package com.valery.homework3.PartOne;

public interface Publication {
    double getPrice();
    String getType();
    int getWordsCount();

    default void description() {
        System.out.println();
        System.out.printf("This publication's type is %s\n", getType());
        System.out.printf("This publication has %d words\n", getWordsCount());
        System.out.printf("This publication costs €%5.2f\n", getPrice());
    }
}
