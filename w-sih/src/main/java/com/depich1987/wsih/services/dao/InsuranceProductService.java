package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSInsuranceProduct;

public interface InsuranceProductService {

	public long countInsuranceProducts();

	public List<WSInsuranceProduct> findAllInsuranceProducts();

	public WSInsuranceProduct findInsuranceProduct(Long id);

	public List<WSInsuranceProduct> findInsuranceProductEntries(int firstResult, int maxResults);

	public void persist(WSInsuranceProduct insuranceProduct);

	public void remove(Long id);

	public void update(WSInsuranceProduct insuranceProduct);

	public void flush();

	public void clear();

	public WSInsuranceProduct merge(WSInsuranceProduct insuranceProduct);

}
