package com.valery.homework3.PartTwo;

import java.util.Calendar;
import java.util.Date;

public class User {
    private final long id;
    private final String name;
    private final int age;
    private final Type type;

    public User(long id, String name, int age, Type type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
    }

    Date getStartTime() {
        return Calendar.getInstance().getTime();
    }

    Type getType() {
        return type;
    }

    String getName() {
        return name;
    }

    public void checkAge() throws Exception {
        if (age < 18)
            throw new Exception("User is under 18");
        else
            System.out.println("User is over 18 y.o.");
    }
}
