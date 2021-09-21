import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Discount {

    // discount as suggested by the marketing department
    public static double marketingDiscount(double amountPayable, ArrayList<JSONObject> items){
        HashMap<String,Integer> itemMap = itemCount(items);
        if(itemMap.get(Constant.VOUCHER) >= 2){
            double discountedAmountPayable = 0.0;
            for(JSONObject item: items) if(item.get(Constant.CODE_KEY).equals(Constant.VOUCHER))
                discountedAmountPayable = amountPayable - (Math.floor((itemMap.get(Constant.VOUCHER) / 2)) * (Long) item.get("Price"));
            return discountedAmountPayable;
        } else {
            return amountPayable;
        }
    }

    // discount as suggested by the cfo
    public static double cfoDiscount(double amountPayable, ArrayList<JSONObject> items) {
        HashMap<String,Integer> itemMap = itemCount(items);
        for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
            if (entry.getValue() >= 3 && !entry.getKey().equals(Constant.VOUCHER))
               amountPayable = amountPayable - entry.getValue();
        }
        return amountPayable;
    }

    // count the amount of times each item was selected by a customer
    public static HashMap<String, Integer> itemCount(ArrayList<JSONObject> items) {
        HashMap<String, Integer> itemMap = new HashMap<String, Integer>();
        for (JSONObject item : items) {
            String itemCode = (String) item.get(Constant.CODE_KEY);
            if (itemMap.containsKey(itemCode)) {
                for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
                    if (entry.getKey().equals(itemCode))
                        itemMap.put(entry.getKey(), entry.getValue() + 1);
                }
            } else {
                itemMap.put(itemCode, 1);
            }
        }
        return itemMap;
    }
}
