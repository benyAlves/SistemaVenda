/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 * @author Bernardo Alves
 */

import org.jdesktop.swingx.*;
import org.jdesktop.swingx.icon.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import org.jdesktop.swingx.painter.Painter;
import org.jdesktop.swingx.painter.BusyPainter;
import org.jdesktop.swingx.painter.MattePainter;

/**
 * BusyLabelExample
 *
 * @author Nazmul Idris
 * @version 1.0
 * @since Feb 2, 2008, 2:43:30 PM
 */
public class BusyLabelExample {
    /** creates a JFrame and calls {@link #doInit} to create a JXPanel and adds the panel to this frame. */
    public BusyLabelExample() {
        JFrame frame = new JFrame("JXBusyLabel Example");
        // add the panel to this frame
        frame.add(doInit());
        // when you close the frame, the app exits
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // center the frame and show it
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    /** simple main driver for this class */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BusyLabelExample();
            }
        });
    }

    /** creates a JXLabel and attaches a painter to it. */
    private Component doInit() {
        JXPanel panel = new JXPanel();
        panel.setLayout(new BorderLayout());
        // create a busylabel
        final JXBusyLabel busylabel1 = createSimpleBusyLabel();
        busylabel1.setMaximumSize(new Dimension(100, 100));
        final JXBusyLabel busylabel2 = createComplexBusyLabel();
        busylabel1.setEnabled(false);
        busylabel2.setEnabled(false);
        // create a label
        final JXLabel label = createLabel();
        // create a button
        JButton button = new JButton("start/stop");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!busylabel1.isEnabled()) {
                    busylabel1.setEnabled(true);
                    busylabel2.setEnabled(true);
                }
                if (busylabel1.isBusy()) {
                    label.setText("BusyLabel stopped");
                    busylabel1.setBusy(false);
                    busylabel2.setBusy(false);
                } else {
                    label.setText("BusyLabel started");
                    busylabel1.setBusy(true);
                    busylabel2.setBusy(true);
                }
            }
        });
        // set the transparency of the JXPanel to 50% transparent
        panel.setAlpha(0.7f);
        // add the label, busylables, and button to the panel
        panel.add(label, BorderLayout.NORTH);
        JXPanel busylabels = new JXPanel(new FlowLayout(FlowLayout.CENTER, 40, 5));
        busylabels.add(busylabel1);
        busylabels.add(busylabel2);
        panel.add(busylabels, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        panel.setPreferredSize(new Dimension(250, 125));
        return panel;
    }

    public JXBusyLabel createSimpleBusyLabel() {
        JXBusyLabel label = new JXBusyLabel();
        label.setToolTipText("simple busy label");
        return label;
    }

    public JXBusyLabel createComplexBusyLabel() {
        // this will not work in the 0.9.1 release of SwingX (need later builds)
        JXBusyLabel label = new JXBusyLabel(new Dimension(38, 38));
        BusyPainter painter = new BusyPainter(
                new Rectangle2D.Float(0, 0, 8.0f, 8.0f),
                new Rectangle2D.Float(5.5f, 5.5f, 27.0f, 27.0f));
        painter.setTrailLength(4);
        painter.setPoints(8);
        painter.setFrame(-1);
        painter.setBaseColor(Color.lightGray);
        painter.setHighlightColor(Color.ORANGE);
        label.setPreferredSize(new Dimension(38, 38));
        label.setIcon(new EmptyIcon(38, 38));
        label.setBusyPainter(painter);


        label.setToolTipText("complex busy label");
        return label;
    }

    public JXLabel createLabel() {
        JXLabel label = new JXLabel();
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setText("<html>BusyLabel Example...<br>click start/stop button</html>");
//  label.setIcon(Images.NetworkDisconnected.getIcon(40, 40));  
        label.setHorizontalAlignment(JXLabel.LEFT);
        label.setBackgroundPainter(getPainter());
        return label;
    }

    /** this painter draws a gradient fill
     * @return  */
    public Painter getPainter() {
        int width = 100;
        int height = 100;
        Color color1 = Color.getHSBColor(12, 55, 123);
        Color color2 = Color.getHSBColor(89, 74, 12);
        LinearGradientPaint gradientPaint =
                new LinearGradientPaint(0.0f, 0.0f, width, height,
                        new float[]{0.0f, 1.0f},
                        new Color[]{color1, color2});
        MattePainter mattePainter = new MattePainter(gradientPaint);
        return mattePainter;
    }
}//end class BusyLabelExample
