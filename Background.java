package game;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class Background {

    private String modelPath;
    private float scrollSpeed;
    private GridPane gridPane1;
    private GridPane gridPane2;
    private AnchorPane gamePane;
    public static Background instance;

    public AnchorPane getGamePane() {
        return gamePane;
    }

    public Background(String modelPath)
    {
        this.modelPath=modelPath;
        scrollSpeed =.0f;
        gamePane=new AnchorPane();
        create();
        instance=this;
    }
    private void create()
    {
        gridPane1= new GridPane();
        gridPane2= new GridPane();
        ImageView backImage1=new ImageView(modelPath);
        gridPane1.getChildren().add(backImage1);
        gridPane2.setLayoutY(-DisplayManager.WIDTH);
        gamePane.getChildren().addAll(gridPane1, gridPane2);
    }
    public void move()
    {
        gridPane1.setLayoutY(gridPane1.getLayoutY()+scrollSpeed);
        gridPane2.setLayoutY(gridPane2.getLayoutY()+scrollSpeed);
        if(gridPane1.getLayoutY()>=DisplayManager.HEIGHT)
            gridPane1.setLayoutY(-DisplayManager.HEIGHT);
        if(gridPane2.getLayoutY()>=DisplayManager.HEIGHT)
            gridPane2.setLayoutY(-DisplayManager.HEIGHT);
    }
}
