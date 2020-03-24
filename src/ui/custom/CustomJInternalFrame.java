package ui.custom;

import system.Memory;

import javax.swing.*;
import java.awt.*;

public class CustomJInternalFrame extends JInternalFrame
{
    public CustomJInternalFrame()
    {
        super("Title", true, true, true, true);
    }

    public CustomJInternalFrame(String title)
    {
        super(title, true, true, true, true);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        JDesktopPane jdesktoppane = (JDesktopPane) Memory.ref.pull("//jdesktoppane");

        jdesktoppane.invalidate();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        JDesktopPane jdesktoppane = (JDesktopPane) Memory.ref.pull("//jdesktoppane");

        jdesktoppane.invalidate();
    }
}
