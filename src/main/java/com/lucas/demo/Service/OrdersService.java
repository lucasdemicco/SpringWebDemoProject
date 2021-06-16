package com.lucas.demo.Service;

import com.lucas.demo.Entities.Orders;
import com.lucas.demo.Repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> findAll(){
        return ordersRepository.findAll();
    }

    public Orders findById(Long id){
        Optional<Orders> obj = ordersRepository.findById(id);
        return obj.get();
    }
}
