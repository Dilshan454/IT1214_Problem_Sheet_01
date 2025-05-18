class Student{
    private int studentId;
    private String name;
    private int daysAttended;

    Student(int studentId,String name,int daysAttended){
        this.studentId=studentId;
        this.name=name;
        this.daysAttended=daysAttended;
    }

    public int getStudentId(){
        return studentId;
    }
    public String getName(){
		return name;
    }
     public int getDaysAttended(){
        return daysAttended;
    }

    public void setStudentId(int studentId){
        this.studentId=studentId;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDaysAttended(int daysAttended) { 
        this.daysAttended = daysAttended;
    }

    public String toString(){
        return "ID: "+studentId+", Name: "+name+", "+daysAttended;
    }
}

class Classroom{
    Student[] students=new Student[10];
    int studentCount=0;

    public void addStudent(Student student){
        if(studentCount<10){
            students[studentCount++]=student;
        }
    }

    public void updateAttendance(int id, int newDays) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == id) {
                students[i].setDaysAttended(newDays);
                return;
            }
        }
        System.out.println("Student ID "+id+" not found.");
    }

    public void displayStudents() {
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        classroom.addStudent(new Student(101, "Saman", 12));
        classroom.addStudent(new Student(102, "Bob", 15));
        classroom.addStudent(new Student(103, "Nimal", 10));

        classroom.updateAttendance(102, 16); 
        classroom.updateAttendance(104, 12); 

        classroom.displayStudents();
    }
}
