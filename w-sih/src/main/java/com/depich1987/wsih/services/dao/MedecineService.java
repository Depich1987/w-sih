package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSMedecine;
import com.depich1987.wsih.domain.WSStockPile;

public interface MedecineService {

	public long countMedecines();

	public List<WSMedecine> findAllMedecines();

	public WSMedecine findMedecine(Long id);

	public List<WSMedecine> findMedecineEntries(int firstResult, int maxResults);

	public void persist(WSMedecine medecine);

	public void remove(WSMedecine medecine);

	public void flush();

	public void clear();

	public WSMedecine merge(WSMedecine medecine);
	
	public void updateMedecine(WSMedecine medecine);

	public List<WSStockPile> findAllStockPileByMedecine(WSMedecine medecine);

	public WSStockPile findStockPile(Long id);

	public void persist(WSStockPile stockPile);

	public WSStockPile merge(WSStockPile stockPile);

	public void remove(WSStockPile stockPile);

}
