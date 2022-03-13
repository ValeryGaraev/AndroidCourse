package com.valery.homework3.PartTwo;

import java.util.ArrayList;
import java.util.List;

public class PartTwo {
    private final AuthCallback authCallback = new AuthCallback() {
        @Override
        public void authSuccess() {
            System.out.println("Authorization has succeeded\n");
        }

        @Override
        public void authFailed() {
            System.out.println("Authorization has failed\n");
        }
    };

    public void auth(User user, Runnable runnable) {
        try {
            user.checkAge();
            authCallback.authSuccess();
            runnable.run();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            authCallback.authFailed();
        }
    }

    void updateCache() {
        System.out.println("Cache has been updated\n");
    }

    public void doAction(Action action) {
        if (action instanceof Action.Registration) {
            System.out.println("Registration has started\n");
        } else if (action instanceof Action.Login) {
            System.out.println("Login has started\n");
            auth(((Action.Login) action).getUser(), this::updateCache);
        } else if (action instanceof Action.Logout) {
            System.out.println("Logout has started\n");
        }
    }

    public void execute() {
        User user = new User(1, "Paul", 50, Type.DEMO);

        System.out.println();
        System.out.printf("%s\n", user.getStartTime().toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s\n", user.getStartTime().toString());

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(new User(2, "John", 25, Type.FULL));
        users.add(new User(3, "Mark", 20, Type.FULL));

        List<User> usersWithFullAccess = users
                .stream()
                .filter(u -> u.getType() == Type.FULL)
                .toList();

        List<String> usersNames = users
                .stream()
                .map(User::getName)
                .toList();

        System.out.println();
        System.out.printf(
                "First name is %s, last name is %s\n",
                usersNames.get(0),
                usersNames.get(usersNames.size() - 1)
        );

        System.out.println();
        doAction(new Action.Registration());
        doAction(new Action.Login(user));
        doAction(new Action.Logout());
    }
}
