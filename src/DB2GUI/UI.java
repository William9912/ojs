package DB2GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.ComponentOrientation;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Scrollbar;
import javax.swing.JPanel;

public class UI {

    private JFrame frame;
    private JTable table;
    //private JTable table;
    //private JPanel panel;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UI window = new UI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public UI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        frame.setBounds(100, 100, 1050, 725);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        String[] titles = {"Ô±¹¤ºÅ","ÐÕ","ÖÐÃû×Ö","ºóÃû×Ö","¹¤×÷²¿ÃÅ","µç»°ºÅÂë","¹¤×÷ÈÕÆÚ","¹¤×÷","EDµÈ¼¶","ÐÔ±ð","ÉúÈÕ","Ð½×Ê","½òÌù","COMM"};

        JButton btnNewButton = new JButton("\u6DFB\u52A0\u884C");
        btnNewButton.setBounds(899, 50, 93, 34);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u5220\u9664\u884C");

        btnNewButton_1.setBounds(899, 119, 93, 34);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u786E\u8BA4");
        btnNewButton_2.setBounds(27, 641, 93, 35);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("\u53D6\u6D88");
        btnNewButton_3.setBounds(199, 641, 93, 35);
        frame.getContentPane().add(btnNewButton_3);

        JPanel panel = new JPanel();
        panel.setBounds(10, 50, 882, 566);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        DefaultTableModel newModel = new DefaultTableModel();
        newModel.setColumnIdentifiers(titles);

        //table = new JTable(rowData,titles);
        table = new JTable(newModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane jscroll = new JScrollPane(table);
        jscroll.setBounds(0, 0, 882, 566);
        jscroll.setViewportView(table);

        panel.add(jscroll);

        JButton btnNewButton_4 = new JButton("\u67E5\u8BE2");
        btnNewButton_4.setBounds(899, 183, 93, 34);
        frame.getContentPane().add(btnNewButton_4);

    }
}
