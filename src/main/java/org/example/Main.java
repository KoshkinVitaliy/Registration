package org.example;
import authorization.Selector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Selector selector = new Selector();
        selector.select();
    }
}