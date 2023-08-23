package springboot.namabus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import sprinboot.namabus.exception.BusNotFoundException;
import springboot.namabus.dao.BusDAO;
import springboot.namabus.entities.Bus;
import springboot.namabus.exception.BusNotFoundException;

@Service
public class BusServiceImpl implements BusService {
	@Autowired
	private BusDAO busDAO;

	@Override
	public List<Bus> getBuses() {

		return busDAO.findAll();

	}

	@Override
	public Bus addBuses(Bus bus) {

		busDAO.save(bus);

		return bus;

	}

	@Override
	public Optional<Bus> getBusById(int Bus_id) {
		return busDAO.findById(Bus_id);
	}

	@Override
	public Bus updateBuses(Bus bus) {
		busDAO.save(bus);
		return bus;
	}

	@Override
	public String deleteBusById(int bus_Id) throws BusNotFoundException {
		Optional<Bus> bus = busDAO.findById(bus_Id);
		String messsage = null;
		if (bus.isPresent()) {
			busDAO.deleteById(bus_Id);
			messsage = new String("bus deleted succssfully");
		} else {
			throw new BusNotFoundException("no such Bus");
		}

		return messsage;
	}

}
