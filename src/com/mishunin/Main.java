package com.mishunin;

import com.mishunin.ui.MainForm;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        mainForm.setVisible(true);
    }
}
