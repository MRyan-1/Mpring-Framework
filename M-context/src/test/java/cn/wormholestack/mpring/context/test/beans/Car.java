package cn.wormholestack.mpring.context.test.beans;

import cn.wormholestack.mpring.beans.factory.annotation.Component;

/**
 * @description： Car
 * @Author MRyan
 * @Date 2021/9/25 21:03
 * @Version 1.0
 */
@Component
public class Car {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }

}
