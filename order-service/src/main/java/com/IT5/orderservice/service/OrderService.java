package com.IT5.orderservice.service;

import com.IT5.orderservice.dao.OrderDao;
import com.IT5.orderservice.feign.CompanyInterface;
import com.IT5.orderservice.feign.CostumerInterface;
import com.IT5.orderservice.feign.ProductInterface;
import com.IT5.orderservice.model.Order;
import com.IT5.orderservice.model.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductInterface productInterface;

    @Autowired
    CompanyInterface companyInterface;

    @Autowired
    CostumerInterface costumerInterface;

    public ResponseEntity<Integer> create(Integer productId , Integer customerOwnerId, Integer customerId, Integer companyId, Integer companyOwnerId ) {
        Order order = new Order();
        order.setProductId(productId);
        order.setCustomerId(customerId);
        order.setCustomerOwnerId(customerOwnerId);
        order.setCompanyId(companyId);
        order.setCompanyOwnerId(companyOwnerId);
        orderDao.save(order);

        return new ResponseEntity<>(order.getId(), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            return new ResponseEntity<>(orderDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<OrderWrapper>> getOrdersFromId(List<Integer> orderIds) {
        List<OrderWrapper> wrappers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        for(Integer id : orderIds){
            orders.add(orderDao.findById(id).get());
        }
        for(Order order : orders){
            OrderWrapper wrapper = new OrderWrapper();
            wrapper.setId(order.getId());
            wrapper.setProduct(productInterface.getProductFromId(order.getProductId()).getBody());
            if(order.getCompanyId()!=null){
                wrapper.setCompany(companyInterface.getById(order.getCompanyId()).getBody());
            }
            if(order.getCompanyOwnerId()!=null){
                wrapper.setCompanyOwner(companyInterface.getById(order.getCompanyOwnerId()).getBody());
            }
            if(order.getCustomerId()!=null){
                wrapper.setCostumer(costumerInterface.getById(order.getCustomerId()).getBody());
            }
            if(order.getCustomerOwnerId()!=null){
                wrapper.setCostumerOwner(costumerInterface.getById(order.getCustomerOwnerId()).getBody());
            }
            wrappers.add(wrapper);
        }

        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public ResponseEntity<OrderWrapper> getOrderById(Integer id) {
        Order order = orderDao.getById(id);

        OrderWrapper wrapper = new OrderWrapper();
        wrapper.setId(order.getId());
        wrapper.setProduct(productInterface.getProductFromId(order.getId()).getBody());
        wrapper.setCompany(companyInterface.getById(order.getCompanyId()).getBody());
        wrapper.setCompanyOwner(companyInterface.getById(order.getCompanyOwnerId()).getBody());
        wrapper.setCostumer(costumerInterface.getById(order.getCustomerId()).getBody());
        wrapper.setCostumerOwner(costumerInterface.getById(order.getCustomerOwnerId()).getBody());
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

    public ResponseEntity<OrderWrapper> accept(Integer id) {
        Order order = orderDao.getById(id);
        order.setStatus(true);
        orderDao.save(order);
        OrderWrapper wrapper = new OrderWrapper();
        wrapper.setId(order.getId());
        wrapper.setProduct(productInterface.getProductFromId(order.getProductId()).getBody());
        if(order.getCompanyId()!=null){
            wrapper.setCompany(companyInterface.getById(order.getCompanyId()).getBody());
        }
        if(order.getCompanyOwnerId()!=null){
            wrapper.setCompanyOwner(companyInterface.getById(order.getCompanyOwnerId()).getBody());
        }
        if(order.getCustomerId()!=null){
            wrapper.setCostumer(costumerInterface.getById(order.getCustomerId()).getBody());
        }
        if(order.getCustomerOwnerId()!=null){
            wrapper.setCostumerOwner(costumerInterface.getById(order.getCustomerOwnerId()).getBody());
        }
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

    public ResponseEntity<OrderWrapper> reject(Integer id) {
        Order order = orderDao.getById(id);
        order.setStatus(false);
        orderDao.save(order);
        OrderWrapper wrapper = new OrderWrapper();
        wrapper.setId(order.getId());
        wrapper.setProduct(productInterface.getProductFromId(order.getProductId()).getBody());
        if(order.getCompanyId()!=null){
            wrapper.setCompany(companyInterface.getById(order.getCompanyId()).getBody());
        }
        if(order.getCompanyOwnerId()!=null){
            wrapper.setCompanyOwner(companyInterface.getById(order.getCompanyOwnerId()).getBody());
        }
        if(order.getCustomerId()!=null){
            wrapper.setCostumer(costumerInterface.getById(order.getCustomerId()).getBody());
        }
        if(order.getCustomerOwnerId()!=null){
            wrapper.setCostumerOwner(costumerInterface.getById(order.getCustomerOwnerId()).getBody());
        }

        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }



}