package springboot.namabus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import springboot.namabus.entities.Bus;

@Service
public interface BusService {
	public List<Bus> getBuses();

	public Bus addBuses(Bus bus);

	public Bus updateBuses(Bus bus);

	public String deleteBusById(int bus_Id);

	Optional<Bus> getBusById(int Bus_id);

}
