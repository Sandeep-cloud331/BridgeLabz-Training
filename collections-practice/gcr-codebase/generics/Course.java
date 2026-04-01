abstract class Course{
    String name;

    CourseType(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}

class ExamCourse extends CourseType{
    ExamCourse(String name){
        super(name);
    }
}

class AssginmentCourse extends CourseType{
    AssginmentCourse(String name){
        super(name);
    }
}

class ResearchCourse extends CourseType{
    ResearchCourse(String name){
        super(name);
    }
}

class Course<T extends CourseType>{
    T course;

    Course(T course){
        this.course = course;
    }

    T getCourse(){
        return course;
    }

    static void listCourses(List<? extends CourseType> courses){
        for(CourseType c : courses){
            System.out.println(c);
        }
    }
}