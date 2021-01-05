public class PigLatin {
    public static void main(String[]args){
        System.out.println(pigLatinSimple("hi"));
        System.out.println(pigLatinSimple("abcdefg"));
        System.out.println(pigLatinSimple("what"));
        System.out.println(pigLatinSimple("I"));
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
        String front = "";
        String back = "";
        int i = 0;
        for(; i < s.length() && isNotVowel(s.charAt(i)); i++){
            back+=s.charAt(i);
        }
        for(; i < s.length(); i++){
            front += s.charAt(i);
        }
        return front + back +"ay";
    }

/*
Given a single word of at least 1 character.
Words that start with any digraph (list included for your convenience) move the first two letters to the end, and add 'ay'
Words that start with a,e,i,o,u add 'hay' to the end of the word
All other words move the first letter to the end, and add 'ay' to the word.
output should be lower case to avoid issues with capitalization
*/

    public static String pigLatin(String s){
        return null;
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
        return null;
    }
}
