package vn.edu.giadinh;

import java.time.LocalDateTime;

public class Person {
    static int citizenSize = 0;

    String name;
    String address;
    LocalDateTime birthday;

    Person() {
        citizenSize++;
    }

    Person(String name, String address, LocalDateTime birthday) {
        this();
        this.name = name;
        this.address = address;
        this.birthday = birthday;
    }


}
