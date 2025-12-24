import java.util.Scanner;

public class ShortestLongestString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] words=str.split(" ");
        String shortest=words[0];
        String longest=words[0];
        for(String word:words){
            if(word.length()>longest.length()){
                longest=word;
            }else if(word.length()<shortest.length()){
                shortest=word;
            }
        }
        System.out.println("shortest string: "+shortest+"( "+shortest.length()+" )");
        System.out.println("longest string: "+longest+"( "+longest.length()+" )");
    }
}
