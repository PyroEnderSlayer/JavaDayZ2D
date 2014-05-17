package pyrotuliq.proz;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import pyrotuliq.proz.gui.GameMenu;

public class ProZ extends JFrame implements KeyListener {
	private static final long serialVersionUID = -1147290630450651940L;

	private ProZ(String title) {
		super(title);
	}
	
	public static void main(String[] args) {
		JFrame frame = new ProZ("ProZ");
		GameMenu menu = new GameMenu();
		
		frame.setLayout(new FlowLayout());
		frame.setSize(1024, 512);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		for (Component component : menu.getComponents())
			frame.add(component);
		
		frame.setVisible(true);
	}
	
	@Override
	public void paint(Graphics graph) {
		super.paint(graph);
		
		// TODO Rendering tiles, entities and game menus.
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
			
		} else if (key == KeyEvent.VK_UP) {
			
		} else if (key == KeyEvent.VK_DOWN) {
			
		} else if (key == KeyEvent.VK_LEFT) {
			
		} else if (key == KeyEvent.VK_RIGHT) {
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
