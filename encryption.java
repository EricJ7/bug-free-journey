import java.util.Scanner;
import java.util.Arrays;

public class test1 {

    //Eric 2020/08/04
    //Encrypts a binary string using a one-time pad (symmetrical encryption)
    
    //converts randomKeyStr to int array
    public static int[] randomKeyArr(String randomkey){

        int[] randomKeyArr = new int[randomkey.length()];

        for(int i = 0; i < randomkey.length(); i++){

            randomKeyArr[i] = randomkey.charAt(i) - '0';        
        }

        return randomKeyArr;

    }

    //converts plaintext str to int array
    public static int[] plaintextArr(String plaintext){

        int[] plaintextArr = new int[plaintext.length()];

        for(int i = 0; i < plaintext.length(); i++){

            plaintextArr[i] = plaintext.charAt(i) - '0';
        }

        return plaintextArr;

    }

    //generates and returns random bit string of length n
    public static String randomKeyGeneration(int length){

        String randomKey = "";

        for(int i = 0; i < length; i++){

            randomKey += (int)Math.round(Math.random());
        }

        return randomKey;

    }

    public static int[] cipherText(int[] randomkeyArr, int[] plaintextArr, int length){

        int[] ciphertextArr = new int[length];

        //XOR 
        for(int i = 0; i < length; i++){

            ciphertextArr[i] = (int)Math.pow((randomkeyArr[i] - plaintextArr[i]), 2);
        }

        return ciphertextArr;

    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the bit string you would like to encrypt");
        String plaintextStr = input.next();

        System.out.print("\nPlaintext: " + plaintextStr + " | Plaintext length: " + plaintextStr.length() + " (bits)\n");

        int plaintextLen = plaintextStr.length();
        String randomKeyStr = randomKeyGeneration(plaintextLen);
                         
        System.out.println("Random key of length " + randomKeyStr.length() + ": " + randomKeyStr + "\n" );
        int[] randomkeyArr = randomKeyArr(randomKeyStr);
        int[] plaintextArr = plaintextArr(plaintextStr);

        int[] ciphertextArr = cipherText(randomkeyArr, plaintextArr, plaintextLen);

        System.out.print("Key Array; ");
        for(int j = 0; j < randomkeyArr.length; j++){
            
            System.out.print(randomkeyArr[j]);
        }


        System.out.print("\nPlaintext Array; ");
        for(int k = 0; k < plaintextArr.length; k++){
            
            System.out.print(plaintextArr[k]);
        }


        System.out.print("\nCiphertext: ");
        for(int i = 0; i < plaintextLen; i++){

            System.out.print(ciphertextArr[i]);
        }


        System.out.println("\n\nP" + "\t" + "K" + "\t" + "C");
        System.out.println("-----------------");
        for(int h = 0; h < randomkeyArr.length; h++){
            
            System.out.println(plaintextArr[h] + "\t" + randomkeyArr[h] + "\t" + ciphertextArr[h]);
        } System.out.print("\n");

    }


}
