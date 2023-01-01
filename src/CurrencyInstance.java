import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyInstance {
    public static void main(String[] args) {
        convertToCurrency(100.58);
    }
    public static void convertToCurrency(double number){
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        String dollars = nf.format(number);
        System.out.println("US: " + dollars);

        NumberFormat nf2 = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String yuan = nf2.format(number);
        System.out.println("China: " + yuan);

        NumberFormat nf3 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String euro = nf3.format(number);
        System.out.println("France: " + euro);

        NumberFormat nf4 = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        String rupees = nf4.format(number);
        System.out.println("India: " + rupees);
    }
}
