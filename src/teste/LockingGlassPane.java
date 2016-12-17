/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alexander Potochkin
 *         <p/>
 *         https://swinghelper.dev.java.net/
 *         http://weblogs.java.net/blog/alexfromsun/
 */
public class LockingGlassPane extends JPanel {
    private Component recentFocusOwner;

    private Color alphaColor;

    public LockingGlassPane(Color backgroundColor) {
        alphaColor = backgroundColor;
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }

    public void setVisible(boolean isVisible) {
        boolean oldVisible = isVisible();
        super.setVisible(isVisible);
        JRootPane rootPane = SwingUtilities.getRootPane(this);
        if (rootPane != null && isVisible() != oldVisible) {
            if (isVisible) {
                Component focusOwner = KeyboardFocusManager.
                        getCurrentKeyboardFocusManager().getPermanentFocusOwner();
                if (focusOwner != null &&
                        SwingUtilities.isDescendingFrom(focusOwner, rootPane)) {
                    recentFocusOwner = focusOwner;
                }
                rootPane.getLayeredPane().setVisible(false);
                requestFocusInWindow();
            } else {
                rootPane.getLayeredPane().setVisible(true);
                if (recentFocusOwner != null) {
                    recentFocusOwner.requestFocusInWindow();
                }
                recentFocusOwner = null;
            }
        }

    }

    protected void paintComponent(Graphics g) {
        JRootPane rootPane = SwingUtilities.getRootPane(this);
        if (rootPane != null) {
            // it is important to call print() instead of paint() here
            // because print() doesn't affect the frame's double buffer
            rootPane.getLayeredPane().print(g);
        }
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(alphaColor);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
}
