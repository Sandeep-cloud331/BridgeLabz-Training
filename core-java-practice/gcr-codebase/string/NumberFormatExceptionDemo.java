public class NumberFormatExceptionDemo {
    static void generateNumberFormatException(){
        String str="abc";
        int num=Integer.parseInt(str);
    }
    public static void main(String[] args) {
        try{
            generateNumberFormatException();
        }catch(NumberFormatException e){
            System.out.println("NumberFormatException: "+e.getMessage());
        }catch(Exception e){
            System.out.println("Generic Exception: "+e.getMessage());
        }
    }
}
