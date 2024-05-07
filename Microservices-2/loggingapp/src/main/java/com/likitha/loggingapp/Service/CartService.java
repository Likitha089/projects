package com.likitha.loggingapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.likitha.loggingapp.Model.Cart;
import com.likitha.loggingapp.Model.ResponseMessage;
import com.likitha.loggingapp.Repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ResponseMessage responseMessage;

    public ResponseEntity<ResponseMessage> addToCartService(Cart cartItem) {
        cartRepository.save(cartItem);

        responseMessage.setSuccess(true);
        responseMessage.setMessage("Item added to cart");

        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);

    }

    public List<Cart> getItemFromCart(int userId) {
        return cartRepository.findByUserId(userId);
    }
}
