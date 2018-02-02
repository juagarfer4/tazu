package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Review;

@Component
@Transactional
public class ReviewToStringConverter implements Converter<Review,String>{

	@Override
	public String convert(Review review) {
		String result;
		
		if(review==null){
			result=null;
		}else{
			result=String.valueOf(review.getId());
		}
		return result;
	}

}
