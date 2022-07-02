package org.example;

import org.example.dao.UserDao;
import org.example.domain.AuthUser;
import org.example.domain.FlycashLoginUser;
import org.example.view.Home;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
        UserDao userDao = applicationContext1.getBean("userDao", UserDao.class);
        for (FlycashLoginUser user : userDao.getAllFlycashLoginUsers()) {
            System.out.println(user.getId());
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            System.out.println(user.getNid());
            System.out.println(user.getPhone());
            System.out.println(user.getType());
            System.out.println("\n");
        }
        /*BaseBallCoach baseBallCoach = new BaseBallCoach();
        System.out.println(baseBallCoach.getInstruction());*/

        /*CricketCoach cricketCoach = new CricketCoach();
        System.out.println(cricketCoach.getInstruction());*/

        /*Coach coach = new BaseBallCoach();
        System.out.println(coach.getInstruction());*/

        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Coach coach1 = applicationContext.getBean("baseBallCoach", Coach.class);*/
        /*Coach coach2 = applicationContext.getBean("baseBallCoach", Coach.class);
        System.out.println("coach1 = " + coach1 + " coach2 = " + coach2);
        if (coach1.equals(coach2)) {
            System.out.println("Both Objects are equal");
        }
        else {
            System.out.println("Not equal");
        }*/
        /*System.out.println(coach1.getInstruction());*/

//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Home();
//            }
//        });

//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//
//
//                JFrame jFrame = new JFrame("Home Page");
//                jFrame.setSize(600, 500);
//                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                jFrame.setVisible(true);
//                jFrame.setLocationRelativeTo(null);
//                LayoutManager layoutManager = new FlowLayout(FlowLayout.CENTER, 0, 20);
//                jFrame.setLayout(layoutManager);
//
//                final JTextField usernameField = new JTextField();
//                usernameField.setColumns(16);
//                jFrame.add(usernameField);
//
//
//                final JTextField passwordField = new JTextField();
//                passwordField.setColumns(16);
//                jFrame.add(passwordField);
//
//                JButton loginButton = new JButton("Login");
//                jFrame.add(loginButton);
//
//                JButton regButton = new JButton("Sign Up");
//                jFrame.add(regButton);
//
//                JLabel message = new JLabel("");
//                jFrame.add(message);
//
//                String[] columns = new String[]{"id","username","password"};
//
//                ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
//                UserDao userDao = applicationContext1.getBean("userDao", UserDao.class);
//
//                List<AuthUser> users = userDao.getAllUsers();
//
//                String[][] rows = new String[users.size()][3];
//                int index = 0;
//                for (AuthUser user : users){
//                    rows[index] = new String[]{String.valueOf(user.getId()),user.getUsername(),user.getPassword()};
//                    System.out.println(rows[index][1]);
//                }
//
//                JTable usersTable = new JTable(rows,columns);
//                jFrame.add(usersTable);
//
//
//                regButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        String username = usernameField.getText();
//                        String password = passwordField.getText();
//                        message.setText(userDao.addUser(username,password)>0?"Sign Up Successful":"Sign Up Error");
//                    }
//                });
//
//                loginButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        String username = usernameField.getText();
//                        String password = passwordField.getText();
//                        message.setText(userDao.authenticateUser(username,password));
//                    }
//                });
//
//            }
//        });
    }
}
