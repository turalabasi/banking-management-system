package service.Impl;

import data.GlobalData;
import enums.ExceptionEnum;
import exception.ApplicationException;
import exception.CustomerNotFoundException;
import helper.CardHelper;
import helper.CustomerHelper;
import model.Customer;
import service.CustomerManagementService;
import service.CustomerService;
import service.HelpManagementService;
import service.HelpService;
import util.InputUtil;
import util.MenuUtil;

import java.awt.*;

import static data.GlobalData.customers;
import static util.InputUtil.*;

public class CustomerServiceImpl implements CustomerService {

    private  HelpManagementService helpManagementService;
    public CustomerServiceImpl(){
        helpManagementService = new HelpManagementServiceImpl();
    }

    private CustomerManagementService customerManagementService;

    {
        customerManagementService = new CustomerManagementServiceImpl();
    }




    public static int failedAttempts = 0 ;

    @Override
    public void register() {
        byte count = inputRequiredByte("enter the count");
        if (customers == null) {
            customers = new Customer[count];
            for (int i = 0; i < count; i++) {
                CustomerHelper.helpRegister();

            }

            System.out.println("REGISTER_SUCCESSFULLY");

        } else {
            Customer[] tempCustomer = customers;
            customers = new Customer[customers.length + count];
            for (int i = 0; i < customers.length; i++) {
                if (i < tempCustomer.length){
                    customers[i] = tempCustomer[i];
                }
                else
                {
                    CustomerHelper.helpRegister();
                }
                System.out.println("REGISTER_SUCCESSFULLY");

            }

        }

    }



    @Override
    public void login() {
        String mail = inputRequiredString("Enter your mail").toLowerCase();
        String password = inputRequiredString("Enter password");

        for (Customer customer : GlobalData.customers) {

                if (customer.getEmail().equals(mail) && customer.getPassword().equals(password)) {
                    failedAttempts = 0;
                    customer.setStatus(true);
                    System.out.println("welcome dear " + customer.getName() );

                    helpManagementService.management();

                } else {
                    failedAttempts++;

                }
                if (failedAttempts == 3) {
                    customer.setBlockStatus((byte) 1);
                    System.exit(1);
                }
          }
    }



    @Override
    public void theBalanceIncrease() {
       String cardNumber = inputRequiredString("enter your card number");
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getCard().getCardNumber().equals(cardNumber)){
              double amount = inputRequiredDouble("write down the amount");
              if (amount > 1) {
                  double currentBalance = customers[i].getCard().getCurrentBalance() + amount;
                  customers[i].getCard().setCurrentBalance(currentBalance);
                  System.out.println("-------Cash Receipt-----------\n"+
                          "Date&Time: " + customers[i].getRegisterDate()+"\n"+
                          "Card number : " + CardHelper.maskCreditCard(customers[i].getCard().getCardNumber()) +"\n"+
                          "amount : "  + "+" + amount +"\n"+
                           "total remain balance " + currentBalance );
              }

            }

        }

    }

}

