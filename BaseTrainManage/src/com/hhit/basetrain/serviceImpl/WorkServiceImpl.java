package com.hhit.basetrain.serviceImpl;

import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.WorkDao;
import com.hhit.basetrain.entity.FinishWorkBean;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.Work;
import com.hhit.basetrain.service.WorkService;

/**
 * 
 * @author mayu
 */
@Service
public class WorkServiceImpl implements WorkService{
	@Resource
	private WorkDao workDao;
	
	public boolean holdWork(String wid, String cno, String cname, Integer base_no,
			String title, String content, String uploadDate, String uploadNo,
			String base_class, String endDate, String file) {
		boolean flag=true;
		Work work=new Work();
		work.setBase_class(base_class);
		work.setBase_no(base_no);
		work.setCname(cname);
		work.setCno(cno);
		work.setContent(content);
		work.setEndDate(endDate);
		work.setFile(file);
		work.setTitle(title);
		work.setUploadDate(uploadDate);
		work.setUploadNo(uploadNo);
		work.setWid(wid);
		int count=workDao.saveWork(work);
		if(count!=0){
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");
			flag=false;
		}
		return flag;
	}

	public Result showWork(String base_class, Integer base_no, Integer page,
			Integer pagesize) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> map1=new HashMap<String,Object>();
		map.put("base_class", base_class);
		map.put("base_no", base_no);
		map.put("page", page);
		map.put("pagesize", pagesize);
		map1.put("base_class", base_class);
		map1.put("base_no", base_no);
		List<Work> works=workDao.findWorkByBasePage(map);
		List<Work> work=workDao.findWorkByBase(map1);
		if(work.size()==0 || works.size()==0){
			result.setMsg("没有布置作业");
			result.setStatus(0);
		}else if(work.size()!=0 && works.size()!=0){
			result.setData(works);
			result.setStatus(work.size());
			result.setMsg("查找成功");
		}
		return result;
	}

	public Result deleteWork(String wid) {
		boolean flag=false;
		Result result=new Result();
		int count=workDao.deleteWorkById(wid);
		if(count!=0){
			result.setMsg("删除成功");
			result.setStatus(count);
		}else{
			result.setMsg("删除失败");
			result.setStatus(0);
		}
		return result;
	}

	public Result searchUnfinishedWork(String stuno, String base_class,
			Integer base_no, Integer page, Integer pagesize, String currentDate) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> map1=new HashMap<String,Object>();
		map.put("base_class", base_class);
		map.put("base_no", base_no);
		map.put("stuno", stuno);
		map.put("pagesize", pagesize);
		map.put("page", page);
		map.put("currentDate", currentDate);
		map1.put("base_class", base_class);
		map1.put("base_no", base_no);
		map1.put("stuno", stuno);
		map1.put("currentDate", currentDate);
		List<Work> works=workDao.findWorkUnfinishedPage(map);
		List<Work> work=workDao.findWorkUnfinished(map1);
		if(work.size()==0 || works.size()==0){
			result.setMsg("没有最新作业");
			result.setStatus(0);
		}else if(work.size()!=0 && works.size()!=0){
			result.setData(works);
			result.setStatus(work.size());
			result.setMsg("查找成功");
		}
		return result;
	}

	public Result searchUfinishedWorkPass(String stuno, String base_class,
			Integer base_no, Integer page, Integer pagesize, String currentDate) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> map1=new HashMap<String,Object>();
		map.put("base_class", base_class);
		map.put("base_no", base_no);
		map.put("stuno", stuno);
		map.put("pagesize", pagesize);
		map.put("page", page);
		map.put("currentDate", currentDate);
		map1.put("base_class", base_class);
		map1.put("base_no", base_no);
		map1.put("stuno", stuno);
		map1.put("currentDate", currentDate);
		List<Work> works=workDao.findWorkUnfinishedPassedPage(map);
		List<Work> work=workDao.findWorkUnfinishedPassed(map1);
		if(work.size()==0 || works.size()==0){
			result.setMsg("没有超时的未交作业");
			result.setStatus(0);
		}else if(work.size()!=0 && works.size()!=0){
			result.setData(works);
			result.setStatus(work.size());
			result.setMsg("你有超时的未交作业，请赶紧交作业！");
		}
		return result;
	}

	public boolean uploadWork(String stuno, String wid, String uploadDate,
			String file) {
		boolean flag=false;
		FinishWorkBean work=new FinishWorkBean();
		work.setFile(file);
		work.setStuno(stuno);
		work.setUploadDate(uploadDate);
		work.setWid(wid);
		int count=workDao.insertFinished(work);
		if(count!=0){
			flag=true;
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");
		}
		return flag;
	}

	public Result uploadedWork(String stuno, Integer page, Integer pagesize) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("stuno", stuno);
		map.put("page", page);
		map.put("pagesize", pagesize);
		List<Map> list=workDao.findWorkUpload(stuno);
		List<Map> lists=workDao.findWorkUploadPage(map);
		if(list.size()==0 || lists.size()==0){
			result.setStatus(0);
			result.setMsg("查找失败");
		}else if(list.size()!=0 || lists.size()!=0){
			result.setMsg("查找成功");
			result.setStatus(list.size());
			result.setData(lists);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.WorkService#deleteUploadedwork(java.lang.String, java.lang.String)
	 */
	public Result deleteUploadedwork(String stuno, String wid) {
		Result result=new Result();
		FinishWorkBean finish=new FinishWorkBean();
		finish.setStuno(stuno);
		finish.setWid(wid);
		int count=workDao.deleteuploadedwork(finish);
		if(count!=0){
			result.setMsg("删除失败");
			result.setStatus(0);
		}else{
			result.setMsg("删除成功");
			result.setStatus(count);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.WorkService#showUploadWorks(java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public Result showUploadWorks(Integer baseNo, String baseClass,
			String title, Integer page, Integer pagesize) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> map1=new HashMap<String,Object>();
		map.put("base_class", baseClass);
		map.put("base_no", baseNo);
		map.put("pagesize", pagesize);
		map.put("page", page);
		map.put("title", title);
		map1.put("base_class", baseClass);
		map1.put("base_no", baseNo);
		map1.put("title", title);
		List<Map> works=workDao.findFinishedWorkPage(map);
		List<Map> work=workDao.findFinishedWork(map1);
		if(work.size()==0 || works.size()==0){
			result.setMsg("没有需要批改的作业");
			result.setStatus(0);
		}else if(work.size()!=0 && works.size()!=0){
			result.setData(works);
			result.setStatus(work.size());
			result.setMsg("有批改的作业");
		}
		return result;
	}
	
}
