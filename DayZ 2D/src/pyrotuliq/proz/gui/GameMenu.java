package pyrotuliq.proz.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameMenu implements KeyListener, MouseListener {
	public static final Dimension BUTTON_SIZE = new Dimension(256, 32);
	
	private MenuButton playButton;
	private MenuButton quitButton;
	
	public GameMenu() {
		playButton = new MenuButton("Play");
		quitButton = new MenuButton("Quit");
		
		playButton.setPreferredSize(BUTTON_SIZE);
		quitButton.setPreferredSize(BUTTON_SIZE);
	}
	
	public Component[] getComponents() {
		return new Component[] {playButton, quitButton};
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() != MouseEvent.BUTTON1)
			return;
		Point location = e.getLocationOnScreen();
		
		if (location.x >= playButton.getX() && location.x <= playButton.getX() + playButton.getWidth() && location.y >= playButton.getY() && location.y <= playButton.getY() + playButton.getHeight()) {
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
