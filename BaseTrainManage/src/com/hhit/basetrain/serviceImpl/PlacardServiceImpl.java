/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.PlacardDao;
import com.hhit.basetrain.entity.PlacardBean;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.PlacardService;
import com.hhit.basetrain.util.TimeUtil;

/**
 * @author Mayu
 * @date 2016-4-23t下午09:03:40
 * 
 */
@Service
public class PlacardServiceImpl implements PlacardService{
	@Resource
	private PlacardDao placardDao;

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#gainPlacard(java.lang.String)
	 */
	public Result loadPlacard(String id) {
		Result result=new Result();
		List<Map> placards=placardDao.findById(id);
		result.setData(placards);
		result.setStatus(0);
		result.setMsg("加载成功");
		return result;
		
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#loadSchoolPlacard()
	 */
	public Result loadSchoolPlacard() {
		Result result=new Result();
		List<Map> schoolPlacards=placardDao.findByType();
		result.setData(schoolPlacards);
		result.setStatus(0);
		result.setMsg("加载成功");
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#loadstudentPlacard(java.lang.String)
	 */
	public Result loadstudentPlacard(String id) {
		Result result=new Result();
		List<Map> Placards=placardDao.findplacardById(id);
		result.setData(Placards);
		result.setStatus(0);
		result.setMsg("加载成功");
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#skimAllQuestionInf()
	 */
	public Result skimAllQuestionInf() {
		
		Result result=new Result();
		List<PlacardBean> list = placardDao.findAllQuestion();
		
		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("未添加常见问题信息！");
		}else{
			
			result.setStatus(1);
			result.setData(list);
			result.setMsg("常见问题查询成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#skimQuestionInfByBaseName(java.lang.String)
	 */
	public Result skimQuestionInfByBaseNo(String baseNo) {
		
		Result result=new Result();
		List<PlacardBean> list = placardDao.findQuestionByBaseNo(baseNo);
		
		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("未添加常见问题信息！");
		}else{
			
			result.setStatus(1);
			result.setData(list);
			result.setMsg("常见问题查询成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#showQuestionInfByPlacardNo(java.lang.String)
	 */
	public Result showQuestionInfByPlacardNo(String placardNo) {
		Result result=new Result();
		PlacardBean placard = placardDao.findQuestionByPlacardNo(placardNo);
		
		if(placard == null){
			
			result.setStatus(0);
			result.setMsg("对不起，查询失败！");
		}else{
			
			result.setStatus(1);
			result.setData(placard);
			result.setMsg("常见问题查询成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#showSchoolInfByPage(java.lang.String)
	 */
	public Result showAllSchoolInf() {
		Result result=new Result();
		List<PlacardBean> list = placardDao.findAllSchoolPlacard();
		
		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("没有学校公告信息！");
		}else{
			
			result.setStatus(1);
			result.setData(list);
			result.setMsg("学校公告查询成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#showSchoolPlacardInfByPlacardNo(java.lang.String)
	 */
	public Result showSchoolPlacardInfByPlacardNo(String placardNo) {
		Result result=new Result();
		PlacardBean placard = placardDao.findSchoolPlacardByPlacardNo(placardNo);
		
		if(placard == null){
			
			result.setStatus(0);
			result.setMsg("对不起，查询失败！");
		}else{
			
			result.setStatus(1);
			result.setData(placard);
			result.setMsg("学校查询成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#addSchoolPlacard(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result addSchoolPlacard(String placardTitle, String placardContent,
			String publishAuthor) {
		
		Result result=new Result();
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("placard_title", placardTitle);
		map.put("placard_content", placardContent);
		map.put("publish_author", publishAuthor);
		map.put("publish_time", TimeUtil.getFormatCurrentTime());
		map.put("placard_type", "2");
		
		int num = placardDao.saveSchoolPlacard(map);
		result.setStatus(num);
		result.setMsg("添加成功！");
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#isSchoolPlacardExit(java.lang.String)
	 */
	public Result isSchoolPlacardExit(String placardTitle) {
		
		Result result=new Result();
		PlacardBean placardBean = placardDao.findSchoolPlacardByTitle(placardTitle);

		if(placardBean != null){
			result.setStatus(0);
			result.setMsg("该公告标题已存在");
		}else{
			result.setStatus(1);
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#deleteSchoolPlacard(java.lang.String)
	 */
	public Result deleteSchoolPlacard(String placardNo) {
		
		Result result=new Result();
		int num =  placardDao.deleteSchoolPlacardByNo(placardNo);
		result.setStatus(num);
		result.setMsg("删除成功!");
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#modifySchoolPlacard(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result modifySchoolPlacard(String placardNo, String placardTitle,
			String placardContent, String publishAuthor) {
		
		Result result=new Result();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("placard_no", placardNo);
		map.put("placard_title", placardTitle);
		map.put("placard_content", placardContent);
		map.put("publish_author", publishAuthor);
		map.put("publish_time", TimeUtil.getFormatCurrentTime());
		
		int num = placardDao.updateSchoolPlacardByNo(map);
		result.setStatus(num);
		result.setMsg("修改成功！");
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#searchSchoolPlacardByTitle(java.lang.String)
	 */
	public Result searchSchoolPlacardByTitle(String placardTitle) {
		
		Result result=new Result();
		List<PlacardBean> list = placardDao.searchSchoolPlacardByTitle("%"+placardTitle+"%");
		
		if(list.size() == 0){
			result.setStatus(0);
			result.setMsg("未查找到相关数据");
		}else{
			result.setStatus(1);
			result.setData(list);
			result.setMsg("查询成功！");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#addBasePlacard(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result addBasePlacard(String placardTitle, String placardContent,
			String publishAuthor, String placardType) {
		
		Result result=new Result();
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("placard_title", placardTitle);
		map.put("placard_content", placardContent);
		map.put("publish_author", publishAuthor);
		map.put("publish_time", TimeUtil.getFormatCurrentTime());
		map.put("placard_type", placardType);
		
		int num = placardDao.saveBasePlacard(map);
		result.setStatus(num);
		result.setMsg("添加成功！");
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#deleteBasePlacard(java.lang.String)
	 */
	public Result deleteBasePlacard(String placardNo) {
		
		Result result=new Result();
		int num =  placardDao.deleteBasePlacardByNo(placardNo);
		result.setStatus(num);
		result.setMsg("删除成功!");
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#isBasePlacardExit(java.lang.String, java.lang.String)
	 */
	public Result isBasePlacardExit(String placardTitle, String publishAuthor) {
		
		Result result=new Result();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("placard_title", placardTitle);
		map.put("publish_author", publishAuthor);
		
		PlacardBean placardBean = placardDao.findBasePlacardByTitle(map);
		
		if(placardBean != null){
			result.setStatus(0);
			result.setMsg("该公告标题已存在");
		}else{
			result.setStatus(1);
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#modifyBasePlacard(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result modifyBasePlacard(String placardNo, String placardTitle,
			String placardContent, String placardType, String publishAuthor) {
		
		Result result=new Result();
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("placard_no", placardNo);
		map.put("placard_title", placardTitle);
		map.put("placard_content", placardContent);
		map.put("publish_author", publishAuthor);
		map.put("placard_type", placardType);
		map.put("publish_time", TimeUtil.getFormatCurrentTime());
		
		int num = placardDao.updateBasePlacardByNo(map);
		result.setStatus(num);
		result.setMsg("修改成功！");
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#searchBasePlacardByTitle(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result searchBasePlacardByTitle(String placardTitle,
			String placardType, String publishAuthor) {
		
		Result result=new Result();
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("placard_title", "%"+placardTitle+"%");
		map.put("publish_author", publishAuthor);
		map.put("placard_type", placardType);
		
		List<PlacardBean> list = placardDao.searchBasePlacardByTitle(map);
		
		if(list.size() == 0){
			result.setStatus(0);
			result.setMsg("未查找到相关数据");
		}else{
			result.setStatus(1);
			result.setData(list);
			result.setMsg("基地公告信息查询成功！");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#showAllBaseInf()
	 */
	public Result showAllBaseInf(String pulish_author) {
		
		Result result=new Result();
		List<PlacardBean> list = placardDao.findAllBasePlacard(pulish_author);
		
		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("没有基地公告信息！");
		}else{
			
			result.setStatus(1);
			result.setData(list);
			result.setMsg("基地公告查询成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#showBasePlacardInfByPlacardNo(java.lang.String)
	 */
	public Result showBasePlacardInfByPlacardNo(String placardNo) {
		
		Result result=new Result();
		PlacardBean placard = placardDao.findBasePlacardByPlacardNo(placardNo);
		
		if(placard == null){
			
			result.setStatus(0);
			result.setMsg("对不起，基地公告信息查询失败！");
		}else{
			
			result.setStatus(1);
			result.setData(placard);
			result.setMsg("基地公告查询成功！");
		}
		
		return result;
	}

}
