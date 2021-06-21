package ex46;

import java.util.HashMap;
import java.util.Map;

public class tracker {
    private int count;
    private String word;

    public void assignVals(Map.Entry<String, Integer> hMap){
        word = hMap.getKey();
        count = hMap.getValue();
    }

    public String getWord(){
        return word;
    }

    public int getCount(){
        return count;
    }
}
