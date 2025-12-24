public class StringIndexOutOfBoundDemo {
    static void generateOutOfBoundException(){
        String str="Dead";
        int last=str.charAt(4);
    }
    public static void main(String[] args) {
        try {
            generateOutOfBoundException();
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("StringIndexOutOfBoundException: "+e.getMessage());
        }
    }
}
