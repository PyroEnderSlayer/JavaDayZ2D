package pyrotuliq.proz.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameMenu implements KeyListener {
	public static final Dimension BUTTON_SIZE = new Dimension(256, 32);
	
	private Dimension currentSize;
	private MenuButton playButton;
	private MenuButton quitButton;
	
	public GameMenu(Dimension size) {
		playButton = new MenuButton("Play");
		quitButton = new MenuButton("Quit");
		
		playButton.setPreferredSize(BUTTON_SIZE);
		quitButton.setPreferredSize(BUTTON_SIZE);
		
		resize(size);
	}
	
	public void resize(Dimension size) {
		if (size == currentSize)
			return;
		
		//playButton.setLocation(size.width / 2 - playButton.getWidth() / 2, size.height / 2 - playButton.getHeight() - 5);
		//quitButton.setLocation(size.width / 2 - quitButton.getWidth() / 2, size.height / 2 + 5);
		
		Dimension playSize = playButton.getPreferredSize();
		Dimension quitSize = quitButton.getPreferredSize();
		
		playButton.setBounds(size.width / 2 - playButton.getWidth() / 2, size.height / 2 - playButton.getHeight() - 25, playSize.width, playSize.height);
		quitButton.setBounds(size.width / 2 - quitButton.getWidth() / 2, size.height / 2 - 15, quitSize.width, quitSize.height);
		
		System.out.println("Resized!");
		
		currentSize = size;
	}
	
	public Component[] getComponents() {
		return new Component[] {playButton, quitButton};
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
