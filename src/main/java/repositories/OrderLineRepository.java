package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.OrderLine;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine,Integer>{

	@Query("select o.orderLines from Order o where o.id=?1")
	Collection<OrderLine> findOrderLinesOfOrder(int orderId);
	
	@Query("select o.orderLines from Order o where o.purchaser.userAccount.id=?1")
	Collection<OrderLine> findMyOrderLines(int userAccountId);
	
	@Query("select ol.ticker from OrderLine ol where ol.ticker=?1 and ol.order.paid is true")
	Collection<String> findMyArtworksPaid(String ticker);
	
	@Query("select ol from OrderLine ol where ol.ticker=?1 and ol.order.paid is true")
	OrderLine findByTicker(String ticker);

}