package configMVC.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import configMVC.model.StoricoCasi;
import configMVC.repository.StoricoRepositoryJPA;

@Service
public class storicoService {

	@Autowired
	StoricoRepositoryJPA storicoRepositoryJPA;
	
	public StoricoCasi findByData(Date d) {
	return  storicoRepositoryJPA.findByData(d).get(0);
	}
}
