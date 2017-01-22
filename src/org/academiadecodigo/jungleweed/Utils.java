package org.academiadecodigo.jungleweed;

/**
 * Created by chapa on 1/8/2017.
 */
public class Utils {

    public static int getBoundedRandomInt(int min, int max){
        return (int) (min + Math.floor(Math.random()*(max+1-min)));
    }

    public static boolean drawWithProbability(double prob) {
        int threshold =  (int) Math.ceil(prob * 10000000);
        int draw = Utils.getBoundedRandomInt(1, 10000000);
        return draw <= threshold;
    }


}
