package com.stevens.spring.security_jwt.util;

import java.util.List;
import java.util.function.Function;

public interface GenericsExampleForMethod {

    String getString();

    Integer getInt();
}


class MainClass {
    //Generics
    public <T extends Number, Y, M, A, R> T execute(List<T> list) {
        return list.get(0);
    }


    public static void main(String[] args) {
        MainClass cl = new MainClass();


        System.out.println(cl.getResult(GenericsExampleForMethod::getString));
        System.out.println(cl.getResult(GenericsExampleForMethod::getInt));

    }

    public <T> T getResult(Function<GenericsExampleForMethod, T> function) {
        return function.apply(getImpl());
    }


    public GenericsExampleForMethod getImpl() {
        return new GenericsExampleForMethod() {
            @Override
            public String getString() {
                return "Abhishek";
            }

            @Override
            public Integer getInt() {
                return 17838;
            }
        };
    }

}
