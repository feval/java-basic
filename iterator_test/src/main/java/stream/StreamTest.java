package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/25 19:32
 */

class Order{
    private String tittle;
    private Double price;
    private Integer count;

    public Order(String tittle, Double price, Integer count) {
        this.tittle = tittle;
        this.price = price;
        this.count = count;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

public class StreamTest {
    public static void main(String[] args) {
/*        List<String> list=new ArrayList<>();
        Collections.addAll(list,"java","python","javaScript");
        List<String> result=list.stream().filter(e->e.contains("java")).collect(Collectors.toList());
        System.out.println(result);*/
//        System.out.println(list.stream().filter((e)->e.contains("java")).count());
        List<Order> list=new ArrayList<>();
        list.add(new Order("1",6.0,100));
        list.add(new Order("2",6.0,100));
        list.add(new Order("3",6.0,100));
        Double alldouble = list.stream().map((e) -> e.getCount() * e.getPrice()).reduce((sum, x) -> sum + x).get();
        System.out.println(alldouble);
    }
}
