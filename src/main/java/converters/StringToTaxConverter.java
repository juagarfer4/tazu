package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.TaxRepository;
import domain.Tax;


@Component
@Transactional
public class StringToTaxConverter implements Converter<String,Tax>{
	
	@Autowired
	private TaxRepository taxRepository;

	@Override
	public Tax convert(String text) {
		Tax result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text)){
				result=null;
			}else{
				id=Integer.valueOf(text);
				result=taxRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return result;
	
	}

}
