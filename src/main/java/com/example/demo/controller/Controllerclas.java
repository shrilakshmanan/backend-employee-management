package com.example.demo.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.example.demo.MODEL.jva_clas;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.DAO.LeaveReposit;
import com.example.demo.DAO.Repo_cls;
import com.example.demo.DAO.Repository_one;
import com.example.demo.DAO.projectRepo;
import com.example.demo.DAO.queries_saved;
import com.example.demo.DAO.salaryRepo;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.MODEL.Admin_cls;
import com.example.demo.MODEL.Querymails;
import com.example.demo.MODEL.Salary;
import com.example.demo.MODEL.currentProjects;
import com.example.demo.MODEL.emailsender;
import com.example.demo.MODEL.jva_clas;
import com.example.demo.MODEL.leaveDates;
import com.example.demo.MODEL.oldprojects;
//import com.example.demo.model.Employee;
//import com.example.demo.model.Employee;
//import com.example.demo.model.Employee;
//import com.example.demo.model.Employee;
//import com.example.demo.model.Employee;
//import com.example.demo.model.Employee;
//import com.example.demo.MODEL.project;
import com.example.demo.service_cls.Admin_serv;
import com.example.demo.service_cls.serv_cls;
import com.example.demo.service_cls.servicecls_one;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.mail.FetchProfile;
import javax.persistence.Entity;
import javax.persistence.Id;

@Controller
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/")
public class Controllerclas {
	// This is for the service class
	@Autowired
	serv_cls services;
	


	@Autowired
	servicecls_one serv;

	@Autowired
	emailsender mail;
	@Autowired
	private HttpSession session;

	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	Repository_one repoone;

//
//	@Autowired
//	jva_clas jva;
	
	@Autowired
	Admin_serv adminserv;

	// This is for the repository class
	@Autowired
	Repo_cls reposit;

	@Autowired
	LeaveReposit LeaveReposits;

	@Autowired
	projectRepo projectRepos;

	@Autowired
	queries_saved queries;

	@Autowired
	salaryRepo salaryRepoes;

	// int idds;

	/*
	 * @RequestMapping("signin") public String signin(Model mks) {
	 * mks.addAttribute("Datas_lk", services.getAllusersalary());
	 * 
	 * Integer idds = (Integer) session.getAttribute("id"); int id=idds; String name
	 * = serv.getByNameid(id); mks.addAttribute("name", name); return "index";
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @GetMapping("/home") public String home(){ return "This is Home Page"; }
	 * 
	 * @GetMapping("/admin") public String admin(){ return "This is Admin Page"; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * // This is for employee login
	 * 
	 * @RequestMapping("/AdminLogin") public String Adminsignin() {
	 * 
	 * return "adminLogin";
	 * 
	 * } /*
	 * 
	 * @RequestMapping("/") public String Home() {
	 * 
	 * return "AfterHomepage";
	 * 
	 * }
	 */
	/*
	 * @RequestMapping("/AfterHomepage") public String AfterHomepg() {
	 * 
	 * return "AfterHomepage";
	 * 
	 * }
	 */
	@GetMapping("/managerEmpDisplay/{id}")
	public List<jva_clas> getAllEmp(@PathVariable(value = "id") int id){
		
		System.out.println("QWEAWQW"+id);
		return reposit.findAllemp(id);
		
	}
//	@GetMapping("AfterLogin/{id}")
//	public ResponseEntity<Object> getleavesLogin(@PathVariable(value = "id") int id) throws JSONException{
//		
//		
//		JSONObject obj=new JSONObject();
//		
//		 obj.put ("leaves",reposit.getLeaves(id));	
//		
//
//		 String status="pending";
//		
//		 int openqueries=queries.getactivecount(id,status);
//		 
//		 int queriesrespond=queries.getquerycount(id,status);
//		 
//		String projectstatus="Current";
//		 
//		 int currentprojectcount=projectRepos.getproject(id,projectstatus);
//		
//		 
//		 
//		 String yet="Yettostart";
//		 
//		 int yettocount=projectRepos.getyetto(id,yet);
//		 
//		 String comp="completed";
//		 
//		 int completed=projectRepos.complete(id,comp);
//		 
//		 
//		 
//		 obj.put("yetto", yettocount);
//		 obj.put("completed", completed);
//		 
//		 obj.put("current",currentprojectcount);
//		 
//		 obj.put("Totalqueryres",queriesrespond );
//		 obj.put("Totalquery",openqueries );
//		 
//		 obj.put("Totalleave",LeaveReposits.getleavecounts(status));
//	
//		 
//		 
//		 
//		int i= reposit.gettotalemp(id);
//		
//		int tot=reposit.gettotalsE();
//		obj.put("Totalemp",tot);
//		 
//		int Totquery=queries.getTotquery();
//	
//		obj.put("TotQuery",Totquery);
//		 obj.put("managerEmp",i);
//		
//		return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
//		
//	}
	@GetMapping("/updateleave/{id}")
	public  leaveDates  updateleave(@PathVariable(value = "id") int id) throws JSONException{
		
		JSONObject obj=new JSONObject();
		
		System.out.println("QWEAWQW"+id);
		 leaveDates l = LeaveReposits.updateleave(id);
		 System.out.println("println"+l);
		 obj.put("leave",l);
		 
		// jva_clas j=reposit.getLeav(id);
	
		 //obj.put ("afterlog",j);	
		 
		 return LeaveReposits.updateleave(id);
//		return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/updatequeries/{id}")
	public Querymails updatequeries(@PathVariable(value = "id") int id){
		
		System.out.println("QWEAWQW"+id);
		Querymails l = queries.updatequery(id);
		 System.out.println("println"+l);
		return queries.updatequery(id);
		
	}
	
	
	@GetMapping("/CurrentEmployee")
	public List<jva_clas> CurrentEmployee(){
		
	String status="currrent";
		return reposit.displaycurrent(status);
		
	}
	
	@GetMapping("/Wrongemployee")
	public List<jva_clas> Wrongemployee(){
		
	String status="Wrongemployee";
		return reposit.displaywrong(status);
		
	}
	
	
	@GetMapping("/FormerEmployee")
	public List<jva_clas> FormerEmployees(){
		
	String status="former";
		return reposit.displayformer(status);
		
	}

	@GetMapping("/AllempDisplay")
	public List<jva_clas> AllempDisplay(){
		
	int id=1;
	String Admin="Admin";
	String status="Wrongemployee";
		return reposit.displayemployee(id,Admin,status);
		
	}
	
	@GetMapping("/UpdateSalary")
	public List<Salary> UpdateSalary(){
		
	
		return salaryRepoes.findAll();
		
	}

	@GetMapping("/CompletedProjectAdmin")
	public List<currentProjects> completedprojects(){
		
		String Status="completed";
	
		return projectRepos.Admincompleted(Status);
		
		
		
		
	}

//	@GetMapping("/yettocome")
//	public List<currentProjects> yetprojects(){
//		
//		String Status="Yettostart";
//	
//		return projectRepos.yetto(Status);
//		
//		
//		
//		
//	}
//	
	@GetMapping("/yettocome/{id}")
	public List<currentProjects> yetprojects(@PathVariable(value = "id") int id){
		
	//	System.out.println("QWEAWQW"+id);
		
		String str="Yettostart";
		return projectRepos.yetto(id,str);
		
	}
	
	
	@GetMapping("/updateproject/{id}")
	public currentProjects updateproject(@PathVariable(value = "id") int id){
		
	//	System.out.println("QWEAWQW"+id);
		
	
		return projectRepos.findproject(id);
		
	}
	
	
	@GetMapping("/ActiveAdminproject")
	public List<currentProjects> ActiveAdminproject(){
		
		String Status="Current";
	
		return projectRepos.AdminActive(Status);
		
	}
	

	@GetMapping("/AdminLeave")
	public List<leaveDates> AdminLeave(){
		
		
	
		return LeaveReposits.findAll();
		
	}
	

	
	
	@GetMapping("/AdminQuery")
	public List<Querymails> AdminQuery(){
		
		return queries.findAll();
		
	}
	@PutMapping("/updateleave/{id}")
	public ResponseEntity<leaveDates> updateLeave(@PathVariable int id, @RequestBody leaveDates employeeDetails) throws ResourceNotFoundException{
	
//		leaveDates employee = LeaveReposit.findById(id);
//			
//		
//	employee.getLeavestartdate(employeeDetails.getLeavestartdate());
//	
////		employee.setLastName(employeeDetails.getLastName());
////		employee.setEmailId(employeeDetails.getEmailId());
//		
//		Employee updatedEmployee = LeaveReposit.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
		leaveDates employee = LeaveReposits.findBYLeaveid(id);
		
		employee.setLeavestartdate(employeeDetails.getLeavestartdate());
		employee.setTotalDays(employeeDetails.getTotalDays());
	employee.setLeaveenddate(employeeDetails.getLeaveenddate());
	employee.setCategory(employeeDetails.getCategory());
	//employee.setCategory(employeeDetails.);
	employee.setReason(employeeDetails.getReason());
	employee.setKindof(employeeDetails.getKindof());
	
		//employee.setStatus(employeeDetails.getStatus());
	
//	
		leaveDates updatedEmployee = LeaveReposits.save(employee);
//		Employee updatedEmployee = employeerepo.save(employee);
		System.out.println("leavedate"+updatedEmployee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	/*
	public ResponseEntity<Object> Query(@RequestBody Querymails  queri) throws JSONException {

		
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		   LocalDateTime now = LocalDateTime.now();  
		   String date=dtf.format(now); 

		queri.setQuerydate(date);

		queri.setResponse("pending");
		queri.setStatus("pending");
		queries.save(queri);
		
		 JSONObject obj = new JSONObject();

	     obj.put("Name","SUCCESS" );
		return new ResponseEntity<>(obj.toString(),HttpStatus.OK);

	}
	*/
	
	@PutMapping("/updateleaveAdmin/{id}")
	public ResponseEntity<Object> updateupdateleaveAdminLeave(@PathVariable int id, @RequestBody leaveDates employeeDetails) throws ResourceNotFoundException{
	
		JSONObject obj = new JSONObject();
		
//		leaveDates employee = LeaveReposit.findById(id);
//			
//		
//	employee.getLeavestartdate(employeeDetails.getLeavestartdate());
//	
////		employee.setLastName(employeeDetails.getLastName());
////		employee.setEmailId(employeeDetails.getEmailId());
//		
//		Employee updatedEmployee = LeaveReposit.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
		leaveDates employee = LeaveReposits.findBYLeaveid(id);
		
		String ids=employeeDetails.getIds();
		int i=Integer.parseInt(ids); 
		
		String getmail=reposit.getpersonelmail(i);
		
	String Username=reposit.getmanagername(i);
	

		
		System.out.println("this is "+employee.getLeaveenddate());
				
//		employee.setLeavestartdate(employeeDetails.getLeavestartdate());
//		employee.setTotalDays(employeeDetails.getTotalDays());
//	employee.setLeaveenddate(employeeDetails.getLeaveenddate());
//	employee.setCategory(employeeDetails.getCategory());
//	//employee.setCategory(employeeDetails.);
//	employee.setReason(employeeDetails.getReason());
	
		employee.setStatus(employeeDetails.getStatus());
	
		System.out.println("This is kind of leave"+employeeDetails.getKindof());
		System.out.println("This is status os a leave"+employeeDetails.getStatus());
//	
		int Totaldays=employeeDetails.getTotalDays();
	System.out.println("This is total days"+employeeDetails.getTotalDays());	
		if(employeeDetails.getStatus().equals("Reject")) {
			leaveDates updatedEmployee = LeaveReposits.save(employee);
			System.out.println("It enters mails");
			 mail.sendemail(
					 "Regarding your Applied leave",
					   "Welcome " + Username +
					   "You have applied leave from "+employee.getLeaveenddate()+" to "+employee.getLeavestartdate()+" as a "+employee.getKindof()+
					  ", Your leave was Rejected" ,getmail);
					
			return ResponseEntity.ok(updatedEmployee);
		}
		else if(employeeDetails.getKindof().equals("sickleave") && employeeDetails.getStatus().equals("Accept")) {
			
			//reposit.updatesick(i,totalsickleave);
int sickcount=reposit.getsickleavecount(i);
			
			System.out.println("THis is sickleave count "+sickcount);
			
			int totalsickleave=sickcount-Totaldays;
			
			System.out.println("This is sicktotal "+totalsickleave);
			

		
			reposit.updatesick(i,totalsickleave);
			 mail.sendemail(
					 "Regarding your Applied leave",
					   "Welcome " + Username +
					   " You have applied leave from "+employee.getLeaveenddate()+" to "+employee.getLeavestartdate()+" as a "+employee.getKindof()+
					  ", Your leave was Accepted",getmail );
			int casualcount2=reposit.getsickleavecount(i);
			
	System.out.println("This is sick leave count "+casualcount2);
			}	
else if(employeeDetails.getKindof().equals("Paidleave") && employeeDetails.getStatus().equals("Accept")) {
			
			//reposit.updatesick(i,totalsickleave);s
//int sickcount=reposit.getsickleavecount(i);
			
			//System.out.println("THis is sickleave count "+sickcount);
			
			int paidcount=reposit.getpaidleave(i);
			
			int updatepaid=paidcount-Totaldays;
			
		
			reposit.updatepaidleave(i,updatepaid);
			 mail.sendemail(
					 "Regarding your Applied leave",
					   "Welcome " + Username +
					   "You have applied leave from "+employee.getLeaveenddate()+" to "+employee.getLeavestartdate()+" as a "+employee.getKindof()+
					  " Your leave was Accepted",getmail );
			
		//	int casualcount2=reposit.getsickleavecount(i);
			
	//System.out.println("This is sick leave count "+casualcount2);
			}	
			
		//
else if(employeeDetails.getKindof().equals("casualleave") && employeeDetails.getStatus().equals("Accept")) {

	int casualcount=reposit.getcasualleave(i);
	
	System.out.println("This is actual casual count "+casualcount);
		
	int updatecasual=casualcount-Totaldays;
	
	System.out.println("This is the total days after minus "+updatecasual);
	

	
	reposit.updatecasualleave(i,updatecasual);
	 mail.sendemail(
			 "Regarding your Applied leave",
			   "Welcome " + Username +
			   "You have applied leave from "+employee.getLeaveenddate()+" to "+employee.getLeavestartdate()+" as a "+employee.getKindof()+
			  " Your leave was Accepted",getmail );
//	
//	int casualcount2=reposit.getcasualleave(i);
	

}
else if(employeeDetails.getKindof().equals("Workfromhome") && employeeDetails.getStatus().equals("Accept")) {

	int wfhh=reposit.getwfh(i);
	
int	Updatewfh=wfhh+Totaldays;
	
	reposit.updatewfh(i,Updatewfh);
	 mail.sendemail(
			 "Regarding your Applied leave",
			   "Welcome " + Username +
			   "You have applied leave from "+employee.getLeaveenddate()+" to "+employee.getLeavestartdate()+" as a "+employee.getKindof()+
			  " Your leave was Accepted",getmail );
}
		
		
		//
		leaveDates updatedEmployee = LeaveReposits.save(employee);
//		Employee updatedEmployee = employeerepo.save(employee);
		System.out.println("leavedate"+updatedEmployee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@PutMapping("/updatequeries/{id}")
	public ResponseEntity<Querymails> updatequeries(@PathVariable int id, @RequestBody Querymails employeeDetails) throws ResourceNotFoundException{
	
//		leaveDates employee = LeaveReposit.findById(id);
//			
//		
//	employee.getLeavestartdate(employeeDetails.getLeavestartdate());
//	
////		employee.setLastName(employeeDetails.getLastName());
////		employee.setEmailId(employeeDetails.getEmailId());
//		
//		Employee updatedEmployee = LeaveReposit.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
		Querymails employee = queries.findbyqueryid(id);
				
		employee.setCategory(employeeDetails.getCategory());


	//employee.setCategory(employeeDetails.);
	employee.setQueries(employeeDetails.getQueries());


	
//	
	Querymails updatedEmployee = queries.save(employee);
//		Employee updatedEmployee = employeerepo.save(employee);
		System.out.println("leavedate"+updatedEmployee);
		return ResponseEntity.ok(updatedEmployee);
	}

	
	
	@PutMapping("/updateAdminqueries/{id}")
	public ResponseEntity<Querymails> updateadminqueries(@PathVariable int id, @RequestBody Querymails employeeDetails) throws ResourceNotFoundException{
	
//		leaveDates employee = LeaveReposit.findById(id);
//			
//		
//	employee.getLeavestartdate(employeeDetails.getLeavestartdate());
//	
////		employee.setLastName(employeeDetails.getLastName());
////		employee.setEmailId(employeeDetails.getEmailId());
//		
//		Employee updatedEmployee = LeaveReposit.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
		
		Querymails employee = queries.findbyqueryid(id);

	employee.setStatus(employeeDetails.getStatus());
	employee.setResponse(employeeDetails.getResponse());
	
	//System.out.println("afefE"+employeeDetails.getStatus());

//	
	Querymails updatedEmployee = queries.save(employee);
//		Employee updatedEmployee = employeerepo.save(employee);
		System.out.println("leavedate"+updatedEmployee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@PutMapping("updatesalaryandDept/{id}")
	public String updatesalaryan(@PathVariable int id, @RequestBody Salary employeeDetails) throws ResourceNotFoundException{
		
//		leaveDates employee = LeaveReposit.findById(id);
//			
//		
//	employee.getLeavestartdate(employeeDetails.getLeavestartdate());
//	
////		employee.setLastName(employeeDetails.getLastName());
////		employee.setEmailId(employeeDetails.getEmailId());
//		
//		Employee updatedEmployee = LeaveReposit.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
		
//		Querymails employee = queries.findbyqueryid(id);
		
		Salary sal=salaryRepoes.getsalaryDept(id);
		
		sal.setDepartment(employeeDetails.getDepartment());
		
		
		sal.setPosition(employeeDetails.getPosition());
		sal.setSalary(employeeDetails.getSalary());
	
	//System.out.println("afefE"+employeeDetails.getStatus());

//	
		
		Salary updatedEmployee = salaryRepoes.save(sal);
//		Employee updatedEmployee = employeerepo.save(employee);
		System.out.println("leavedate"+updatedEmployee);
return "success";
	}
	
	
	
	@GetMapping("/CompletedProjects/{id}")
	public List<currentProjects> CompletedProjects(@PathVariable(value = "id") int id){
		
		System.out.println("QWEAWQW"+id);
		
		String s="completed";
		return projectRepos.completed(id,s);
		
	}
	
	@GetMapping("/ActiveProjects/{id}")
	public List<currentProjects> ActiveProjects(@PathVariable(value = "id") int id){
		
	//	System.out.println("QWEAWQW"+id);
		
		String str="Current";
		return projectRepos.Active(id,str);
		
	}
	
	@GetMapping("/displayteam/{name}")
	public List<jva_clas> displayteam(@PathVariable(value = "name") String name){
		
	//	System.out.println("QWEAWQW"+id);
		
		//String str="Current";
		System.out.println("this is name"+name);
		
		String namesplit=projectRepos.Team(name);
				List<String> elephantList = Arrays.asList(namesplit	.split(","));
		
				String[] namesList = namesplit.split(",");
				
				List<jva_clas> data=new ArrayList<jva_clas>();
				
				for(int i=0;i<namesList.length;i++)
				{
					List<jva_clas> elephantLists = reposit.getdetail(namesList[i]);
					
					data.addAll(elephantLists);
				}																	
				return data;
					
	}
	
	

	@GetMapping("/updatesalaryandDept/{id}")
	public Salary updatesalaryandDept(@PathVariable(value = "id") int id){
		
	//	System.out.println("QWEAWQW"+id);

		
		//String str="Current";
		
		return salaryRepoes.getsalaryDept(id);
		
	}
	

		
		@GetMapping("/Addproject")
		public List<jva_clas> dropdown(){
			
		//	System.out.println("QWEAWQW"+id);
			
			String str="Employee";
			String former="former";
			String wrong="Wrongemployee";
			return reposit.gets(str,former,wrong);
			
		}
		
		@PostMapping("/Addproject")
		public int saveproject(@RequestBody currentProjects  employee){
			
		//	System.out.println("QWEAWQW"+id);
			
			System.out.println(employee.getStatus());
			//currentProjects.
			
			
		
			
					projectRepos.save(employee);
					
	String name=employee.getProjectname();
	
int number=	projectRepos.getnumber(name);
	
		return number;
		
		}
	
		@PutMapping("/updateproject/{id}")
		public String updateproject(@PathVariable int id,@RequestBody currentProjects  employee){
			
		//	System.out.println("QWEAWQW"+id);
			
			
			System.out.println("THis is manager projecgt id"+id);
			
			System.out.println(employee.getStatus());
			//currentProjects.
			
			currentProjects cpu = projectRepos.findproject(id);
			
			
			System.out.println("afwetawtgrg"+employee.getStartdate());

			cpu.setStartdate(employee.getStartdate());
	cpu.setEmployeeid(employee.getEmployeeid());
	cpu.setProjectid(employee.getProjectid());
		cpu.setManagerid(employee.getManagerid());
			cpu.setEnddate(employee.getEnddate());
			cpu.setProjectdescription(employee.getProjectdescription());
			cpu.setStatus(employee.getStatus());
			cpu.setProjectname(employee.getProjectname());
			
					projectRepos.save(cpu);
					

	
		return "success";
		
		}

		@PutMapping("/updateEmployee/{id}")
		public ResponseEntity<Object> updateemployee(@PathVariable int id, @RequestBody jva_clas employeeDetails) throws ResourceNotFoundException, JSONException{
			JSONObject obj=new JSONObject();
//			leaveDates employee = LeaveReposit.findById(id);
//				
//			
//		employee.getLeavestartdate(employeeDetails.getLeavestartdate());
	//	
////			employee.setLastName(employeeDetails.getLastName());
////			employee.setEmailId(employeeDetails.getEmailId());
//			
//			Employee updatedEmployee = LeaveReposit.save(employee);
//			return ResponseEntity.ok(updatedEmployee);
			
			jva_clas employee = reposit.findBYempid(id);
			

			if(employeeDetails.getRoles().equals("Manager") && !(employeeDetails.getManagerIncharge().equals("1")))
			{
			//System.out.println(employee.getStatus());		
		
				obj.put("error","Please select the manager incharge as None");
				return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
		
			}
			
			if(employeeDetails.getRoles().equals("Employee") && (employeeDetails.getManagerIncharge().equals("1"))) {
				
				obj.put("error","Please,Assign a manager for "+employeeDetails.getUsername());
				return new ResponseEntity<>(obj.toString(),HttpStatus.OK);			
				
			}
			
			
			System.out.println("iwurefhywirgyw"+employeeDetails.getManagerIncharge());
			
			employee.setCasualleave(employeeDetails.getCasualleave());
			employee.setPaidleave(employeeDetails.getPaidleave());
			employee.setSickleave(employeeDetails.getSickleave());
		employee.setJobdesc(employeeDetails.getJobdesc());
			employee.setManagerIncharge(employeeDetails.getManagerIncharge());
			employee.setEmployeestatus(employeeDetails.getEmployeestatus());
			employee.setUsername(employeeDetails.getUsername());
			employee.setPassword(employeeDetails.getPassword());
			employee.setEmailid(employeeDetails.getEmailid());
			employee.setPersonelmail(employeeDetails.getPersonelmail());
			employee.setRoles(employeeDetails.getRoles());
			
if(employeeDetails.getEmployeestatus().equals("former")) {
	

	  Date date = new Date();
      SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
       String str = formatter.format(date);
//
//	queri.setQuerydate(date);
//				
//	Date date = Calendar.getInstance().getTime();  
//	DateFormat dateFormat = new SimpleDateFormat("yyyy-11-dd");  
//	String strDate = dateFormat.	format(date);  
//	
				employee.setDateofleaving(str);
				
			}
			
		
			//employee.setStatus(employeeDetails.getStatus());
			jva_clas Updateemployee = reposit.save(employee);
			
			obj.put("success", "Updated Successfully" );
	//	
//			leaveDates updatedEmployee = LeaveReposits.save(employee);
////			Employee updatedEmployee = employeerepo.save(employee);
//			System.out.println("leavedate"+updatedEmployee);
			return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
		}
		
		@GetMapping("/getEmployeenames/{id}")
		public String Getemployee(@PathVariable int id) {
		
			
			jva_clas employee = reposit.findBYempid(id);	
			return employee.getUsername();

		
}
		
		
		
		@PostMapping("/CreateNewEmployee")
		public ResponseEntity<Object> CreateNewEmployee(@RequestBody jva_clas  employee) throws JSONException{
			
		//	System.out.println("QWEAWQW"+id);
			
			JSONObject obj=new JSONObject();
			
			int id=employee.getEmployeeid();
			
//			jva_clas employee = reposit.findById(id);		
			System.out.println(employee.getManagerIncharge());
			//employee.setUsername(employeeDetails.getStatus());
			
			String name=reposit.findAllnameid(1);
			
			
			
			
			if(employee.getRoles().equals("Manager") && !(employee.getManagerIncharge().equals("1")))
			{
			//System.out.println(employee.getStatus());		
		
				obj.put("error","Please select the manager incharge as None");
				return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
		
			}
			
			if(employee.getRoles().equals("Employee") && (employee.getManagerIncharge().equals("1"))) {
				
				obj.put("error","Please Assign a manager to this Employee");
				return new ResponseEntity<>(obj.toString(),HttpStatus.OK);			
				
			}
//		employee.setCasualleave(5);
//		employee.setPaidleave(5);
//		employee.setSickleave(5);
			employee.setDateofleaving("NotYet");

			reposit.save(employee);
			
			obj.put("success", " Employee created successfully"); 
			return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
			
		}
		
		@DeleteMapping("/ListEmpLeaves/{id}")
		public String returndelete(@PathVariable(value = "id") int id){
			System.out.println("afaefAErfzbtzrwt "+ id);
			
			leaveDates leave= LeaveReposits.findBYLeaveid(id);
			
			LeaveReposits.delete(leave);
			return "success";
			
					
			}
		
		
		@DeleteMapping("/UpdateSalary/{id}")
		public String deletesalary(@PathVariable(value = "id") int id){
			System.out.println("afaefAErfzbtzrwt "+ id);
			
			//leaveDates leave= LeaveReposits.findBYLeaveid(id);
			Salary salar=salaryRepoes.findbysalid(id);
			salaryRepoes.delete(salar);
			
			return "success";
			
					
			}
		
		@DeleteMapping("/ListQueries/{id}")
		public String ListQueriesdelete(@PathVariable(value = "id") int id){
			System.out.println("afaefAErfzbtzrwt "+ id);
			
			Querymails queri= queries.findbyqueryid(id);
			
			queries.delete(queri);
			return "success";
			
					
			}
		
		@DeleteMapping("/yettocome/{id}")
			public String yettocomedelete(@PathVariable(value = "id") int id){
				System.out.println("afaefAErfzbtzrwt "+ id);
				
				currentProjects yetto= projectRepos.findproject(id);
				
				projectRepos.delete(yetto);
				return "success";
				
						
				}
		
		@DeleteMapping("/Wrongemployee/{id}")
		public String AllempDisplaydelete(@PathVariable(value = "id") int id){
			System.out.println("afaefAErfzbtzrwt "+ id);
		
		
			jva_clas yetto= reposit.findBYempid(id);
			
			reposit.delete(yetto);
			return "success";
			
					
			}
		
			
		@DeleteMapping("/CompletedProjects/{id}")
		public String CompletedProjectsdelete(@PathVariable(value = "id") int id){
			System.out.println("afaefAErfzbtzrwt "+ id);
			
			currentProjects yetto= projectRepos.findproject(id);
			
			projectRepos.delete(yetto);
			return "success";
			
					
			}
			@DeleteMapping("/ActiveProjects/{id}")
				public String ActiveProjectsdelete(@PathVariable(value = "id") int id){
					System.out.println("afaefAErfzbtzrwt "+ id);
					
					currentProjects yetto= projectRepos.findproject(id);
					
					projectRepos.delete(yetto);
					return "success";
					
							
				}
		
		
	
	@GetMapping("/ProjectEmpDisplay/{id}")
	public List<currentProjects> getEmpproject(@PathVariable(value = "id") String id){
	System.out.println("afaefAErfzbtzrwt "+ id);
	
	
	
	return projectRepos.findByempids(id);
			
	}
	
	
	
	@GetMapping("/displaymanagerproject/{id}")
	public List<currentProjects> displaymanagerproject(@PathVariable(value = "id") int id){
	System.out.println("afaefAErfzbtzrwt "+ id);
	
	
	
	return projectRepos.findAllEmp(id);
			
	}
	
	@GetMapping("/updateEmployee/{id}")
	public jva_clas updateEmployee(@PathVariable(value = "id") int id){
	System.out.println("afaefAErfzbtzrwt"+id);
	
		return reposit.findByemployee(id);
		
		
	}
	
	
	

	
	@GetMapping("/yettostart")
	public List<currentProjects> yettostart(){
		
	//	System.out.println("QWEAWQW"+id);
		
		String status="Yettostart";
		return projectRepos.getyetproject(status);
		
	}
	
	
	
	@GetMapping("/ListQueries/{id}")
	public List<Querymails> ListQueries(@PathVariable(value = "id") int id){
		

	
		return queries.findByepid(id);
		
		
	}
	
	@GetMapping("AfterLogin/{id}")
	public ResponseEntity<Object> getleavesLogin(@PathVariable(value = "id") int id) throws JSONException{
		
		
		JSONObject obj=new JSONObject();
		
		 obj.put ("leaves",reposit.getLeaves(id));	
		
		
		 obj.put ("wfh",reposit.getwfh(id));	
		 
		 String usernameemp=reposit.getmanagername(id);
		 
		 String current="Current";
		 
		 int EmpprojectCurrent=projectRepos.getcount(usernameemp,current);
		 
		 String compemp="completed";
		 
		 System.out.println("This is current project count"+EmpprojectCurrent);
		
		 obj.put("empcurrent",EmpprojectCurrent);
		 
		 int Empprojectcompleted=projectRepos.getcompletedcount(usernameemp,compemp);
		
		 
		 int adminproject=projectRepos.getfullcount();
		 
		 obj.put("totprt",adminproject);
		 
		 obj.put("completedemp",Empprojectcompleted);
		 
		 System.out.println("This is completed project count"+Empprojectcompleted);
		 
		 String YetEmp="Yettostart";
		 
		 System.out.println("this is username"+usernameemp);
		 
		 int Yetproject=projectRepos.YetEmpfind(usernameemp,YetEmp);
		 
		 
		 System.out.println("This is yetto project"+Yetproject);
		 
		 obj.put("Yetemp",Yetproject);

		 String status="pending";
		 
		 String accetedadm="Accept";
		 
		 String rejectadm="Reject";
		 
		
		 int openqueries=queries.getactivecount(id,status);
		 
		 int queriesrespond=queries.getquerycount(id,accetedadm);
		 
		 
		 int queriesrespondreject=queries.getrejectquerycount(id,rejectadm);
		 
		 obj.put("rejectedqueryemp",queriesrespondreject );
		 
		 
		String projectstatus="Current";
		 
		 int currentprojectcount=projectRepos.getproject(id,projectstatus);
		
		 
		 
		 String yet="Yettostart";
		 
		 int yettocount=projectRepos.getyetto(id,yet);
		 
		 String comp="completed";
		 
		 int completed=projectRepos.complete(id,comp);
		 
		 
		 
		 obj.put("yetto", yettocount);
		 obj.put("completed", completed);
		 
		 obj.put("current",currentprojectcount);
		 
		 obj.put("Totalqueryres",queriesrespond );
		 obj.put("Totalquery",openqueries );
		 
		 obj.put("Totalleave",LeaveReposits.getleavecounts(status));
	
		 
		 
		 
		int i= reposit.gettotalemp(id);
		
		int tot=reposit.gettotalsE();
		obj.put("Totalemp",tot);
		 
		int Totquery=queries.getTotquery();
	
		obj.put("TotQuery",Totquery);
		 obj.put("managerEmp",i);
		
		return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
		
	}
	
	
//	@PostMapping("Addsalary")
//	public ResponseEntity<Object> salary(@RequestBody Salary  employee) throws JSONException {
//
//		
//		JSONObject obj = new JSONObject();
//		salaryRepoes.save(employee);
//		obj.put("success","success");
//		
//		return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
//		
//	}
//		
	
//	@PostMapping("AfterLogin")
//	public ResponseEntity<Object> allcount() throws JSONException {
//
//		
//		JSONObject obj = new JSONObject();
//		
//		repoes.counts();
//		
//		obj.put("success","success");
//		
//		return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
//		
//	}
		
	
	//This is for getting the employees leave status
	@GetMapping("/ListEmpLeaves/{id}")
public List<leaveDates> getEmpLeaves(@PathVariable(value = "id") int idds){
	
	// System.out.println(idds);
	System.out.println("This is the id "+idds);
	//Employee employee = employeerepo.findById(id)
	 
	
//	int	id=101;
			
			
	// id=employee.getEmployeeid();	
	
	//System.out.println("this is id"+id);
//	List<leaveDates> leaves = serv.getleavedetailsemp(idds);
	//Integer val = Integer.parseUnsignedInt(idds);
		return LeaveReposits.findByepid(idds);
		
	}
	// This brings the data and stores here
	// for now this is for testing purpose
	// This is the mail here
	// If the mail is not working just change the mail password
	//
	/*
	 * @PostMapping("/Datas/Emailid/password/personelmail/Username/jobdesc") public
	 * String savelogin(Model mk, @ModelAttribute jva_clas cls,
	 * 
	 * @RequestParam(value = "personelmail") String
	 * personelmail, @RequestParam(value = "jobdesc") int ids,
	 * 
	 * @RequestParam(value = "Username") String Username, @RequestParam(value =
	 * "Emailid") String Email,
	 * 
	 * @RequestParam(value = "password") String password, RedirectAttributes
	 * redirectAttributes,BindingResult jva_clas) { //System.out.println("This is "
	 * + ids); mail.sendemail(personelmail,
	 * "This is regarding your Email and password", "Welocome " + Username +
	 * " Your Mail id is: " + Email + " and your password is: " + password);
	 * mk.addAttribute("Datas", cls);
	 * redirectAttributes.addFlashAttribute("message", "Failed");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
	 * 
	 * if (jva_clas.hasErrors()) { return "redirect:/displays"; }
	 * redirectAttributes.addFlashAttribute("message",
	 * "Employee added Successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * 
	 * String encodedPassword = bCryptPasswordEncoder.encode(cls.getPassword());
	 * cls.setPassword(encodedPassword); // System.out.println(encodedPassword);
	 * cls.setEnabled(1); reposit.save(cls);
	 * 
	 * return "redirect:/displays";
	 * 
	 * }
	 */

	// This is for temporarily mail send to the admin
	/*
	 * @RequestMapping("/Helpqueries/{ids}") public String sendquery(@ModelAttribute
	 * Querymails Querymails, @PathVariable(value = "ids") int ids,
	 * RedirectAttributes redirectAttributes,BindingResult jva_clas) {
	 * //System.out.println("This is " + ids);
	 * 
	 * // String personelmail="shrilakshmanan2000@gmail.com";
	 * 
	 * // mail.sendemails(Emailid, "This is regarding the query","The query rised
	 * by: // "+Emailid+" The query is: " + queries);
	 * 
	 * // mk.addAttribute("leavedates", leaveDate); Querymails.setStatus("pending");
	 * Querymails.setResponse("pending");
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Failed");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
	 * 
	 * if (jva_clas.hasErrors()) { return "redirect:/displays"; }
	 * redirectAttributes.addFlashAttribute("message", "Query sent Successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success"); Date
	 * myObj = new Date(); // Create a date object System.out.println(myObj);
	 * SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); String
	 * dates= formatter.format(myObj);
	 * 
	 * Querymails.setQuerydate(dates);
	 * 
	 * queries.save(Querymails);
	 * 
	 * return "redirect:/Help";
	 * 
	 * }
	 */

	/*
	 * //empHelpqueries //This is for the employee to rise the query
	 * 
	 * @RequestMapping("/empHelpqueries/{ids}") public String
	 * empHelpqueries(@ModelAttribute Querymails Querymails, @PathVariable(value =
	 * "ids") int ids) { //System.out.println("This is " + ids);
	 * 
	 * // String personelmail="shrilakshmanan2000@gmail.com";
	 * 
	 * // mail.sendemails(Emailid, "This is regarding the query","The query rised
	 * by: // "+Emailid+" The query is: " + queries);
	 * 
	 * // mk.addAttribute("leavedates", leaveDate); Querymails.setStatus("pending");
	 * Querymails.setResponse("pending"); Date myObj = new Date(); // Create a date
	 * object System.out.println(myObj); SimpleDateFormat formatter = new
	 * SimpleDateFormat("yyyy-MM-dd"); String dates= formatter.format(myObj);
	 * 
	 * Querymails.setQuerydate(dates); queries.save(Querymails);
	 * 
	 * 
	 * return "redirect:/empHelp";
	 * 
	 * }
	 */
//http://localhost:8085/

	// This is for leave mail loop

	/*
	 * @RequestMapping("/leave/{ids}") public String saveLeavedate(Model
	 * mk, @ModelAttribute leaveDates leaveDate,RedirectAttributes
	 * redirectAttributes, @PathVariable(value = "ids") int ids) {
	 * 
	 * 
	 * Integer idds = (Integer) session.getAttribute("id");
	 * 
	 * // mk.addAttribute("leaveDate", leaveDate); String name =
	 * serv.getByNameid(idds);
	 * 
	 * List<leaveDates> leaves = serv.getleavedetailsemp(idds);
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(idds);
	 * 
	 * // This is to display the projects to the individual List<currentProjects>
	 * projectsdata = serv.getprojectdetailsemp(idds);
	 * 
	 * 
	 * mk.addAttribute("name", name); mk.addAttribute("ids", idds);
	 * 
	 * mk.addAttribute("leaves", leaves); mk.addAttribute("queries", queries);
	 * mk.addAttribute("ids", idds);
	 * 
	 * 
	 * mk.addAttribute("Datas_lk", services.getAlluser());
	 * 
	 * 
	 * String sDate1= leaveDate.getLeavestartdate().toString(); SimpleDateFormat
	 * date1=new SimpleDateFormat("yyyy-MM-DD"); sDate1 = date1.format(sDate1);
	 * leaveDate.setLeavestartdate(new Date(sDate1)); LeaveReposits.save(date1);
	 * return "leavemail";
	 * 
	 * 
	 * Date date = leaveDate.getLeavestartdate(); SimpleDateFormat formatter = new
	 * SimpleDateFormat("yyyy-MM-dd"); String strDate= formatter.format(date);
	 * 
	 * // System.out.println(strDate.getClass().getName());
	 * leaveDate.setLeavestartdate(new Date(strDate)); Date Enddate =
	 * leaveDate.getLeaveenddate();
	 * 
	 * String strEndDate= formatter.format(Enddate);
	 * 
	 * // System.out.println(strDate.getClass().getName());
	 * leaveDate.setLeaveenddate(new Date(strEndDate));
	 * LeaveReposits.save(leaveDate);
	 * 
	 * 
	 * int date=leaveDate.getTotalDays(); //System.out.println(date);
	 * 
	 * if(date==0 || date<0) {
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Not valid");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-danger"); return
	 * "redirect:/sendmail"; }
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Mail sent Successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * mk.addAttribute("leavedates", leaveDate); leaveDate.setStatus("pending");
	 * LeaveReposits.save(leaveDate); return "redirect:/sendmail"; }
	 */

	/*
	 * @RequestMapping("/leaveemp/{ids}") public String saveLeavedateEMP(Model
	 * mk, @ModelAttribute leaveDates leaveDate, @PathVariable(value = "ids") int
	 * ids) {
	 * 
	 * // mk.addAttribute("leaveDate", leaveDate);
	 * 
	 * 
	 * 
	 * Integer idds = (Integer) session.getAttribute("id"); //
	 * mk.addAttribute("leaveDate", leaveDate); String name =
	 * serv.getByNameid(idds);
	 * 
	 * List<leaveDates> leaves = serv.getleavedetailsemp(idds);
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(idds);
	 * 
	 * // This is to display the projects to the individual List<currentProjects>
	 * projectsdata = serv.getprojectdetailsemp(idds);
	 * 
	 * 
	 * mk.addAttribute("name", name); mk.addAttribute("ids", idds);
	 * 
	 * mk.addAttribute("leaves", leaves); mk.addAttribute("queries", queries);
	 * mk.addAttribute("ids", idds);
	 * 
	 * 
	 * mk.addAttribute("Datas_lk", services.getAlluser());
	 * 
	 * 
	 * String sDate1= leaveDate.getLeavestartdate().toString(); SimpleDateFormat
	 * date1=new SimpleDateFormat("yyyy-MM-DD"); sDate1 = date1.format(sDate1);
	 * leaveDate.setLeavestartdate(new Date(sDate1)); LeaveReposits.save(date1);
	 * return "leavemail";
	 * 
	 * 
	 * Date date = leaveDate.getLeavestartdate(); SimpleDateFormat formatter = new
	 * SimpleDateFormat("yyyy-MM-dd"); String strDate= formatter.format(date);
	 * 
	 * // System.out.println(strDate.getClass().getName());
	 * leaveDate.setLeavestartdate(new Date(strDate)); Date Enddate =
	 * leaveDate.getLeaveenddate();
	 * 
	 * String strEndDate= formatter.format(Enddate);
	 * 
	 * // System.out.println(strDate.getClass().getName());
	 * leaveDate.setLeaveenddate(new Date(strEndDate));
	 * LeaveReposits.save(leaveDate);
	 * 
	 * 
	 * 
	 * mk.addAttribute("leavedates", leaveDate); leaveDate.setStatus("pending");
	 * LeaveReposits.save(leaveDate);
	 * 
	 * return "redirect:/leavestatusemp";
	 * 
	 * 
	 * }
	 * 
	 * 
	 * // This is for leave access for admin
	 * 
	 * 
	 * @RequestMapping("Helpqueries") public String Querymessages() {
	 * 
	 * return "DisplayAllqueries";
	 * 
	 * }
	 * 
	 * 
	 * @RequestMapping("/adminleaveaccess") public String adminleaveaccess() {
	 * 
	 * // mk.addAttribute("leaveDate", leaveDate);
	 * 
	 * 
	 * return "adminleaveaccess";
	 * 
	 * }
	 * 
	 * 
	 * //Here to display all user here
	 * 
	 * @RequestMapping("/addproject") public String projects(Model mks ,HttpSession
	 * session) { Integer idds = (Integer) session.getAttribute("id");
	 * 
	 * int id=idds; long count=reposit.counts(id); // Integer idds = (Integer)
	 * session.getAttribute("id"); String name = serv.getByNameid(idds);
	 * 
	 * //System.out.println(requestCount);
	 * 
	 * //System.out.println("This is"+requestCount);
	 * 
	 * List<leaveDates> leaves = serv.getleavedetailsemp(idds);
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(idds);
	 * 
	 * // This is to display the projects to the individual List<currentProjects>
	 * projectsdata = serv.getprojectdetailsemp(idds);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * mks.addAttribute("name", name); mks.addAttribute("ids", idds);
	 * 
	 * mks.addAttribute("leaves", leaves); mks.addAttribute("queries", queries);
	 * mks.addAttribute("ids", idds);
	 * 
	 * 
	 * mks.addAttribute("Datas_lk", services.getAlluser());
	 * 
	 * return "project";
	 * 
	 * }
	 * 
	 * @RequestMapping("/saveproject") public String projects(@ModelAttribute
	 * currentProjects projectsAdd, RedirectAttributes
	 * redirectAttributes,BindingResult jva_clas) {
	 * 
	 * 
	 * int empid =projectsAdd.getEmployeeid();
	 * 
	 * String projectname=projectsAdd.getProjectname();
	 * 
	 * // System.out.println(empid); //System.out.println(projectname);
	 * 
	 * // this is to compare the given project name and in db String
	 * comp=projectRepos.namecompare(projectname); System.out.println(comp); int
	 * Empname=projectsAdd.getEmployeeid();
	 * 
	 * 
	 * //List<currentProjects> leaves =projectRepos.verify(empid,projectname);
	 * 
	 * // long total = leaves.stream().count();
	 * 
	 * //System.out.println(total);
	 * 
	 * // if(comp!=null){
	 * 
	 * // projectRepos.save(projectsAdd); // projectRepos.concat("spring",Empname);
	 * 
	 * 
	 * //}
	 * 
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Added successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success"); //
	 * Boolean bool =projectRepos.findtorf(empid,projectname);
	 * 
	 * //System.out.println(bool); projectRepos.save(projectsAdd);
	 * 
	 * return "redirect:/ManagerDisplayProjects"; }
	 */
@PutMapping("/CompletedProjectAdmin/id")
public String deleteproject(@PathVariable int id)
{
//	
//	projectRepos.deleteproject(id);
	return "success";
	
	
}

@PostMapping("Addsalary")
public ResponseEntity<Object> salary(@RequestBody Salary  employee) throws JSONException {
	JSONObject obj = new JSONObject();
String newone=employee.getPosition();
	
	String position=salaryRepoes.position(newone);
	
	if(position!=null) {
		
		obj.put("wrong","Position already exists");
	}
	
	else {

	salaryRepoes.save(employee);
	obj.put("success","success");
	}
	return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
	
}
		

@PostMapping("/leavedisplay")
public ResponseEntity<Object> leaveapply(@RequestBody leaveDates  employee) throws JSONException {

	JSONObject obj = new JSONObject();
	
		String id=employee.getIds();	
	int i=Integer.parseInt(id);  
	
	String name=reposit.username(id);
	
		int Totaldays=employee.getTotalDays();
		
		System.out.println("This is Total days"+Totaldays);
		
		String kindof=employee.getKindof();
		
		System.out.println("This is kindof "+kindof);
		
		if(kindof.equals("casualleave"))
		{
			System.out.println("This is casual leave");
			
		int casualcount=reposit.getcasualleave(i);
		
		System.out.println("This is actual casual count "+casualcount);
			
		int updatecasual=casualcount-Totaldays;
		
		System.out.println("This is the total days after minus "+updatecasual);
		
		if (updatecasual < 0) {
			
			System.out.println("Error");
			obj.put("alert","Error! Kindly check the Leave Balance" );
			return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
		}
		else {
//		reposit.updatecasualleave(i,updatecasual);
//		
		int casualcount2=reposit.getcasualleave(i);
		
		obj.put("casualleave","Hello "+ name+"  You have applied "+ Totaldays +" days leave" );
		
		
		System.out.println("This is casual leave count "+casualcount2);
		}
		
		}
		else if(kindof.equals("Paidleave")){
			System.out.println("This is paid leave");
		
		
			
			int paidcount=reposit.getpaidleave(i);
			
			System.out.println("This is actual paid count "+paidcount);
				
			int updatepaid=paidcount-Totaldays;
			
			System.out.println("This is the total days after minus "+updatepaid);
			
			if( updatepaid < 0) {
				
				System.out.println("The available balance is too  low");
				
				obj.put("alert", "Error! Kindly check the Leave Balance");
				return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
				
			}
			else {
		//	reposit.updatepaidleave(i,updatepaid);
			
			int casualcount2=reposit.getpaidleave(i);
			
//			obj.put("Paidleave", casualcount2);
			obj.put("Paidleave","Hello "+ name+" You have applied "+ Totaldays +" days leave" );
			
			
			
			System.out.println("This is casual leave count "+casualcount2);
			}
		
		}
		else if(kindof.equals("Workfromhome"))
		{
			//reposit.updatewfh(i,Totaldays);
			obj.put("wfh","Hello "+ name+" You have applied "+ Totaldays +" days Work from home" );
			
		}
		else if(kindof.equals("sickleave")){
			
			System.out.println("This is sick leave");
			

			int sickcount=reposit.getsickleavecount(i);
			
			System.out.println("THis is sickleave count "+sickcount);
			
			int totalsickleave=sickcount-Totaldays;
			
			System.out.println("This is sicktotal "+totalsickleave);
			

			if( totalsickleave < 0) {
				
				System.out.println("The available balance is too  low");
				
				obj.put("alert","Error! Kindly check the Leave Balance");
				return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
			}
			
			else {
			//reposit.updatesick(i,totalsickleave);
			
			int casualcount2=reposit.getsickleavecount(i);
			

			
			obj.put("sickleave","Hello "+ name +" You have applied "+ Totaldays +" days leave" );
			
			System.out.println("This is sick leave count "+casualcount2);
			}	
			
			
			
			
		}
	//
//int appliedleave=employee.getTotalDays();
//
//	String id=employee.getIds();
//	int i=Integer.parseInt(id);  
//	 JSONObject obj = new JSONObject();
////int total=reposit.gettotaldates(i); //15
//
//System.out.println("json obj"+obj);
////System.out.println("thisis total days"+total);
//
//String kindof=employee.getKindof();
//
//System.out.println(kindof);
//
//int allleave=0;
//
//String Paidleave="Paidleave";
//String Casualleave="casualleave";
//String Sickleave="sickleave";
//
//
//if(kindof.equals(Paidleave))
//{
//
//int kindofleave=reposit.getleavecount(i);
//System.out.println(" leave "+kindofleave);
//
//int totalleave=appliedleave-kindofleave;
//
//if(totalleave ==0 || totalleave <0 ) {
//	obj.put("Alert", "Your leave is over Kindly contact admin");
//}	
//	obj.put("PaidLeave",totalleave);
//int updateleave=reposit.updatepaid(i);
//System.out.println("paidleave"+updateleave);
//
//
//}
//else if(kindof.equals(Casualleave))
//{
//	int casualleave=reposit.getcasual(i);
//
//	int totalleave=appliedleave-casualleave;
//	if(totalleave ==0 || totalleave <0 ) {
//		obj.put("Alert", "Your leave is over Kindly contact admin");
//	}
//			obj.put("Casualleave",totalleave);
//			
//			int casualleaveupdate=reposit.updatecasualleave(i);
//			System.out.println("paidleave"+casualleaveupdate);
//
//	
//}
//else if(kindof.equals(Sickleave)) {
//
//	int sickleave=reposit.getsickleave(i);
//	
//	int totalleave=appliedleave-sickleave;
//	if(totalleave ==0 || totalleave <0 ) {
//		obj.put("Alert", "Your leave is over Kindly contact admin");
//	}	
//obj.put("SickLeave",totalleave);
//			
//		
//	int sickleaveupdate=reposit.updatesickleave(i);
//		System.out.println("sickleave"+sickleaveupdate);
//
//
//	
//	
//}
////int appliedDays=employee.getTotalDays();
//
////jva.setLeaveTotalDays(appliedDays-total);
//
////jva.setLeaveTotalDays(appliedDays-total);
//
//
////int CasualLeave=5;
////int PaidLeave=5;
////int SickLeave=5;
//
//String casual="CasualLeave";
//String paid="PaidLeave";
//String sick="SickLeave";
//
////if(appliedDays-total==0 || appliedDays-total >-1) {
////
////	obj.put("Alert", "Your leave is over Kindly contact admin");
//////	return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
////}
////else {
////	if(kindof.equals(casual)) {
////	
////	System.out.println("this is if condition");
////	
////	
////	int remaining1=total-appliedDays;
////
//////	int remaining=remaining1-CasualLeave;
////	
////	System.out.println("this is casula leave"+remaining);
////	obj.put("Casualleave",remaining);
////	
////}else if(kindof.equals(sick)) {
////	
////
////	int remainingSick=total-SickLeave;
////	
////	obj.put("SickLeave",remainingSick);
////
////}	else if(kindof.equals(paid)){
////	
////	int remainingPaid=total-PaidLeave;
////
////	obj.put("PaidLeave",remainingPaid);
////	
////	
////}
////}
////if(appliedDays-total==0 || appliedDays-total >-1) {
////		
////	obj.put("Alert", "Your leave is over Kindly contact admin");
////	return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
////}
//	
		
	
	employee.setStatus("pending");
	
	LeaveReposits.save(employee);


     obj.put("Name","SUCCESS" );
	return new ResponseEntity<>(obj.toString(),HttpStatus.OK);

}






@PostMapping("/Managerproject")
public List<currentProjects> ManagerDisplay(int id) {
	
	
return projectRepos.findAllEmp(id);
	
}




@PostMapping("/Support")
public ResponseEntity<Object> Query(@RequestBody Querymails  queri) throws JSONException {

	
	
	  Date date = new Date();
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       String str = formatter.format(date);
     // System.out.print("Current date: "+str);

	queri.setQuerydate(str);

	queri.setResponse("pending");
	queri.setStatus("pending");
	queries.save(queri);
	
	 JSONObject obj = new JSONObject();

     obj.put("Name","SUCCESS" );
	return new ResponseEntity<>(obj.toString(),HttpStatus.OK);

}

@GetMapping("/CreateNewEmployee")
public List<jva_clas> CreateNewEmployee(){
	
	String m = "Manager";

String status="former";
//	
//	List<jva_clas> jobdesc=reposit.getjobdesc();
	//List<leaveDates> leaveDate=option;

	return 	reposit.getmanager(m,status);
	
}

 
@PutMapping("/CreateNewEmployee")
public List<Salary> jobdesc( ){
	
	


//	
//	List<jva_clas> jobdesc=reposit.getjobdesc();
	//List<leaveDates> leaveDate=option;

	return 	salaryRepoes.getsalary();
	
}


@PutMapping("/updateEmployee")
public List<jva_clas> updateEmployeemanagers( ){
	
	


//	
//	List<jva_clas> jobdesc=reposit.getjobdesc();
	//List<leaveDates> leaveDate=option;

	String manager="Manager";
	return 	reposit.getmanagerupdate(manager);
	
}



	@PostMapping("/")
	public ResponseEntity<Object> login(@RequestBody  jva_clas employee) throws JSONException {
		
		// Object principal =
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// String usernames = ((UserDetails) principal).getUsername();

		/*
		 * if (principal instanceof UserDetails) { String username = ((UserDetails)
		 * principal).getUsername();
		 * 
		 * int ids = serv.getempId(username); System.out.println("Thsi is empid" + ids);
		 * Collection<SimpleGrantedAuthority> authorities =
		 * (Collection<SimpleGrantedAuthority>) SecurityContextHolder
		 * .getContext().getAuthentication().getAuthorities();
		 * System.out.println(authorities.toString()); // System.out.println(username);
		 * } else { String username = principal.toString(); //
		 * System.out.println(username); }
		 */
		// Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		/*
		 * if (!(auth instanceof AnonymousAuthenticationToken)) {
		 * 
		 * String email = usernames;
		 * 
		 * String clas = serv.getByname(email);
		 * 
		 * String Role = serv.getByRole(email);
		 * 
		 * String name = serv.getByName(email);
		 * 
		 * int ids = serv.getempId(email);
		 * 
		 * String status = "pending";
		 * 
		 * long leavecount = LeaveReposits.findByempstatus(ids, status);
		 * 
		 * long projectcount = projectRepos.findByempprojects(ids); long projectcountM =
		 * projectRepos.projectcount(ids);
		 * 
		 * long querycount = queries.findByempquery(ids, status);
		 * 
		 * session.setAttribute("id", ids);
		 * 
		 * // sessionStorage.setItem("firstName", "ids");
		 * System.out.println("This is id " + ids); // this is for getting whole details
		 * from the employee
		 * 
		 * // idds=ids; // System.out.println("This is id "+idds); int id =
		 * serv.getById(email); long count = reposit.counts(ids);
		 * 
		 * String manager = "Manager"; long managercount =
		 * reposit.countmanager(manager);
		 * 
		 * System.out.println("This is count" + managercount); // String name =
		 * serv.getByName(email);
		 * 
		 * long querycounts = queries.querycountcounts(id);
		 * 
		 * List<leaveDates> leaves = serv.getleavedetailsemp(ids);
		 * 
		 * // This is to get the query mail List<Querymails> queries =
		 * serv.getquerydetailsemp(ids);
		 * 
		 * // This is to display the projects to the individual List<currentProjects>
		 * projectsdata = serv.getprojectdetailsemp(ids);
		 * 
		 * // System.out.println("This is id"+id); // System.out.println(clas);
		 * 
		 * int id1 = serv.getById(email);
		 * 
		 * long projectcountA = projectRepos.projectcount(id);
		 * mks.addAttribute("projectcountA", projectcountA);
		 * mks.addAttribute("projectsdata", projectsdata);
		 * 
		 * mks.addAttribute("querycounts", querycounts); // mks.addAttribute("Datas_lk",
		 * services.getAlluser()); mks.addAttribute("ids", id1); mks.addAttribute("ids",
		 * ids); mks.addAttribute("name", name); mks.addAttribute("count", count);
		 * 
		 * List<currentProjects> projectsdatam = services.getmanagersemp(id);
		 * 
		 * mks.addAttribute("projectDatas", projectsdatam);
		 * 
		 * mks.addAttribute("querycount", querycount); mks.addAttribute("projectcount",
		 * projectcount); mks.addAttribute("projectcountM", projectcountM);
		 * mks.addAttribute("leavecount", leavecount); //
		 * System.out.println(managercount); mks.addAttribute("managercount",
		 * managercount); // mks.addAttribute("Datas_lk", services.getAlluser());
		 * mks.addAttribute("Role", Role); System.out.println("This is admin" + Role);
		 * 
		 * mks.addAttribute("Role", Role); mks.addAttribute("name", name);
		 * mks.addAttribute("leaves", leaves); mks.addAttribute("queries", queries);
		 * System.out.println("This is manager" + Role); System.out.println(Role); //
		 * rattrs.addAttribute("string", "this will be converted into string, if not //
		 * already"); mks.addAttribute("userDatas", services.getAlluser());
		 * 
		 * System.out.println(usernames);
		 * 
		 * return "managerdisplays"; }
		 */
		  JSONObject obj = new JSONObject();
		
		System.out.println("emailid "+employee.getEmailid());
		String Email=employee.getEmailid();
		obj.put("Email",Email);
		
		
		
		
//here the data is receiving but i cant do any thing as of now we have to compare the data and send the equest as login to frontend and so on
//still the emailid is null
		System.out.println("password "+employee.getPassword());
		String password=employee.getPassword();

	//	int Totalleave=reposit.getleave(Email);
		
//		obj.put("Totalleave",Totalleave);
//		
//		System.out.println(Totalleave);
		jva_clas clas = serv.getByname(Email);
				//.orElseThrow(()->new ResourceNotFoundException("The employee not found"));
		
		System.out.println("db pass "+clas.getPassword());
		int id = serv.getempId(Email);
		
		
	int managerid =	reposit.getmanagerprofile(id);
		
		
		//int notpending
		
//		int counts =LeaveReposits.getleavecounts(id);
//		System.out.println("thisi applied counts"+counts);
//		obj.put("Appliedleaves",counts);
		
		
		
		
	//String email=reposit.getemail(Email);
		
		//jva_clas alluser =reposit.getById(id);
		
		String Role = serv.getByRole(Email);
		 // String position= serv.getByposition(Email);
			  String name = serv.getByName(Email);
		System.out.println("This is the id "+id);
		
		if(clas !=null && Email!=null) {//here the default value is false so we are using the not condition here to satisfy the condition here 
			System.out.println("the User exists1");
			
			String password1=clas.getPassword();
			
			
			if(password.equals(password1) ) {
//				String Success="success";
				
				System.out.println("the User exists");
				String Success="Success"; 
			
				
			      obj.put("Name",name );
					obj.put("id", id);
					obj.put("Role",Role);
					
					int managercheck=reposit.getmanageer(id);
					
					String managername=reposit.getmanagername(managercheck);
					
					obj.put("managerincharge",managername );
					
					long projectcount = projectRepos.findByempprojects(id);
					long projectcountM = projectRepos.projectcount(id);
					obj.put("projectcount",projectcount);
					obj.put("projectcountM",projectcountM);
							
						
					
					String status="pending";
							  long querycount = queries.findByempquery(id, status);
							
							  
							  long 	Allqueries=queries.findqueries(id);
							  
							  String status1="Accept";  
							  long 	accepted=queries.findacceptqueries(id,status1);
							  obj.put("AcceptQueries", accepted);
							  String status2="Reject";  
							  long 	Reject=queries.findRejectqueries(id,status2);
							  obj.put("reject", Reject);
							  obj.put("AcceptQueries", accepted);
							  obj.put("allqueries", Allqueries);
							  long Allquerycount = queries.findByAllempquery(id);
							  obj.put("UnansweredQuery",Allquerycount);
							  
							  obj.put("querycount",querycount);
				//	obj.put("alluser", alluser);
					
				//	obj.put("object", clas);
					
					//TODO Auto-generated catch block
				
				
				return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
			}
			
			else {
				
				 obj.put("wrong","Error");
					return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
			}
		
			
			//return ResponseEntity.ok(Success);
		}

		String fail="failed";
		return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
	

	}

	

	
	

	//here the data is receiving but i cant do any thing as of now we have to compare the data and send the request as login to frontend and so on
	//still the emailid is null


	

	

	

	/*
	 * @RequestMapping("/EmpDetails") public String EmployeDetails() {
	 * 
	 * return "EmpDetails";
	 * 
	 * }
	 * 
	 * @RequestMapping("/TestingSidenavbar") public String TestingSidenavbar() {
	 * 
	 * return "TestingSidenavbar";
	 * 
	 * }
	 * 
	 * // Secondnavbartest
	 * 
	 * @RequestMapping("/Secondnavbartest") public String Secondnavbartest() {
	 * 
	 * return "Secondnavbartest";
	 * 
	 * }
	 * 
	 * //This is for displaying all users to the Admin
	 * 
	 * @RequestMapping("displays") public String disp_all_user(Model mks) { try { //
	 * int id=idds;
	 * 
	 * Integer id = (Integer) session.getAttribute("id"); String name =
	 * serv.getByNameid(id); mks.addAttribute("name", name);
	 * 
	 * mks.addAttribute("Datas_lk", services.getAlluser()); //this is for getting
	 * the individual employees for the singlt manager
	 * 
	 * return "Display"; } catch (Exception e) {
	 * 
	 * return "errormsg"; } }
	 * 
	 * 
	 * //this is to display the leave and query details to all
	 * 
	 * @RequestMapping("LEAVEDISPLAYALL") public String LEAVEDISPLAYALL(Model mks) {
	 * try { // int id=idds;
	 * 
	 * Integer id = (Integer) session.getAttribute("id"); String name =
	 * serv.getByNameid(id); mks.addAttribute("name", name);
	 * 
	 * List<leaveDates> leaves = serv.getleavedetailsemp(id);
	 * 
	 * mks.addAttribute("leaves", leaves); // This is to get the query mail //
	 * List<Querymails> queries = serv.getquerydetailsemp(id);
	 * 
	 * //this is for getting the individual employees for the singlt manager
	 * 
	 * return "LEAVEDISPLAYALL"; } catch (Exception e) {
	 * 
	 * return "errormsg"; } }
	 * 
	 * //
	 * 
	 * @RequestMapping("updatequery") public String updatequery(Model mks) { try {
	 * // int id=idds;
	 * 
	 * Integer id = (Integer) session.getAttribute("id"); String name =
	 * serv.getByNameid(id); mks.addAttribute("name", name);
	 * 
	 * // List<leaveDates> leaves = serv.getleavedetailsemp(id);
	 * 
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(id); mks.addAttribute("queries", queries);
	 * 
	 * 
	 * return "updatequery"; } catch (Exception e) {
	 * 
	 * return "errormsg"; } }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @RequestMapping("updateEmpquery") public String updateEmpquery(Model mks) {
	 * try { // int id=idds;
	 * 
	 * Integer id = (Integer) session.getAttribute("id"); String name =
	 * serv.getByNameid(id); mks.addAttribute("name", name);
	 * 
	 * // List<leaveDates> leaves = serv.getleavedetailsemp(id);
	 * 
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(id); mks.addAttribute("queries", queries);
	 * 
	 * 
	 * return "updateEmpquery"; } catch (Exception e) {
	 * 
	 * return "errormsg"; } }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * // This is to display the details to the manager
	 * 
	 * @RequestMapping("MangrDisply") public String disp_all_user_manager(Model mks)
	 * { try {
	 * 
	 * Integer idds = (Integer) session.getAttribute("id"); String name =
	 * serv.getByNameid(idds);
	 * 
	 * 
	 * mks.addAttribute("Datas_lk", services.getAlluser());
	 * 
	 * List<leaveDates> leaves = serv.getleavedetailsemp(idds);
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(idds);
	 * 
	 * // This is to display the projects to the individual
	 * //System.out.println("This is id"+idds);
	 * 
	 * 
	 * mks.addAttribute("name", name); mks.addAttribute("ids", idds);
	 * 
	 * mks.addAttribute("leaves", leaves); mks.addAttribute("queries", queries);
	 * mks.addAttribute("ids", idds);
	 * 
	 * 
	 * return "Mangr_Emp_Disply"; } catch (Exception e) {
	 * 
	 * return "errormsg"; } }
	 * 
	 * //This is for testing purpose here
	 * 
	 * @GetMapping("/suggest-event") public String suggestEvent() { return
	 * "/suggested-event/suggestEvent"; }
	 * 
	 * @PostMapping("/suggest-event") public String
	 * receiveSuggestedEvent(BindingResult result, RedirectAttributes
	 * redirectAttributes) { redirectAttributes.addFlashAttribute("message",
	 * "Failed"); redirectAttributes.addFlashAttribute("alertClass",
	 * "alert-danger"); if (result.hasErrors()) { return "redirect:/suggest-event";
	 * } redirectAttributes.addFlashAttribute("message", "Success");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success"); return
	 * "redirect:/suggest-event"; }
	 * 
	 * // This is for displaying the project to the manager
	 * 
	 * @RequestMapping("projectsdisplay") public String Displayprojects(Model mks) {
	 * 
	 * try { Integer id = (Integer) session.getAttribute("id"); // int id=idds;
	 * String name = serv.getByNameid(id); mks.addAttribute("name", name);
	 * mks.addAttribute("Datas_lk", services.getAllprojects());
	 * 
	 * return "projectsdisplay";
	 * 
	 * } catch (Exception e) {
	 * 
	 * return "errormsg"; }
	 * 
	 * }
	 * 
	 * 
	 * @RequestMapping("/viewmore/{id}") public String empViewmore(Model
	 * mks,@PathVariable(value = "id") int id) {
	 * 
	 * try {
	 * 
	 * String name = serv.getByNameid(id); mks.addAttribute("name", name);
	 * mks.addAttribute("Datas_lk", services.getAllprojects());
	 * 
	 * List<leaveDates> leaves = serv.getleavedetailsemp(id); List<currentProjects>
	 * projectsdata = services.getmanagersemp(id);
	 * 
	 * 
	 * mks.addAttribute("projectsdata", projectsdata);
	 * 
	 * mks.addAttribute("leave", leaves);
	 * 
	 * 
	 * return "EmpViewmore";
	 * 
	 * } catch (Exception e) {
	 * 
	 * return "errormsg"; }
	 * 
	 * }
	 * 
	 * // This is to display the leave dates to the admin
	 * 
	 * @RequestMapping("Leavedisplay") public String Displayleave(Model mks) {
	 * 
	 * try { Integer id = (Integer) session.getAttribute("id"); //int id=idds;
	 * String name = serv.getByNameid(id); mks.addAttribute("name", name);
	 * mks.addAttribute("Datas_lk", services.getAllLeave());
	 * 
	 * return "Leavedisplay"; } catch (Exception e) {
	 * 
	 * return "errormsg"; }
	 * 
	 * }
	 * 
	 * // This is to display the querie to the adimin
	 * 
	 * @RequestMapping("/DisplayAllqueries") public String Querymessage(Model mks,
	 * RedirectAttributes redirectAttributes) {
	 * 
	 * Integer idds = (Integer) session.getAttribute("id"); int id=idds; String name
	 * = serv.getByNameid(id); mks.addAttribute("name", name);
	 * mks.addAttribute("queries", services.getallQuerymails());
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Deleted Successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success"); return
	 * "DisplayAllqueries";
	 * 
	 * }
	 * 
	 * 
	 * //This is for displaying the salary and department
	 * 
	 * @RequestMapping("Updatesalary") public String Updatesalaryanddepts(Model cls)
	 * {
	 * 
	 * try {
	 * 
	 * Integer idds = (Integer) session.getAttribute("id"); int id=idds; String name
	 * = serv.getByNameid(id); cls.addAttribute("name", name);
	 * cls.addAttribute("salaries", services.getAllusersalary());
	 * 
	 * return "Updatesalary";
	 * 
	 * } catch (Exception e) {
	 * 
	 * return "redirect:/error"; }
	 * 
	 * }
	 * 
	 * 
	 * // This is to display the projects to the manager ->ManagerDisplayProjects
	 * 
	 * @RequestMapping("ManagerDisplayProjects") public String
	 * Displayprojects_manager(Model mks) {
	 * 
	 * try { Integer idds = (Integer) session.getAttribute("id"); int id=idds;
	 * 
	 * 
	 * List<leaveDates> leaves = serv.getleavedetailsemp(id);
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(id);
	 * 
	 * // This is to display the projects to the individual List<currentProjects>
	 * projectsdata = services.getmanagersemp(id);
	 * 
	 * mks.addAttribute("Datas_lk", projectsdata); String name =
	 * serv.getByNameid(idds); //mks.addAttribute("queries", queries); //
	 * mks.addAttribute("Datas_lk", services.getAlluser()); mks.addAttribute("ids",
	 * id); mks.addAttribute("leaves", leaves); mks.addAttribute("queries",
	 * queries); mks.addAttribute("name", name);
	 * 
	 * List<List<String>> c = projectRepos.concat("spring");
	 * System.out.println("ccccc"+c); return "ManagerDisplayProjects"; } catch
	 * (Exception e) {
	 * 
	 * return "errormsg"; }
	 * 
	 * }
	 * 
	 * @GetMapping("login/Employeeid/password") public String Homepg(Model
	 * mks, @RequestParam(value = "Employeeid") int id,
	 * 
	 * @RequestParam(value = "password") String pass) {
	 * 
	 * String clas = serv.getById(id);
	 * 
	 * // System.out.println(clas);
	 * 
	 * if (clas != null && clas.equals(pass)) {
	 * 
	 * mks.addAttribute("Datas_lk", services.getAlluser());
	 * 
	 * return "Display";
	 * 
	 * } return "failedlogin";
	 * 
	 * }
	 * 
	 * // Thi is for testing purpose here
	 * 
	 * @RequestMapping("admin_check/Emailid/password") public String Admin_log(Model
	 * mks, @RequestParam(value = "password") String pass,
	 * 
	 * @RequestParam(value = "Emailid") String email) {
	 * 
	 * String clas = adminserv.getByname(email); System.out.println(clas); if (clas
	 * != null && clas.equals(pass)) { mks.addAttribute("Datas_lk",
	 * services.getAlluser());
	 * 
	 * return "After_login"; }
	 * 
	 * return "failedlogin";
	 * 
	 * }
	 * 
	 * // This is for taking the password // This is the login page
	 * 
	 * @RequestMapping("loginPwds") public String password(jva_clas jva,Model
	 * mks,RedirectAttributes rattrs,HttpSession session) {
	 * 
	 * // System.out.println(pass);
	 * 
	 * 
	 * String email=jva.getEmailid(); String pass=jva.getPassword();
	 * 
	 * System.out.println(email); System.out.println(pass);
	 * 
	 * String clas = serv.getByname(email);
	 * 
	 * String Role = serv.getByRole(email);
	 * 
	 * String name = serv.getByName(email);
	 * 
	 * 
	 * int ids = serv.getempId(email);
	 * 
	 * 
	 * session.setAttribute("id", ids);
	 * 
	 * // sessionStorage.setItem("firstName", "ids");
	 * System.out.println("This is id "+ ids); // this is for getting whole details
	 * from the employee
	 * 
	 * // idds=ids; // System.out.println("This is id "+idds); int id =
	 * serv.getById(email); long count=reposit.counts(ids);
	 * 
	 * String manager="Manager"; long managercount=reposit.countmanager(manager);
	 * 
	 * System.out.println("This is count"+managercount); //String name =
	 * serv.getByName(email);
	 * 
	 * List<leaveDates> leaves = serv.getleavedetailsemp(ids);
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(ids);
	 * 
	 * // This is to display the projects to the individual List<currentProjects>
	 * projectsdata = serv.getprojectdetailsemp(ids);
	 * 
	 * // System.out.println("This is id"+id); // System.out.println(clas);
	 * 
	 * if (clas != null && clas.equals(pass) && Role.equals("Employee")) {
	 * 
	 * mks.addAttribute("Datas_lk", services.getAlluser());
	 * 
	 * // This is for taking the password jva_clas clas1 =
	 * services.getById_det(ids);
	 * 
	 * 
	 * // leaveDates leavedates=services.getById_lev(id);
	 * 
	 * if (clas1 == null) { return "wrong_emp_id";
	 * 
	 * }
	 * 
	 * mks.addAttribute("password", clas1);
	 * 
	 * // mks.addAttribute("leaves", leavedates); mks.addAttribute("Role", Role);
	 * mks.addAttribute("name", name); mks.addAttribute("ids", ids);
	 * mks.addAttribute("leaves", leaves); mks.addAttribute("queries", queries);
	 * mks.addAttribute("projectsdata", projectsdata);
	 * System.out.println("This is employee"+Role); return "managerdisplays"; }
	 * 
	 * else if (clas != null && clas.equals(pass) && Role.equals("Admin")) {
	 * mks.addAttribute("ids", ids); mks.addAttribute("name", name);
	 * mks.addAttribute("count", count); // System.out.println(managercount);
	 * mks.addAttribute("managercount", managercount); //
	 * mks.addAttribute("Datas_lk", services.getAlluser()); mks.addAttribute("Role",
	 * Role); System.out.println("This is admin"+Role); // RequestCache requestCache
	 * = new HttpSessionRequestCache(); //
	 * requestCache.saveRequest(request,response);
	 * 
	 * return "managerdisplays";
	 * 
	 * }
	 * 
	 * else if (clas != null && clas.equals(pass) && Role.equals("Manager")) { int
	 * id1 = serv.getById(email); // mks.addAttribute("Datas_lk",
	 * services.getAlluser()); mks.addAttribute("ids", id1);
	 * 
	 * 
	 * mks.addAttribute("Role", Role); mks.addAttribute("name", name);
	 * mks.addAttribute("leaves", leaves); mks.addAttribute("queries", queries);
	 * System.out.println("This is manager"+Role); System.out.println(Role); //
	 * rattrs.addAttribute("string",
	 * "this will be converted into string, if not already");
	 * rattrs.addFlashAttribute("pojo",id1 );
	 * 
	 * return "managerdisplays";
	 * 
	 * }
	 * 
	 * return "failedlogin"; }
	 * 
	 * 
	 * 
	 * @GetMapping("/displayempproject") public String displayempproject(Model mks)
	 * { // This is to display the projects to the individual //int id=idds; Integer
	 * id = (Integer) session.getAttribute("id"); List<currentProjects> projectsdata
	 * = serv.getprojectdetailsemp(id); String name = serv.getByNameid(id);
	 * mks.addAttribute("name", name); mks.addAttribute("projects", projectsdata);
	 * 
	 * return "empprojects";
	 * 
	 * }
	 * 
	 * @GetMapping("/employeeloginsuccess") public String employeeloginsuccess(Model
	 * mks) {
	 * 
	 * //int id=idds; Integer id = (Integer) session.getAttribute("id");
	 * 
	 * String name = serv.getByNameid(id);
	 * 
	 * String status="pending";
	 * 
	 * long leavecount=LeaveReposits.findByempstatus(id,status);
	 * 
	 * long projectcount=projectRepos.findByempprojects(id);
	 * 
	 * 
	 * long querycount=queries.findByempquery(id,status);
	 * 
	 * 
	 * //System.out.println(querycount); List<leaveDates> leaves =
	 * serv.getleavedetailsemp(id);
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(id);
	 * 
	 * // This is to display the projects to the individual List<currentProjects>
	 * projectsdata = serv.getprojectdetailsemp(id); jva_clas clas1 =
	 * services.getById_det(id);
	 * 
	 * mks.addAttribute("password", clas1);
	 * 
	 * 
	 * // mks.addAttribute("leaves", leavedates); mks.addAttribute("Datas_lk",
	 * services.getAlluser()); mks.addAttribute("name", name);
	 * mks.addAttribute("ids", id); mks.addAttribute("querycount", querycount);
	 * mks.addAttribute("projectcount", projectcount);
	 * mks.addAttribute("leavecount", leavecount); mks.addAttribute("leaves",
	 * leaves); mks.addAttribute("queries", queries); long count=reposit.counts(id);
	 * mks.addAttribute("count", count);
	 * 
	 * mks.addAttribute("projectsdata", projectsdata);
	 * 
	 * 
	 * return "employeeloginsuccess";
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @GetMapping("/Adminloginsuccess") public String Adminloginsuccess(Model mks)
	 * {
	 * 
	 * Integer id = (Integer) session.getAttribute("id");
	 * 
	 * String name = serv.getByNameid(id); long count=reposit.counts(id); long
	 * projectcount=projectRepos.projectcount(id); long
	 * querycount=queries.querycountcounts(id); String manager="Manager"; long
	 * managercount=reposit.countmanager(manager);
	 * 
	 * System.out.println("This is count"+managercount);
	 * mks.addAttribute("managercount", managercount); String status="pending"; long
	 * leavecount=LeaveReposits.findBystatus(status);
	 * 
	 * mks.addAttribute("leavecount", leavecount); mks.addAttribute("ids", id);
	 * mks.addAttribute("projectcount", projectcount); mks.addAttribute("name",
	 * name); mks.addAttribute("count", count); mks.addAttribute("querycount",
	 * querycount);
	 * 
	 * 
	 * return "Adminloginsuccess";
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @GetMapping("/managerdisplays") public String managerdisplays(HttpSession
	 * session,Model mks) {
	 * 
	 * //int id=idds;
	 * 
	 * // int id=isd;'
	 * 
	 * Integer id = (Integer) session.getAttribute("id");
	 * 
	 * long count=reposit.counts(id); // System.out.println("This is pojo"+id);
	 * 
	 * 
	 * // System.out.println("This is request"+requestCount); //long
	 * querycount=queries.querycountcounts(id);
	 * 
	 * 
	 * 
	 * 
	 * long projectcount=projectRepos.projectcount(id);
	 * 
	 * 
	 * String status="pending";
	 * 
	 * long querycount=queries.findByempquery(id,status); long
	 * leavecount=LeaveReposits.findByempstatus(id,status);
	 * 
	 * // System.out.println("This is leave"+leavecount);
	 * 
	 * List<leaveDates> leaves = serv.getleavedetailsemp(id);
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(id);
	 * 
	 * // This is to display the projects to the individual //List<currentProjects>
	 * projectsdata = serv.getprojectdetailsemp(id);
	 * 
	 * mks.addAttribute("Datas_lk", services.getAllprojects()); String name =
	 * serv.getByNameid(id); //mks.addAttribute("queries", queries);
	 * mks.addAttribute("Datas_lk", services.getAlluser()); mks.addAttribute("ids",
	 * id); mks.addAttribute("leaves", leaves); mks.addAttribute("queries",
	 * queries); mks.addAttribute("name", name); mks.addAttribute("count", count);
	 * mks.addAttribute("leavecount", leavecount); mks.addAttribute("querycount",
	 * querycount); mks.addAttribute("projectcount", projectcount); //
	 * this.serv.deleteprojects(id); return "managerdisplays"; }
	 * 
	 * 
	 * 
	 * //this is for testing purpose here
	 * 
	 * 
	 * @RequestMapping("/admin_check/Emailid/password") public String
	 * Admin_log(Model mks, @RequestParam(value = "password") String pass,
	 * 
	 * @RequestParam(value = "Emailid") String email) {
	 * 
	 * System.out.println(pass); String clas = adminserv.getByname(email);
	 * System.out.println(clas); if (clas != null && clas.equals(pass)) {
	 * mks.addAttribute("Datas_lk", services.getAlluser());
	 * 
	 * return "After_login"; }
	 * 
	 * return "failedlogin";
	 * 
	 * 
	 * 
	 * 
	 * // this is for the testing purpose here
	 * 
	 * @RequestMapping("forgetpwds/Employeeid") public String Forgetpwds(Model
	 * mks, @RequestParam(value = "Employeeid") int id) {
	 * 
	 * jva_clas clas = services.getByIdd(id); if (clas == null) { return
	 * "wrong_emp_id";
	 * 
	 * } mks.addAttribute("password", clas);
	 * 
	 * return "PASSWORD_DISPLAY";
	 * 
	 * }
	 * 
	 * 
	 * @GetMapping("/delete/{id}") public String delete(@PathVariable(value = "id")
	 * int id) {
	 * 
	 * 
	 * this.serv.deleteById(id); return "redirect:/displays";
	 * 
	 * 
	 * }
	 * 
	 * 
	 * //this is to delete the employee
	 * 
	 * @GetMapping("/deleteempleave/{id}") public String
	 * deleteemp(@PathVariable(value = "id") int id) {
	 * 
	 * this.serv.deleteleave(id); return "redirect:/leavestatusemp";
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * // deletequery/{id}
	 * 
	 * @GetMapping("/deletequery/{id}") public String
	 * deletequery(@PathVariable(value = "id") int id) {
	 * 
	 * 
	 * queries.deleteById(id); return "redirect:/updatequery";
	 * 
	 * 
	 * }
	 * 
	 * //leave status for emp
	 * 
	 * @GetMapping("leavestatusemp") public String leavestatusemp(Model mks) {
	 * 
	 * try { // int id=idds;
	 * 
	 * Integer id = (Integer) session.getAttribute("id"); String name =
	 * serv.getByNameid(id); mks.addAttribute("name", name);
	 * 
	 * List<leaveDates> leaves = serv.getleavedetailsemp(id);
	 * 
	 * 
	 * // This is to get the query mail // List<Querymails> queries =
	 * serv.getquerydetailsemp(id); mks.addAttribute("leaves", leaves);
	 * 
	 * return "leavestatusemp"; } catch (Exception e) {
	 * 
	 * return "errormsg"; }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @GetMapping("displayprojects") public String displayprojects() {
	 * 
	 * return "displayprojects";
	 * 
	 * } // This is to delete the projcts list
	 * 
	 * @GetMapping("/deleteprojects/{id}") public String
	 * deleteprojects(@PathVariable(value = "id") int id, RedirectAttributes
	 * redirectAttributes){
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Failed");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Deleted Successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * this.serv.deleteprojects(id);
	 * 
	 * return "redirect:/projectsdisplay"; }
	 * 
	 * //tHIS IS THE MANAGER DELETE THE PROJECT
	 * 
	 * @GetMapping("/deletemanagerprojects/{id}") public String
	 * deleteManagerprojects(@PathVariable(value = "id") int id ,RedirectAttributes
	 * redirectAttributes){
	 * 
	 * 
	 * // System.out.println(id);
	 * 
	 * //List<currentProjects> oldprojects = serv.getprojects(id);
	 * 
	 * //mks.addAttribute("old", oldprojects);
	 * redirectAttributes.addFlashAttribute("message", "Failed");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Deleted Successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * this.serv.deleteprojects(id);
	 * 
	 * return "redirect:/ManagerDisplayProjects"; }
	 * 
	 * 
	 * //tHIS IS THE MANAGER DELETE THE PROJECT
	 * 
	 * @GetMapping("/deleteempqueries/{id}") public String
	 * deleteempqueries(@PathVariable(value = "id") int id ,RedirectAttributes
	 * redirectAttributes){
	 * 
	 * 
	 * // System.out.println(id);
	 * 
	 * //List<currentProjects> oldprojects = serv.getprojects(id);
	 * 
	 * //mks.addAttribute("old", oldprojects);
	 * redirectAttributes.addFlashAttribute("message", "Failed");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Deleted Successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * queries.deleteById(id);
	 * 
	 * 
	 * return "redirect:/updateEmpquery"; }
	 * 
	 * 
	 * 
	 * @GetMapping("/deleteleave/{id}") public String
	 * deleteleave(@PathVariable(value = "id") int id, RedirectAttributes
	 * redirectAttributes){
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Failed");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Deleted Successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * this.serv.deleteleave(id);
	 * 
	 * return "redirect:/LEAVEDISPLAYALL"; }
	 * 
	 * 
	 * 
	 * @GetMapping("update/{id}") public String
	 * showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
	 * 
	 * try { jva_clas employee = serv.getEmployeeById(id);
	 * 
	 * model.addAttribute("employee", employee); Integer ids = (Integer)
	 * session.getAttribute("id"); //int ids=idds; String name =
	 * serv.getByNameid(ids); model.addAttribute("name", name);
	 * 
	 * return "update_employee"; } catch (Exception e) { return "errormsg"; } }
	 * 
	 * 
	 * // This is for updating the leave status
	 * 
	 * @GetMapping("/updatestatus/{id}") public String
	 * Updateleavestatus(@PathVariable(value = "id") int id, Model model) {
	 * 
	 * // leaveDates leaveDates= serv.findByid(int id); leaveDates leaves =
	 * serv.getleavedetails(id); Integer ids = (Integer) session.getAttribute("id");
	 * // int ids=idds; String name = serv.getByNameid(ids);
	 * model.addAttribute("name", name);
	 * 
	 * 
	 * model.addAttribute("leaves", leaves);
	 * 
	 * return "updateLeavestatus";
	 * 
	 * }
	 * 
	 * //This is for updating the salary
	 * 
	 * 
	 * @GetMapping("/updatesalary/{id}") public String
	 * updatesalary(@PathVariable(value = "id") int id, Model model,
	 * RedirectAttributes redirectAttributes) {
	 * 
	 * 
	 * Integer ids = (Integer) session.getAttribute("id"); //int ids=idds; String
	 * name = serv.getByNameid(ids); model.addAttribute("name", name); Salary Salary
	 * = serv.getsalarydetails(id);
	 * 
	 * redirectAttributes.addFlashAttribute("message",
	 * "Employee added Successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * model.addAttribute("Salary", Salary);
	 * 
	 * return "deptandsalaryupdate";
	 * 
	 * }
	 * 
	 * 
	 * // This is for updating the queries status
	 * 
	 * @GetMapping("/updatequeries/{id}") public String
	 * updatequeries(@PathVariable(value = "id") int id, Model model,
	 * RedirectAttributes redirectAttributes) {
	 * 
	 * // leaveDates leaveDates= serv.findByid(int id); Integer idds = (Integer)
	 * session.getAttribute("id"); int ids=idds; String name =
	 * serv.getByNameid(ids); model.addAttribute("name", name); Querymails queries =
	 * serv.getquerydetails(id);
	 * 
	 * model.addAttribute("queries", queries);
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Deleted Successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * 
	 * return "updatequeries";
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @GetMapping("/updatequerymanager/{id}") public String
	 * updatequery(@PathVariable(value = "id") int id, Model model) {
	 * 
	 * // leaveDates leaveDates= serv.findByid(int id); Integer idds = (Integer)
	 * session.getAttribute("id"); int ids=idds; String name =
	 * serv.getByNameid(ids); model.addAttribute("name", name); Querymails queries =
	 * serv.getquerydetails(id);
	 * 
	 * model.addAttribute("queries", queries);
	 * 
	 * return "updatequerymanager";
	 * 
	 * }
	 * 
	 * //old projects
	 * 
	 * 
	 * @GetMapping("/updateempqueries/{id}") public String
	 * updateempqueries(@PathVariable(value = "id") int id, Model model) {
	 * 
	 * // leaveDates leaveDates= serv.findByid(int id); Integer idds = (Integer)
	 * session.getAttribute("id"); int ids=idds; String name =
	 * serv.getByNameid(ids); model.addAttribute("name", name); Querymails queries =
	 * serv.getquerydetails(id);
	 * 
	 * model.addAttribute("queries", queries);
	 * 
	 * return "updatequeryemployee";
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * // This is for getting the id from the user when he applies leave
	 * 
	 * @GetMapping("/sendmail") public String LeaveMail(Model model) { Integer idds
	 * = (Integer) session.getAttribute("id"); int id=idds; List<leaveDates> leaves
	 * = serv.getleavedetailsemp(id);
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(id);
	 * 
	 * // This is to display the projects to the individual List<currentProjects>
	 * projectsdata = serv.getprojectdetailsemp(id);
	 * 
	 * model.addAttribute("Datas_lk", services.getAllprojects()); String name =
	 * serv.getByNameid(idds); //mks.addAttribute("queries", queries); //
	 * mks.addAttribute("Datas_lk", services.getAlluser());
	 * model.addAttribute("ids", id); model.addAttribute("leaves", leaves);
	 * model.addAttribute("queries", queries); model.addAttribute("name", name);
	 * 
	 * // System.out.println(ids); model.addAttribute("ids",idds);
	 * //model.addAttribute("ids", ids); return "leavemail";
	 * 
	 * }
	 * 
	 * 
	 * //This is for displaying the leave to the employee
	 * 
	 * @GetMapping("/empleavemails") public String leavemails(Model model) { Integer
	 * idds = (Integer) session.getAttribute("id"); int id=idds; List<leaveDates>
	 * leaves = serv.getleavedetailsemp(id);
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(id);
	 * 
	 * // This is to display the projects to the individual List<currentProjects>
	 * projectsdata = serv.getprojectdetailsemp(id);
	 * 
	 * model.addAttribute("Datas_lk", services.getAllprojects()); String name =
	 * serv.getByNameid(idds); //mks.addAttribute("queries", queries); //
	 * mks.addAttribute("Datas_lk", services.getAlluser());
	 * model.addAttribute("ids", id); model.addAttribute("leaves", leaves);
	 * model.addAttribute("queries", queries); model.addAttribute("name", name);
	 * 
	 * // System.out.println(ids); model.addAttribute("ids",idds);
	 * //model.addAttribute("ids", ids); return "leaverequest";
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * // This is for help and support
	 * 
	 * @RequestMapping("Help") public String Help(Model model) { Integer idds =
	 * (Integer) session.getAttribute("id"); int id=idds;
	 * 
	 * String name = serv.getByNameid(idds); System.out.println(name);
	 * List<leaveDates> leaves = serv.getleavedetailsemp(id);
	 * 
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(id);
	 * 
	 * // This is to display the projects to the individual List<currentProjects>
	 * projectsdata = serv.getprojectdetailsemp(id);
	 * 
	 * model.addAttribute("Datas_lk", services.getAllprojects());
	 * 
	 * //mks.addAttribute("queries", queries); // mks.addAttribute("Datas_lk",
	 * services.getAlluser()); model.addAttribute("ids", id);
	 * model.addAttribute("name", name); model.addAttribute("leaves", leaves);
	 * model.addAttribute("queries", queries); model.addAttribute("ids", idds);
	 * return "Help";
	 * 
	 * }
	 * 
	 * //This is for help and suport for the employe
	 * 
	 * @RequestMapping("empHelp") public String empHelp(Model model) { Integer idds
	 * = (Integer) session.getAttribute("id"); int id=idds;
	 * 
	 * String name = serv.getByNameid(idds); // System.out.println(name);
	 * List<leaveDates> leaves = serv.getleavedetailsemp(id);
	 * 
	 * 
	 * // This is to get the query mail List<Querymails> queries =
	 * serv.getquerydetailsemp(id);
	 * 
	 * // This is to display the projects to the individual List<currentProjects>
	 * projectsdata = serv.getprojectdetailsemp(id);
	 * 
	 * model.addAttribute("Datas_lk", services.getAllprojects());
	 * 
	 * //mks.addAttribute("queries", queries); // mks.addAttribute("Datas_lk",
	 * services.getAlluser()); model.addAttribute("ids", id);
	 * model.addAttribute("name", name); model.addAttribute("leaves", leaves);
	 * model.addAttribute("queries", queries); model.addAttribute("projectsdata",
	 * projectsdata); model.addAttribute("ids", idds); return "empHelp";
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * //This is for Adding the salary
	 * 
	 * @RequestMapping("updatesalaryanddept") public String savesalary(Model mks,
	 * RedirectAttributes redirectAttributes) {
	 * 
	 * try { Integer idds = (Integer) session.getAttribute("id"); int id=idds;
	 * String name = serv.getByNameid(id);
	 * 
	 * mks.addAttribute("name", name); mks.addAttribute("queries",
	 * services.getallQuerymails()); // model.addAttribute("ids", ids);
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Success");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * 
	 * return "salaryAndDept";
	 * 
	 * 
	 * }catch (Exception e) {
	 * 
	 * 
	 * return "redirect:/updatesalaryanddept";
	 * 
	 * } }
	 * 
	 * 
	 * @RequestMapping("updatesalary") public String savesalary(@ModelAttribute
	 * Salary cls, RedirectAttributes redirectAttributes) { //
	 * model.addAttribute("ids", ids); try {
	 * redirectAttributes.addFlashAttribute("message", " Added successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * salaryRepoes.save(cls);
	 * 
	 * return "redirect:/Updatesalary"; }catch (Exception e) {
	 * 
	 * redirectAttributes.addFlashAttribute("message", "position Already exists");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success"); return
	 * "redirect:/updatesalaryanddept";
	 * 
	 * }
	 * 
	 * }
	 * 
	 * // This is after the save employee
	 * 
	 * @PostMapping("/saveEmployee") public String saveEmployee(@ModelAttribute
	 * jva_clas cls, RedirectAttributes redirectAttributes,BindingResult jva_clas) {
	 * // save employee to database redirectAttributes.addFlashAttribute("message",
	 * "Failed"); redirectAttributes.addFlashAttribute("alertClass",
	 * "alert-danger");
	 * 
	 * if (jva_clas.hasErrors()) { return "redirect:/displays"; }
	 * redirectAttributes.addFlashAttribute("message", "Success");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * reposit.save(cls); return "redirect:/displays";
	 * 
	 * }
	 * 
	 * // This is to update the leave status information
	 * 
	 * @PostMapping("/saveLeaveStatus") public String
	 * saveLeaveStatus(@ModelAttribute leaveDates leaveDate, RedirectAttributes
	 * redirectAttributes,BindingResult leaveDates) { // save leavestatus to
	 * database redirectAttributes.addFlashAttribute("message", "Failed");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
	 * 
	 * if (leaveDates.hasErrors()) { return "redirect:/Leavedisplay"; }
	 * redirectAttributes.addFlashAttribute("message", "Success");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * LeaveReposits.save(leaveDate); return "redirect:/Leavedisplay"; }
	 * 
	 * // This is for saving the queries
	 * 
	 * @PostMapping("/savequeries") public String savequeries(@ModelAttribute
	 * Querymails Querymails, RedirectAttributes redirectAttributes) { // save
	 * leavestatus to database queries.save(Querymails);
	 * redirectAttributes.addFlashAttribute("message",
	 * "Query updated Successfully");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success"); return
	 * "redirect:/DisplayAllqueries"; }
	 * 
	 * 
	 * 
	 * @PostMapping("/savemanagerqueries") public String
	 * savemanagerqueries(@ModelAttribute Querymails Querymails) { // save
	 * leavestatus to database queries.save(Querymails); return
	 * "redirect:/updatequery"; }
	 * 
	 * 
	 * 
	 * @PostMapping("/saveempqueries") public String saveempqueries(@ModelAttribute
	 * Querymails Querymails) { // save leavestatus to database
	 * queries.save(Querymails); return "redirect:/updateEmpquery"; }
	 * 
	 * 
	 * 
	 * //This is for saving the salary and dept details
	 * 
	 * @PostMapping("/savesalaryanddept") public String
	 * savesalaryanddept(@ModelAttribute Salary Salary , RedirectAttributes
	 * redirectAttributes) { // save leavestatus to database
	 * 
	 * redirectAttributes.addFlashAttribute("message", "Success");
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 * salaryRepoes.save(Salary); return "redirect:/Updatesalary"; }
	 * 
	 * 
	 * @RequestMapping("Forget_pwd") public String Forget_pswd(Model mks) {
	 * 
	 * try { return "forgetpassword"; } catch (Exception e) { return "errormsg";
	 * 
	 * } }
	 * 
	 * @RequestMapping("Mangr_Emp_Disply") public String Manager_display(Model mks)
	 * {
	 * 
	 * try { return "Mangr_Emp_Disply"; } catch (Exception e) { return "errormsg";
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * 
	 * //This is for the create new Admin
	 * 
	 * @RequestMapping("/createAdmin") public String create_admin(Model mks) {
	 * 
	 * try {
	 * 
	 * return "createAdmin"; } catch (Exception e) { return "errormsg";
	 * 
	 * } }
	 * 
	 * @RequestMapping("/Adminsuccess") public String admin_success(Model
	 * mks, @ModelAttribute Admin_cls cls) {
	 * 
	 * try {
	 * 
	 * mks.addAttribute("Datas", cls); this.repoone.save(cls);
	 * 
	 * return "Adminsuccess"; } catch (Exception e) { return "adminfailed"; } }
	 * 
	 * 
	 * 
	 * @RequestMapping("/admin_check/Emailid/password") public String
	 * Admin_log(Model mks, @RequestParam(value = "password") String pass,
	 * 
	 * @RequestParam(value = "Emailid") String email) {
	 * 
	 * // System.out.println(pass); String clas = adminserv.getByname(email); //
	 * System.out.println(clas); if (clas != null && clas.equals(pass)) {
	 * mks.addAttribute("Datas_lk", services.getAlluser());
	 * 
	 * return "After_login"; }
	 * 
	 * return "failedlogin";
	 * 
	 * }
	 * 
	 * @RequestMapping("leave_mail/Emailid/password/Reason") public String
	 * Leave_Mail(
	 * 
	 * @RequestParam(value = "Emailid") String Email,
	 * 
	 * @RequestParam(value = "Reason") String Reason,
	 * 
	 * @RequestParam(value = "password") String password ) {
	 * 
	 * //System.out.println(Email); String RecMail="shrilakshmanan2000@gmail.com";
	 * 
	 * // System.out.println(password);
	 * 
	 * //System.out.println(Reason);
	 * 
	 * mail.sendemail(RecMail," LEAVE MAIL"," From "+ Email +" to "+ password +
	 * "    ["+ Reason +" ]");
	 * 
	 * 
	 * return "mail_success";
	 * 
	 * }
	 * 
	 * 
	 * @RequestMapping("leave_mail/Emailid/password/Reason") public String
	 * Leave_Mail(
	 * 
	 * @RequestParam(value = "Emailid") String Email,
	 * 
	 * @RequestParam(value = "Reason") String Reason,
	 * 
	 * @RequestParam(value = "password") String password ) {
	 * 
	 * //System.out.println(Email); String RecMail="shrilakshmanan2000@gmail.com";
	 * 
	 * // System.out.println(password);
	 * 
	 * //System.out.println(Reason);
	 * 
	 * mail.sendemail(RecMail," LEAVE MAIL"," From "+ Email +" to "+ password +
	 * "    ["+ Reason +" ]");
	 * 
	 * 
	 * return "mail_success";
	 * 
	 * }
	 * 
	 * 
	 * 
	 * // this is fpr the testing mail purpose here
	 * 
	 * @RequestMapping("/Datas/Emailid/password/personelmail/Username") public
	 * String savelogin(Model mk, @ModelAttribute jva_clas cls,
	 * 
	 * @RequestParam(value = "personelmail") String personelmail,
	 * 
	 * @RequestParam(value = "Username") String Username, @RequestParam(value =
	 * "Emailid") String Email,
	 * 
	 * @RequestParam(value = "password") String password) {
	 * 
	 * mail.sendemail(personelmail, "This is regarding your Email and password",
	 * "Welocome " + Username + " Your Mail id is: " + Email +
	 * " and your password is: " + password); mk.addAttribute("Datas", cls);
	 * reposit.save(cls); return "Two";
	 * 
	 * 
	 * }
	 * 
	 * 
	 * @RequestMapping("forgetpwds/Emailid") public String Forgetpwds(Model
	 * mks, @RequestParam(value = "Emailid") String id) { //this is the mail
	 * function here
	 * 
	 * try {
	 * 
	 * String personelmail = services.getByIdd(id);
	 * 
	 * 
	 * 
	 * String passwd = services.findAllpwd(personelmail);
	 * System.out.println(passwd);
	 * 
	 * mail.sendemail(personelmail, "This is regarding your Email and password",
	 * "Welcome " + " Your Mail id is: " + id + " and your password is: " + passwd);
	 * // mk.addAttribute("Datas", cls);
	 * 
	 * if (personelmail == null) { return "errormsg";
	 * 
	 * }
	 * 
	 * // mks.addAttribute("password", clas);
	 * 
	 * return "mail_success"; } catch (Exception e) { return "errormsg"; }
	 * 
	 * }
	 */

	// THIS IS FOR TODO LIST
}
