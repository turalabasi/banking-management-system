package service.Impl;

import helper.CardHelper;
import model.Customer;
import service.OperationsService;
import util.InputUtil;

import static data.GlobalData.customers;
import static util.InputUtil.inputRequiredDouble;

public  class OperationsServiceImpl implements OperationsService {

    @Override
    public void showBalance() {
        for (Customer customer : customers) {
            if (customer.isStatus()) {
                System.out.println("---your balance is--- : \n" + customer.getCard().getCurrentBalance());
            }
        }

    }

    @Override
    public void cashingOut() {

        for (int i = 0; i < customers.length; i++) {

            if (customers[i].isStatus()) {
                double withdrawAmount = inputRequiredDouble("enter amount to withdraw : ");
                if (withdrawAmount > 1 && withdrawAmount < customers[i].getCard().getCurrentBalance()) {
                    double currentBalance = customers[i].getCard().getCurrentBalance() - withdrawAmount;
                    customers[i].getCard().setCurrentBalance(currentBalance);

                    System.out.println("-------Cash Receipt-----------\n" +
                            "Date&Time: " + customers[i].getRegisterDate() + "\n" +
                            "Card number : " + CardHelper.maskCreditCard(customers[i].getCard().getCardNumber()) + "\n" +
                            "Cash : " + "-" + withdrawAmount + "\n" +
                            "total remain balance " + currentBalance);

                    int banknote500 = (int) (withdrawAmount / 500);
                    if (banknote500 > 0) {
                        System.out.println(banknote500 + " - 500");
                        withdrawAmount -= banknote500 * 500;
                    }

                    int banknote200 = (int) (withdrawAmount / 200);
                    if (banknote200 > 0) {
                        System.out.println(banknote200 + " - 200");
                        withdrawAmount -= banknote200 * 200;
                    }

                    int banknote100 = (int) (withdrawAmount / 100);
                    if (banknote100 > 0) {
                        System.out.println(banknote100 + " - 100");
                        withdrawAmount -= banknote100 * 100;
                    }

                    int banknote50 = (int) (withdrawAmount / 50);
                    if (banknote50 > 0) {
                        System.out.println(banknote50 + " - 50");
                        withdrawAmount -= banknote50 * 50;
                    }

                    int banknote20 = (int) (withdrawAmount / 20);
                    if (banknote20 > 0) {
                        System.out.println(banknote20 + " - 20");
                        withdrawAmount -= banknote20 * 20;
                    }

                    int banknote5 = (int) (withdrawAmount / 5);
                    if (banknote5 > 0) {
                        System.out.println(banknote5 + " - 5");
                        withdrawAmount -= banknote5 * 5;
                    }

                    int banknote1 = (int) withdrawAmount;
                    if (banknote1 > 0) {
                        System.out.println(banknote1 + " - 1");
                    }

                }
                else {
                    System.out.println("Lack of funds");
            }


                }

            }

        }


    }



    


