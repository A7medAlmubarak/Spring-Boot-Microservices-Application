package com.IT5.costumerservice.feign;

import com.IT5.costumerservice.model.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("ORDER-SERVICE")

public interface OrderInterface {

    @PostMapping("order/create")
    public ResponseEntity<Integer> create(@RequestBody OrderDto orderDto);

    @GetMapping("order/getOrders")
    public ResponseEntity<List<Object>> getOrdersFromId(@RequestBody List<Integer> ordersIds);

}
