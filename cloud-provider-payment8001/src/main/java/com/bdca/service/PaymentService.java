package com.bdca.service;

import com.bdca.entities.Payment;

import org.apache.ibatis.annotations.Param;

/**
 * Created by gaoqiong on 2021/3/22
 */

public interface PaymentService {
    public int create(Payment payment);

    public Payment  getPaymentById(@Param("id")String id);
}
