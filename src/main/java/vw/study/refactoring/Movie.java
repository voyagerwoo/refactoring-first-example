package vw.study.refactoring;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        this._title = title;
        this._priceCode = priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int priceCode) {
        this._priceCode = priceCode;
    }

    double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += daysRented * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
        }
        return result;
    }

    int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == NEW_RELEASE) && daysRented > 1)
            return 2;
        return 1;
    }
}
