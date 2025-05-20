class Student{

    //Design a Student class with the private fields
    private int studentId;
    private String name;
    private int daysAttended;

    //constructor to initialize all fields
    Student(int studentId,String name,int daysAttended){
        this.studentId=studentId;
        this.name=name;
        this.daysAttended=daysAttended;
    }

    //getter methods for all fields
    int getStudentId(){
        return studentId;
    }
    String getName(){
        return name;
    }
    int getDaysAttended(){
        return daysAttended;
    }

    //setter methods for all fields
    void setStudentId(int studentId){
        this.studentId=studentId;
    }
    void setName(String name) {
        this.name = name;
    }
    void setDaysAttended(int daysAttended) {
        this.daysAttended = daysAttended;
    }
}

//classroom class
class Classroom{
    //student array
    Student[] students=new Student[10];
    int studentCount=0;

    void addStudent(Student student){
        if(studentCount</*10*/students.length){
            students[studentCount] = student;
            studentCount++;
        }
         else {
            System.out.println("Classroom is full. Cannot add more students.");
        }
    }

    void updateAttendance(int id,int daysUpdate){
        for(int i=0;i<studentCount;i++){
            if(students[i].getStudentId()==id){
                students[i].setDaysAttended(daysUpdate);
                return;
            }
        }
        System.out.println("Student ID "+id+" not found.");
    }

     //display students
    public void displayAllStudents() {
        for (int i = 0; i < studentCount; i++) {
             System.out.println("Student ID: " + students[i].getStudentId());
             System.out.println("Name: " + students[i].getName());
             System.out.println("Days Attended: " + students[i].getDaysAttended());
             System.out.println("----------------------------");
         }
    }
    
}

public class StudentAttend{
    public static void main(String[] args){
        //student object
        /*Student student=new Student(101,"Alice smith",12);

        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Days Attended: " + student.getDaysAttended());*/

        // Create classroom
        Classroom classroom = new Classroom();

        // Add 3 students
        /*Student s1 = new Student(101, "Alice Smith", 12);
        Student s2 = new Student(102, "Bob Jones", 15);
        Student s3 = new Student(103, "Carol Lee", 10);*/


        classroom.addStudent(new Student(101, "Alice Smith", 12));
        classroom.addStudent(new Student(102, "Bob Jones", 15));
        classroom.addStudent(new Student(103, "Carol Lee", 10));

        classroom.updateAttendance(102, 16);

        classroom.updateAttendance(104, 8);


        classroom.displayAllStudents();
    }
}
