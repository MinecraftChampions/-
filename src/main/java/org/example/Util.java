package org.example;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.Serializable;
import java.util.*;

public class Util {
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length-1);
        return clazz.getEnumConstants()[x];
    }

    public static String[] partition(String string) {
        return string.split(" ");
    }

    public static Random random = new Random();

    public static void click(Entity entity) {
        list.add((Type) entity.getType());
        Type type = isRepeat();
        if (type == null) {
            if (list.size()==8) {
                end1();
            } else {
                entity.setPosition(37+list.size()*25,414);
            }
        } else {
            for (int i = 0;i<3;i++) {
                list.remove(type);
            }
            List<Entity> entitiesNearby = FXGL.getGameWorld().getEntitiesInRange(new Rectangle2D(62, 414, 199, 24));
            List<Entity> l = new ArrayList<>();
            for(Entity e : entitiesNearby) {
                if (e.getType() == type) {
                    l.add(e);
                    FXGL.getGameWorld().removeEntity(e);
                }
            }
            entitiesNearby.removeAll(l);
            for (int i = 0;i<list.size();i++) {
                entitiesNearby.get(i).setPosition(37+(i+1)*25,414);
            }
            if (FXGL.getGameWorld().getEntitiesInRange(new Rectangle2D(62, 80, 200, 200)).isEmpty()) {
                end2();
            }
        }
    }

    public static void end1() {
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("你失败了");
        alert2.setHeaderText("点击退出");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                FXGL.getPrimaryStage().close();
            }
        } else {
            FXGL.getPrimaryStage().close();
        }
    }

    public static void end2() {
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("你胜利了");
        alert2.setHeaderText("点击退出");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                FXGL.getPrimaryStage().close();
            }
        } else {
            FXGL.getPrimaryStage().close();
        }
    }

    public static List<Type> list = new ArrayList<>();

    public static Type isRepeat() {
        Type type = null;
        Map<Type,Integer> map = new HashMap<>();
        for(Type t:list){
            int i = 1; //定义一个计数器，用来记录重复数据的个数
            if(map.get(t) != null){
                i=map.get(t)+1;
            }
            map.put(t,i);
        }
        for(Type t:map.keySet()){
            if(map.get(t) > 2){
                type = t;
            }
        }
        return type;
    }
}
