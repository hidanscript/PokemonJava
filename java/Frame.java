import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {

	private JLabel bg, foePkmn;

	public Frame() {
		initComponents();
	}

	public void initComponents() {
		setLayout(null);
		setTitle("Pokemon Java Version.");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Image imgbg = new ImageIcon("images/bt_bg.png").getImage();
		ImageIcon imgbg2 = new ImageIcon(imgbg.getScaledInstance(850,540, Image.SCALE_SMOOTH));
		bg = new JLabel(imgbg2);
		add(bg);
		setContentPane(bg);

		ImageIcon imgFoe = new ImageIcon("images/squirtle.gif");
		//ImageIcon imgFoe2 = new ImageIcon(imgFoe.getScaledInstance(240,240, Image.SCALE_SMOOTH));
		foePkmn = new JLabel(imgFoe);
		foePkmn.setBounds(500,200,120,120);
		add(foePkmn);


	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}