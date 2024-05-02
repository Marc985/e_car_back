package com.codinftitans.backend.service;

import com.codinftitans.backend.model.Mail;
import com.codinftitans.backend.model.Order;
import com.codinftitans.backend.model.Product;
import com.codinftitans.backend.repository.ChocolateRepository;
import com.codinftitans.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
@Autowired
    MailService mailService;
    @Autowired
    ChocolateRepository chocolateRepository;
    public Order save(Order toSave){
        Optional<Product> chocolatOpt=chocolateRepository.findById(toSave.getIdProduct());
        Product chocolat=chocolatOpt.get();
        mailService.sendMessage(toSave.getClientEmail(),"achat", String.valueOf(chocolat.getNom()+" "+chocolat.getDescription()+"\n"+"https://codinftitans-backend-vmod4mzmzq-uc.a.run.app/order/status?email="+toSave.getClientEmail()));
        return orderRepository.save(toSave);
    }
    public List<Order> findAll(){
        return orderRepository.findAll();
    }


    public Optional<Order> getOne(int id){
        return orderRepository.findById(id);
    }
}
