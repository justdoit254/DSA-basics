package com.basics.Stack;

import java.util.*;

/*class Student implements Comparable<Student> {
    int id;
    String name;
    float grade;
    Student(int id, String name, float grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    public int compareTo(Student st) {
        if (grade==st.grade) return 0;
        else if (grade<st.grade) return 1;
        else return -1;
    }

}*/
class Student {
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }
}

public class JavaSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> stu = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();
            Student st = new Student(id, name, cgpa);
            stu.add(st);
        }
        Collections.sort(stu, Comparator.comparing(Student :: getCgpa).reversed().thenComparing(Student :: getName).thenComparing(Student :: getId));
        for (Student st : stu) {
            System.out.println(st.getName());
        }
        /*ArrayList<Student> stu = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stu.add(new Student(sc.nextInt(),sc.next(), sc.nextFloat()));
        }
        Collections.sort(stu);
        for (Student st : stu) {
            System.out.println(st.name);
        }*/
    }


}
