package game;

import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.util.Duration;

import java.io.File;

public class Explosion extends GameObject{

    private Media sound;
    private float sizeX;
    private float sizeY;

    public Media getSound() {
        return sound;
    }
    public ImageView getView() {
        return view;
    }
    public Explosion(Asteroide asteroide)
    {
        sizeX=.5f;
        sizeY=.5f;
        model = new Image("game/explosion-clip-gif-4.gif");
        view = new ImageView(model);

        view.setScaleX(sizeX);
        view.setScaleY(sizeY);

        view.setLayoutX(asteroide.getView().getLayoutX()-asteroide.model.getWidth());
        view.setLayoutY(asteroide.getView().getLayoutY()-asteroide.model.getHeight());

        sound = new Media(new File("src\\game\\explosion.wav").toURI().toString());
    }

    public void fadeAnimation()
    {
        FadeTransition ft = new FadeTransition(Duration.millis(1300), view);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();
    }
}
