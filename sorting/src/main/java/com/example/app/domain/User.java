package com.example.app.domain;

import java.util.Objects;
import com.example.app.Comparable;

public class User implements Comparable<User> {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // lhs < rhs - lhs.compareTo(rhs) < 0
    // lhs > rhs - lhs.compareTo(rhs) > 0
    // lhs == rhs - lhs.compareTo(rhs) == 0
    @Override
    public int compareTo(User user) {
        return age - user.getAge();
    }

    @Override
    public String toString() {
        return "User" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
