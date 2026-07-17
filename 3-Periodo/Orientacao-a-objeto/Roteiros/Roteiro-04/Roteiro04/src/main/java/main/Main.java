package main;

import gui.FrHome;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FrHome frm = new FrHome();
            frm.setVisible(true);
        });
    }
}