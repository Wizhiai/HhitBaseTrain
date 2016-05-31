/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hhit.basetrain.dao.BaseAdminDao;
import com.hhit.basetrain.dao.BaseDao;
import com.hhit.basetrain.dao.BaseTeacherDao;
import com.hhit.basetrain.dao.UserDao;
import com.hhit.basetrain.entity.BaseAdvantageBean;
import com.hhit.basetrain.entity.BaseAllianceBean;
import com.hhit.basetrain.entity.BaseBean;
import com.hhit.basetrain.entity.BaseBuildBean;
import com.hhit.basetrain.entity.BaseCoachBean;
import com.hhit.basetrain.entity.BaseFieldBean;
import com.hhit.basetrain.entity.BaseNameBean;
import com.hhit.basetrain.entity.BaseResearchBean;
import com.hhit.basetrain.entity.BaseTeacher;
import com.hhit.basetrain.entity.BaseTrainContentBean;
import com.hhit.basetrain.entity.BaseTrainEffectBean;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.BaseService;
import com.hhit.basetrain.util.BaseUtil;

/**
 * @author Jiya
 * @date 2016-4-23t下午05:04:10
 * 
 */
@Service

public class BaseServiceImpl implements BaseService{

	@Resource
	private BaseDao baseDao;
	@Resource
	private BaseAdminDao baseAdminDao;
	@Resource
	private UserDao userDao;
	@Resource
	private BaseTeacherDao baseTeacherDao;

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#skimBaseInf(java.lang.String)
	 */
	public Result skimBaseInfByName(String baseName) {
		
		Result result = new Result();
		
		List<BaseBean> list = baseDao.findByName("%"+baseName+"%");
		
		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("没有符合查找条件的记录！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(list);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#skimBaseInfByAddress(java.lang.String)
	 */
	public Result skimBaseInfByAddress(String baseAddress) {
		Result result = new Result();
		
		List<BaseBean> list = baseDao.findByAddress("%"+baseAddress+"%");
		
		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("没有符合查找条件的记录！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(list);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#skimBaseInfByCourse(java.lang.String)
	 */
	public Result skimBaseInfByCourse(String cname) {
		Result result = new Result();
		List<BaseBean> list = baseDao.findByCourse("%"+cname+"%");

		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("没有符合查找条件的记录！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(list);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#skimAllBaseInf()
	 */
	public Result skimAllBaseInf() {

		Result result = new Result();
		List<BaseBean> list = baseDao.findAllBaseInf();

		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("对不起，没有合作基地的信息！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(list);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showAllBaseName()
	 */
	public Result showAllBaseName() {
		
		Result result = new Result();
		List<BaseNameBean> list = baseDao.findAllBaseName();

		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("对不起，没有合作基地的信息！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(list);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseBasicInfoByNo(java.lang.String)
	 */
	public Result showBaseBasicInfoByNo(int baseNo) {
		Result result = new Result();
		BaseBean base = baseDao.findBasicInfoByNo(baseNo);
		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("基地基本信息查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseAdvantageInfoByNo(java.lang.String)
	 */
	public Result showBaseAdvantageInfoByNo(int baseNo) {
		
		Result result = new Result();
		BaseAdvantageBean base = baseDao.findAdvantageInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("基地特色查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseAllianceInfoByNo(java.lang.String)
	 */
	public Result showBaseAllianceInfoByNo(int baseNo) {
		Result result = new Result();
		BaseAllianceBean base = baseDao.findAllianceInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("基地企业联盟查找成功查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseBuildInfoByNo(java.lang.String)
	 */
	public Result showBaseBuildInfoByNo(int baseNo) {
		Result result = new Result();
		BaseBuildBean base = baseDao.findBuildInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("基地建设与管理状况查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseCoachInfoByNo(java.lang.String)
	 */
	public Result showBaseCoachInfoByNo(int baseNo) {
		Result result = new Result();
		BaseCoachBean base = baseDao.findCoachInfoByNo(baseNo);
		
		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("基地教师与辅导队伍查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseContentInfoByNo(java.lang.String)
	 */
	public Result showBaseContentInfoByNo(int baseNo) {
		Result result = new Result();
		BaseTrainContentBean base = baseDao.findContentInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("实训目标及内容查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseEffectInfoByNo(java.lang.String)
	 */
	public Result showBaseEffectInfoByNo(int baseNo) {
		Result result = new Result();
		BaseTrainEffectBean base = baseDao.findEffectInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("时间效果及开发能力查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseFieldInfoByNo(java.lang.String)
	 */
	public Result showBaseFieldInfoByNo(int baseNo) {
		Result result = new Result();
		BaseFieldBean base = baseDao.findFieldInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("场地与设施条件查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseResearchInfoByNo(java.lang.String)
	 */
	public Result showBaseResearchInfoByNo(int baseNo) {
		Result result = new Result();
		BaseResearchBean base = baseDao.findResearchInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("科研与技术活动查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#insertBase()
	 */
	@Transactional(rollbackFor=Exception.class)
	public Result insertBase(String base_name,String base_address) {
		
		Result result = new Result();
		BaseNameBean baseNameBean = baseDao.findBaseByNameCarefully(base_name);
		if(baseNameBean != null){
			
			result.setStatus(0);
			result.setMsg("基地名已存在！");
		}else{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("base_name", base_name);
			map.put("base_address", base_address);
			
			try{
				/*先插入基地*/
				int num = baseDao.save(map);
				
				if(num == 0){
					result.setStatus(0);
					result.setMsg("基地插入失败！");
					throw new RuntimeException("基地插入失败！");
					
				}else{//基地插入成功
					
					/*查找到这个基地*/
					BaseNameBean base = baseDao.findBaseByNameCarefully(base_name);
					/*获取基地管理员编号*/
					String manager_no = BaseUtil.generateBaseAdminNo(base.getBase_no(), 3);
					/*将基地管理员插入数据库*/
					int inserBaseAdminNum = baseAdminDao.saveBaseAdmin(manager_no);
					
					if(inserBaseAdminNum == 0){
						result.setStatus(0);
						result.setMsg("基地管理员插入失败！");
						throw new RuntimeException("基地管理员插入失败！");
						
					}else{//基地管理员插入成功
						/*将基地管理员和基地关系插入数据库*/
						Map<String,Object> relationMap = new HashMap<String,Object>();
						relationMap.put("base_no", base.getBase_no());
						relationMap.put("base_name", base.getBase_name());
						relationMap.put("manager_no", manager_no);
						
						int insertBaseRelation = baseDao.saveBaseRelation(relationMap);
						if(insertBaseRelation == 0){//基地管理员和基地关系插入失败
							result.setStatus(0);
							result.setMsg("基地管理员和基地关系插入失败！");
							throw new RuntimeException("基地管理员和基地关系插入失败！");
							
						}else{//基地管理员和基地关系插入成功
							/*将基地管理员加入用户表*/
							Map<String,Object> userMap = new HashMap<String,Object>();
							userMap.put("username",manager_no);
							userMap.put("identity", "1");
							int userNum = userDao.save(userMap);
							
							if(userNum == 0){//基地管理员插入用户表失败
								result.setStatus(0);
								result.setMsg("基地管理员插入用户表失败！");
								throw new RuntimeException("基地管理员插入用户表失败！");
								
							}else{//基地管理员插入用户表成功
								result.setStatus(1);
								result.setMsg("基地插入成功！");
								result.setData(manager_no);
							}
						}
					}
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#deleteBase(java.lang.String)
	 */
	@Transactional(rollbackFor=RuntimeException.class)
	public Result deleteBase(int baseNo) {
		
		Result result = new Result();
		BaseBean baseBean =  baseDao.findBasicInfoByNo(baseNo);
		
		if(baseBean == null){
			result.setStatus(0);
			result.setMsg("该基地不存在！");
		}else{
			/*通过基地号查询基地管理员账号*/
			String manager_no = baseDao.findBaseAdminByBaseNo(baseNo);
			
			try{
				/*将基地管理员从用户表中删除*/
				int userNum = userDao.delete(manager_no);
				
				if(userNum == 0){//将基地管理员从用户表中删除失败
					
					result.setStatus(0);
					result.setMsg("基地管理员从用户表中删除失败！");
					throw new RuntimeException("基地管理员插入用户表失败！");
					
				}else{//将基地管理员从基地关系表中删除成功
					
					int deleteRelationNum = baseDao.deleteBaseRelation(baseNo);
					
					if(deleteRelationNum == 0){//基地管理员和基地关系删除失败
						
						result.setStatus(0);
						result.setMsg("基地管理员和基地关系删除失败！");
						throw new RuntimeException("基地管理员和基地关系删除失败！");
						
					}else{//基地管理员和基地关系删除成功
						
						int deleteBaseAdminNum = baseAdminDao.deleteBaseAdminByNo(manager_no);
						
						if(deleteBaseAdminNum == 0){//基地管理员删除失败
							
							result.setStatus(0);
							result.setMsg("基地管理员和基地关系删除失败！");
							throw new RuntimeException("基地管理员和基地关系删除失败！");
						}else{//基地管理员删除成功
							
							List<String> list = baseTeacherDao.findBaseTeacherNoByBaseNo(baseNo);
							for(String t_no:list){
								int deleteUserBaseTeacherNum = userDao.delete(t_no);
							}
							int deleteBaseTeacherNum = baseTeacherDao.deleteBaseTeacherByBaseNo(baseNo);//删除基地教师
							
							int deleteBaseNum = baseDao.deleteBase(baseNo);
							
							if(deleteBaseNum == 0){//删除基地失败
								result.setStatus(0);
								result.setMsg("基地管理员和基地关系删除失败！");
								throw new RuntimeException("基地管理员和基地关系删除失败！");
								
							}else{//基地删除成功
								result.setStatus(1);
								result.setMsg("基地删除失败！");
							}
							
						}
						
					}
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#isBaseExit(java.lang.String)
	 */
	public Result isBaseExit(String baseName) {
		
		Result result = new Result();
		BaseNameBean baseNameBean = baseDao.findBaseByNameCarefully(baseName);
		
		if(baseNameBean == null){
			
			result.setStatus(1);
			result.setMsg("该基地名不存在");
			
		}else{
			
			result.setStatus(0);
			result.setMsg("该基地名已经存在！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseAndBaseAdminBasicInfoByNo(java.lang.String)
	 */
	public Result showBaseAndBaseAdminBasicInfoByNo(int baseNo) {
		Result result = new Result();
		BaseBean base = baseDao.findBasicBaseInfoByNo(baseNo);
		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("基地基本信息查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#modifyBaseAdvantageInfoByNo(int, java.lang.String)
	 */
	public Result modifyBaseAdvantageInfoByNo(int baseNo, String baseAdvantage) {
		Result result = new Result();
		BaseBean base = baseDao.findBasicBaseInfoByNo(baseNo);
		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			BaseAdvantageBean baseAdvantageBean = new BaseAdvantageBean();
			baseAdvantageBean.setBase_no(baseNo);
			baseAdvantageBean.setBase_advantage(baseAdvantage);
			int num = baseDao.updateAdvantageInfoByNo(baseAdvantageBean);
			result.setStatus(num);
			result.setMsg("基地特色修改成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#modifyBaseAllianceInfoByNo(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double, java.lang.String)
	 */
	public Result modifyBaseAllianceInfoByNo(int baseNo,
			String cooperationEnterpriseNum, String cooperationProjectNum,
			String employmentAllianceNum, String actualEmploymentNum,
			double employmentAllianceProportion,
			String cooperationEnterpriseName) {
		
		Result result = new Result();
		BaseBean base = baseDao.findBasicBaseInfoByNo(baseNo);
		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			BaseAllianceBean baseAllianceBean = new BaseAllianceBean();
			baseAllianceBean.setBase_no(baseNo);
			baseAllianceBean.setActual_employment_num(actualEmploymentNum);
			baseAllianceBean.setCooperation_enterprise_name(cooperationEnterpriseName);
			baseAllianceBean.setCooperation_enterprise_num(cooperationEnterpriseNum);
			baseAllianceBean.setCooperation_project_num(cooperationProjectNum);
			baseAllianceBean.setEmployment_alliance_num(employmentAllianceNum);
			baseAllianceBean.setEmployment_alliance_proportion(employmentAllianceProportion);
			
			
			int num = baseDao.updateAllianceInfoByNo(baseAllianceBean);
			result.setStatus(num);
			result.setMsg("基地企业联盟信息修改成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#modifyBaseBasicInfoByNo(int, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result modifyBaseBasicInfoByNo(int baseNo, String baseName,
			String baseAddress, String establishTime) {
		Result result = new Result();
		BaseBean base = baseDao.findBasicBaseInfoByNo(baseNo);
		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			BaseBean baseBasicBean = new BaseBean();
			baseBasicBean.setBase_no(baseNo);
			baseBasicBean.setBase_name(baseName);
			baseBasicBean.setBase_address(baseAddress);
			baseBasicBean.setEstablish_time(establishTime);
			
			int num = baseDao.updateBasicInfoByNo(baseBasicBean);
			result.setStatus(num);
			result.setMsg("基地基本修改成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#modifyBaseBuildInfoByNo(int, java.lang.String, int, java.lang.String, int, double, int, int, int, int, int, int, int, int, int)
	 */
	public Result modifyBaseBuildInfoByNo(int baseNo, String baseProperty,
			int manageInstitution, String mainRule, int developmentPlan,
			double constructionFunds, int financialSituation,
			int baseQualification, int teacherNum, int seniorNum,
			int intermediateNum, int experiencedTeacher, int managerNum,
			int aidNum, int developerNum) {
		
		Result result = new Result();
		BaseBean base = baseDao.findBasicBaseInfoByNo(baseNo);
		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			BaseBuildBean baseBuildBean = new BaseBuildBean();
			baseBuildBean.setAid_num(aidNum);
			baseBuildBean.setBase_no(baseNo);
			baseBuildBean.setBase_property(baseProperty);
			baseBuildBean.setBase_qualification(baseQualification);
			baseBuildBean.setConstruction_funds(constructionFunds);
			baseBuildBean.setDeveloper_num(developerNum);
			baseBuildBean.setDevelopment_plan(developmentPlan);
			baseBuildBean.setExperienced_teacher(experiencedTeacher);
			baseBuildBean.setFinancial_situation(financialSituation);
			baseBuildBean.setIntermediate_num(intermediateNum);
			baseBuildBean.setMain_rule(mainRule);
			baseBuildBean.setManage_institution(manageInstitution);
			baseBuildBean.setManager_num(managerNum);
			baseBuildBean.setSenior_num(seniorNum);
			baseBuildBean.setTeacher_num(teacherNum);
			
			int num = baseDao.updateBuildInfoByNo(baseBuildBean);
			result.setStatus(num);
			result.setMsg("基地建设与管理状况信息修改成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#modifyBaseCoachInfoByNo(int, int, int)
	 */
	public Result modifyBaseCoachInfoByNo(int baseNo, int schoolTeacher,
			int companyTeacher) {
		
		Result result = new Result();
		BaseBean base = baseDao.findBasicBaseInfoByNo(baseNo);
		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			BaseCoachBean bascCoachBean = new BaseCoachBean();
			bascCoachBean.setBase_no(baseNo);
			bascCoachBean.setCompany_teacher(companyTeacher);
			bascCoachBean.setSchool_teacher(schoolTeacher);
			
			int num = baseDao.updateCoachInfoByNo(bascCoachBean);
			result.setStatus(num);
			result.setMsg("基地教师与辅导队伍信息修改成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#modifyBaseContentInfoByNo(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result modifyBaseContentInfoByNo(int baseNo,
			String internshipOutline, String outlinePlan, String trainPlan,
			String newPlan, String guideBook, String newGuidingbook,
			String teachingMaterial, String newMaterial, String publishBook,
			String trainProject, String newProject, String studentNum,
			String trainPrice, String developCase) {
		
		Result result = new Result();
		BaseBean base = baseDao.findBasicBaseInfoByNo(baseNo);
		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			BaseTrainContentBean bascTrainContentBean = new BaseTrainContentBean();
			bascTrainContentBean.setBase_no(baseNo);
			bascTrainContentBean.setDevelop_case(developCase);
			bascTrainContentBean.setGuide_book(guideBook);
			bascTrainContentBean.setInternship_outline(internshipOutline);
			bascTrainContentBean.setNew_guidingbook(newGuidingbook);
			bascTrainContentBean.setNew_material(newMaterial);
			bascTrainContentBean.setNew_plan(newPlan);
			bascTrainContentBean.setNew_project(newProject);
			bascTrainContentBean.setOutline_plan(outlinePlan);
			bascTrainContentBean.setPublish_book(publishBook);
			bascTrainContentBean.setStudent_num(studentNum);
			bascTrainContentBean.setTeaching_material(teachingMaterial);
			bascTrainContentBean.setTrain_plan(trainPlan);
			bascTrainContentBean.setTrain_price(trainPrice);
			bascTrainContentBean.setTrain_project(trainProject);
			
			int num = baseDao.updateContentInfoByNo(bascTrainContentBean);
			result.setStatus(num);
			result.setMsg("实训项目目标及内容信息修改成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#modifyBaseEffectInfoByNo(int, int, int, int, int, java.lang.String, double, double, double, double, double, java.lang.String, java.lang.String, double, double, double, java.lang.String, double, double)
	 */
	public Result modifyBaseEffectInfoByNo(int baseNo, int projectInuse,
			int goodProject, int companyProject, int selfdevelopProject,
			String evaluationRule, double postgraduateProportion,
			double undergraduateProportion, double specialistProportion,
			double schoolSource, double traineeSource, String trainFinishNum,
			String trainEmployedNum, double largeEnterprise,
			double middleEnterprise, double smallEnterprise,
			String salaryRange, double baseRecommend, double studentSelfask) {

		Result result = new Result();
		BaseBean base = baseDao.findBasicBaseInfoByNo(baseNo);
		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			BaseTrainEffectBean baseTrainEffectBean = new BaseTrainEffectBean();
			baseTrainEffectBean.setBase_no(baseNo);
			baseTrainEffectBean.setBase_recommend(baseRecommend);
			baseTrainEffectBean.setCompany_project(companyProject);
			baseTrainEffectBean.setEvaluation_rule(evaluationRule);
			baseTrainEffectBean.setGood_project(goodProject);
			baseTrainEffectBean.setLarge_enterprise(largeEnterprise);
			baseTrainEffectBean.setMiddle_enterprise(middleEnterprise);
			baseTrainEffectBean.setPostgraduate_proportion(postgraduateProportion);
			baseTrainEffectBean.setProject_inuse(projectInuse);
			baseTrainEffectBean.setSalary_range(salaryRange);
			baseTrainEffectBean.setSchool_source(schoolSource);
			baseTrainEffectBean.setSelfdevelop_project(selfdevelopProject);
			baseTrainEffectBean.setSmall_enterprise(smallEnterprise);
			baseTrainEffectBean.setSpecialist_proportion(specialistProportion);
			baseTrainEffectBean.setStudent_selfask(studentSelfask);
			baseTrainEffectBean.setTrain_employed_num(trainEmployedNum);
			baseTrainEffectBean.setTrain_finish_num(trainFinishNum);
			baseTrainEffectBean.setTrainee_source(traineeSource);
			baseTrainEffectBean.setUndergraduate_proportion(undergraduateProportion);
			
			int num = baseDao.updateEffectInfoByNo(baseTrainEffectBean);
			result.setStatus(num);
			result.setMsg("实训效果与能力开发信息修改成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#modifyBaseFieldInfoByNo(int, java.lang.String, java.lang.String, int, int, int, int, int, int, int, java.lang.String, java.lang.String)
	 */
	public Result modifyBaseFieldInfoByNo(int baseNo, String baseArea,
			String handware, int machineSituation, int softwareSelfevaluation,
			int softwareDemand, int canteenBelong, int dormitoryBelong,
			int studentManage, int cleanManage, String environment,
			String safety) {
		
		Result result = new Result();
		BaseBean base = baseDao.findBasicBaseInfoByNo(baseNo);
		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			BaseFieldBean baseFieldBean = new BaseFieldBean();
			baseFieldBean.setBase_area(baseArea);
			baseFieldBean.setBase_no(baseNo);
			baseFieldBean.setCanteen_belong(canteenBelong);
			baseFieldBean.setClean_manage(cleanManage);
			baseFieldBean.setDormitory_belong(dormitoryBelong);
			baseFieldBean.setEnvironment(environment);
			baseFieldBean.setHandware(handware);
			baseFieldBean.setMachine_situation(machineSituation);
			baseFieldBean.setSafety(safety);
			baseFieldBean.setSoftware_demand(softwareDemand);
			baseFieldBean.setSoftware_selfevaluation(softwareSelfevaluation);
			baseFieldBean.setStudent_manage(studentManage);
			
			int num = baseDao.updateFieldInfoByNo(baseFieldBean);
			result.setStatus(num);
			result.setMsg("实训场地与设施条件信息修改成功！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#modifyBaseResearchInfoByNo(int, int, int, double, int, java.lang.String, int, double, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result modifyBaseResearchInfoByNo(int baseNo, int researchNum,
			int educationNum, double researchFunding, int scientificResearch,
			String typicalResearch, int developProjectNum,
			double developProjectFunding, String developProjectStaff,
			String developProjectStudent, String typicalProject) {
		Result result = new Result();
		BaseBean base = baseDao.findBasicBaseInfoByNo(baseNo);
		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			BaseResearchBean baseResearchBean = new BaseResearchBean();
			baseResearchBean.setBase_no(baseNo);
			baseResearchBean.setDevelop_project_funding(developProjectFunding);
			baseResearchBean.setDevelop_project_num(developProjectNum);
			baseResearchBean.setDevelop_project_staff(developProjectStaff);
			baseResearchBean.setDevelop_project_student(developProjectStudent);
			baseResearchBean.setEducation_num(educationNum);
			baseResearchBean.setResearch_funding(researchFunding);
			baseResearchBean.setResearch_num(researchNum);
			baseResearchBean.setScientific_research(scientificResearch);
			baseResearchBean.setTypical_project(typicalProject);
			baseResearchBean.setTypical_research(typicalResearch);
			
			int num = baseDao.updateResearchInfoByNo(baseResearchBean);
			result.setStatus(num);
			result.setMsg("科研与技术活动信息修改成功！");
		}
		
		return result;
		
	}
	
}
