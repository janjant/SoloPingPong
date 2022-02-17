import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Igra extends JPanel {
	
	Zoga zoga = new Zoga(this); //zoga kot: tip objekta, ime objekta, objekt
	Lopar lopar = new Lopar(this);
	
	public Igra() {
		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					lopar.nastaviPremikanje(1);
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					lopar.nastaviPremikanje(-1);
				}
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT) {
					lopar.ustaviPremikanje();
				}
			}
			
			public void keyTyped(KeyEvent e) {
			}
		});
		
		setFocusable(true);
	}
	
	public void paint(Graphics g ) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		zoga.narisi(g2d);
		lopar.narisi(g2d);
	}
	
	public void konecIgre() {
		JOptionPane.showMessageDialog(this, "Konec igre!");
		System.exit(0);;
	}
	
	public static void main(String[] args) {
		JFrame okvir = new JFrame("Igra");
		
		Igra igra = new Igra();
		
		okvir.add(igra);
		okvir.setSize(300,400);
		okvir.setVisible(true);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			igra.zoga.premakni();
			igra.lopar.premakni();
			igra.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
		}

	}

}
