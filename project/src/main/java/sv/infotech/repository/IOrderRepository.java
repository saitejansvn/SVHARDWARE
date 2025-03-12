package sv.infotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sv.infotech.entity.Order;



public interface IOrderRepository extends JpaRepository<Order, Integer> {

	
	public sv.infotech.entity.Order findByOrderId(int int1);

	//public void save(sv.infotech.entity.Order order);
	 
	List<sv.infotech.entity.Order> findByIsOrderDeliverd(String IsOrderDeliverd);
	
//	//query to get all orders
//	@Query(nativeQuery = true,value="select count(*) from order")
//	Integer getAllOrdersCount();
//	
//	//query to count delivered orders
//	@Query(nativeQuery = true, value="select count(*) from order where isOrderDelivered=:#{T(sv.infotech.entity.Constant).DELIVERED}")
//	Integer getDeliveredOrders();
//	
//	//query to count pending orders
//	@Query(nativeQuery = true, value="select count(*) from order where isOrderDelivered=:#{T(sv.infotech.entity.Constant).PENDING}")
//	Integer getPendingOrders();
//	
//	//query to count payments through cash
//	@Query(nativeQuery = true, value = "select count(*) from order where paymentMode=:#{T(sv.infotech.entity.Constant).CASH_MODE}")
//	Integer getCashPayments();
//	
//	//query to count payments through check
//	@Query(nativeQuery = true, value = "select count(*) from order where paymentMode=:#{T(sv.infotech.entity.Constant).INSTRUMENT_MODE}")
//	Integer getInstrumentPayments();
//	
//	//query to count payment through UPI
//	@Query(nativeQuery = true, value = "select count(*) from order where paymentMode=:#{T(sv.infotech.entity.Constant).UPI_MODE}")
//	Integer getUPIPayments();
	
}
