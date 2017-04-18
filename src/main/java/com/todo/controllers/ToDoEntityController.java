package com.todo.controllers;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.todo.entities.ToDoEntity;
import com.todo.services.ToDoEntityService;



/**
 * @author : Achuth K
 */

@Controller
public class ToDoEntityController {
	private static final Logger logger = LoggerFactory.getLogger(ToDoEntityController.class);
	@Autowired
	private ToDoEntityService service;

	@ModelAttribute("ToDoEntity")
	public ToDoEntity getToDoEntity(){
		return new ToDoEntity();
	}



	@RequestMapping(value="/", method=RequestMethod.GET)
	public String redirectdefaultToDoEntityAnyFinadAll(Model model){
		List<String> prio= new ArrayList<>();
		prio.add("low");
		prio.add("medium");
		prio.add("high");

		model.addAttribute("allTypes", prio);
		return "test";
	}





	/*@RequestMapping(value="/ToDoEntity", method=RequestMethod.GET)
	public String redirectdefaultToDoEntitysFinadAll(){
		return "redirect:/ToDoEntity/page/1.html";
	}

	@RequestMapping(value="/ToDoEntity/page", method=RequestMethod.GET)
	public String redirectdefaultToDoEntitypageModelFinadAll(){
		return "redirect:/ToDoEntity/page/1.html";
	}

	@RequestMapping(value="/ToDoEntity/page/{pgNO}",  method=RequestMethod.GET)
	public String redirectdefaultToDoEntityFinadAllView(@PathVariable("pgNO")Integer pgNO,Map<String,Object> model){

		Integer pageNo=pgNO-1;
		Integer displayRowSize=10;
		String propertyName="modificationDate";

		Page<ToDoEntity> page = service.findAll(new PageRequest(pageNo,displayRowSize,Sort.Direction.ASC,propertyName));
		//get current page 
		int current = page.getNumber() + 1;
		//get starting page number
		int begin = Math.max(1, current - 5);
		//get ending page number
		int end = Math.min(begin + 10, page.getTotalPages());
		// get all the contents of current page
		List<ToDoEntity> lists=page.getContent();
		model.put("deploymentLog", page);
		model.put("beginIndex", begin);
		model.put("endIndex", end);
		model.put("currentIndex", current);
		model.put("content", lists);
		return "ToDoEntity-view";
	}
	 */

	@RequestMapping(value="/ToDoEntitys",  method=RequestMethod.GET)
	public String redirectdefaultToDoEntityFinadAllView(Model model){
		List<ToDoEntity> doEntities=service.findAll();

		model.addAttribute("todos",service.findAll() );


		return "todos";
	} 

	//save new blog
	@RequestMapping(value="/ToDoEntity/add",method=RequestMethod.GET)
	public String insertToDoEntityController(Model model) {
		List<String> prio= new ArrayList<>();
		prio.add("low");
		prio.add("medium");
		prio.add("high");

		model.addAttribute("allTypes", prio);
		return "add";
	}

	//update redirect
	@RequestMapping(value="/ToDoEntity/update/{id}",method=RequestMethod.GET)
	public String redirectUpdateToDoEntityController(@PathVariable("id")Long id, Model model) {
		try {
			ToDoEntity dto = service.findOne(id);
			if (dto.getId() > 0 && dto != null) {
				List<String> prio= new ArrayList<>();
				prio.add("low");
				prio.add("medium");
				prio.add("high");

				model.addAttribute("allTypes", prio);
				model.addAttribute("ToDoEntity", dto);
				System.out.println(dto.toString());
				return "edit";
			}
			else {
				return "redirect:/ToDoEntity/add?success=false";
			} 
		} catch (Exception e) {
			logger.error(e.toString());
			return "redirect:/ToDoEntity/add?success=false";
		}
	}

	// save the  value
	@RequestMapping(value="/ToDoEntity/save",method=RequestMethod.POST)
	public String saveToDoEntityController(@Valid @ModelAttribute("ToDoEntity") ToDoEntity dto, BindingResult result) {
		if(result.hasErrors()){
			return "redirect:/ToDoEntity/add?success=false";
		}
		else{
			service.save(dto);
			return "redirect:/ToDoEntity/add?success=true";	
		}
	}

	//updated value
	@RequestMapping(value="/ToDoEntity/update",method=RequestMethod.POST)
	public String upadteToDoEntityController(@Valid @ModelAttribute("ToDoEntity") ToDoEntity dto, BindingResult result) {
		if(result.hasErrors()){
			return "redirect:/ToDoEntity/add?success=false";
		}
		else{
			service.update(dto);
			return "redirect:/ToDoEntity/add?success=true";	
		}
	}
	//view
	@RequestMapping(value="/ToDoEntity/view/{id}",method=RequestMethod.GET)
	public String redirectUpdateToDoEntityController(@PathVariable("id")Long id, Map<String,Object> model) {
		ToDoEntity dto=service.findOne(id);
		if(dto==null){
			return "redirect:/ToDoEntity/add?success=false";
		}else{
			model.put("dto",dto);
			return "add";
		}

	}
	//delete redirect
	@RequestMapping(value="/ToDoEntity/delete/{id}",method=RequestMethod.GET)
	public String redirectDeleteToDoEntityController(@PathVariable("id")Long id, Model model) {
		ToDoEntity dto=service.findOne(id);
		if(dto.getId()>0 && dto!=null){
			service.delete(id);
			return "redirect:/ToDoEntitys";
		}
		return "redirect:/ToDoEntity/add";
	}
}