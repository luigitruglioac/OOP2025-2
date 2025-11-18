package studentGpa;

public class StudentTester {
    public static void main (String[] args ){

        Student s1 = new Student("Luigi" , "2024-1" , new double[]{10.0, 9.2, 7.0});
        System.out.printf(" Name: %s | GPA: %.2f%n" , s1.getName() , s1.getGpa());

        Student s2 = new Student("Albiere" , "2024-2" , new double[]{10.0, 10.0, 7.0});
        System.out.printf(" Name: %s | GPA: %.2f%n" , s2.getName(), s2.getGpa());

        Student s3 = new Student("Felipe" , "2024-3" , new double[]{9.0, 9.8, 6.0});
        System.out.printf(" Name: %s | GPA: %.2f%n" , s3.getName() , s3.getGpa());
    }
}