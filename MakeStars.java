import java.util.Scanner;

public class MakeStars{
    public static void main(String[]args){
        Scanner stuff = new Scanner(System.in);
        Scanner line;
        while (stuff.hasNextLine()){
            line = new Scanner(stuff.nextLine());
            while(line.hasNext()){
                System.out.print(stars(line.next()));
            }
        }
        stuff.close();
    }
    
    private static String stars(String item){
        String a = "";
        for(int i = 0; i<item.length(); i++){
            a+='*';
        }
        return a;
    } 
}