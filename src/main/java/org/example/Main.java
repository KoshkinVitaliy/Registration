package org.example;

import authorization.Authorization;

public class Main {
    public static void main(String[] args) {
        Authorization authorization = new Authorization();
        authorization.readDatabaseFile();
    }
}