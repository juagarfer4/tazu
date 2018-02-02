package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import domain.Artist;
import repositories.ArtistRepository;


@Component
@Transactional
public class StringToArtistConverter implements Converter<String,Artist>{
	
	@Autowired
	private ArtistRepository artistRepository;

	@Override
	public Artist convert(String text) {
		Artist result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text)){
				result=null;
			}else{
				id=Integer.valueOf(text);
				result=artistRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return result;
	
	}

}
