/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;


import org.jdesktop.swingx.JXBusyLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public abstract class GlassPaneWorker extends SwingWorker<Object, Object> {

    public void execute(
            final JFrame frame,
            final String message) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final WaitingGlassPane glassPane = new WaitingGlassPane(frame, message);
                addPropertyChangeListener(glassPane);
            }
        });
        super.execute();
    }

    private class WaitingGlassPane extends LockingGlassPane implements PropertyChangeListener {

        private JXBusyLabel busyLabel;

        private Component previousGlassPane;

        private JFrame frame;


        WaitingGlassPane(JFrame frame, String message) {
            super(new Color(255, 255, 255, 180));

            busyLabel = new JXBusyLabel();

            this.frame = frame;

            previousGlassPane = frame.getGlassPane();
            setLayout(new BorderLayout());
            JPanel messagePanel =
                    new JPanel(new FlowLayout(FlowLayout.LEADING));
            messagePanel.setOpaque(false);
            JLabel messageLabel = new JLabel(message);
            messageLabel.setOpaque(false);
            messagePanel.add(messageLabel);
            add(messagePanel, BorderLayout.NORTH);
            JPanel centerPanel = new JPanel();
            centerPanel.setOpaque(false);
            centerPanel.add(busyLabel);
            add(centerPanel, BorderLayout.CENTER);
            final JButton cancelButton = new JButton("Cancel");
            cancelButton.setOpaque(false);
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancel(true);
                }
            });
            addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    cancelButton.requestFocusInWindow();
                }
            });
            JPanel southPanel = new JPanel();
            southPanel.setOpaque(false);
            southPanel.add(cancelButton);
            cancelButton.setCursor(Cursor.getDefaultCursor());
            add(southPanel, BorderLayout.SOUTH);
        }

        public void propertyChange(PropertyChangeEvent evt) {
            if ("state".equals(evt.getPropertyName())) {
                if (StateValue.DONE.equals(evt.getNewValue())) {
                    setVisible(false);
                    frame.setGlassPane(previousGlassPane);
                    busyLabel.setBusy(false);
                } else if (StateValue.STARTED.equals(evt.getNewValue())) {
                    busyLabel.setBusy(true);
                    frame.setGlassPane(this);
                    setVisible(true);
                }
            }
        }

    }


}
