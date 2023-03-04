package org.example;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Block {
    public static List<Entity> spawn() {
        List<Entity> list = new ArrayList<>();
        for (int i = 0;i<130;i++) {
            Type type = Util.randomEnum(Type.class);
            String color = type.getType();
            String[] args = Util.partition(color);
            Entity entity = FXGL.entityBuilder()
                    .onClick(Util::click)
                    .type(type)
                    .view(new Rectangle(24, 24, Color.rgb(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]))))
                    .buildAndAttach();
            for (int j = 0;j<3;j++) {
                list.add(entity);
            }
        }
        Collections.shuffle(list);
        return  list;
    }

    public static void setCoordinate(List<Entity> list) {
        Collections.shuffle(list);
        for (int i = 0;i<6;i++) {
            for (int j = 0;j<8;j++) {
                for (int k = 0;k<8;k++) {
                    int size = i*64+j*8+k+1;
                    list.get(size-1).setPosition(37+25*(k+1),80+25*(j+1));
                }
            }
        }
    }

    public static void init() {
        setCoordinate(spawn());
    }
}
