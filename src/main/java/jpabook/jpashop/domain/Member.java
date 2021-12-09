package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty // [View + Controller] = presentation 계층에 validation 이 들어가는 것은 권장하지 않음
    private String name;

    @Embedded
    private Address address;

    @JsonIgnore //- presentation layer를 위한 로직이 추가되는 형태이므로 권장하지 않음
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
