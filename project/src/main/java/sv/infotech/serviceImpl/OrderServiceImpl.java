package sv.infotech.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sv.infotech.dto.InstrumentDto;
import sv.infotech.dto.OrderDto;
import sv.infotech.dto.ServiceChargeDto;
import sv.infotech.dto.UPIDto;
import sv.infotech.entity.Constant;
import sv.infotech.entity.Instrument;
import sv.infotech.entity.Order;
import sv.infotech.entity.Upi;
import sv.infotech.mailSender.AppMailSender;
import sv.infotech.repository.IOrderRepository;
import sv.infotech.repository.InstrumentRepository;
import sv.infotech.repository.IupiRepository;
import sv.infotech.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	// Auto wiring Repository
	@Autowired
	private AppMailSender appMailSender;

	@Autowired
	private IOrderRepository orderRepository;

	@Autowired
	private IupiRepository iupiRepository;

	@Autowired
	private InstrumentRepository instrumentRepository;

	// Create Order

	public ResponseEntity<String> CreateOrder(OrderDto orderDto) {
		String response = null;

		if (orderDto != null) {
			Order order = null;

			if (orderDto.getOrderId() != null) {
				order = orderRepository.findByOrderId(Integer.parseInt(orderDto.getOrderId()));
				// update order
				if (order != null) {
					order.setOrderId(Integer.parseInt(orderDto.getOrderId()));
					order.setTypeOfOperation(orderDto.getTypeOfOperation());
					order.setServiceFor(orderDto.getServiceFor());
					order.setComplaint(orderDto.getComplaint());
					order.setProblemDescription(orderDto.getProblemDescription());
					order.setPaymentMode(paymentMode(orderDto, null, null));
					order.setOnService("Y");
					order.setIsOrderDeliverd("N");
				}
				orderRepository.save(order);
				response = "Order updated";
				
			} else {
				// creating order
				order = new Order();
				order.setTypeOfOperation(orderDto.getTypeOfOperation());
				order.setServiceFor(orderDto.getServiceFor());
				order.setComplaint(orderDto.getComplaint());
				order.setProblemDescription(orderDto.getProblemDescription());
				order.setTotalAmount(findTotalAmount(null, null));
				order.setPaymentMode(paymentMode(orderDto, null, null));
				order.setAdvanceAmount(orderDto.getAdvanceAmount());
				order.setBalanceAmount(orderDto.getBalanceAmount());
				order.setOnService("Y");
				order.setIsOrderDeliverd("N");

				orderRepository.save(order);
				response = "Order created";

				//appMailSender.sendOrderEmail(new CustomerDto(),new FileSystemResource(new File(response)) ,response);
			}

			
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// displaying the order which are note delivered

	public ResponseEntity<List<OrderDto>> displayOrders() {

		List<Order> order = orderRepository.findByIsOrderDeliverd("N");
		List<OrderDto> orderDto = new ArrayList<>();

		for (Order order1 : order) {
			OrderDto orderDto2 = new OrderDto();
			orderDto2.setOrderId(Integer.toString(order1.getOrderId()));
			orderDto2.setTypeOfOperation(order1.getTypeOfOperation());
			orderDto2.setTypeOfProblem(order1.getTypeOfProblem());
			orderDto2.setComplaint(order1.getComplaint());
			orderDto2.setProblemDescription(order1.getProblemDescription());
			orderDto2.setTotalAmount(order1.getTotalAmount());
			orderDto2.setPaymentMode(order1.getPaymentMode());
			orderDto.add(orderDto2);
		}
		return new ResponseEntity<>(orderDto, HttpStatus.OK);

	}

	// delivering orders
	public String deliverOrder(OrderDto orderDto) {
		String response = null;
		Order order = orderRepository.findByOrderId(Integer.parseInt(orderDto.getOrderId()));
		if (order != null && "N".equals(order.getIsOrderDeliverd())) {

			order.setOnService("N");
			order.setIsOrderDeliverd("Y");

			orderRepository.save(order);

			response = "User deleted Succesfully";
		}
		return response;
	}

	// Finding totalAmount for a service

	public int findTotalAmount(ServiceChargeDto serviceChargeDto, OrderDto orderDto) {
		//ServiceCharge serviceCharge = new ServiceCharge();
		Order order = new Order();
		order = orderRepository.findByOrderId(Integer.parseInt(orderDto.getOrderId()));
		String response = null;
		int totalCharge = 0;

		// setting totalCharge value
		if (orderDto.getServiceFor().equals(Constant.SERVICE_FOR_OS)) {
			totalCharge = serviceChargeDto.getOperatingSystem();
		} else if (orderDto.getServiceFor().equals(Constant.SERVICE_FOR_HARDWARE)) {
			totalCharge = serviceChargeDto.getHardware();
		} else if (orderDto.getServiceFor().equals(Constant.SERVICE_FOR_DESKTOP)) {
			totalCharge = serviceChargeDto.getDesktop();
		} else if (orderDto.getServiceFor().equals(Constant.SERVICE_FOR_LAPTOP)) {
			totalCharge = serviceChargeDto.getLaptop();
		} else {
			response = "Choose a service";
		}

		return totalCharge;
	}

	// Payment mode

	public String paymentMode(OrderDto orderDto, InstrumentDto instrumentDto, UPIDto upiDto) {

		Order order = new Order();
		String response = null;

		int payMode = 0;

		if (orderDto.getPaymentMode().equals(Constant.CASH_MODE)) {
			payMode = 1;
		} else if (orderDto.getPaymentMode().equals(Constant.INSTRUMENT_MODE)) {
			payMode = 2;
		} else if (orderDto.getPaymentMode().equals(Constant.UPI_MODE)) {
			payMode = 3;
		} else {
			response = "Choose a payment mode";
		}

		// access corresponding paymentMode
		switch (payMode) {
		// cash mode
		case 1:
			response = "cash received";
			break;
		// Instrument mode
		case 2:
			if (instrumentDto != null) {
				Instrument instrument = new Instrument();

				if (instrumentDto.getInstrumentId() != null) {

					instrument.setChequeNumber(instrumentDto.getChequeNumber());
					instrument.setBankName(instrumentDto.getBankName());
					instrument.setBankBranch(instrumentDto.getBankBranch());
					instrument.setPaymentStatus(instrumentDto.getPaymentStatus());
					instrumentRepository.save(instrument);

					response = "payment through check is successfully paid";
				} else {
					response = "InstrumentId not found";
				}
			}

			break;

		// UPI mode
		case 3:
			if (upiDto != null) {
				Upi upi = new Upi();
				if (upiDto.getUpiId() != null) {

					upi.setTransactionId(upiDto.getTransactionId());
					upi.setTransactionDate(upiDto.getTransactionDate());
					upi.setTransactionStatus(upiDto.getTransactionStatus());
					iupiRepository.save(upi);

					response = "payment through UPI is successfully paid";
				} else {
					response = "UpiId not found";
				}
			}

			break;
		default:
			response = "Invalid payment mode";
			break;
		}

		return null;
	}

	@Override
	public List<OrderDto> getdisplayOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDto getOrderDtoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDto getdeliverOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDto getfindTotalAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDto getpaymentMode() {
		// TODO Auto-generated method stub
		return null;
	}

}