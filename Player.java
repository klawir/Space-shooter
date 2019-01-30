package assets.player;

import javafx.scene.media.AudioClip;
import game.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;


public class Player extends GameObject {

    private int life;
    private int points;
    private int moveSpeed;
    private int extraLife;
    private ImageView[] lifes;
    private Bullet firstBullet;
    private Bullet secondBullet;
    public static Player instance;
    private AudioClip sound; //media
    private AudioClip shoot;
    private int cannon1Pos;
    private int cannon2Pos;

    public ImageView getView() {
        return view;
    }

    public Player(AudioClip shoot) {

        life=3;
        points=0;
        moveSpeed=4;
        extraLife=5;
        model = new Image("assets/player/model.png");
        view = new ImageView(model);
        spawnPos();
        instance=this;
        sound = new AudioClip (new File("src\\assets\\player\\playerHit.wav").toURI().toString());
        this.shoot=shoot;
        cannon1Pos=0;
        cannon2Pos=-100;
    }

    public boolean isExtraLife() {
        return points%extraLife==0;
    }
    public void addLife()
    {
        life++;
    }

    public void spawnPos()
    {
        view.setLayoutX(DisplayManager.WIDTH/2);
        view.setLayoutY(DisplayManager.HEIGHT- model.getHeight());
    }
    public void TurnLeft()
    {
        if(view.getLayoutX()>0)
            view.setLayoutX(view.getLayoutX()-moveSpeed);
    }

    public void TurnRight()
    {
        if(view.getLayoutX()+ model.getWidth()< DisplayManager.WIDTH)
            view.setLayoutX(view.getLayoutX()+moveSpeed);
    }
    public void shoot()
    {
        firstBullet = new Bullet(this, cannon1Pos);
            secondBullet = new Bullet(this, cannon2Pos);
            Background.instance.getGamePane().getChildren().add(firstBullet.getView());
            Background.instance.getGamePane().getChildren().add(secondBullet.getView());
            GameManager.bulletsList.add(firstBullet);
        GameManager.bulletsList.add(secondBullet);
            System.out.println(GameManager.bulletsList.size());
        KeyManager.instance.setKeySpace(false);

        shoot= new AudioClip(new File("src\\game\\sounds\\laser.wav").toURI().toString());
        shoot.play();
    }

    public double getAngle()
    {
        return model.getHeight()/2;
    }

    public void addPoint()
    {
        points++;
    }
    public void addBonusPoint(){points+=10;}
    public void removeLife()
    {
        life--;
    }
    public int getLife() {
        return life;
    }

    public int getPoints() {
        return points;
    }

    public AudioClip getSound() {
        return sound;
    }
}
