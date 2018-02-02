package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Purchaser;

@Component
@Transactional
public class PurchaserToStringConverter implements Converter<Purchaser,String>{

	@Override
	public String convert(Purchaser purchaser) {
		String result;
		
		if(purchaser==null){
			result=null;
		}else{
			result=String.valueOf(purchaser.getId());
		}
		return result;
	}

}
