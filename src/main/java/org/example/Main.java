package org.example;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Main extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(324);
        settings.setHeight(546);
        settings.setTitle("羊了个羊");
        settings.setVersion("Beta版");
    }

    @Override
    protected void initUI() {

    }


    @Override
    protected void initGame() {
        Block.init();
        FXGL.entityBuilder()
                .at(61,413)
                .view(new Rectangle(201, 1, Color.CORAL))
                .buildAndAttach();
        FXGL.entityBuilder()
                .at(61,414)
                .view(new Rectangle(1, 24, Color.CORAL))
                .buildAndAttach();
        FXGL.entityBuilder()
                .at(261,414)
                .view(new Rectangle(1, 24, Color.CORAL))
                .buildAndAttach();
        FXGL.entityBuilder()
                .at(61,438)
                .view(new Rectangle(201, 1, Color.CORAL))
                .buildAndAttach();
    }

    public static void main(String[] args) {
        launch(args);
    }
}