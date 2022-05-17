package cn.fighter3.serv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 三分恶
 * @Date: 2021/5/18
 * @Description:
 **/
@SpringBootApplication
@MapperScan("cn.fighter3.serv.mapper")
@EnableDiscoveryClient
public class EshopGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopGoodsApplication.class, args);
    }
}
