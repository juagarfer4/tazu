package repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

	@Query("select o from Order o where o.purchaser.userAccount.id=?1 order by o.moment desc")
	Collection<Order> findMyOrders(int userAccount);

	@Query("select o from Order o where o.momentPaid is not null and o.purchaser.userAccount.id=?1 ")
	Order findLastCreatedByPurchaser(int userAccount);
	
	@Query("select o from Order o where o.momentPaid is not null")
	Collection<Order> findMomentPaidIsNotNull();
	
	@Query("select sum(o.totalCost) from Order o where o.moment between ?1 and CURRENT_TIMESTAMP")
	ArrayList<Object> findTotalCostByStartDate(Date start);
	
	@Query("select sum(o.totalCost) from Order o where o.moment <= CURRENT_TIMESTAMP")
	ArrayList<Object> findTotalCost();
	
	@Query("select sum((ol.totalCost*ol.profit)/(ol.profit+100)) from Order o join o.orderLines ol where o.moment between ?1 and CURRENT_TIMESTAMP")
	ArrayList<Object> findProfitByStartDate(Date start);
	
	@Query("select sum((ol.totalCost*ol.profit)/(ol.profit+100)) from Order o join o.orderLines ol where o.moment <= CURRENT_TIMESTAMP")
	ArrayList<Object> findProfit();

}
