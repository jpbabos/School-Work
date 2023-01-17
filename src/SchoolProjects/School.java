package SchoolProjects;

import java.util.*;
public class School {
    public static class classes {
        Scanner s = new Scanner(System.in);
        int gradeLevel;
        String[] grade9Classes = {"PE", "Algebra", "Biology", "Elective 1", "English 9", "Foreign Language 1"};
        String[] grade10Classes = {"PE", "Geometry", "English 10", "Foreign Language 2", "Modern Civilization", "Physics"};
        String[] grade11Classes = {"Trigonometry", "U.S. History", "English 11", "Elective 2", "Elective 3", "Anatomy"};
        String[] grade12Classes = {"English 12", "Calculus", "Economics", "Health", "Elective 4"};
        int grade9Index = 0;
        int grade10Index = 0;
        int grade11Index = 0;
        int grade12Index = 0;
        String student;
        classes() {
            student = "Jessica";
        }
        classes(String student) {
            this.student = student;
        }

        void menu () {
            System.out.println("What grade level are you in? (9-12)");
            System.out.println("   1. Grade 9");
            System.out.println("   2. Grade 10");
            System.out.println("   3. Grade 11");
            System.out.println("   4. Grade 12");
            System.out.println("   5. Finished the school year");
            gradeLevel = s.nextInt();
            if (gradeLevel == 1) {
                int l = grade9Classes.length;
                if (grade9Index >= l) grade9Index = 0;
                System.out.println("To complete 9th grade, you need to take " + grade9Classes[grade9Index]);
                grade9Index++;
                System.out.println("Did you complete this class? y or n");
                char yesNo = s.next().charAt(0);
                if (yesNo == 'y') gradeLevel = 5;
            } else if (gradeLevel == 2) {
                int l = grade10Classes.length;
                if (grade10Index >= l) grade10Index = 0;
                System.out.println("To complete 10th grade, you need to take " + grade10Classes[grade10Index]);
                grade10Index++;
                System.out.println("Did you complete this class? y or n");
                char yesNo = s.next().charAt(0);
                if (yesNo == 'y') gradeLevel = 5;
            }else if (gradeLevel == 3) {
                int l = grade11Classes.length;
                if (grade11Index >= l) grade11Index = 0;
                System.out.println("To complete 11th grade, you need to take " + grade11Classes[grade11Index]);
                grade11Index++;
                System.out.println("Did you complete this class? y or n");
                char yesNo = s.next().charAt(0);
                if (yesNo == 'y') gradeLevel = 5;
            } else if (gradeLevel == 4) {
                int l = grade12Classes.length;
                if (grade12Index >= l) grade12Index = 0;
                System.out.println("To complete 12th grade, you need to take " + grade12Classes[grade12Index]);
                grade12Index++;
                System.out.println("Did you complete this class? y or n");
                char yesNo = s.next().charAt(0);
                if (yesNo == 'y') gradeLevel = 5;
            }
        }
        int getGradeLevel() {
            return gradeLevel;
        }
        String getStudent() {
            return student;
        }
    }

    public static void main(String[] args) {
        classes student1 = new classes();
        classes student2 = new classes("Sam");
        System.out.println("Let's help " + student1.getStudent() + " finish the school year");
        while (student1.getGradeLevel() != 5) {
            student1.menu();
        }
        System.out.println("Congratulations " + student1.student + ", you have finished the school year!!");
        System.out.println(" ");
        System.out.println("Now, let's help " + student2.student + " finish the school year");
        while (student2.getGradeLevel() != 5) {
            student2.menu();
        }
        System.out.println("Congratulations " + student2.student + ", you have finished the school year!!");
    }
}