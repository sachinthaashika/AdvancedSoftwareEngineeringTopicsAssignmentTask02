import java.awt.*;

import javax.swing.*;

public class PictureFrame {
  public int[] reroll = null;
  Aardvark master = null;

  public DominoPanel dp;

  public void PictureFrame(Aardvark sf) {
    master = sf;
    if (dp == null) {
    	return;
    }
      JFrame f = new JFrame("Abominodo");
      dp = new DominoPanel();
      f.setContentPane(dp);
      f.pack();
      f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      f.setVisible(true);
    }

  public void reset() {
    // TODO Auto-generated method stub

  }
  
  class DominoPanel extends JPanel {
    private static final long serialVersionUID = 4190229282411119364L;

public static final int ColorVal=20;
public static final int DrawVal=30;

    public void drawGrid(Graphics g) {
      for (int are = 0; are < 7; are++) {
        for (int see = 0; see < 8; see++) {
          drawDigitGivenCentre(g, DrawVal  + see * ColorVal, DrawVal + are * ColorVal, ColorVal,
              master.grid[are][see]);
        }
      }
    }
    public void drawGridLines(Graphics g) {
      g.setColor(Color.LIGHT_GRAY);
      for (int are = 0; are <= 7; are++) {
        g.drawLine(ColorVal, ColorVal + are * ColorVal, 180, ColorVal + are * ColorVal);
      }
      for (int see = 0; see <= 8; see++) {
        g.drawLine(ColorVal + see * ColorVal, ColorVal, ColorVal + see * ColorVal, 160);
      }
    }
    public void drawHeadings(Graphics g) {
      for (int are = 0; are < 7; are++) {
        fillDigitGivenCentre(g, 10, DrawVal + are * ColorVal, ColorVal, are+1);
      }
      for (int see = 0; see < 8; see++) {
        fillDigitGivenCentre(g, DrawVal + see * ColorVal, 10, ColorVal, see+1);
      }
    }
    public void drawDomino(Graphics g, Domino d) {
    	if (!(d.placed)){
    		return;
    	}
        final int y = Math.min(d.ly, d.hy);
        final int x = Math.min(d.lx, d.hx);
        final int w = Math.abs(d.lx - d.hx) + 1;
        final int h = Math.abs(d.ly - d.hy) + 1;
        g.setColor(Color.WHITE);
        g.fillRect(ColorVal + x * ColorVal, ColorVal + y * ColorVal, w * ColorVal, h * ColorVal);
        g.setColor(Color.RED);
        g.drawRect(20 + x * ColorVal, ColorVal + y * ColorVal, w * ColorVal, h * ColorVal);
        drawDigitGivenCentre(g, DrawVal + d.hx * ColorVal, DrawVal + d.hy * ColorVal, ColorVal, d.high,
            Color.BLUE);
        drawDigitGivenCentre(g, DrawVal + d.lx * ColorVal, DrawVal + d.ly * ColorVal, ColorVal, d.low,
            Color.BLUE);
      
    }

    void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
      final int radius = diameter / 2;
      g.setColor(Color.BLACK);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      final FontMetrics fm = g.getFontMetrics();
      final String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n,
        Color c) {
      final int radius = diameter / 2;
      g.setColor(c);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      final FontMetrics fm = g.getFontMetrics();
      final String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    void fillDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
      final int radius = diameter / 2;
      g.setColor(Color.GREEN);
      g.fillOval(x - radius, y - radius, diameter, diameter);
      g.setColor(Color.BLACK);
      g.drawOval(x - radius, y - radius, diameter, diameter);
      final FontMetrics fm = g.getFontMetrics();
      final String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    protected void paintComponent(Graphics g) {
      g.setColor(Color.YELLOW);
      g.fillRect(0, 0, getWidth(), getHeight());

      if (master.mode == 1) {
        drawGridLines(g);
        drawHeadings(g);
        drawGrid(g);
        master.drawGuesses(g);
      }
      if (master.mode != 0) {
    	  return;
      }
        drawGridLines(g);
        drawHeadings(g);
        drawGrid(g);
        master.drawDominoes(g);
      }
    }

    public Dimension getPreferredSize() {
      return new Dimension(202, 182);
    }
  }




