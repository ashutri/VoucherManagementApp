package com.VoucherService.Software.generator;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.VoucherService.Software.mapper.GeneretorRowMapper;

@Service
public class GeneratorDao implements GeneratorDaoInterface{

	@Autowired
	private Generator generator;

	private String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "0123456789"
			+ "abcdefghijklmnopqrstuvxyz"; 
	NamedParameterJdbcTemplate template; 
	public GeneratorDao(NamedParameterJdbcTemplate template) {  
		this.template = template;  
	}

	@Override
	public List<Generator> findAll() {
		long millis=System.currentTimeMillis();  
		Date current=new Date(millis);
		return template.query("select * from generator where expiry_date > '"+current+"' and redeemed=false", new GeneretorRowMapper());
	}

	@Override
	public Generator insertGenerator(Generator gen) {


		final String sql = "insert into generator(\"voucher_id\", \"face_value\", \"start_date\", \"expiry_date\", redeemed)"
				+ " values(:voucherId,:faceValue,:startDate,:endDate,:redeemed)";

		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("voucherId", gen.getVoucherId())
				.addValue("faceValue", gen.getFaceValue())
				.addValue("startDate", gen.getStartDate())
				.addValue("endDate", gen.getExpiryDate())
				.addValue("redeemed", gen.isRedeemed());
		template.update(sql,param, holder);
		return gen;
	}

	public void createVouchers(int number)
	{
		for(int j=1;j<=number;j++)
		{
			int n=8;
			StringBuilder sb = new StringBuilder(n);
			for (int i = 0; i < n; i++) {     		  
				int index = (int)(AlphaNumericString.length() 
						* Math.random());    
				sb.append(AlphaNumericString 
						.charAt(index)); 
			} 

			long millis=System.currentTimeMillis();  
			Date startDate=new Date(millis);
			Date expiryDate=new Date(startDate.getYear(), startDate.getMonth()+j, startDate.getDate());
			Long amount=(long) (500*j);
			boolean redeemed=false;

			generator.setVoucherId(sb.toString());
			generator.setFaceValue(amount);
			generator.setStartDate(startDate);
			generator.setExpiryDate(expiryDate);
			generator.setRedeemed(redeemed);
			
			insertGenerator(generator);
		}
	}

	@Override
	public void updateGenerator(Generator gen) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGenerator(int id) {
		// TODO Auto-generated method stub

	}


}
