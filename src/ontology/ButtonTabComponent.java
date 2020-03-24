package ontology;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;

/**
 * Component to be used as tabComponent;
 * Contains a JLabel to show the text and
 * a JButton to close the tab it belongs to
 */
public class ButtonTabComponent extends JPanel
{
    private final JTabbedPane pane;

    public ButtonTabComponent(final JTabbedPane pane)
    {
        //unset default FlowLayout' gaps
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));

        if (pane == null)
        {
            throw new NullPointerException("TabbedPane is null");
        }

        this.pane = pane;

        this.setOpaque(false);


        JLabel label = new JLabel()
        {
            public String getText()
            {
                int i = pane.indexOfTabComponent(ButtonTabComponent.this);

                if (i != -1)
                {
                    return pane.getTitleAt(i);
                }

                return null;
            }
        };

        add(label);

        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));

        JButton button = new TabButton();

        add(button);

        this.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
    }

    private class TabButton extends JButton implements ActionListener
    {
        public TabButton()
        {
            int size = 17;

            this.setPreferredSize(new Dimension(size, size));

            this.setToolTipText("close this tab");

            this.setUI(new BasicButtonUI());

            this.setContentAreaFilled(false);

            this.setFocusable(false);

            this.setBorder(BorderFactory.createEtchedBorder());

            this.setBorderPainted(false);

            this.addMouseListener(listener);

            this.setRolloverEnabled(true);

            this.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e)
        {
            int i = pane.indexOfTabComponent(ButtonTabComponent.this);

            System.out.println("Index "+i);

            if (i != -1) {
                pane.remove(i);
            }
        }

        //we don't want to update UI for this button
        public void updateUI() {
        }

        //paint the cross
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            //shift the image for pressed buttons
            if (getModel().isPressed()) {
                g2.translate(1, 1);
            }
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLACK);
            if (getModel().isRollover()) {
                g2.setColor(Color.MAGENTA);
            }
            int delta = 6;
            g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
            g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
            g2.dispose();
        }
    }

    private final static MouseListener listener = new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(true);
            }
        }

        public void mouseExited(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(false);
            }
        }
    };
}