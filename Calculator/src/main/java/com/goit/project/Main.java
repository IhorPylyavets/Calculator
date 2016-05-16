package com.goit.project;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(1111);

        get("/hello", (req, res) -> "Hello World");
    }
}
