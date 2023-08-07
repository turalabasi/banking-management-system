package service.Impl;

import data.GlobalData;
import enums.ExceptionEnum;
import exception.ApplicationException;
import exception.CustomerNotFoundException;
import exception.EmptyListException;
import exception.WrongParameterException;
import helper.CustomerHelper;
import model.Customer;
import service.HelpService;
import util.InputUtil;

import static data.GlobalData.customers;
import static util.InputUtil.inputRequiredLong;
import static util.InputUtil.inputRequiredString;


public class HelpServiceImpl implements HelpService {

    @Override
    public void show() {
        for (Customer customer : customers) {
            if (customer.isStatus()) {
                System.out.println(customer.getInfo());

            }
        }
    }

    @Override
    public boolean update() {
        if (customers == null && customers.length ==0)
            throw new EmptyListException(ExceptionEnum.EMPTY_LIST_EXCEPTION);
        long id = inputRequiredLong("enter the customer  id");
        boolean isTrue = false;

        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getId()==id){
                String parameter = inputRequiredString("Enter the customer parameters");
                String [] parameters = parameter.toLowerCase().split(",");

                for (String str:parameters) {
                    switch (str) {
                        case "name":
                            customers[i].setName(inputRequiredString("update the customer name"));
                            isTrue = true;
                            break;
                        case "surname":
                            customers[i].setSurname(inputRequiredString("update the  surname"));
                            isTrue = true;
                            break;
                        case "username":
                            customers[i].setEmail(inputRequiredString("Update email : "));
                            isTrue = true;
                            break;
                        case "password" :
                            String newPassword = InputUtil.inputRequiredString("Enter new password");
                            if (!newPassword.isEmpty()) {
                                String oldPassword = InputUtil.inputRequiredString("enter your old password");
                                if (oldPassword.equals(customers[i].getPassword())) {
                                    customers[i].setPassword(newPassword);
                                    System.out.println("Password updated successfully!");
                                } else {
                                    System.out.println("Incorrect old password. ");
                                }
                            } else {
                                System.out.println("Password remains unchanged.");

                            }
                            isTrue = true;
                            break;
                            default :
                            throw new WrongParameterException(ExceptionEnum.WRONG_PARAMETER_EXCEPTION);
                    }
                }

                if (isTrue) {

                    System.out.println("Updated Succesfully");
                }

                else {
                    throw new CustomerNotFoundException(ExceptionEnum.CUSTOMER_NOTFOUND_EXCEPTION);
                }
            }
        }

        return true;

    }

}



