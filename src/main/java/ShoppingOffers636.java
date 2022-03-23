import java.util.*;

public class ShoppingOffers636 {

    int n;
    int calculatedPrice = Integer.MAX_VALUE;

    public static void main(String[] args) {

        ShoppingOffers636 obj = new ShoppingOffers636();
        List<Integer> price = Arrays.asList(2, 3, 4);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(1,1,0,4), Arrays.asList(1,2,1,7));
        List<Integer> needs = Arrays.asList(3,2,1);
        System.out.println(obj.shoppingOffers(price,special, needs));

        /**
         * price: [2,3,4]
         * offer: [[1,1,0,4],[1,2,1,7]]
         * need: [3,2,1]
         */
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        n = price.size();
        int maxRequiredPrice=0;
        for(int i=0;i<=n-1;i++){
            maxRequiredPrice = maxRequiredPrice + (needs.get(i)*price.get(i));
        }

        List<List<Integer>> subOfferList = new ArrayList<>();
        findBestOffers(price, special, needs, maxRequiredPrice, subOfferList,  0);

        return calculatedPrice;
    }

    private void findBestOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs,  int maxRequiredPrice, List<List<Integer>> subOfferList ,int start) {
        Map<List<Integer>, Integer> remNeedsMap = calculateRemainingNeedsAndPrice(price, subOfferList, needs);
        List<Integer> remainNeeds = remNeedsMap.keySet().iterator().next();
        int totalExpenseTillNow = remNeedsMap.get(remainNeeds);

        if(totalExpenseTillNow<0){
            return;
        }
        if(totalExpenseTillNow< calculatedPrice){
            calculatedPrice = totalExpenseTillNow;
        }
        for(int i = start; i < special.size(); i++){
            if(isValidOffer(special.get(i), remainNeeds, maxRequiredPrice)){
                subOfferList.add(special.get(i)); // choose
                findBestOffers(price, special, needs, maxRequiredPrice, subOfferList,  i); //explore
                subOfferList.remove(subOfferList.size() - 1); // unchoose
            }
        }
    }


    private Map<List<Integer>, Integer> calculateRemainingNeedsAndPrice(List<Integer> price, List<List<Integer>> subOfferList, List<Integer> needs) {
        //<needs, needs-price>
        Map<List<Integer>, Integer> result = new HashMap<>();

        List<Integer> newRemainingNeeds = new ArrayList<>(needs);
        int p =0;
        for(List<Integer> offerUnits : subOfferList){
            for(int j=0;j<n;j++){
                int remNeeds = newRemainingNeeds.get(j)- offerUnits.get(j);
                newRemainingNeeds.set(j, remNeeds);
            }
            p=p+offerUnits.get(n); // offer price
        }


        for(int j=0;j<n;j++){
            p = p+ (newRemainingNeeds.get(j) * price.get(j));
        }
        result.put(newRemainingNeeds, p);
        return result;
    }

    private boolean isValidOffer(List<Integer> currentOffer, List<Integer> needs,  int maxRequiredPrice) {
        if(currentOffer.get(n)>maxRequiredPrice){
            return false;
        }
        for(int i=0;i<=n-1;i++){
            if(currentOffer.get(i)>needs.get(i)){
                return false;
            }
        }
        return true;
    }
}
