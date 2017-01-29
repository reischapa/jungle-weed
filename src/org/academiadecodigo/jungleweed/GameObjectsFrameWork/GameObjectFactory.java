package org.academiadecodigo.jungleweed.GameObjectsFrameWork;

import org.academiadecodigo.jungleweed.GameObjects.Totem;
import org.academiadecodigo.jungleweed.logic.LogicEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chapa on 1/28/2017.
 */
public class GameObjectFactory {


    private LogicEngine logicEngine;

    public GameObjectFactory(LogicEngine logicEngine) {
        this.logicEngine = logicEngine;
    }

    public List<RepresentableGameObject> getRepresentableGameObjects(){

        List<RepresentableGameObject> result = new ArrayList<>();

        result.add(new Totem(logicEngine));

        return result;
    }

}
