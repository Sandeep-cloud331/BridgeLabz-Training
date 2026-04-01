public class ArrayIndexOutOfBoundDemo {
    static void generateException(){
        int[] arr={1,2,3};
        int last=arr[3];
    }
    public static void main(String[] args) {
        try{
            generateException();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundException: "+e.getMessage());
        }catch(Exception e){
            System.out.println("Generic Exception: "+e.getMessage());
        }
    }
}
