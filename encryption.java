import java.util.Scanner;
import java.util.Arrays;

public class encryption{

    //Eric Cristante
    //2020/08/04

    //Encrypts a binary string using a one-time pad (symmetrical encryption)
    //Achieves IND-CPA security by using a DRBG of length n (plaintext length) 

    //converts randomKeyStr to int array
    public static int[] randomKeyArr(String randomkey){

        int[] randomKeyArr = new int[randomkey.length()];

        for(int i = 1; i < randomkey.length(); i++){

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
    public static String randomKeyGeneration(int plaintextLen){

        String randomKey = " ";

        //generates random bit string
        for(int i = 0; i < plaintextLen; i++){

            randomKey += (int)Math.round(Math.random());
        }

        return randomKey;

    }

    public static int[] cipherText(int[] randomkeyArr, int[] plaintextArr, int plaintextLen){

        int[] ciphertextArr = new int[plaintextLen];

        //XOR each rka value with each pta value
        for(int i = 0; i < plaintextLen; i++){

            ciphertextArr[i] = (int)Math.pow((randomkeyArr[i] - plaintextArr[i]), 2);
        }

        return ciphertextArr;

    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the bit string you would like to encrypt");
        String plaintextStr = input.next();

        System.out.print("Plaintext: " + plaintextStr + " ");
        System.out.println(" | Plaintext length: " + plaintextStr.length() + " (bits)");

        int plaintextLen = plaintextStr.length();

        String randomKeyStr = randomKeyGeneration(plaintextLen);
        System.out.println("Random key of length " + plaintextLen + ": " + randomKeyStr);

        //local variables of randomkeyarr and plaintextarr
        int[] randomkeyArr = randomKeyArr(randomKeyStr);
        int[] plaintextArr = plaintextArr(plaintextStr);

        System.out.println();

        int[] ciphertextArr = cipherText(randomkeyArr, plaintextArr, plaintextLen);

        System.out.println();
        System.out.print("Key Array; ");
        for(int j = 1; j < randomkeyArr.length; j++){
            System.out.print(randomkeyArr[j]);
        }

        System.out.println();
        System.out.print("Plaintext Array; ");
        for(int k = 0; k < plaintextArr.length; k++){
            System.out.print(plaintextArr[k]);
        }

        System.out.println();
        System.out.print("Ciphertext: ");
        for(int i = 1; i < plaintextLen; i++){

            System.out.print(ciphertextArr[i]);

        }

        System.out.println();

        System.out.println(" ");
        System.out.println("P" + "\t" + "K" + "\t" + "C");
        for(int h = 0; h < randomkeyArr.length - 1; h++){
            System.out.println(plaintextArr[h] + "\t" + randomkeyArr[h] + "\t" + ciphertextArr[h]);
        }

    }


}

