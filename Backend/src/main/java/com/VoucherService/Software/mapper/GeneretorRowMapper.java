package com.VoucherService.Software.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.VoucherService.Software.generator.Generator;

public class GeneretorRowMapper implements RowMapper<Generator> {

	@Override
	public Generator mapRow(ResultSet rs, int arg1) throws SQLException {
		Generator gen=new Generator();
		gen.setVoucherId(rs.getString("voucher_id"));
		gen.setFaceValue(rs.getLong("face_value"));
		gen.setStartDate(rs.getDate("start_date"));
		gen.setExpiryDate(rs.getDate("expiry_date"));
		gen.setRedeemed(rs.getBoolean("redeemed"));
		return gen;
	}
}
