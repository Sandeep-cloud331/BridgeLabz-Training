public class NullPointerExceptionDemo {
    static void generateStringException(){
        String str=null;
        int len=str.length();
        System.out.println(len);
    }
    public static void main(String[] args) {
        try {
            generateStringException();
        }catch(NullPointerException e){
            System.out.println("NullPointerException: "+e.getMessage());
        }
    }
}
