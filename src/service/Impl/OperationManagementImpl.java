package service.Impl;

import service.CustomerService;
import service.OperationManagementService;
import service.OperationsService;
import util.MenuUtil;

public class OperationManagementImpl implements OperationManagementService {
    @Override
    public void OperationManagement() {

            while (true) {
                int option = MenuUtil.getInstance().entryOperationsMenu();
                OperationsService operationsService = new OperationsServiceImpl();
                switch (option) {
                    case 1:
                        operationsService.showBalance();
                        break;
                    case 2:
                        operationsService.cashingOut();
                        break;

                    default:
                        System.out.println("Invalid option: ");
                }

            }
    }
}
