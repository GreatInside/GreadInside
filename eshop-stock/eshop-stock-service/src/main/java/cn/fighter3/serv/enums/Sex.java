package cn.fighter3.serv.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum Sex {

    MALE(1,"男"),
    FEMALE(2,"女");

    @EnumValue
    private final Integer sex;
    private final String sexName;

    Sex(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
