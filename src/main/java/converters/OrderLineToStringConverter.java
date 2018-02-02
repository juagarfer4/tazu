package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.OrderLine;

@Component
@Transactional
public class OrderLineToStringConverter implements Converter<OrderLine,String>{

	@Override
	public String convert(OrderLine orderLine) {
		String result;
		
		if(orderLine==null){
			result=null;
		}else{
			result=String.valueOf(orderLine.getId());
		}
		return result;
	}

}
