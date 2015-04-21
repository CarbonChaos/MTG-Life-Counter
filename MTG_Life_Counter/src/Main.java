/**
 * Version 1.3
 * (Technically "Version 2.TakenApartAndReDebuggedVersion1.0AfterVersion1.2WasLostAlongWithTheSourceCodeForEverything".  
 * But nobody wants to say *that*.)
 * 
 * 
 * 
 * Life counter for the card game "Magic the Gathering" 
 * 
 * 
 * 
 * Created by Yvonne Lumetta on March 28, 2015
 */


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main
{
  public static final int WIDTH = 400;
  public static final int HEIGHT = 300;
  public static boolean isEDH = false;
  public Player gregory;
  
  public static void main(String[] args)
  {
    JFrame frameTemp = new JFrame();
    
    Object[] modes = { "EDH", "60 Card" };
    int n = JOptionPane.showOptionDialog(
      frameTemp, 
      "EDH or 60 Card?", 
      "Mode", 
      0, 
      3, 
      null, 
      modes, 
      modes[0]);
    if (n == 0) {
      isEDH = true;
    }
    String s = (String)JOptionPane.showInputDialog(
      frameTemp, 
      "Player name?", 
      "Player Name", 
      -1, 
      null, 
      null, 
      null);
    Player gregory = new Player();
    if (s != null) {
      gregory.setName(s);
    }
    final JFrame frame = new JFrame(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
    frame.setSize(400, 300);
    
    JPanel gui = new JPanel(new BorderLayout());
    frame.add(gui);
    
    JPanel life = new JPanel();
    gui.add(life, "North");
    JButton loseOneLife = new JButton("-1");
    JButton loseFiveLife = new JButton("-5");
    JButton loseTenLife = new JButton("-10");
    JButton addOneLife = new JButton("+1");
    JButton addFiveLife = new JButton("+5");
    JButton addTenLife = new JButton("+10");
    loseOneLife.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        gregory.loseOneLife();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    loseFiveLife.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gregory.loseFiveLife();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    loseTenLife.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gregory.loseTenLife();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    addOneLife.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gregory.gainOneLife();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    addFiveLife.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gregory.gainFiveLife();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    addTenLife.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gregory.gainTenLife();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    life.add(loseOneLife);
    life.add(loseFiveLife);
    life.add(loseTenLife);
    life.add(addOneLife);
    life.add(addFiveLife);
    life.add(addTenLife);
    
    JPanel infect = new JPanel();
    gui.add(infect, "Center");
    JButton addOneInfect = new JButton("+1 Infect");
    JButton addFiveInfect = new JButton("+5 Infect");
    JButton youDie = new JButton("+10 Infect");
    addOneInfect.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gregory.oneInfect();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    addFiveInfect.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gregory.fiveInfect();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    youDie.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gregory.tenInfect();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    JButton restart = new JButton("Restart");
    restart.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        gregory.restart();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    infect.add(addOneInfect);
    infect.add(addFiveInfect);
    infect.add(youDie);
    infect.add(restart);
    
    JPanel commander = new JPanel();
    gui.add(commander, "South");
    JButton oneCommander = new JButton("-1 Commander");
    JButton fiveCommander = new JButton("-5 Commander");
    JButton tenCommander = new JButton("-10 Commander");
    oneCommander.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gregory.oneCommanderDamage();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    fiveCommander.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gregory.fiveCommanderDamage();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    tenCommander.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gregory.tenCommanderDamage();
        frame.setTitle(gregory.name + ": " + gregory.lifeTotal + " Life, " + gregory.commanderDamage + " C, " + gregory.infectCount + " I");
        gregory.checkStatus();
      }
    });
    commander.add(oneCommander);
    commander.add(fiveCommander);
    commander.add(tenCommander);
    
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(3);
    frame.pack();
    frame.setVisible(true);
  }
}