import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Scanner;

public class CalculateDOB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int day = 0, month = 0, year = 0;
            do{
                System.out.println("Enter your Date of Birth as dd-mm-yyyy");
                String dob = scanner.nextLine();
                    try {
                        String dayString = dob.substring(0, 2);
                        String monthString = dob.substring(3, 5);
                        String yearString = dob.substring(6, 10);
                        day = Integer.parseInt(dayString);
                        month = Integer.parseInt(monthString);
                        year = Integer.parseInt(yearString);
                        validInput = true;
                    } catch (NumberFormatException | StringIndexOutOfBoundsException sioobe) {
                        System.out.println("Invalid format");
                        validInput = false;
                }
            } while (!validInput);
        System.out.println("Day = " + day + ", Month = " + month + ", Year = " + year);


        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear = calendar.get(Calendar.YEAR);

        int yearDelta = currentYear - year;
        int monthDelta = currentMonth + 1 - month;
        int dayDelta = currentDay - day;

        if (dayDelta<0){
            monthDelta--;
            dayDelta = 30 + dayDelta;}
        if (monthDelta<0){
            yearDelta--;
            monthDelta = 12 + monthDelta;}


        String age = yearDelta + " years " + monthDelta + " months " + dayDelta + " days old";
        System.out.println(age);
    }

    public static int calculateAgeAlternative(){
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(2005,01,22);
        return Period.between(birthDate, today).getYears();
    }

}


