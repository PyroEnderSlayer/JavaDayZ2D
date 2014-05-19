package pyrotuliq.proz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import pyrotuliq.proz.entity.Entity;
import pyrotuliq.proz.gui.GameMenu;
import pyrotuliq.proz.world.World;
import pyrotuliq.proz.world.WorldEntityManager;
import pyrotuliq.proz.world.WorldMemory;

public class ProZ extends JFrame implements KeyListener, ComponentListener, WorldMemory {
	/**
	 * The default JFrame size.
	 */
	public static final Dimension DEFAULT_SIZE = new Dimension(768, 512);
	
	private static final long serialVersionUID = -1147290630450651940L;
	private static ProZ frame;
	private World world;
	private GameMenu gameMenu;
	private WorldEntityManager entityManager;

	/**
	 * Creates a ProZ object with the entered title and mob spawn frequency.
	 * @param title The title of the JFrame.
	 * @param mobFrequency The spawn frequency for mobs (between 0 and 1).
	 */
	ProZ(String title, float mobFrequency) {
		super(title);
		addComponentListener(this);
		
		world = null;
		gameMenu = null;
		entityManager = new WorldEntityManager(this, mobFrequency);
	}
	
	/**
	 * Main method, called by the JRE.
	 * @param args The execution arguments.
	 */
	public static void main(String[] args) {
		frame = new ProZ("ProZ", 0.145F);
		GameMenu gameMenu = new GameMenu(DEFAULT_SIZE);
		
		frame.setLayout(null);
		frame.setSize(DEFAULT_SIZE);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setGameMenu(gameMenu);
		
		frame.setVisible(true);
	}
	
	public void setGameMenu(GameMenu gameMenu) {
		if (this.gameMenu != null)
			return;
		
		this.gameMenu = gameMenu;
		
		for (Component component : gameMenu.getComponents())
			this.add(component);
	}
	
	public void setWorld(World world) {
		for (Component comp : this.getComponents())
			comp.setVisible(world == null);
		
		this.world = world;
	}
	
	public GameMenu getGameMenu() {
		return this.gameMenu;
	}
	
	public World getWorld() {
		return this.world;
	}
	
	@Override
	public void paint(Graphics g) {
		this.setBackground(Color.RED);
		this.setForeground(Color.RED);
		
		if (world != null) {
			for (int y = 0; y < world.getHeight(); y++) {
				for (int x = 0; x < world.getWidth(); x++) {
					g.drawImage(world.getTile(x, y).getIcon(), (int) (world.getScale() * x * 32), (int) (world.getScale() * y * 32 + getInsets().top), (int) (world.getScale() * 32), (int) (world.getScale() * 32), null);
				}
			}
		} else
			super.paint(g);
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
		// TODO Code this for the shooter.
	}

	@Override
	public void componentResized(ComponentEvent e) {
		if (e.getComponent() instanceof ProZ && gameMenu != null) {
			gameMenu.resize(getSize());
		}
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// DO NOTHING
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// DO NOTHING
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// DO NOTHING
	}

	@Override
	public void spawnEntity(Entity entity, int x, int y) {
		System.out.println("Spawned Entity!");
		world.spawnEntity(entity, x, y);
	}

	@Override
	public Entity getEntity(long uuid) {
		return world.getEntity(uuid);
	}

	@Override
	public long getEntityCount() {
		return world.getEntityCount();
	}

	@Override
	public Dimension getWorldSize() {
		return new Dimension(world.getWidth(), world.getHeight());
	}

	@Override
	public void despawnEntity(long uuid) {
		world.despawnEntity(uuid);
	}
}
