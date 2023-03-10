package tile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.GamePanel;
import main.ImageManager;
import java.awt.Graphics2D;


public class TileManager {
    GamePanel panel;
    Tile tile[];
    int mapTileNum[][];

    public TileManager(GamePanel gp){
        panel = gp;

        tile = new Tile[20];
        mapTileNum = new int[panel.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("maps/world01.txt");
    }

    public void getTileImage(){
        tile[0] = new Tile();
        tile[0].image = ImageManager.loadBufferedImage("sprites/tiles/grass-1.png");
        tile[0].collision = true;

        tile[1] = new Tile();
        tile[1].image = ImageManager.loadBufferedImage("sprites/tiles/dirt-1.png");

        tile[2] = new Tile();
        tile[2].image = ImageManager.loadBufferedImage("sprites/tiles/path-left-1.png");

        tile[3] = new Tile();
        tile[3].image = ImageManager.loadBufferedImage("sprites/tiles/path-right-1.png");

        tile[4] = new Tile();
        tile[4].image = ImageManager.loadBufferedImage("sprites/tiles/path-top-2.png");

        tile[5] = new Tile();
        tile[5].image = ImageManager.loadBufferedImage("sprites/tiles/path-bottom-1.png");

        tile[6] = new Tile();
        tile[6].image = ImageManager.loadBufferedImage("sprites/tiles/path-corner-1.png");

        tile[7] = new Tile();
        tile[7].image = ImageManager.loadBufferedImage("sprites/tiles/path-corner-2.png");

        tile[8] = new Tile();
        tile[8].image = ImageManager.loadBufferedImage("sprites/tiles/path-corner-3.png");

        tile[9] = new Tile();
        tile[9].image = ImageManager.loadBufferedImage("sprites/tiles/path-corner-4.png");

        tile[10] = new Tile();
        tile[10].image = ImageManager.loadBufferedImage("sprites/tiles/path-inner-corner-2.png");

        // tile[11] = new Tile();
        // tile[11].image = ImageManager.loadBufferedImage("sprites/tiles/path-corner-1.png");

        // tile[12] = new Tile();
        // tile[12].image = ImageManager.loadBufferedImage("sprites/tiles/path-corner-2.png");

        // tile[13] = new Tile();
        // tile[13].image = ImageManager.loadBufferedImage("sprites/tiles/path-top-1.png");

        // tile[14] = new Tile();
        // tile[14].image = ImageManager.loadBufferedImage("sprites/tiles/path-top-2.png");


    }
    public void loadMap(String mapPath){
        try {
            InputStream is = new FileInputStream(mapPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < panel.maxScreenCol && row < panel.maxScreenRow){
                String line = br.readLine();
                while(col< panel.maxScreenCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == panel.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < panel.maxScreenCol && row < panel.maxScreenRow){
            int tileNum = mapTileNum[col][row];
            g2.drawImage(tile[tileNum].image, x, y, panel.scaledTile, panel.scaledTile, null);
            col++;
            x += panel.scaledTile;

            if(col==panel.maxScreenCol){
                col=0;
                x=0;
                row++;
                y += panel.scaledTile;
            }
        }
    }
}
