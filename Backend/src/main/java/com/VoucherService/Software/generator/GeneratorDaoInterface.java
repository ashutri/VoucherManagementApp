package com.VoucherService.Software.generator;

import java.util.List;

public interface GeneratorDaoInterface {

	List<Generator> findAll();
	Generator insertGenerator(Generator gen);
	void updateGenerator(Generator gen);
	public void deleteGenerator(int id);

}
