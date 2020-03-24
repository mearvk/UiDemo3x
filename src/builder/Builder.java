package builder;

import ontology.Members;
import system.Memory;
import ui.custom.CustomJInternalFrame;

import javax.swing.*;
import java.awt.*;

public class Builder
{
    public Builder_Step001 builder_step001;

    public Builder_Step002 builder_step002;

    public Builder_Step003 builder_step003;

    public Builder_Step004 builder_step004;

    public Builder_Step005 builder_step005;

    //

    public static class Builder_Step001
    {
        public Builder_Step001()
        {
            try
            {
                //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

                //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

                //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

                //UIManager.getCrossPlatformLookAndFeelClassName();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static class Builder_Step002
    {
        public Builder_Step002()
        {
            Memory.ref.push("//jframe", Members.jframe);

            Memory.ref.push("//jmenubar", Members.jmenubar);

            Memory.ref.push("//jmenubar", Members.jmenubar);

            Memory.ref.push("//jdesktoppane", Members.jdesktoppane);
        }
    }

    public static class Builder_Step003
    {
        public Builder_Step003_001 builder_step3_001;

        public Builder_Step003_002 builder_step3_002;

        public static Builder_Step003 ref;

        public Builder_Step003()
        {
            Builder_Step003.ref = this;

            this.builder_step3_001 = new Builder_Step003_001();

            this.builder_step3_002 = new Builder_Step003_002();
        }

        public static class Builder_Step003_001
        {
            public Builder_Step003_001()
            {
                JFrame jframe = (JFrame)Memory.ref.pull("//jframe");

                jframe.setSize(800,600);

                jframe.setContentPane(Members.jdesktoppane);

                jframe.setLayout(new FlowLayout());

                jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                jframe.setVisible(true);
            }
        }

        public static class Builder_Step003_002
        {
            public Builder_Step003_002()
            {
                JDesktopPane jdesktoppane = (JDesktopPane)Memory.ref.pull("//jdesktoppane");

                CustomJInternalFrame internalframe;

                for(int i=0; i<9; i++)
                {
                    internalframe = new CustomJInternalFrame("Pane #"+i);

                    internalframe.setBounds(0,50, 800,600);

                    internalframe.setVisible(true);

                    jdesktoppane.add(internalframe);
                }
            }
        }
    }

    public static class Builder_Step004
    {
        public Builder_Step004()
        {

        }
    }

    public static class Builder_Step005
    {
        public Builder_Step005()
        {

        }
    }


}
