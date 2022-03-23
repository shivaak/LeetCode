package designpatterns;

interface Currency{
    public String getSymbol();
}

class IndianCurrency implements  Currency{
    @Override
    public String getSymbol() {
        return "INR";
    }
}

class USCurrency implements  Currency{
    @Override
    public String getSymbol() {
        return "USD";
    }
}

class CurrencyFactory {
    public static Currency getCurrency(String countryName){
        switch(countryName){
            case "India":
                return new IndianCurrency();
            case "US":
                return new USCurrency();
        }
        throw new IllegalArgumentException("No such currency " + countryName);
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        Currency c = CurrencyFactory.getCurrency("India");
        System.out.println(c.getSymbol());
    }
}
