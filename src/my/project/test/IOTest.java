package my.project.test;

import my.project.IO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class IOTest {

    private IO io = new IO();

    @BeforeEach
    void setUp() {
    }

    @Test
    void adminMenu() {
        System.out.println("the password is correct");
        String password = "test";
        Assertions.assertTrue(password.equals(io.getPASSWORD()));

    }

}