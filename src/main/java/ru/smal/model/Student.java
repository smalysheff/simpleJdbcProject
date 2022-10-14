package ru.smal.model;

public class Student extends AbstractEntity{

    private String firstName;
    private String lastName;
    private int age;
    private int groupId;

    public Student() {
    }

    public Student(String firstName, String lastName, int age, int groupId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.groupId = groupId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", GroupId=" + groupId +
                ", id=" + id +
                '}';
    }
}
