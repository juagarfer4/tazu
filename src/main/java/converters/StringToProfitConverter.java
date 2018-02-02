package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.ProfitRepository;
import domain.Profit;


@Component
@Transactional
public class StringToProfitConverter implements Converter<String,Profit>{
	
	@Autowired
	private ProfitRepository profitRepository;

	@Override
	public Profit convert(String text) {
		Profit result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text)){
				result=null;
			}else{
				id=Integer.valueOf(text);
				result=profitRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return result;
	
	}

}
