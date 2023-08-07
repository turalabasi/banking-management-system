package util;

import static util.InputUtil.inputRequiredInt;

public class MenuUtil {
    private MenuUtil() {

    }
    private static MenuUtil instance;

    public static MenuUtil getInstance() {
        return instance == null
                ? instance = new MenuUtil() : instance;
    }
    public  int entryOperationsMenu() {

        System.out.println(
                "[1]. show balance\n" +
                "[2]. cashing out ");
        return inputRequiredInt("Choose Option: ");
    }


    public  int entryMenu() {
        System.out.println("[0]. System exit\n" +
                "[1]. Register\n" +
                "[2]. Login\n" +
                "[3]. Increase the balance ");

        return inputRequiredInt("Choose Option: ");
    }
    public  int entryAppMenu() {
        System.out.println("[1] -> Show my details\n" +
                "[2] -> Update my details\n" +
                "[3] -> Operations\n" +
                "[4] -> Log out ");
        return inputRequiredInt("Choose Option");
}
}
