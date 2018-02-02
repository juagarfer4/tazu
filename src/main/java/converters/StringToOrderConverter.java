package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.OrderRepository;
import domain.Order;


@Component
@Transactional
public class StringToOrderConverter implements Converter<String,Order>{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order convert(String text) {
		Order result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text)){
				result=null;
			}else{
				id=Integer.valueOf(text);
				result=orderRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return result;
	
	}

}
