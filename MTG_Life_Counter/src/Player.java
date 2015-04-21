import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Player
{
  public int lifeTotal;
  public int lifeLost;
  public int lifeGained;
  public String name;
  public int infectCount;
  public int commanderDamage;
  public boolean isDead;
  
  public Player()
  {
    this.name = "Gregory";
    this.lifeTotal = 20;
    if (Main.isEDH) {
      this.lifeTotal = 40;
    }
  }
  
  public Player(String name)
  {
    this.name = name;
    this.lifeTotal = 20;
    if (Main.isEDH) {
      this.lifeTotal = 40;
    }
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public int loseOneLife()
  {
    this.lifeTotal -= 1;
    this.lifeLost += 1;
    return this.lifeTotal;
  }
  
  public int loseFiveLife()
  {
    this.lifeTotal -= 5;
    this.lifeLost -= 5;
    return this.lifeTotal;
  }
  
  public int loseTenLife()
  {
    this.lifeTotal -= 10;
    this.lifeLost += 10;
    return this.lifeTotal;
  }
  
  public int gainOneLife()
  {
    this.lifeTotal += 1;
    this.lifeGained += 1;
    return this.lifeTotal;
  }
  
  public int gainFiveLife()
  {
    this.lifeTotal += 5;
    this.lifeGained += 5;
    return this.lifeTotal;
  }
  
  public int gainTenLife()
  {
    this.lifeTotal += 10;
    this.lifeGained += 10;
    return this.lifeTotal;
  }
  
  public int oneCommanderDamage()
  {
    this.commanderDamage += 1;
    return this.lifeTotal--;
  }
  
  public int fiveCommanderDamage()
  {
    this.commanderDamage += 5;
    this.lifeTotal -= 5;
    return this.lifeTotal;
  }
  
  public int tenCommanderDamage()
  {
    this.commanderDamage += 10;
    this.lifeTotal -= 10;
    return this.lifeTotal;
  }
  
  public int oneInfect()
  {
    this.infectCount += 1;
    return this.infectCount;
  }
  
  public int fiveInfect()
  {
    this.infectCount += 5;
    return this.infectCount;
  }
  
  public int tenInfect()
  {
    return this.infectCount += 10;
  }
  
  public void checkStatus()
  {
    if ((this.infectCount >= 10) || 
      (this.lifeTotal <= 0) || (
      (this.commanderDamage >= 21) && (Main.isEDH))) {
      showScoreboard();
    }
  }
  
  public void showScoreboard()
  {
    JFrame scoreboard = new JFrame(":(");
    JPanel scores = new JPanel();
    JLabel stats = new JLabel("<html>Congratulations!  You have died!<br> Life Lost:  " + this.lifeLost + "<br>" + 
      "Life Gained:  " + this.lifeGained + "<br>" + 
      "Infect Counters:  " + this.infectCount + "<br>" + 
      "Commander Damage:  " + this.commanderDamage + "</html>");
    scores.add(stats);
    scoreboard.add(scores);
    scoreboard.setResizable(false);
    scoreboard.setLocationRelativeTo(null);
    scoreboard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    scoreboard.pack();
    scoreboard.setVisible(true);
  }
  public void restart()
  {
    this.infectCount = 0;
    this.commanderDamage = 0;
    this.lifeGained = 0;
    this.lifeLost = 0;
    if (Main.isEDH) {
      this.lifeTotal = 40;
    } else {
      this.lifeTotal = 20;
    }
  }
}
