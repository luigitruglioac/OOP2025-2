package StudentGPA;

public class Student {
    private String name;
    private String registry;
    private double[] grades;

    public Student(String name, String registry, double[] grades){
        this.name = name;
        this.registry = registry;
        this.grades = grades;
    }

    public Student(){
        this("", "", new double[]{0});
    }

    public String getName(){
        return this.name;
    }

   public String getRegistry(){
        return this.registry;
   }

    public double getGpa(){
        double gpa = 0.0;

        for(Double grades : grades){
            gpa += grades;
        }
        return gpa/grades.length;
    }
}
