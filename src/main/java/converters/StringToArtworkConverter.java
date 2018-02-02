package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import domain.Artwork;
import repositories.ArtworkRepository;


@Component
@Transactional
public class StringToArtworkConverter implements Converter<String,Artwork>{
	
	@Autowired
	private ArtworkRepository artworkRepository;

	@Override
	public Artwork convert(String text) {
		Artwork result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text)){
				result=null;
			}else{
				id=Integer.valueOf(text);
				result=artworkRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return result;
	
	}

}
