package com.yst.poker_game;

import javax.swing.*;
import java.util.ArrayList;

public class LoginJFrame extends JFrame {
    private static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User("shenhengxu", "123"));
        users.add(new User("yangsiting", "456"));
    }

}
