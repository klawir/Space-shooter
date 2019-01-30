package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Asteroide extends GameObject{

    protected double radius;
    protected Random position;
    protected float rorate;
    protected int speed;

    private int randSpeed;
    private int randRotate;
    private Random random= new Random();

    public double getRadius() {
        return radius;
    }

    public ImageView getView() {
        return view;
    }

    public Asteroide(String modelPath)
    {
        randSpeed=5;
        randRotate=6;
        model = new Image(modelPath);
        radius=model.getHeight()/2;

        speed=random.nextInt(randSpeed);;
        rorate = random.nextInt(randRotate);

        view= new ImageView(modelPath);
        position= new Random();
    }
    public void create(Background background)
    {
        setNewElementPos(view);
        background.getGamePane().getChildren().add(view);
    }

    public void resetPos()
    {
        setNewElementPos(view);
    }
    public void speedUp()
    {
        speed++;
    }

    public void move()
    {
        view.setLayoutY(view.getLayoutY()+speed);
        view.setRotate(view.getRotate()+rorate);
    }
    public boolean outOfDisplay()
    {
        return view.getLayoutY()> DisplayManager.HEIGHT;
    }
    public void setNewElementPos(ImageView image)
    {
        image.setLayoutX(position.nextInt(DisplayManager.WIDTH-resetXPos()));
        image.setLayoutY(-(position.nextInt(resetYPos())));

        speed=random.nextInt(randSpeed);
        rorate = random.nextInt(randRotate);
    }
    public int resetYPos()
    {
        return DisplayManager.HEIGHT*4;
    }
    public int resetXPos()
    {
        return DisplayManager.ONE_PERCENT_OF_WIDTH*25;
    }
}