package com.valery.homework3.PartOne;

import org.jetbrains.annotations.NotNull;

public class PartOne {
    private void buy(@NotNull Publication publication) {
        System.out.printf("The purchase is complete. The purchase amount was €%5.2f\n", publication.getPrice());
    }

    public void execute() {
        Book firstBook = new Book(50.0, 100);
        Book secondBook = new Book(100.0, 1500);
        Magazine magazine = new Magazine(30, 500);

        firstBook.description();
        secondBook.description();
        magazine.description();

        System.out.println();

        buy(firstBook);
        buy(secondBook);
        buy(magazine);

        System.out.println();

        System.out.printf("Comparing books by reference: %b\n", firstBook == secondBook);
        System.out.printf("Comparing books by value: %b\n", firstBook.equals(secondBook));

        Sum sum = (int x, int y) -> System.out.printf("Sum of %d and %d is %d\n", x, y, x + y);

        System.out.println();
        sum.calculate(22, 55);
    }
}
