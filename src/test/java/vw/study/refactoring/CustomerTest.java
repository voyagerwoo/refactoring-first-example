package vw.study.refactoring;

import org.junit.Test;

import java.sql.SQLOutput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void statement_no_rented() {
        //given
        Customer customer = new Customer("홍길동");
        //when
        String statement = customer.statement();

        //then
        System.out.println(statement);
        assertThat(statement, is("홍길동 고객님의 대여 기록\n누적 대여료: 0.0\n적립 포인트: 0"));
    }

    @Test
    public void statement_1() {
        //given
        Movie movie1 = new Movie("가디언즈 오브 갤럭시 1", Movie.REGULAR);
        Movie movie4 = new Movie("상어가족", Movie.CHILDRENS);

        Customer customer = new Customer("홍길동");
        customer.addRental(new Rental(movie1, 1));
        customer.addRental(new Rental(movie4, 1));
        //when
        String statement = customer.statement();

        //then
        System.out.println(statement);
        assertThat(statement, is("홍길동 고객님의 대여 기록\n\t" +
                "가디언즈 오브 갤럭시 1\t2.0\n\t" +
                "상어가족\t1.5\n누적 대여료: 3.5\n적립 포인트: 2"));
    }

    @Test
    public void statement_2() {
        //given
        Movie movie1 = new Movie("가디언즈 오브 갤럭시 1", Movie.REGULAR);
        Movie movie4 = new Movie("상어가족", Movie.CHILDRENS);

        Customer customer = new Customer("홍길동");
        customer.addRental(new Rental(movie1, 3));
        customer.addRental(new Rental(movie4, 4));
        //when
        String statement = customer.statement();

        //then
        System.out.println(statement);
        assertThat(statement, is("홍길동 고객님의 대여 기록\n\t" +
                "가디언즈 오브 갤럭시 1\t3.5\n\t" +
                "상어가족\t3.0\n누적 대여료: 6.5\n적립 포인트: 2"));
    }

    @Test
    public void statement_3() {
        //given
        Movie movie1 = new Movie("가디언즈 오브 갤럭시 1", Movie.REGULAR);
        Movie movie2 = new Movie("가디언즈 오브 갤럭시 2", Movie.REGULAR);
        Movie movie3 = new Movie("서치", Movie.NEW_RELEASE);
        Movie movie4 = new Movie("상어가족", Movie.CHILDRENS);

        Customer customer = new Customer("홍길동");
        customer.addRental(new Rental(movie1, 2));
        customer.addRental(new Rental(movie2, 5));
        customer.addRental(new Rental(movie3, 1));
        customer.addRental(new Rental(movie4, 5));
        //when
        String statement = customer.statement();

        //then
        System.out.println(statement);
        assertThat(statement, is("홍길동 고객님의 대여 기록\n\t" +
                "가디언즈 오브 갤럭시 1\t2.0\n\t가디언즈 오브 갤럭시 2\t6.5\n\t서치\t3.0\n\t상어가족\t4.5\n" +
                "누적 대여료: 16.0\n적립 포인트: 4"));
    }

    @Test
    public void htmlStatement_no_rented() {
        //given
        Customer customer = new Customer("홍길동");
        //when
        String htmlStatement = customer.htmlStatement();

        //then
        System.out.println(htmlStatement);
        assertThat(htmlStatement, is("<h1>홍길동 고객님의 대여 기록</h1><p>\n<p>누적 대여료: <em>0.0</em><p>\n<p>적립 포인트: <em>0</em><p>"));
    }

    @Test
    public void htmlStatement_1() {
        //given
        Movie movie1 = new Movie("가디언즈 오브 갤럭시 1", Movie.REGULAR);
        Movie movie4 = new Movie("상어가족", Movie.CHILDRENS);

        Customer customer = new Customer("홍길동");
        customer.addRental(new Rental(movie1, 1));
        customer.addRental(new Rental(movie4, 1));
        //when
        String htmlStatement = customer.htmlStatement();

        //then
        System.out.println(htmlStatement);
        assertThat(htmlStatement, is("<h1>홍길동 고객님의 대여 기록</h1><p>\n" +
                "가디언즈 오브 갤럭시 1: 2.0<br>\n" +
                "상어가족: 1.5<br>\n" +
                "<p>누적 대여료: <em>3.5</em>" +
                "<p>\n<p>적립 포인트: <em>2</em><p>"));
    }

    @Test
    public void htmlStatement_2() {
        //given
        Movie movie1 = new Movie("가디언즈 오브 갤럭시 1", Movie.REGULAR);
        Movie movie4 = new Movie("상어가족", Movie.CHILDRENS);

        Customer customer = new Customer("홍길동");
        customer.addRental(new Rental(movie1, 3));
        customer.addRental(new Rental(movie4, 4));
        //when
        String htmlStatement = customer.htmlStatement();

        //then
        System.out.println(htmlStatement);
        assertThat(htmlStatement, is("<h1>홍길동 고객님의 대여 기록</h1><p>\n" +
                "가디언즈 오브 갤럭시 1: 3.5<br>\n" +
                "상어가족: 3.0<br>\n" +
                "<p>누적 대여료: <em>6.5</em><p>\n" +
                "<p>적립 포인트: <em>2</em><p>"));
    }

    @Test
    public void htmlStatement_3() {
        //given
        Movie movie1 = new Movie("가디언즈 오브 갤럭시 1", Movie.REGULAR);
        Movie movie2 = new Movie("가디언즈 오브 갤럭시 2", Movie.REGULAR);
        Movie movie3 = new Movie("서치", Movie.NEW_RELEASE);
        Movie movie4 = new Movie("상어가족", Movie.CHILDRENS);

        Customer customer = new Customer("홍길동");
        customer.addRental(new Rental(movie1, 2));
        customer.addRental(new Rental(movie2, 5));
        customer.addRental(new Rental(movie3, 1));
        customer.addRental(new Rental(movie4, 5));
        //when
        String htmlStatement = customer.htmlStatement();

        //then
        System.out.println(htmlStatement);
        assertThat(htmlStatement, is("<h1>홍길동 고객님의 대여 기록</h1><p>\n" +
                "가디언즈 오브 갤럭시 1: 2.0<br>\n" +
                "가디언즈 오브 갤럭시 2: 6.5<br>\n" +
                "서치: 3.0<br>\n" +
                "상어가족: 4.5<br>\n" +
                "<p>누적 대여료: <em>16.0</em><p>\n" +
                "<p>적립 포인트: <em>4</em><p>"));
    }
}