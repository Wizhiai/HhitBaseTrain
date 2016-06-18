package com.hhit.basetrain.serviceImpl;

import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.WorkDao;
import com.hhit.basetrain.entity.FinishWorkBean;
import com.hhit.basetrain.entity.MarkedWork;
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
			String file,String filename,String title) {
		boolean flag=false;
		FinishWorkBean work=new FinishWorkBean();
		work.setFile(file);
		work.setStuno(stuno);
		work.setUploadDate(uploadDate);
		work.setWid(wid);
		work.setFilename(filename);
		int count=workDao.insertFinished(work);
		if(count!=0){
			Map<String,String> map=new HashMap<String,String>();
			map.put("stuno", stuno);
			map.put("title", title);
			Map<String,String> map1=workDao.findTixingInfo(map);
			if(map1!=null){
				int count1=workDao.deleteTixing(map1);
				if(count1==0){
					flag=false;
				}else{
					flag=true;
				}
			}else{
				flag=true;
				System.out.println("插入成功");
			}
			
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
			result.setMsg("没有已交的作业");
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

	public Result showComments() {
		Result result=new Result();
		List<String> comments=workDao.findComments();
		if(comments.size()!=0){
			result.setMsg("加载成功");
			result.setStatus(1);	
			result.setData(comments);
		}else{
			result.setMsg("加载失败");
			result.setStatus(0);
		}
		return result;
	}

	public boolean upDateIden(String stuno, String wid) {
		boolean flag=false;
		FinishWorkBean finish=new FinishWorkBean();
		finish.setStuno(stuno);
		finish.setWid(wid);
		int count=workDao.updateIdentity(finish);
		if(count!=0){
			flag=true;
		}
		else{
			flag=false;
		}
		return flag;
	}

	public boolean saveMarked(String stuno, String wid, String uploadDate,
			Double result, String comment,String markedfile) {
		boolean flag=false;
		MarkedWork mark=new MarkedWork();
		mark.setStuno(stuno);
		mark.setWid(wid);
		mark.setUploadDate(uploadDate);
		mark.setResult(result);
		mark.setComment(comment);
		mark.setMarkedfile(markedfile);
		int count=workDao.saveMarkedWork(mark);
		System.out.println(count);
		if(count!=0){
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}

	public Result searchMarkedWork(String stuno, Integer page, Integer pagesize) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> map1=new HashMap<String,Object>();
		map.put("stuno", stuno);
		map.put("page", page);
		map.put("pagesize", pagesize);
		List<Map> works=workDao.findWorkMarkPage(map);
		List<Map> work=workDao.findWorkMark(stuno);
		if(work.size()==0 || works.size()==0){
			result.setMsg("没有批改完的作业");
			result.setStatus(0);
		}else if(work.size()!=0 && works.size()!=0){
			result.setData(works);
			result.setStatus(work.size());
			result.setMsg("有批改的作业");
		}
		return result;
	}

	public Result searchAllFinishedWork(String base_class, Integer base_no,
			String title, Integer page, Integer pageSize) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> map1=new HashMap<String,Object>();
		map.put("base_class", base_class);
		map.put("page", page);
		map.put("pagesize", pageSize);
	    map.put("base_no", base_no);
	    map.put("title", title);
	    map1.put("base_class", base_class);
	    map1.put("base_no", base_no);
	    map1.put("title", title);
		List<Map> works=workDao.findAllFinishedWorkPage(map);
		List<Map> work=workDao.findAllFinishedWork(map1);
		if(work.size()==0 || works.size()==0){
			result.setMsg("没有已交作业的同学");
			result.setStatus(0);
		}else if(work.size()!=0 && works.size()!=0){
			result.setData(works);
			result.setStatus(work.size());
			result.setMsg("有已交作业的同学");
		}
		return result;
	}

	public Result searchAllUnFinishedWork(String base_class, Integer base_no,
			String title, Integer page, Integer pageSize) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> map1=new HashMap<String,Object>();
		map.put("base_class", base_class);
		map.put("page", page);
		map.put("pagesize", pageSize);
	    map.put("base_no", base_no);
	    map.put("title", title);
	    map1.put("base_class", base_class);
	    map1.put("base_no", base_no);
	    map1.put("title", title);
		List<Map> works=workDao.findUnfinishedWorkPage(map);		
		List<Map> work=workDao.findUnfinishedWork(map1);
		if(work.size()==0 || works.size()==0){
			result.setMsg("没有未交作业的同学");
			result.setStatus(0);
		}else if(work.size()!=0 && works.size()!=0){
			result.setData(works);
			result.setStatus(work.size());
			result.setMsg("有未交作业的同学");
		}
		return result;
	}

	public Result searchStudentWork(String base_no, String stuno, Integer page,
			Integer pagesize) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> map1=new HashMap<String,Object>();
	    map.put("stuno", stuno);
		map.put("page", page);
		map.put("pagesize", pagesize);
	    map.put("base_no", base_no);
	    map1.put("base_no", base_no);
	    map1.put("stuno", stuno);
		List<Map> works=workDao.findstudentworkPage(map);		
		List<Map> work=workDao.findstudentwork(map1);
		if(work.size()==0 || works.size()==0){
			result.setMsg("该同学没有作业");
			result.setStatus(0);
		}else if(work.size()!=0 && works.size()!=0){
			result.setData(works);
			result.setStatus(work.size());
			result.setMsg("查找成功");
		}
		return result;
		
	}

	public boolean reUpload(String stuno, String uploadDate,
			String file, String wid,String filename) {
		boolean flag=false;
		FinishWorkBean finish=new FinishWorkBean();
		finish.setStuno(stuno);
		finish.setFile(file);
		finish.setUploadDate(uploadDate);
		finish.setWid(wid);
		finish.setFilename(filename);
		int count=workDao.updateFinshedWork(finish);
		if(count!=0){
			flag=true;
		}
		return flag;
	}

	public Result reUploadResult(String wid, String stuno) {
		Result result=new Result();
		Map<String,String> map=new HashMap<String,String>();
		map.put("wid", wid);
		map.put("stuno", stuno);
		
		Map<String,String> finish=workDao.findReuploadWork(map);
		if(finish==null){
			result.setMsg("没有记录");
			result.setStatus(0);
		}else{
			result.setMsg("查找成功");
			result.setStatus(1);
			result.setData(finish);
		}
		return result;
	}

	public Result remindWork(String title, String stuno, String t_no) {
		Result result=new Result();
		Map<String,String> map=new HashMap<String,String>();
		map.put("title", title);
		map.put("stuno", stuno);
		Map<String,String> map1=new HashMap<String,String>();
		map1.put("title", title);
		map1.put("stuno", stuno);
		map1.put("t_no", t_no);
		System.out.println(map);
		Map<String,String> map3=workDao.findTixingInfo(map);
		if(map3==null){
			int count=workDao.insertTixingInfo(map1);
			if(count==0){
				result.setMsg("提醒失败");
				result.setStatus(0);
			}else{
				result.setMsg("提醒成功");
				result.setStatus(1);
			}	
		}else{
			result.setMsg("不可重复提醒");
			result.setStatus(0);
		}
		
	return result;
	}

	public Result gainRemind(String stuno) {
		Result result=new Result();
		List<Map> map=workDao.findTixing(stuno);
		if(map==null){
			result.setStatus(0);
			result.setMsg("没有提醒");
		}else{
			result.setStatus(1);
			result.setMsg("有提醒");
			result.setData(map);	
		}
		return result;
		
	}
	
	
}
