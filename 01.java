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
    public void setAttended(int daysAttended) { 
        this.daysAttended = daysAttended;
    }
}

class Classroom{
    Student[] students=new Student[10];
    int studentcount=0;

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
}

class AttendanceSystem {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        classroom.addStudent(new Student(101, "Alice Smith", 12));


        classroom.displayStudents();
    }
}