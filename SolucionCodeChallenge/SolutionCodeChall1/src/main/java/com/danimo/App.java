package com.danimo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        String in1= "amor";
        String in2 = "roma";

        Boolean result = isAnagram(in1, in2);

        System.out.println(result);

    }

    public static  boolean isAnagram(String word1, String word2){ // Complejidad O(n'2), 
        boolean response = true;


        if( word1.length() == word2.length()){
            char[] array1 = word1.toCharArray();
            char[] array2 = word2.toCharArray();

            for(int a = 0; a < word1.length(); a++){
                int repeatChar = 0;
                int repeatChar2 = 0;
                for(int b=0; b < word1.length(); b++){
                    
                    if(array1[a] == array1[b]){
                        repeatChar2++;
                    }
                }

                for(int b=0; b < word2.length(); b++){
                    
                    if(array1[a] == array2[b]){
                        repeatChar++;
                    }
                }

                if(repeatChar != repeatChar2){
                    return false;
                }

            }
        }else{
            return false;
        }
        
        return response;
    }
}
