import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;

public class Application extends JFrame
{
    private JMenuBar menubar;

    public Application()
    {
        setTitle("EKG-Software");
        setBounds(50,50,400,300);
        getContentPane().setBackground(new Color(0, 144, 255, 255));

        menubar = new JMenuBar();

        JMenu Datei = new JMenu("Datei");
        JMenuItem actionItem = new JMenuItem("Importieren");
        JMenuItem ergebnisItem = new JMenuItem("Darstellen");
        JMenuItem zusammenfassungItem = new JMenuItem("Zusammenfassung");
        Datei.add(actionItem);
        Datei.add(ergebnisItem);
        Datei.add(zusammenfassungItem);

        ActionListener al = new ActionListener()
        {
            public void actionPerformed( ActionEvent e)
            {
                //String Datei = READ.chooseFile();
                if(e.getSource() == actionItem)
                {
                    String Datei = READ.chooseFile();
                    READ.fileMover(Datei);
                }
                else if (e.getSource() == ergebnisItem)
                {
                    //READ.main(Datei);
                }
            }
        }
                ;
        actionItem.addActionListener(al);
        ergebnisItem.addActionListener(al);

        JMenu Ordner = new JMenu("Support");
        JMenuItem katzeItem = new JMenuItem("E-Mail");
        JMenuItem coolItem = new JMenuItem("Cool");
        JMenuItem AmmonItem = new JMenuItem("Pfiffig");
        Ordner.add(katzeItem);
        Ordner.add(coolItem);
        Ordner.add(AmmonItem);

        menubar.add(Datei);
        menubar.add(Ordner);
        setJMenuBar(menubar);

        initInnerComiponents();

        setVisible(true);
    }

    public void initInnerComiponents()
    {
        JButton b1 = new JButton(" Knopf1");
        JButton b2 = new JButton(" Knopf2");
        JButton b3 = new JButton(" Knopf3");
        JButton b4 = new JButton(" Knopf4");

        //Drawingarea d = new Drawingarea();                            //HIER!!! <------
        //getContentPane().add(d, BorderLayout.CENTER);
        getContentPane().add(b1, BorderLayout.PAGE_START);
        getContentPane().add(b2, BorderLayout.PAGE_END);
        getContentPane().add(b3, BorderLayout.LINE_START);
        getContentPane().add(b4, BorderLayout.LINE_END);


        ActionListener al = new ActionListener()
        {
            public void actionPerformed( ActionEvent e)
            {
                if(e.getSource() == b1)
                {
                    System.out.println("DAS IST SPARTA");
                }
                else if (e.getSource() == b2)
                {
                    System.out.println("Nein, DAS IST SPARRRRRRRRTA");
                }
                else if (e.getSource() == b3)
                {
                    System.out.println("Links, rechts im Quadrat, Kinndergarten, Zinnsoldat");
                }
                else if (e.getSource() == b4)
                {
                    System.out.println("Garrr, Buhuhuhi, Garrr");
                }
            }
        }
                ;
        b1.addActionListener(al);
        b2.addActionListener(al);
        b3.addActionListener(al);
        b4.addActionListener(al);
    }
}


