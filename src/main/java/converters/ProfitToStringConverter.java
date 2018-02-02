package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Profit;

@Component
@Transactional
public class ProfitToStringConverter implements Converter<Profit,String>{

	@Override
	public String convert(Profit profit) {
		String result;
		
		if(profit==null){
			result=null;
		}else{
			result=String.valueOf(profit.getId());
		}
		return result;
	}

}
