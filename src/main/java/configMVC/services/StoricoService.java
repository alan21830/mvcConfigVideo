package configMVC.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import configMVC.model.StoricoCasi;
import configMVC.repository.StoricoRepositoryJPA;
import configMVC.repository.StoricoRepositoryPagination;

@Service
public class StoricoService {

	@Autowired
	StoricoRepositoryJPA storicoRepositoryJPA;
	
	@Autowired
	StoricoRepositoryPagination storicoRepositoryPagination;
	
	public StoricoCasi findByData(Date d) {
	return  storicoRepositoryJPA.findByData(d).get(0);
	}
	
	public List<StoricoCasi> findAll()
	{
		return storicoRepositoryJPA.findAll();
	}
	
	public StoricoCasi insCaso(StoricoCasi sc)
	{
		return storicoRepositoryJPA.save(sc);
	}
	
	public List<StoricoCasi> findDistinct()
	{
		return storicoRepositoryJPA.findDistinctAll();
	}
	
	public Page<StoricoCasi> findPageSort (int numero_pagina ,int tot_per_pagina)
	{
		 Pageable pageable = PageRequest.of(numero_pagina , tot_per_pagina,Sort.by("data").ascending());

		return storicoRepositoryPagination.findAll(pageable);
	}
	
	
	
}
