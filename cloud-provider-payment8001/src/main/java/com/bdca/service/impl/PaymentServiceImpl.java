package com.bdca.service.impl;

import com.bdca.dao.PaymentDao;
import com.bdca.entities.Payment;
import com.bdca.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaoqiong on 2021/3/22
 */
@Service
public class PaymentServiceImpl  implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    public int create(Payment payment) {
        System.out.println("*****插入结果："+payment);
        return paymentDao.create(payment);
    }


    public Payment getPaymentById(String id) {
        return paymentDao.getPaymentById(id);
    }

}

