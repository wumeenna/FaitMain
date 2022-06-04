package com.faitmain.domain.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faitmain.domain.product.domain.Cart;
import com.faitmain.domain.product.mapper.CartMapper;

import lombok.RequiredArgsConstructor;

@Service("cartServiceImpl")
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	
	public CartServiceImpl(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}
	
	@Override
	public void addCart(Cart cart) throws Exception {
		cartMapper.addCart(cart);
	}

	@Override
	public List<Cart> getCartList(Map<String, String> map) throws Exception {
		List<Cart> list = cartMapper.getCartList(map);		
		return list;
	}

	@Override
	public void updateCart(Cart cart) throws Exception {
		cartMapper.updateCart(cart);		
	}

	@Override
	public void deleteCart(int cartNumber) throws Exception {
		cartMapper.deleteCart(cartNumber);		
	}
	
}