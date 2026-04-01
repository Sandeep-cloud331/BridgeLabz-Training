public class Course{

    // Instance variable
    String courseName;
    String duration;
    int fee;

    // Constructor
    Course(String courseName, String duration, int fee){
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;

    }

    // Class variable 
    static String instituteName = "GLA University";

    // Instance method
    void displayCourseDetail(){
        System.out.println("Course : " +courseName);
        System.out.println("Institute name : " +instituteName);
        System.out.println("Duration of course : " +duration);
        System.out.println("Fees of course : " +fee);
    }

    // Class method
    static void updateInstituteName(String newName){
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course newCourse = new Course("BTech", "4 years", 1000000);
        newCourse.displayCourseDetail();
        updateInstituteName("Chandigarh University");
        System.out.println("");
        Course newCourse1 = new Course("Btech", "4 years", 13000000);
        newCourse1.displayCourseDetail();
    }
}