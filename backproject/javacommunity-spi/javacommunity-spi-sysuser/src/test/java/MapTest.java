import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author cctv14
 * @data 2024/4/7 22:17
 * @description
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Map.Entry<Integer, Integer>> entryArrayList = new ArrayList<>(map.entrySet());
        entryArrayList.sort(Map.Entry.comparingByValue());
        System.out.println(entryArrayList);
        HashMap<Integer, Integer> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
        int k = 1;
        int result = map.size();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k >= entry.getValue()){
                --result;
                k -= entry.getValue();
            }else {
                break;
            }
        }
        
    }
}
