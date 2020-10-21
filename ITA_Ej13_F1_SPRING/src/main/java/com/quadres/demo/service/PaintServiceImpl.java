package com.quadres.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quadres.demo.dao.IPaintDAO;
import com.quadres.demo.dto.Paint;


@Service
public class PaintServiceImpl implements IPaintService{

	@Autowired
	IPaintDAO ipaintDAO;
	
	@Override
	public Paint createPaint(Paint paint) {
		return ipaintDAO.save(paint);
	}
	
	@Override
	public List<Paint> selectAllPaints() {
		return ipaintDAO.findAll();
	}
	
	@Override
	public Paint selectPaintById(long id) {
		return ipaintDAO.findById(id).get();
	}
	
	public List<Paint> selectPaintsShop (Long id) {
		return ipaintDAO.findByShopId(id);
	}

	@Override
	public Paint updatePaint(Paint paint) {
		return ipaintDAO.save(paint);
	}

	@Override
	public void deletePaint(Long id) {
		ipaintDAO.deleteById(id);
	}

	@Override
	public void deletePaintsShop(Long id) {
		
		List<Paint> paintsToDelete = ipaintDAO.findByShopId(id);
		
		for (Paint iter : paintsToDelete) {
			ipaintDAO.deleteById(iter.getId());
		}
	
	}
	
}
