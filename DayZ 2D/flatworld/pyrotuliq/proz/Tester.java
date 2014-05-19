package pyrotuliq.proz;

import javax.swing.JFrame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import pyrotuliq.proz.entity.PlayerEntity;
import pyrotuliq.proz.graphics.IconRegister;
import pyrotuliq.proz.gui.GameMenu;
import pyrotuliq.proz.tile.Tile;
import pyrotuliq.proz.tile.WallTile;
import pyrotuliq.proz.world.World;

@RunWith(JUnit4.class)
public class Tester {
	@Test
	public void test() {
		ProZ frame = new ProZ("JUnit Test Run", 0.145F);
		
		frame.setSize(16 * 32, 16 * 32);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		WallTile tile = new WallTile(0);
		Tile[][] tiles = new Tile[16][16];
		
		tile.registerIcon(IconRegister.instance());
		
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles.length; y++) {
				tiles[x][y] = tile;
			}
		}
		
		World world = new World(1F, tiles);
		world.spawnEntity(new PlayerEntity(20), 8, 8);

		frame.setGameMenu(new GameMenu(frame.getSize()));
		frame.setWorld(world);
		
		frame.repaint();
		
		while (true) {}
	}
}