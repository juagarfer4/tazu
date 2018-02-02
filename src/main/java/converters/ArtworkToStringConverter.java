package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Artwork;

@Component
@Transactional
public class ArtworkToStringConverter implements Converter<Artwork,String>{

	@Override
	public String convert(Artwork artwork) {
		String result;
		
		if(artwork==null){
			result=null;
		}else{
			result=String.valueOf(artwork.getId());
		}
		return result;
	}

}
