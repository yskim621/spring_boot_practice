package jpabook.jpashop.domain;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // 값 타입은 변경 불가능하도록 설계하므로 생성 시 갑 초기화만 가능
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    // JPA 스팩상 사용을 위해 생성 - 실제로 개발자가 사용을 위해 생성해둔 것은 아님
    protected Address() {

    }
}
