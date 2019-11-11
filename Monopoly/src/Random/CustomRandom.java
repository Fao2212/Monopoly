/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Random;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author ferol
 */
public class CustomRandom {
    
    public static int randomRange(int min,int max){
        return ThreadLocalRandom.current().nextInt(min, max);
    }
    public static boolean probabilidad(int prob){
        int random = ThreadLocalRandom.current().nextInt(100);
        if(random <= prob)
            return true;
        return false;
    }
    public static Integer[] shuffle(Integer[] array){
        List<Integer> lista = Arrays.asList(array);
        Collections.shuffle(lista);
        lista.toArray(array);
        return array;
    }
}
