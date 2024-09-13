package Ueb08;

import java.util.Arrays;

public class Examples {

    public static void main(String[] args) {

        // handle exceptions
        try {
            int[] numbers = new int[5];
            numbers[1] = 1;
            numbers[2] = 2;
            numbers[3] = 3;
            numbers[4] = Integer.parseInt("vier");
            numbers[5] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This index is out of bounds!");
        } catch (NumberFormatException e) {
            System.out.println("This string could not be parsed to a number!");
        }

        // multidimensional arrays
        Person studentR = new Person("Rupert", 21);
        Person studentS = new Person("Siggi", 20);
        Person studentK = new Person("Kunigunde", 20);
        Person studentL = new Person("Ludovika", 22);

        Person[] courseA = new Person[2];  // courseA -> memory address: 123
        courseA[0] = studentR;
        courseA[1] = studentS;

        Person[] courseB = new Person[]{studentK, studentL};

        Person[][] courses = new Person[2][];

        courses[0] = courseA; // courses[0] -> memory address: 123
        courses[1] = courseB;

        /*
            [   [studentR, studentS], [studentK, studentL]   ]
                          0                     1
                    0          1          0           1
        */

        // print students, iterating through arrays using indices
        System.out.println("--------------------\nPrint all students:");
        for (int i = 0; i < courses.length; i++) {
            for (int j = 0; j < courses[i].length; j++) {
                System.out.println(courses[i][j]);
            }
        }

        // print students, iterating through arrays using foreach
        System.out.println("--------------------\nPrint all students:");
        for (Person[] course : courses) {
            for (Person student : course) {
                System.out.println(student);
            }
        }

        System.out.println("--------------------\nAdd student to course");
        Person studentM = new Person("Mathilda", 19);
        // Mathilda should be added to courseA
        courseA = addStudentToCourse(studentM, courseA); // courseA -> memory address: 456, courses[0] -> memory address: 123
        // when printing all students in courses array, Mathilda does not appear
        printAllStudents(courses);
        // courseA needs to be saved in the courses array again because the variable courseA refers to a new object now
        courses[0] = courseA; // courses[0] -> memory address: 456
        printAllStudents(courses);

        System.out.println("--------------------\nChange Rupert's age");
        Person[] courseC = courseA;
        System.out.println(courseC == courseA); // true because courseC and courseA refer to the same object
        Person[] courseD = courseA.clone();
        System.out.println(courseD == courseA); // false because courseD and courseA refer to different objects
        System.out.println(Arrays.equals(courseD, courseA)); // true because this function compares the elements within the arrays

        // remember: we are dealing with object references. changing a property of a student in courseD will also affect the same student in courseA.
        courseD[0].setAge(18);
        System.out.println(courseA[0].getAge()); // 18
        System.out.println(studentR.getAge()); // 18
        System.out.println(studentR == courseA[0]); // true
        System.out.println(studentR == courseD[0]); // true
        printAllStudents(courses);
    }

    private static Person[] addStudentToCourse(Person newStudent, Person[] course){
        int newLength = course.length + 1;
        Person[] newCourse = new Person[newLength];
        newCourse[newLength - 1] = newStudent;
        for (int i = 0; i < newLength; i++) {
            if (i < newLength - 1) {
                newCourse[i] = course[i];
            }
        }
        return newCourse;
    }

    private static void increaseAgeOfAllStudents(Person[][] courses) {
        for (Person[] course : courses) {
            for (Person student : course) {
                student.setAge(student.getAge() + 1);
            }
        }
    }

    private static void printAllStudents(Person[][] courses) {
        System.out.println("Print all students:");
        for (Person[] course : courses) {
            for (Person student : course) {
                System.out.println(student);
            }
        }
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " (" + age + " Jahre alt)";
        }
    }
}
