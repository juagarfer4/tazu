package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.PurchaserRepository;
import domain.Purchaser;


@Component
@Transactional
public class StringToPurchaserConverter implements Converter<String,Purchaser>{
	
	@Autowired
	private PurchaserRepository purchaserRepository;

	@Override
	public Purchaser convert(String text) {
		Purchaser result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text)){
				result=null;
			}else{
				id=Integer.valueOf(text);
				result=purchaserRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return result;
	
	}

}
