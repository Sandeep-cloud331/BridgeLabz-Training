public class IllegalArgumentExceptionDemo {
    static void generateIllegalArgumentException(){
        String str="Ryuga";
        String subStr=str.substring(4,0);
    }
    public static void main(String[] args) {
        try{
            generateIllegalArgumentException();
        }catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }catch(Exception e){
            System.out.println("Generic Exception: "+e.getMessage());
        }
    }
}
