package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
	
	@Query("select p.cart from Purchaser p where p.userAccount.id=?1")
	Cart findMyCart(int idUserAccount);

}
