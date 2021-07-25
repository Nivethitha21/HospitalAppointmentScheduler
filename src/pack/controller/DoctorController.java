package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dao.DoctorDAO;
import pack.dao.docAvailDAO;
import pack.entity.Doctor;
import pack.entity.docAvail;

@Controller
@RequestMapping("/doc")
public class DoctorController {
	@Autowired
	private DoctorDAO doctorDAO;
	@Autowired
	private docAvailDAO docAvaildao;
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Doctor doc = new Doctor();
		theModel.addAttribute(doc);
		return "doct-form";
	}
	@RequestMapping("showFormForSearch")
	public String showFormForSearch()
	{
		return "search-doc";
	}
	
	@RequestMapping("updateDoc")
	public String updateDoc(Model theModel)
	{
		List<Doctor> li = doctorDAO.getAllDoctor();
		theModel.addAttribute("docList",li);
		return "updateDoc";
	}
	@GetMapping("showDoc")
	public String searchDoc(@RequestParam("id") int id,Model theModel)
	{
		Doctor d = doctorDAO.getOneDoctor(id);
		theModel.addAttribute("doctor",d);
		return "doct-form";
	}
	@RequestMapping("showDelDoc")
	public String showDelDoc(@RequestParam("id") int docId)
	{
		Doctor theDoctor = doctorDAO.getOneDoctor(docId);
		doctorDAO.deleteDoctor(theDoctor);
		return "doc-home";
	}
	
	@RequestMapping("/deleteDoc")
	public String deleteDoc(Model theModel)
	{
		return "deleteDoc";
	}
	
	
	@RequestMapping("/saveDoctor")
	public String saveDoctor(@ModelAttribute("doctor") Doctor theDoctor,@RequestParam("Id") int did, @RequestParam("Da") String[] Da,@RequestParam("slo") int slot)
	{
		System.out.println(did);
		for(String str:Da)
		{
			if(str==null)
				continue;
			theDoctor.addAvail(new docAvail(str,slot));
		}
		doctorDAO.saveDoctor(theDoctor);
		return "redirect:/doc/clearNull";
	}
	@RequestMapping("/clearNull")
	public String clearNull()
	{
		docAvaildao.clearNull();
		return "doc-home";
	}
		
	@RequestMapping("searchDoctor")
	public String searchDoctor(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
			@RequestParam("speciality") String speciality,
			@RequestParam("Da") String[] Da, @RequestParam("id") int id,@RequestParam("phneNum") String phneNum,Model theModel )
	{
		List<Doctor> dc = doctorDAO.searchDoctor(firstName,lastName,speciality,Da,id,phneNum);
		theModel.addAttribute("dc",dc);
		
			
		return "list-doc";
	}
	
}
