package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSPricing;

public interface PricingService {

	public long countPricings();

	public List<WSPricing> findAllPricings();

	public WSPricing findPricing(Long id);

	public List<WSPricing> findPricingEntries(int firstResult, int maxResults);

	public void persist(WSPricing pricing);

	public void remove(Long id);

	public void update(WSPricing pricing);

	public void flush();

	public void clear();

	public WSPricing merge(WSPricing pricing);

}
