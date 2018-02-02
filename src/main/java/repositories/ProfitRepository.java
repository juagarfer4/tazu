package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Profit;

@Repository
public interface ProfitRepository extends JpaRepository<Profit,Integer>{

	@Query("select f from Profit f where f.lowerLimit<=?1 and f.upperLimit>=?1")
	Profit findProfitByNumberSales(int numberSales);
	
}