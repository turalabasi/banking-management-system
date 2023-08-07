package helper;

import model.Card;
import model.Customer;
import util.InputUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static data.GlobalData.customers;
import static helper.CardHelper.fillCard;

public class CustomerHelper {
    static long id=0;
    static int customerCount=0;
    public static Customer fillCustomer() {
        try {
            String name = InputUtil.inputRequiredString("Enter the name");
            String surname = InputUtil.inputRequiredString("Enter the surname");
            String email = InputUtil.inputRequiredString("Enter the email");
            String password = InputUtil.inputRequiredString("Enter the password]");
            LocalDateTime registerDate = nowDate();
            Card card = fillCard();
            return new Customer(++id,name,surname,email,password,false,(byte) 0,registerDate,null,card);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());

        }
        return null;

    }

    public static LocalDateTime nowDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.withNano(0);
    }

    public static void helpRegister() {
        Customer customer = fillCustomer();
        if (customer != null) {
            customers[customerCount] = customer;
            customerCount++;
        }
    }

        }

