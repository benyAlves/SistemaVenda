/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoescolarb;

import org.jdesktop.swingx.*;
import org.jdesktop.swingx.JXCollapsiblePane;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author claucio
 */

public class CollapsiblePaneDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final JXCollapsiblePane cp =
                new JXCollapsiblePane(JXCollapsiblePane.Direction.RIGHT);

        // JXCollapsiblePane can be used like any other container
        cp.setLayout(new BorderLayout());

        // the Controls panel with a textfield to filter the tree
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        controls.add(new JLabel("Search:"));
        controls.add(new JTextField(10));
        controls.add(new JButton("Refresh"));
        controls.setBorder(new TitledBorder("Filters"));

        cp.add("Center", controls);

        JXFrame frame = new JXFrame();
        frame.setLayout(new BorderLayout());

        // Then the tree - we assume the Controls would somehow filter the tree
        JScrollPane scroll = new JScrollPane(new JTree());
        // Put the "Controls" first
        frame.add("Center", scroll);


        // Show/hide the "Controls"
        final JButton toggle = new JButton(cp.getActionMap()
                .get(JXCollapsiblePane.TOGGLE_ACTION));
        toggle.setText("-");
        toggle.setPreferredSize(new Dimension(20, toggle.getSize().height));

        toggle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (cp.getSize().width == 0) {

                    toggle.doClick();
                }
            }
        });

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add("Center", toggle);
        panel.add("East", cp);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                if (!panel.contains(e.getPoint())) {
                    toggle.doClick();
                }
            }
        });

        frame.add("East", panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        cp.setCollapsed(true);
        frame.setVisible(true);

    }
}
