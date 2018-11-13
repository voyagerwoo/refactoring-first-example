package vw.study.refactoring;

import org.junit.Test;

import java.sql.SQLOutput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void statement() {
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
}