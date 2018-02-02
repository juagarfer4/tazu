package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.ReviewRepository;
import domain.Review;


@Component
@Transactional
public class StringToReviewConverter implements Converter<String,Review>{
	
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public Review convert(String text) {
		Review result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text)){
				result=null;
			}else{
				id=Integer.valueOf(text);
				result=reviewRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return result;
	
	}

}
