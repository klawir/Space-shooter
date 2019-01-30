package game;

import javafx.scene.layout.AnchorPane;

public class Game {

    private AnchorPane pane;
    private GameManager manager;

    public Game()
    {
        pane= new AnchorPane();
        manager = new GameManager();
        manager.gameloop();
    }
}
