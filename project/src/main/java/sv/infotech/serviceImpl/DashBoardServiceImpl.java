package sv.infotech.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.infotech.repository.IOrderRepository;
import sv.infotech.service.DashBoardService;

@Service
public  class DashBoardServiceImpl implements DashBoardService{

	@Autowired
	private IOrderRepository orderRepository;

//	public int AllOrdersCount() {
//		int response = orderRepository.getAllOrdersCount();
//		return response;
//	}
//
//	public int deliveredOrders() {
//		int response = orderRepository.getDeliveredOrders();
//		return response;
//	}
//
//	public int pendingOrders() {
//		int response = orderRepository.getPendingOrders();
//		return response;
//	}
//
//	public int cashPayments() {
//		int response = orderRepository.getCashPayments();
//		return response;
//	}
//
//	public int instrumentPaymenst() {
//		int response = orderRepository.getInstrumentPayments();
//		return response;
//	}
//
//	public int upiPayments() {
//		int response = orderRepository.getUPIPayments();
//		return response;
//	}
}
