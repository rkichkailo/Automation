package com.academy.Ruslana_Kichkailo.homework3.application;

public class Menu {

    public static void getWelcomeMenu(){
        System.out.println("""
                Select action:
                --------------------
                1 - Login
                2 - Register new user
                3 - Close app""");
    }
    public static void getAccountMenu(){
        System.out.println("""
                Select action:
                --------------------
                1 - Create account
                2 - Show Accounts
                3 - Open account
                4 - Log out""");
    }

    public static void showGoodByeMessage(){
        System.out.println("Good bye!");
        LoginForm.setIsLogged(false);
    }
    public static boolean showMenu(){
        return LoginForm.isLoginEnabled && !LoginForm.isLogged();
    }
}
