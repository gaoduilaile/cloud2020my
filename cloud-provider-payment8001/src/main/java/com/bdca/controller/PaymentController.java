package com.bdca.controller;

import com.bdca.entities.CommonResult;
import com.bdca.entities.Payment;
import com.bdca.service.PaymentService;
import com.bdca.util.IdWorker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by gaoqiong on 2021/3/22
 */

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private IdWorker idWorker;

    @RequestMapping(value = "/payment/create", method = RequestMethod.POST)
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        payment.setId(idWorker.nextId()+"");
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        // 判断是否插入成功
        if (result > 0) {
            return new CommonResult(200, "插入数据成功", result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @RequestMapping(value = "/payment/get/{id}", method = RequestMethod.GET)
    public CommonResult getPaymentById(@PathVariable("id") String id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果：" + payment);
        int a = 8 / 2;
        log.info(a + "" + 12345);
        // 判断是否插入成功
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "没有对应记录", null);
        }
    }

}
