package Difference_two_date;

import java.time.LocalDate;

/*this code get the Difference  between two date(return number of days between dates) 
considering that some months 31 day or 30 or 28 or 29 if the year is leap*/
public class Deffrince_two_date {

    public static void main(String[] args) {
        // initialize date1 and split it to year and month and day
        LocalDate date1 = LocalDate.of(2020, 4, 11);
        int year1 = date1.getYear();
        int month1 = date1.getMonthValue();
        int day1 = date1.getDayOfMonth();//you scan date from user like last 3 line with some changes (int year1=input.nextiInt())
        //initialize date2 
        LocalDate date2 = LocalDate.of(2024, 4, 30);
        int year2 = date2.getYear();
        int month2 = date2.getMonthValue();
        int day2 = date2.getDayOfMonth();
        long total=sum_total(year1,month1,day1,year2,month2,day2);
        System.out.println("the deffrince between" + date1.toString() + " and " + date2.toString() + " is " + total);

    }

    public static long sum_total(int year1, int month1, int day1, int year2, int month2, int day2) {
        long days_on_years = calculte_num_of_days_on_years(year1, year2);
        int days_on_months = calculte_num_of_days_on_months(month1, month2, year1, year2);
        int days = calculte_num_of_days(day1, day2, month1, month2, year1, year2);
        long total = days_on_years + days_on_months + days;
        return total;
    }

    public static long calculte_num_of_days_on_years(int f_year, int sec_year) {
        long num_ofdayes_years = 0;
        for (int i = (f_year + 1); i < sec_year; i++) {
            if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
                num_ofdayes_years = num_ofdayes_years + 366;
            } else {
                num_ofdayes_years = num_ofdayes_years + 365;
            }
        }
        return num_ofdayes_years;
    }

    public static int calculte_num_of_days_on_months(int f_month, int sec_month, int f_year, int sec_year) {
        int num_ofdayes_months_year1 = 0;
        int num_ofdayes_months_year2 = 0;
        if (f_year != sec_year) {
            for (int i = (f_month + 1); i <= 12; i++) {
                f_month++;
                if (f_month == 4 || f_month == 6 || f_month == 9 || f_month == 11) {
                    num_ofdayes_months_year1 = num_ofdayes_months_year1 + 30;
                } else if (f_month == 2) {
                    if (((f_year % 4 == 0) && (f_year % 100 != 0)) || (f_year % 400 == 0)) {
                        num_ofdayes_months_year1 = num_ofdayes_months_year1 + 29;
                    } else {
                        num_ofdayes_months_year1 = num_ofdayes_months_year1 + 28;
                    }
                } else {
                    num_ofdayes_months_year1 = num_ofdayes_months_year1 + 31;
                }
            }

            for (int i = 1; i < sec_month; i++) {

                if (i == 4 || i == 6 || i == 9 || i == 11) {
                    num_ofdayes_months_year2 = num_ofdayes_months_year2 + 30;
                } else if (i == 2) {
                    if (((sec_year % 4 == 0) && (sec_year % 100 != 0)) || (sec_year % 400 == 0)) {
                        num_ofdayes_months_year2 = num_ofdayes_months_year2 + 29;
                    } else {
                        num_ofdayes_months_year2 = num_ofdayes_months_year2 + 28;
                    }
                } else {
                    num_ofdayes_months_year2 = num_ofdayes_months_year2 + 31;
                }
            }
        }
        return num_ofdayes_months_year1 + num_ofdayes_months_year2;
    }

    public static int calculte_num_of_days(int day_of_fmonth, int day_of_secmonth, int f_month, int sec_month, int f_year, int sec_year) {
        int num_ofdayes_month1 = 0;
        if (f_year == sec_year && f_month == sec_month) {
            return day_of_secmonth - day_of_fmonth;
        } else {
            if (f_month == 4 || f_month == 6 || f_month == 9 || f_month == 11) {
                num_ofdayes_month1 = 30 - day_of_fmonth;
            } else if (f_month == 2) {
                if (((f_year % 4 == 0) && (f_year % 100 != 0)) || (f_year % 400 == 0)) {
                    num_ofdayes_month1 = 29 - day_of_fmonth;
                } else {
                    num_ofdayes_month1 = 28 - day_of_fmonth;
                }
            } else {
                num_ofdayes_month1 = 31 - day_of_fmonth;
            }
        }
        return num_ofdayes_month1 + day_of_secmonth;
    }
}
