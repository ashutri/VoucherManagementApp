package com.VoucherService.Software.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.VoucherService.Software.consumer.Consumer;
import com.VoucherService.Software.generator.Generator;

public class ConsumerRowMapper implements RowMapper<Consumer> {

	@Override
	public Consumer mapRow(ResultSet rs, int arg1) throws SQLException {
		Consumer con=new Consumer();
		con.setId(rs.getLong("id"));
		con.setMobile(rs.getLong("mobile"));
		con.setVoucherId(rs.getString("voucher_id"));
		return con;
	}
}
