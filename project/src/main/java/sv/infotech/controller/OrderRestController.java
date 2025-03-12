package sv.infotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.infotech.dto.OrderDto;
import sv.infotech.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderRestController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/saveOrder")
	public ResponseEntity<String> saveOrder(@RequestBody OrderDto orderDto) {
		return orderService.CreateOrder(orderDto);
	}

	@GetMapping("/getAllOrderDto")
	public ResponseEntity<List<OrderDto>> getAllOrderDto() {
		List<OrderDto> order = orderService.getdisplayOrders();
		return ResponseEntity.ok(order);
	}

	@PutMapping("/updateOrder")
	public ResponseEntity<String> updateOrder(@RequestBody OrderDto orderDto) {
		return orderService.CreateOrder(orderDto);
	}

}
