package repositories;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Artist;
import security.UserAccount;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Integer>{
	
	@Query("select a from Artist a where a.userAccount.id = ?1")
	Artist findArtistByUserAccountId(int userAccountId);
	
	@Query("select a from Customer a where a.userAccount=?1")
	Artist findByUserAccount(UserAccount userAccount);
	
	// The artist with the highest rate
	@Query("select a from Artist a  where a.rating = (select max(a.rating) from Artist a)")
	Collection<Artist> findHighestRateArtists();
	
	// The rating of the artist with the highest rate
	@Query("select max(a.rating) from Artist a")
	Double findNumberHighestRateArtists();

	// The artist who has sold more artworks
	@Query("select a from Artist a join a.artworks art where art.status= domain.Status.SOLD group by art.artist having count(art) >= all (select count(art) from Artist a join a.artworks art where art.status= domain.Status.SOLD group by art.artist)")
	Collection<Artist> findMoreArtworksSoldArtists();
	
	// The artist who has earned more money
	@Query("select a from Artist a join a.artworks art where art.status= domain.Status.SOLD group by art.artist having sum(art.price) >= all (select sum(art.price) from Artist a join a.artworks art where art.status= domain.Status.SOLD group by art.artist)")
	Collection<Artist> findArtistEarnedMoreMoney();
	
	// The quantity of money who has earned the artist who has earned more money
	@Query("select sum(art.price) from Artist a join a.artworks art where art.status= domain.Status.SOLD group by art.artist")
	ArrayList<Object> findQuantityArtistEarnedMoreMoney();

	// The average of rating of a certain Artist
	@Query("select sum(r.rating)*100/(select count(s) from Review s where s.artist.id=?1) from Review r where r.artist.id=?1")
	Double updateAverage(int artistId);

	@Query("select count(a) from Artwork a where a.status=domain.Status.SOLD and a.artist.userAccount.id=?1")
	Integer findNumberArtworkSoldByArtist(int userAccountId);
	
	// Find collection of artist by a keyword
	@Query("select a from Artist a where a.name like %?1% or a.surname like %?1%")
	Collection<Artist> findArtistByKeywork(String keyword);
}