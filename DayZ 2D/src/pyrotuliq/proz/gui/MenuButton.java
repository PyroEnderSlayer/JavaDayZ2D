package pyrotuliq.proz.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import pyrotuliq.proz.tile.IconRegister;

public class MenuButton extends JButton implements MouseListener {
	private static final long serialVersionUID = 18862887163287944L;
	private static BufferedImage unchanged;
	private static BufferedImage selected;
	
	private BufferedImage currentImage;
	
	public MenuButton() {
		super();
		
		if (unchanged == null)
			unchanged = IconRegister.instance().createGuiIcon("button");
		if (selected == null)
			selected = IconRegister.instance().createGuiIcon("button_selected");
		
		currentImage = unchanged;
		addMouseListener(this);
	}
	
	public MenuButton(String text) {
		super(text);
		
		if (unchanged == null)
			unchanged = IconRegister.instance().createGuiIcon("button");
		if (selected == null)
			selected = IconRegister.instance().createGuiIcon("button_selected");
		
		currentImage = unchanged;
		addMouseListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		int textWidth = g.getFontMetrics(this.getFont()).stringWidth(getText());
		int textHeight = g.getFontMetrics(this.getFont()).getHeight();
		
		g.drawImage(currentImage, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.drawString(getText(), getWidth() / 2 - textWidth / 2, getHeight() / 2 + textHeight / 4);
	}
	
	@Override
	protected void paintBorder(Graphics g) {
		// DO NOTHING
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		currentImage = selected;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		currentImage = unchanged;
	}
}
