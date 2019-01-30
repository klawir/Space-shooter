package game;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

public class KeyManager {

    private Scene scene;

    private boolean keyRight;
    private boolean keyLeft;
    private boolean keySpace;
    public static KeyManager instance;

    public void setKeySpace(boolean keySpace) {
        this.keySpace = keySpace;
    }

    public KeyManager(Scene scene) {
        keyRight=false;
        keyLeft=false;
        keySpace=false;
        instance=this;
        this.scene=scene;
    }
    public void keyListerners()
    {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()== KeyCode.LEFT)
                    keyLeft=true;
                else if(event.getCode()== KeyCode.RIGHT)
                    keyRight=true;
                else if(event.getCode()== KeyCode.SPACE)
                {
                    keySpace=true;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()== KeyCode.LEFT)
                    keyLeft=false;
                else if(event.getCode()== KeyCode.RIGHT)
                    keyRight=false;
                else if(event.getCode()== KeyCode.SPACE)
                {
                    keySpace=false;
                }
            }
        });
    }

    public  boolean turnLeft()
    {
        return keyLeft && !keyRight;
    }
    public  boolean turnRight()
    {
        return !keyLeft && keyRight;
    }
    public  boolean shoot() { return keySpace; }
    public boolean pressedAllOrNothing()
    {
        return keyLeft && keyRight || !keyLeft && !keyRight;
    }
}
