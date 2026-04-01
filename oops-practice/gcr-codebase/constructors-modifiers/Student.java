class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Method to get CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Method to set CGPA
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

// Child class extending parent class
class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void showName() {
        System.out.println("Postgraduate Student Name: " + name);
    }

    public static void main(String[] args) {

        // Method calling
        PostgraduateStudent pg = new PostgraduateStudent(101, "Aarav", 8.7);
        pg.showName();
    }
}