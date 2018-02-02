package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Cart;

@Component
@Transactional
public class CartToStringConverter implements Converter<Cart,String>{

	@Override
	public String convert(Cart cart) {
		String result;
		
		if(cart==null){
			result=null;
		}else{
			result=String.valueOf(cart.getId());
		}
		return result;
	}

}
