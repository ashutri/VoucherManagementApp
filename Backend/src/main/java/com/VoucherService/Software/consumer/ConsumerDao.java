package com.VoucherService.Software.consumer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.VoucherService.Software.generator.Generator;
import com.VoucherService.Software.mapper.ConsumerRowMapper;
import com.VoucherService.Software.mapper.GeneretorRowMapper;

@Service
public class ConsumerDao implements ConsumerDaoInterface{

	@Autowired
	private Generator generator;


	NamedParameterJdbcTemplate template; 
	public ConsumerDao(NamedParameterJdbcTemplate template) {  
		this.template = template;  
	}

	@Override
	public List<Consumer> findAll() {
		return template.query("select * from consumer", new ConsumerRowMapper());
	}




	@Override
	public void updateConsumer(Consumer con) {
		// TODO Auto-generated method stub

	}

	public List<Generator> findConsumer(Long mobile) {
		List<Generator> list=new ArrayList<>();
		List<Consumer> con=template.query("select * from consumer where mobile="+mobile, new ConsumerRowMapper());
		if(con!=null)
		{
			for(int i=0;i<con.size();i++)
			{	
				list=template.query("select * from  generator where voucher_id IN "
						+ "(select voucher_id from consumer where mobile = "+con.get(i).getMobile()+")", new GeneretorRowMapper());
			}
		}
		return list;
	}

	public String redeemId(String voucherId) {
		String res="Voucher is InValid";
		List<Consumer> con=template.query("select * from consumer where voucher_id='"+voucherId+"'", new ConsumerRowMapper());

		if(!con.isEmpty())
			res="Voucher is Redeemed";

		return res;
	}

	@Override
	public void insertConsumer(ConsumerInfo conInfo) {		
		int len=conInfo.getvArray().length;
		for(int i=0;i<len;i++)
		{
			final String sql = "insert into consumer(id, \"mobile\", \"voucher_id\")"
					+ " values(:id,:mobile,:voucherId)";

			KeyHolder holder = new GeneratedKeyHolder();
			SqlParameterSource param = new MapSqlParameterSource()
					.addValue("id", i+1)
					.addValue("mobile", conInfo.getMobile())
					.addValue("voucherId", conInfo.getvArray()[i]);

					template.update(sql,param, holder);
		}

	}


}
