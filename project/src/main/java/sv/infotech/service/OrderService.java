package sv.infotech.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import sv.infotech.dto.InstrumentDto;
import sv.infotech.dto.OrderDto;
import sv.infotech.dto.ServiceChargeDto;
import sv.infotech.dto.UPIDto;
import sv.infotech.dto.UserDetailsDto;

public interface OrderService {

	public ResponseEntity<String> CreateOrder(OrderDto orderDto);

	public int findTotalAmount(ServiceChargeDto serviceChargeDto, OrderDto orderDto);
	
	public String paymentMode(OrderDto orderDto, InstrumentDto instrumentDto, UPIDto upiDto);

	public List<OrderDto> getdisplayOrders();

	public OrderDto getOrderDtoById(String id);

	public OrderDto getdeliverOrder();

	public OrderDto getfindTotalAmount();

	public OrderDto getpaymentMode();

	

}
