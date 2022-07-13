package com.myjavacode.collectionpractice.listpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvgMaxGrade {
    static Map<String, List<Student>> subjectToStudentsMap = new HashMap();

    static {
        subjectToStudentsMap.put("Physics", Arrays.asList(
                new Student("Rahul", "Garg", 25,"Science", 40),
                new Student("Sidd", "Bhatia", 30,"Science", 50),
                new Student("Monica", "Mishra", 26, "Science", 30)
        ));
        subjectToStudentsMap.put("Chemistry", Arrays.asList(
                new Student("Rahul", "Garg", 25,"Science", 46),
                new Student("Neha", "Jain", 33,"Science", 48),
                new Student("Monica", "Mishra", 26,"Science", 46)
        ));

        subjectToStudentsMap.put("Maths", Arrays.asList(
                new Student("Vishal", "Garg", 24,"Commerce", 44),
                new Student("Abhishek", "Kakkar",22, "Commerce", 43),
                new Student("Monica", "Mishra", 26,"Science", 48)
        ));
    }

    public static void main(String[] args) {
        //We need to print the students in the descending order of their average marks across subjects.

        Map<Student, List<Double>> studentScore = new HashMap<>();

        subjectToStudentsMap.forEach(
                (key, value) -> value
                        .forEach(student -> studentScore.computeIfAbsent(student, val -> new ArrayList<>())
                                .add(student.score)));

        List<Student> s = new ArrayList<>();

        studentScore.forEach((key, val) -> {
            double sum = 0;
            for (int i = 0; i < val.size(); i++) {
                sum += val.get(i);
            }
            key.score = sum / val.size();
            s.add(key);
        });

         s.sort((s1, s2) -> Double.compare(s2.score, s1.score));
         s.forEach(s1 -> System.out.println(s1));
    }
}


class Student {
    String firstName;
    String lastName;
    double score;
    String stream;
    int age;

    public Student(String firstName, String lastName, int age, String stream, double score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
        this.age = age;
        this.stream = stream;
    }

    @Override
    public boolean equals(Object s1) {
        if (this == s1) {
            return true;
        }
        if (!(s1 instanceof Student)) {
            return false;
        }
        Student student = (Student)s1;
        return student.firstName.equals(this.firstName) &&
                student.lastName.equals(this.lastName) &&
                student.stream.equals(this.stream) &&
                student.age == this.age;
    }

    @Override
    public int hashCode() {
        return this.age;
    }

    public String toString() {
        return "Student{firstName=" + this.firstName + "," + "lastName=" + this.lastName + "," + "stream=" + this.stream + "," + "avgScore=" + this.score;
    }

}
