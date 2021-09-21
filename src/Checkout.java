import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Checkout {
    // since there can be more than one pricing rule it was ideal to have an array of pricing rules.
    public String[] priceRule = null;
    // list of items selected by customer.
    public ArrayList<JSONObject> customerItemsList = new ArrayList<>();
    // storage of all items currently available by the Novicap physical store.
    public JSONModel itemsWareHouse = new JSONModel(Constant.FILE_NAME);

    public Checkout(String[] priceRule){
        this.priceRule = priceRule;
    }

    // an item scanner this adds to the items selected by customer
    public void scan(String item){
        if(item.equals(Constant.VOUCHER)){
            customerItemsList.add(itemsWareHouse.getItem(item));
        }else if(item.equals(Constant.TSHIRT)){
            customerItemsList.add(itemsWareHouse.getItem(item));
        }else if(item.equals(Constant.MUG)){
            customerItemsList.add(itemsWareHouse.getItem(item));
        }else {
            return;
        }
    }

    // this is used to remove from items selected by customer
    public void removeItem(int index){
        customerItemsList.remove(index);
    }

    // calculate cost of goods with discount applied
    public double calculateAmountPayable(){
        return applyPriceRule(calculateTotalCost());
    }

    public double calculateTotalCost(){
        double amountPayable = 0;
        for(JSONObject item: customerItemsList) {
            // Json VOUCHER AND TSHIRT values are parsed as a Long
            // JSON MUG values are parsed as double
            if(item.get("Code").equals(Constant.MUG)) {
                amountPayable += (double) item.get(Constant.PRICE_KEY);
            }else {
                amountPayable += (long) item.get(Constant.PRICE_KEY);
            }
        }
        return amountPayable;
    }

    public ArrayList<JSONObject> getCustomerItemsList() {
        return customerItemsList;
    }
    // apply the discount rules using the discount rules assigned on the day.
    public double applyPriceRule(double amountPayable){
        double discountState = 0.0;
        for(int index=0; index < priceRule.length; index++){
            if (priceRule[index].equals("cfo-rule")){
                discountState = Discount.cfoDiscount(amountPayable, customerItemsList);
            }else if(priceRule[index].equals("mark-rule")) {
                discountState = Discount.marketingDiscount(discountState, customerItemsList);
            } else {}
        }
        return discountState;
    }
}
