package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Purchaser;

@Repository
public interface PurchaserRepository extends JpaRepository<Purchaser,Integer>{
	// The purchaser who has spent more money
	@Query("select o.purchaser.name,sum(o.totalCost) from Order o group by o.purchaser	having sum(o.totalCost) >= all(select sum(o.totalCost) from Order o group by o.purchaser)")
	Collection<Object> findPurchaserSpendMoreMoney();
	
	// The purchaser who has purchased more artworks. 
	@Query("select o.purchaser from Order o group by o.purchaser having sum(o.orderLines.size) >= all(select sum(o.orderLines.size) from Order o group by o.purchaser) ")
	Collection<Purchaser> findPurchaserMoreArtworkBought();

	@Query("select p from Purchaser p where p.userAccount.id = ?1")
	Purchaser findOneByUserId(int userAccount);
		
	
}