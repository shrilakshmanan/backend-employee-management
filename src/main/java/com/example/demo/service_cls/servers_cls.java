package com.example.demo.service_cls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.Repost_cls;
import com.example.demo.MODEL.jva_clas;
import com.example.demo.MODEL.pojo_cls;

@Service
public class servers_cls  {

	@Autowired 
	private Repost_cls repo;
	
	public List < pojo_cls > getAlluser() {
		
        return repo.findAll();
       
	}
	

	
	public void deleteById(int id) {
		repo.deleteById(id);
		
	}

	public pojo_cls getById(int id) 
	{
		Optional<pojo_cls> option=repo.findById(id);
		
		pojo_cls pojo=option.get();

		return pojo;
	}

}
