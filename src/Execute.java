public class Execute {
    public static void main(String args[]){
        // discount rules that should be applied
        String[] discountRules = {"cfo-rule", "mark-rule"};
        // checkout instance
        Checkout checkout = new Checkout(discountRules);
        // scanning of customer products
        checkout.scan("VOUCHER");
        checkout.scan("VOUCHER");
        checkout.scan("VOUCHER");

        checkout.scan("TSHIRT");
        checkout.scan("TSHIRT");
        checkout.scan("TSHIRT");

        checkout.scan("MUG");
        // display of cost for customer
        System.out.println(checkout.calculateAmountPayable());
    }
}
