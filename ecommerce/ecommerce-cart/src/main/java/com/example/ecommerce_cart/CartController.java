package com.example.ecommerce_cart;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private List<CartItem> cart = new ArrayList<>();

    @GetMapping
    public List<CartItem> getCart() {
        return cart;
    }

    @PostMapping
    public void addItem(@RequestBody CartItem item) {
        cart.add(item);
    }

    @DeleteMapping("/{id}")
    public void removeItem(@PathVariable long id) {
        cart.removeIf(item -> item.getId() == id);
    }
}
