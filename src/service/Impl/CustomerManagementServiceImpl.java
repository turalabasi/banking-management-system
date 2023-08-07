package service.Impl;

import service.CustomerManagementService;
import service.CustomerService;
import util.MenuUtil;

public class CustomerManagementServiceImpl implements CustomerManagementService {


    public void CustomerManagement() {
        while (true) {
            int option = MenuUtil.getInstance().entryMenu();
            CustomerService customerService = new CustomerServiceImpl();
            switch (option) {
                case 0:
                    System.exit(100);
                    break;
                case 1:
                    customerService.register();
                    break;
                case 2:
                    customerService.login();
                    break;
                case 3:
                    customerService.theBalanceIncrease();
                    break;
                default:
                    System.out.println("Invalid option: ");
            }

        }
    }
}


