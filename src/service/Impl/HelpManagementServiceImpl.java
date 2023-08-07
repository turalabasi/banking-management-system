package service.Impl;

import service.HelpService;
import service.HelpManagementService;
import service.OperationsService;
import util.MenuUtil;

public class HelpManagementServiceImpl implements HelpManagementService {
    CustomerManagementServiceImpl customerManagementService = new CustomerManagementServiceImpl();
    OperationManagementImpl operationManagement = new OperationManagementImpl();


    @Override
    public void management() {
        while (true) {
            HelpService helpService = new HelpServiceImpl();

            int option = MenuUtil.getInstance().entryAppMenu();

            switch (option) {
                case 1:
                   helpService.show();
                    break;
                case 2:
                    helpService.update();
                    break;
                case 3:
                    operationManagement.OperationManagement();
                    break;
                case 4:
                    customerManagementService.CustomerManagement();
                    break;
                default:
                    System.out.println("Invalid option: ");
            }

        }


    }
}
