package helper;

import model.Card;
import util.InputUtil;

import java.util.Random;


public class CardHelper {

    static long id=0;
    public static Card fillCard(){
        Random random = new Random();
        String cardNumber = "";
        cardNumber += (random.nextInt(9) + 1);


        for (int i = 0; i < 15; i++) {
            cardNumber += random.nextInt(10);
        }
   return new Card(++id,cardNumber,0,null);
    }

    public static String maskCreditCard(String input) {
        if (input == null || input.length() != 16) {
            throw new IllegalArgumentException("Input string must have 16 characters.");
        }

        String firstFourChars = input.substring(0, 4);
        String lastFourChars = input.substring(12);


        String maskedString = firstFourChars;
        for (int i = 0; i < 8; i++) {
            maskedString += "*";
        }
        maskedString += lastFourChars;

        return maskedString;
    }
}








