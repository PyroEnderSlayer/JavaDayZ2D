package pyrotuliq.proz;

import java.awt.Graphics;

import javax.swing.JFrame;

public class ProZ extends JFrame {
	private static final long serialVersionUID = -1147290630450651940L;

	private ProZ(String title) {
		super(title);
	}
	
	public static void main(String[] args) {
		JFrame frame = new ProZ("ProZ");
		
		frame.setSize(1024, 512);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	@Override
	public void paint(Graphics graph) {
		super.paint(graph);
		
		// TODO Rendering tiles, entities and game menus.
	}
}
