package springboot.namabus.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.namabus.entities.Bus;
import springboot.namabus.service.BusService;

@RestController

@CrossOrigin
@RequestMapping("/api")

public class BusController {
	@Autowired

	private BusService busService;
	private static final Logger logger = LoggerFactory.getLogger(BusController.class);

	@GetMapping("/buses/{id}")
	public Optional<Bus> getBusById(@PathVariable int id) {
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warning message");
		return this.busService.getBusById(id);
	}

	@GetMapping("/buses")

	public ResponseEntity<Bus> getBuses() {
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warning message");
		logger.error("Error message");

		List<Bus> BusImpl = busService.getBuses();
		return new ResponseEntity(BusImpl, HttpStatus.OK);
	}

	@PostMapping("/buses")

	public ResponseEntity<Bus> addBuses(@RequestBody Bus busDAO) {
		Bus busImpl = busService.addBuses(busDAO);

		return new ResponseEntity(busImpl, HttpStatus.CREATED);
	}

	@PutMapping("/buses")

	public ResponseEntity<Bus> updateBuses(@RequestBody Bus bus) {
		Bus busImpl = busService.updateBuses(bus);
		return new ResponseEntity(busImpl, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/buses/{bus_Id}")
	public void deletebusById(@PathVariable int bus_Id) {
		this.busService.deleteBusById(bus_Id);
	}

}
