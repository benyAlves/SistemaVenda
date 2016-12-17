/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import org.jdesktop.swingx.JXFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlassPaneDemo implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GlassPaneDemo());
    }

    public void run() {
        final JXFrame frame = new JXFrame("Aguarde por favor...", true);
        frame.setUndecorated(true);
        frame.add(createCenterPanel(frame));
        frame.pack();
        frame.setLocationRelativeTo(JOptionPane.getRootFrame());
        frame.setVisible(true);
    }

    private Component createCenterPanel(final JXFrame frame) {
        JPanel borderPanel = new JPanel(new BorderLayout());
        JPanel north = new JPanel();
        north.add(new JLabel("Aguarde por favor..."));
        borderPanel.add(north, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            JPanel panel = new JPanel();
            //panel.add(new JCheckBox("Just a grid " + i));
            centerPanel.add(panel);
        }
        borderPanel.add(centerPanel, BorderLayout.CENTER);
        JPanel southPanel = new JPanel();
        JButton startButton = new JButton("Processando");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GlassPaneWorker worker = new GlassPaneWorker() {

                    @Override
                    protected Object doInBackground() throws Exception {
                        Thread.sleep(5000);
                        return null;
                    }

                };
                worker.execute(frame, "Gerando relatorio");

            }
        });
        southPanel.add(startButton);
        borderPanel.add(southPanel, BorderLayout.SOUTH);
        return borderPanel;

    }


}
