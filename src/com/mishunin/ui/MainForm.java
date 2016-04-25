package com.mishunin.ui;

import com.mishunin.currency.CurrencyWorker;
import com.mishunin.db.DbWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Andrey on 23.04.2016.
 */
public class MainForm extends JFrame {

    public static String FRAME_TITLE = "Finance worker";

    private DbWorker dbWorker;
    private CurrencyWorker currencyWorker;

    private JPanel mainPanel;

    public MainForm() throws HeadlessException {
        super();
        init();
    }

    private void init() {
        this.setTitle(FRAME_TITLE);
        this.setSize(new Dimension(600, 400));

        dbWorker = DbWorker.getInstance();
        currencyWorker = new CurrencyWorker();

//        checkAndInitDb();

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        this.getContentPane().add(mainPanel);

        JTable values = new JTable();
        values.setBounds(0,35,600,350);
        mainPanel.add(values);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    dbWorker.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();  //todo add Logger
                }
            }
        });
    }

    private void checkAndInitDb() {
        try {
            try (Connection connection = dbWorker.getConnection()) {
                DatabaseMetaData databaseMetaData = connection.getMetaData();
                ResultSet resultSet = databaseMetaData.getTables(null, null, "SYS_PROPERTIES", null);
                if (!resultSet.next()) {
                    dbWorker.init();
                }
            }
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();  //todo add Logger
        }
    }
}
