package com.dmytroqa.annotations.db;

@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30) String firstName;
    @SQLString(30) String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30, constrains = @Constrains(primaryKey = true))
    String reference;
    static int memberCount;

    public String getReference() {
        return reference;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "reference='" + reference + '\'' +
                '}';
    }

    public Integer getAge() {
        return age;
    }
}
