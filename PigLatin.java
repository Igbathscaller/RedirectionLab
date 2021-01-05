import java.util.Scanner;

public class PigLatin {
    public static void main(String[]args){
        /*
        System.out.println(pigLatinBest("mock"));       // "ockmay"
        System.out.println(pigLatinBest("pie"));        // "iepay
        System.out.println(pigLatinBest("david"));      // "avidday"
        System.out.println(pigLatinBest("aaron"));      // "aaronhay"
        System.out.println(pigLatinBest("the"));        // "ethay"
        System.out.println(pigLatinBest("check"));      // "eckchay"
        System.out.println(pigLatinBest("skee"));       // "eeskay"
        System.out.println(pigLatinBest("emu"));        // "emuhay"
        System.out.println(pigLatinBest("grade"));      // "adegray"
        System.out.println(pigLatinBest("*emu"));       // "*emu"
        System.out.println(pigLatinBest("4chan"));      // "4chan"
        System.out.println(pigLatinBest("fish!"));      // "ishfay!"
        System.out.println(pigLatinBest("fish"));       // "ishfay"
        System.out.println(pigLatinBest("the."));       // "ethay."
        System.out.println(pigLatinBest("cat!"));       // "atcay!"
        System.out.println(pigLatinBest("amazing?"));   // "amazinghay?"	
        System.out.println(pigLatinBest("apple%"));     // "applehay%"
        */
        Scanner text = new Scanner(System.in);
        Scanner line;
        while (text.hasNextLine()){
            line = new Scanner(text.nextLine());
            while(line.hasNext()){
                System.out.print(pigLatinBest(line.next()));
                if (line.hasNext()){
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
        text.close();
    }
    
    private static char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};

    private static boolean isNotVowel(char c){
        for(int i=0;i<10;i++){
            if (c == vowels[i]){
                return false;
            }
        }
        return true;
    }

/*
Given a single word of at least 1 character:
Words that start with a,e,i,o,u  add 'hay' to the end of the word
All other words move the first letter to the end, and add 'ay' to the word.
output should be lower case to avoid issues with capitalization
pigLatinSimple("mock") → "ockmay"
pigLatinSimple("pie") → "iepay
pigLatinSimple("david") → "avidday"
pigLatinSimple("aaron") → "aaronhay"
*/
    public static String pigLatinSimple(String s){
        if (isNotVowel(s.charAt(0))){
            return (s.substring(1, s.length()) + s.charAt(0)+"ay").toLowerCase();
        }
        else{
            return (s +"hay").toLowerCase();
        }
    }
    

/*
Given a single word of at least 1 character.
Words that start with any digraph (list included for your convenience) move the first two letters to the end, and add 'ay'
Words that start with a,e,i,o,u add 'hay' to the end of the word
All other words move the first letter to the end, and add 'ay' to the word.
output should be lower case to avoid issues with capitalization
pigLatin("the") → "ethay"
pigLatin("check") → "eckchay"
pigLatin("skee") → "eeskay"
pigLatin("emu") → "emuhay"
pigLatin("grade") → "adegray"
*/

    public static String pigLatin(String s){
        if(isNotVowel(s.charAt(0))){
            
            String front = "";
            String back = "";
            int i = 0;
            for(; i < s.length()-1 && isNotVowel(s.charAt(i)); i++){
                back+=s.charAt(i);
            }

            if(i == s.length()-1 && (s.charAt(s.length()-1)=='y' || !isNotVowel(s.charAt(s.length()-1)))){
                front+=s.charAt(s.length()-1);
                i++;
            }

            for(; i < s.length(); i++){
                front += s.charAt(i);
            }
            return (front + back + "ay").toLowerCase();
        
        }
            return (s + "hay").toLowerCase();
    }

/*
Given a single word of at least 1 character, that can optionally have a punctuation mark afterwards.
Words that start with a NON letter are left alone
Otherwise: Same rules as pigLatin() except now there can optionally be punctuation marks at the end of a word.
Punctuation is any non-letter, non-number symbol after the word.
The punctuation must remain after the word after you convert to pig latin.
output should be lower case to avoid issues with capitalization
*/

    public static String pigLatinBest(String s){
        if (!Character.isLetter(s.charAt(0))){
            return s;
        }
        if(Character.isLetter(s.charAt(s.length()-1)) || Character.isDigit(s.charAt(s.length()-1))){
            return pigLatin(s);
        }
        return pigLatin(s.substring(0, s.length()-1))+s.charAt(s.length()-1);
    }
}
