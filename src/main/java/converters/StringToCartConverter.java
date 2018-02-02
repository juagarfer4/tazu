package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.CartRepository;
import domain.Cart;


@Component
@Transactional
public class StringToCartConverter implements Converter<String,Cart>{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart convert(String text) {
		Cart result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text)){
				result=null;
			}else{
				id=Integer.valueOf(text);
				result=cartRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return result;
	
	}

}
