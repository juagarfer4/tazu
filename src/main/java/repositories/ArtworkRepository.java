package repositories;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Artwork;
import domain.Status;

@Repository
public interface ArtworkRepository extends JpaRepository<Artwork,Integer>{
	
	
	@Query("select a from Artwork a where a.ticker = ?1")
	Artwork findArtworkByTicker(String ticker);
		
	// The artwork with the highest price that has not been sold yet
	@Query("select a from domain.Artwork a where a.price=(select max(p.price) from domain.Artwork p where p.status=domain.Status.SALE)")
	Collection<Artwork> findMostExpensiveOnSale();
	
	@Query("select p from domain.Artwork p where p.status=domain.Status.SALE and p.deleted = FALSE")
	Collection<Artwork> findArtworkOnSale();
	
	@Query(value="select * from artwork where status = 0 order by moment desc limit 5 ",nativeQuery=true)
	Collection<Artwork> findArtworkOnSaleLimit();
	
	@Query("select a from Artwork a where a.artist.id = ?1 and a.deleted = FALSE")
	Collection<Artwork> findByArtist(int artistId);
	
	@Query("select a from Artwork a where a.deleted = FALSE")
	Collection<Artwork> findAllNotDeleted();

	// Artwork that contains the given keyword in its title discipline tags
	@Query("select distinct(a) from Artwork a where a.deleted = FALSE and a.status = domain.Status.SALE and (a.title like concat(concat('%', ?1), '%') or a.discipline like concat(concat('%', ?1), '%') or a.tags like concat(concat('%', ?1), '%'))")
	Collection<Artwork> findByKeywordService(String keyword);

	@Query("select a from Artwork a join a.carts c where c.id = ?1 and a.status=domain.Status.SALE")
	Collection<Artwork> findArtWorkInCart(int cartId);

	@Query("select a.ticker from Artwork a where a.status=domain.Status.SOLD and a.artist.userAccount.id=?1")
	Collection<String> findTickerOfArtworkSold(int userAccountId);

	
	@Query("select a from Artwork a where a.ticker = ?1")
	Artwork findByTicker(String ticker);

	@Query("select a.status from Artwork a where a.id =?1")
	Status findStatus(int artworkId);

	@Query("select count(a) from Artwork a join a.carts c where a.status =domain.Status.SALE and c.id=?1")
	Integer findArtworkNotSoldInCart(int cartId);

	@Query("select count(a) from Artwork a where a.artist.id = ?1 and a.status=domain.Status.SALE")
	Integer findNumberOfSalesByArtist(int artistId);

	@Query("select c.artworks from Cart c where c.id = ?1")
	Collection<Artwork> findArtWorkInCartAlthoughArtworkIsSold(int id);
	
	@Query("select a from Artwork a where a.status=domain.Status.SALE and a.deleted = FALSE and a.artist.id = ?1")
	Collection<Artwork> findByArtistIdOnSale(int artistId);

	
	
}