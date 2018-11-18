package vw.study.refactoring;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        this._name = name;
    }

    public String statement() {
        String result = _name + " 고객님의 대여 기록\n";
        Enumeration rentals = _rentals.elements();

        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        //푸터 행 추가
        result += "누적 대여료: " + String.valueOf(getTotalCharge()) + "\n";
        result += "적립 포인트: " + String.valueOf(getTotalFrequentRenterPoints());
        return result;
    }

    public String htmlStatement() {
        String result = "<h1>"+ _name + " 고객님의 대여 기록</h1><p>\n";
        Enumeration rentals = _rentals.elements();

        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<br>\n";
        }

        //푸터 행 추가
        result += "<p>누적 대여료: <em>" + String.valueOf(getTotalCharge()) + "</em><p>\n";
        result += "<p>적립 포인트: <em>" + String.valueOf(getTotalFrequentRenterPoints()) + "</em><p>";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    public String getName() {
        return _name;
    }

    public void addRental(Rental rental) {
        _rentals.addElement(rental);
    }
}
