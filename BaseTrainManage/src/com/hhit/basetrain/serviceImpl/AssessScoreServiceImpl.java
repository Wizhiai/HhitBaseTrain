/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.hhit.basetrain.controller.assess.kmp;
import com.hhit.basetrain.dao.AssessExpertDao;
import com.hhit.basetrain.dao.AssessScoreDao;
import com.hhit.basetrain.dao.BaseDao;
import com.hhit.basetrain.dao.CommentDao;
import com.hhit.basetrain.dao.ExpertDao;
import com.hhit.basetrain.dao.KeyWordDao;
import com.hhit.basetrain.dao.UserDao;
import com.hhit.basetrain.entity.BaseBean;

import com.hhit.basetrain.entity.Keyword;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.User;
import com.hhit.basetrain.service.AssessScoreService;

import com.hhit.basetrain.service.UserService;
import com.hhit.entity.assess.AssessExpert;
import com.hhit.entity.assess.AssessScore;
import com.hhit.entity.assess.Comment;
import com.hhit.entity.assess.Expert;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * @author Jiya
 * @date 2016-4-17t下午01:40:24
 */
@Service
public class AssessScoreServiceImpl implements AssessScoreService{
	@Resource
	private AssessScoreDao assessDao;
	@Resource
	private UserDao userDao;
	@Resource
	private BaseDao baseDao;
	@Resource
	private ExpertDao expertDao;
	@Resource
	private AssessExpertDao assessExpertDao;
	@Resource 
	private CommentDao commentDao;
	@Resource
	private KeyWordDao keywordDao;
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#insertAssessScore(float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float)
	 */
	public Result insertAssessScore(float s11, float s12, float s13, float s21,
			float s22, float s23, float s24, float s25, float s26, float s27,
			float s31, float s32, float s33, float s34, float s35,float s36, 
			float s41,
			float s42, float s43, float s44, float s45, float s51, float s52,
			float s53, float s54, float s55, float s61, float s62, float s63,
			float s64, float s65,float s66,int basetypeid,String userId,float allScore) {
		System.out.println("services1");
		
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("s11", s11);
		map.put("s12", s12);
		map.put("s13", s13);
		map.put("s21", s21);
		map.put("s22", s22);
		map.put("s23", s23);
		map.put("s24", s24);
		map.put("s25", s25);
		map.put("s26", s26);
		map.put("s27", s27);
		map.put("s31", s31);
		map.put("s32", s32);
		map.put("s33", s33);
		map.put("s34", s34);
		map.put("s35", s35);
		map.put("s36", s36);
		map.put("s41", s41);
		map.put("s42", s42);
		map.put("s43", s43);
		map.put("s44", s44);
		map.put("s45", s45);
		map.put("s51", s51);
		map.put("s52", s52);
		map.put("s53", s53);
		map.put("s54", s54);
		map.put("s55", s55);
		map.put("s61", s61);
		map.put("s62", s62);
		map.put("s63", s63);
		map.put("s64", s64);
		map.put("s65", s65);
		map.put("s66", s66);
		map.put("allScore", allScore);
		map.put("basetypeid", basetypeid);
		map.put("userId", userId);
		String basename = baseDao.findBaseNameByNo(basetypeid);
		
		map.put("basename", basename);
		
		
		System.out.println(userId+"sasasasas");
		Result result = new Result();
		AssessScore assessScore =assessDao.findByUserIdAndbaseTypeId(userId, basetypeid);
		System.out.println(assessScore);
		if (assessScore==null) {
			int re = assessDao.save(map);
			if (re==0) {
				result.setMsg("插入失败!");
			}else {
				result.setMsg("插入成功！");
				result.setStatus(re);
			}
		}else {
			result.setMsg("您已评价！");}
	
	
	return result;
		
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#insertAssessExpert(java.lang.String)
	 */
	public Result insertAssessExpert(String userName,String expertType) {
		Result result = new Result();
		String expertId =assessDao.findByUserName(userName);
		System.out.println(expertType+"ssssss");
		if (expertId==null) {
			int re = assessDao.insertToExpert(userName,expertType);
			System.out.println(re+"re");
			System.out.println(userName);
			if (re==0) {
				result.setMsg("插入失败!");
			}else {
				result.setMsg("插入成功！");
				result.setStatus(re);
			}
		}else {
			result.setMsg("该专家已存在！");}
	
	
	return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#findAllExpert()
	 */
	public Result findAllExpert() {
		
		Result result = new Result();
		List<BaseBean> user= expertDao.findAllExpert();
	
		if(user!=null){
			System.out.println(user);
			if(user.size() == 0){
				
				result.setStatus(0);
				result.setMsg("对不起，暂时没有用户呢！");
				
			}else{
				System.out.println(user);
				result.setStatus(1);
				result.setMsg("查找成功");
				result.setData(user);
			}
			}else{
				
				result.setStatus(0);
				result.setMsg("对不起，暂时没有用户呢！");
				
			}

	
	
		return result;
	
	}

	public Result deleteExpertByUsernName(String userName) {
		System.out.println("services1"+userName);
		

		
		
		Result result = new Result();
//		Expert expert =expertDao.findByName(userName);
//		System.out.println(expert);
//		if (expert==null) {
			int re = expertDao.deleteByUserName(userName);
			if (re==0) {
				result.setMsg("删除失败!");
			}else {
				result.setMsg("删除成功！");
				result.setStatus(re);
			}
//		}else {
//			result.setMsg("您已评价！");}


	return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#inserttoAssessExpert(java.lang.String, java.lang.String)
	 */
	public Result inserttoAssessExpert(String userName, String experType) {
		Result result = new Result();
		System.out.println(userName+"ssssss");
		AssessExpert expertId =assessExpertDao.findByUserName(userName);
		System.out.println(experType+"ssssss");
		System.out.println(expertId+"expertId");
		if (expertId==null) {
			int re = assessExpertDao.inserttoAssessExpert(userName,experType);
			System.out.println(re+"re");
			System.out.println(userName);
			if (re==0) {
				result.setMsg("插入失败!");
			}else {
				result.setMsg("插入成功！");
				result.setStatus(re);
			}
		}else {
			result.setMsg("该专家已存在！");}
	
	
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#findAllassessExpert()
	 */
	public Result findAllassessExpert() {
		
		Result result = new Result();
		List<BaseBean> user= assessExpertDao.findAllExpert();
		

		
		
		//
//	kmp.search("高博真的蛮不错的啊", "不错", kmp.getNext("不错"));
//	kmp.search("高博真的蛮不错的啊", "真的蛮不错", kmp.getNext("真的蛮不错"));
//		getSameChar("高博真的蛮不错的啊", "高博还不错啊");
		if(user!=null){
			System.out.println(user);
			if(user.size() == 0){
				
				result.setStatus(0);
				result.setMsg("对不起，暂时没有用户呢！");
				
			}else{
				System.out.println(user);
				result.setStatus(1);
				result.setMsg("查找成功");
				result.setData(user);
			}
			}else{
				
				result.setStatus(0);
				result.setMsg("对不起，暂时没有用户呢！");
				
			}

	
	
		return result;
	}
	public int solveGoodKeyword (String comment,int baseno,int commentid) {
		int emotionR = 0;
		List<String> goodkeyword = keywordDao.findAllKeyword();

		ArrayList<String[]> getArrStrings = new ArrayList<String[]>();
		for (int i = 0; i < goodkeyword.size(); i++) {
//			System.out.println(keyword.get(i));
//			getSameChar("高博真的蛮不错的啊蛮好的",keyword.get(i));
			//获得每一个匹配到评价值的字符串数组
		String getArrString[] =	kmp.search(comment, goodkeyword.get(i).trim(), kmp.getNext(goodkeyword.get(i).trim()));
		
		if (getArrString[0]!=null) {
			getArrString[2]="1";
			getArrStrings.add(getArrString);
		}

		}
		ArrayList<String[]> getTArrStrings = getResultValue(getArrStrings);

		String []getResultStringT = new String[2];
		getResultStringT[0]="";
		ArrayList<String[]> getResultString = new ArrayList<String[]>();
		
		for (int j = 0; j < getTArrStrings.size(); j++) {
			if (getTArrStrings.get(j)!=null) {//如果此项有值则进行程度词语匹配，然后将取得的值存入数据库
				//从数据库中取出所有程度级别词语
				List<String> degreeWord = keywordDao.findAllDegreeKeyword();
				for (int k = 0; k < degreeWord.size(); k++) {
				String tString[] = kmp.searchDegree(getTArrStrings.get(j), degreeWord.get(k).trim(), kmp.getNext(degreeWord.get(k).trim()));
				if (!getResultStringT[0].equals(tString[0])) {
					
				
				getResultStringT[0]=	tString[0];
					int emotion = 0;
			System.out.println(getResultStringT[0]+"ffff");
				if (degreeWord.get(k).trim()!=null) {
					emotion = keywordDao.getEmotionScore( degreeWord.get(k).trim());
					
					
					getResultStringT[1] =String.valueOf( emotion * Integer.parseInt(getTArrStrings.get(j)[2]));
					tString[1] = String.valueOf( emotion * Integer.parseInt(getTArrStrings.get(j)[2]));
					getResultString.add(tString);
					System.out.println(	getResultString.get(getResultString.size()-1)[0]+"ssss");
				}
				}
				}
			}
		}
		
	
		for (int i = 0; i < getResultString.size(); i++) {
			System.out.println(getResultString.get(i)[0]+"+++++----");
		}
//		Collections.addAll(getResultStringList, getResultString);
	
		ArrayList<String[]> getValueLastArrayList =	  getResultValue(getResultString);
		for (int i = 0; i < getValueLastArrayList.size(); i++) {
			System.out.println(getValueLastArrayList.get(i)[0]+"+++++");
		}
	
		for (int i = 0; i < getValueLastArrayList.size(); i++) {
			if (getValueLastArrayList.get(i)!=null) {
//				System.out.println(getTArrStrings[0]+"ARRRR");
				emotionR = Integer.parseInt(getValueLastArrayList.get(i)[1])+emotionR;
				keywordDao.insertIntoCommentKeyWord(baseno,getValueLastArrayList.get(i)[0],Integer.parseInt(getValueLastArrayList.get(i)[1]),commentid);
				System.out.println(getValueLastArrayList.get(i));
			}
		
		}
		return emotionR;
	
		
	}
	
	public int  solveBadKeyword (String comment,int baseno,int commentid) {
		int emotionR = 0;
		List<String> badkeyword = keywordDao.findAllBadKeyword();

		ArrayList<String[]> badgetArrStrings = new ArrayList<String[]>();
		for (int i = 0; i < badkeyword.size(); i++) {
//			System.out.println(keyword.get(i));
//			getSameChar("高博真的蛮不错的啊蛮好的",keyword.get(i));
			//获得每一个匹配到评价值的字符串数组
		String getArrString[] =	kmp.search(comment, badkeyword.get(i).trim(), kmp.getNext(badkeyword.get(i).trim()));
		
		if (getArrString[0]!=null) {
			getArrString[2]="-1";
			badgetArrStrings.add(getArrString);
		}

		}
		ArrayList<String[]> badgetTArrStrings = getResultValue(badgetArrStrings);

		String []badgetResultStringT = new String[2];
		badgetResultStringT[0]="";
		ArrayList<String[]> badgetResultString = new ArrayList<String[]>();
		
		for (int j = 0; j < badgetTArrStrings.size(); j++) {
			if (badgetTArrStrings.get(j)!=null) {//如果此项有值则进行程度词语匹配，然后将取得的值存入数据库
				//从数据库中取出所有程度级别词语
				List<String> degreeWord = keywordDao.findAllDegreeKeyword();
				for (int k = 0; k < degreeWord.size(); k++) {
				String tString[] = kmp.searchDegree(badgetTArrStrings.get(j), degreeWord.get(k).trim(), kmp.getNext(degreeWord.get(k).trim()));
				if (!badgetResultStringT[0].equals(tString[0])) {
					
				
					badgetResultStringT[0]=	tString[0];
					int emotion = 0;
			System.out.println(badgetResultStringT[0]+"ffff");
				if (degreeWord.get(k).trim()!=null) {
					emotion = keywordDao.getEmotionScore( degreeWord.get(k).trim());
					
					
					badgetResultStringT[1] =String.valueOf( emotion * Integer.parseInt(badgetTArrStrings.get(j)[2]));
					tString[1] = String.valueOf( emotion * Integer.parseInt(badgetTArrStrings.get(j)[2]));
					badgetResultString.add(tString);
					System.out.println(	badgetResultString.get(badgetResultString.size()-1)[0]+"ssss");
				}
				}
				}
			}
		}
		
	
		for (int i = 0; i < badgetResultString.size(); i++) {
			System.out.println(badgetResultString.get(i)[0]+"+++++----");
		}
//		Collections.addAll(getResultStringList, getResultString);
	
		ArrayList<String[]> badgetValueLastArrayList =	  getResultValue(badgetResultString);
		for (int i = 0; i < badgetValueLastArrayList.size(); i++) {
			System.out.println(badgetValueLastArrayList.get(i)[0]+"+++++");
		}
	
		for (int i = 0; i < badgetValueLastArrayList.size(); i++) {
			if (badgetValueLastArrayList.get(i)!=null) {
//				System.out.println(getTArrStrings[0]+"ARRRR");
	emotionR = Integer.parseInt(badgetValueLastArrayList.get(i)[1])+emotionR;
				keywordDao.insertIntoCommentKeyWord(baseno,badgetValueLastArrayList.get(i)[0],Integer.parseInt(badgetValueLastArrayList.get(i)[1]),commentid);
				System.out.println(badgetValueLastArrayList.get(i));
			}
		
		}
		return emotionR;
	
	}
	
	
	
	
	
public ArrayList<String[]> getResultValue(ArrayList<String[]> getArrStrings) {
		ArrayList<String[]> getTArrStrings = new ArrayList<String[]>();
		
		
		boolean b = false;
		
		for (int j = 0; j < getArrStrings.size(); j++) {
			if (getTArrStrings.size()>0) {
				if (getArrStrings.get(j)[0]!=null) {
					for (int j2 = 0; j2 < getTArrStrings.size(); j2++) {
					
						if (kmp.isContain(getTArrStrings.get(j2)[0], getArrStrings.get(j)[0], kmp.getNext(getArrStrings.get(j)[0]))) {
							b = false;
							
							break;
						}else {
							b = true;
						}
					}
				}
				
				
			}else {
				b = true;
			}
			if (b) {
				getTArrStrings.add(getArrStrings.get(j)) ;
			
				
				b = false;
			}
			
			
		}
		
		
		return getTArrStrings;
		
	}
	

	
	public  void getSameChar(String s1,String s2){
		char c;//相同字符
//		System.out.println("__________________-------");
		String[] getSameArrar=new String[100];
		String getSameString = "";
		int g = 0;
		char[] same=s1.toCharArray();//数组same用于控制：如果s1字符串中有相同的字符，则只输出一次
		//如s1为aabc s2为a 则只输出1次a 而不是两次
		int count=0,j;//与数组same相关的变量
		int i,k;//循环变量
//		System.out.println(s1+"与"+s2+"相同的字符有");
		for(i=0;i<s1.length();i++){
		c=s1.charAt(i);
		out:for(k=0;k<s2.length();k++){
		if(c==(s2.charAt(k))){

			//
			
		
			getSameString = c+getSameString;
			//
			

		for(j=0;j<count;j++){//如果字符c已经被打印过，则直接跳出循环，查找下一个
				if(c==same[j])break out;//跳出被out标记的循环
							}//如果字符c是第一次出现，则把它添加进数组same
		same[count]=c;
		count++;
		//如果字符c是第一次出现，将其打印出来
				if(c==' '){
						System.out.println("空格键");
						break;
							}
					System.out.println(c);
						break;
		}else{
			getSameArrar[g] = getSameString;
			System.out.println(getSameString);
			System.out.println(getSameArrar+"arr");
			getSameString = "";
			g++;
		}
		}
		}
		}
		

	

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#deleteassessExpertByUsernName(java.lang.String)
	 */
	public Result deleteassessExpertByUsernName(String userName) {
	System.out.println("services1"+userName);
		

		
		
		Result result = new Result();
//		Expert expert =expertDao.findByName(userName);
//		System.out.println(expert);
//		if (expert==null) {
			int re = assessExpertDao.deleteassessExpertByUsernName(userName);
			if (re==0) {
				result.setMsg("删除失败!");
			}else {
				result.setMsg("删除成功！");
				result.setStatus(re);
			}
//		}else {
//			result.setMsg("您已评价！");}


	return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#appointmentOfDirector(java.lang.String, java.lang.String)
	 */
	public Result appointmentOfDirector(String userName, String position) {
		Result result = new Result();
		System.out.println(userName+"ssssss");
		
			String findedPosition = assessExpertDao.findUserPositionByUserName(userName);
			String positionUpdate;
		if (position.equals(findedPosition)) {
			positionUpdate = "普通成员";
		}else {
			positionUpdate = position;
		}
		System.out.println(positionUpdate+"ssssss");
			
	
			int re = assessExpertDao.updateAssessExpertPosition(userName,positionUpdate);
			System.out.println(re+"re");
			System.out.println(userName);
			if (re==0) {
				result.setMsg("修改失败!");
			}else {
				result.setMsg("修改成功！");
				result.setStatus(re);
			}
		
	
	
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#findAssessExpertByName(java.lang.String)
	 */
	public Result findAssessExpertByName(String userName) {
		Result result = new Result();
		System.out.println("1www");
		List<BaseBean> user= assessExpertDao.findByNames(userName);
	System.out.println(userName);
	System.out.println(user);
		if(user.size() == 0){
			
			
			result.setMsg("无此用户！");
			result.setStatus(0);
			
		}else{//登陆成功
			
			result.setMsg("登陆成功！");
			result.setStatus(1);
			result.setData(user);
		}
		
		return result;
		
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#assessLogin(java.lang.String, java.lang.String)
	 */
	public Result assessLogin(String userName, String passWord) {
		
		Result result = new Result();
		User user = userDao.findByName(userName);
		System.out.println(userName);
		if(user == null){//用户不存在
			
			result.setMsg("用户不存在！");
			result.setStatus(0);
			
		}else if(!user.getPassword().equals(passWord)){//密码错误
			
			result.setMsg("用户名或密码错误！");
			result.setStatus(0);
			
		}else{//登陆成功
			
			
			
			if (user.getIdentity().equals("0") ) {
				result.setMsg("管理员");
				result.setStatus(1);
				result.setData(user);
			}else if(user.getIdentity().equals("1") ) {
				result.setMsg("基地管理员");
				result.setStatus(1);
				result.setData(user);
			}else{
				

				List<BaseBean> expert= assessExpertDao.findByNames(userName);
				System.out.println(userName);
				System.out.println(expert);
					if(expert.size() == 0){
						
						
						result.setMsg("无权限");
						result.setStatus(0);
						
					}else{//登陆成功
						
						result.setMsg("专家委员会成员");
						result.setStatus(1);
						result.setData(expert);
					}
					
				
		
				
			}
			
			
			
		}

		return result;
		
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#getAssessScore()
	 */
	public Result getAssessScore() {
	
		Result result = new Result();
		
		List<BaseBean> list = baseDao.findAllBaseInf();
		List<List<AssessScore>> score = new ArrayList<List<AssessScore>>();
		
		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("对不起，没有合作基地的信息！");
			
		}else{
	int j = 0;
	for (int i = 0; i < list.size(); i++) {
		List<AssessScore> scoreT= assessDao.getScore(list.get(i).getBase_no());
		
		System.out.println(list.get(1).getBase_no()+"ssssssss");
		System.out.println(scoreT);
		if(scoreT.size()>0){
			
			System.out.println(i);
score.add(j, scoreT);
j++;
		}
		
	}
	if(score == null){
		
		result.setStatus(0);
		result.setMsg("对不起，没有成绩！");
		
	}else{

		result.setData(score);
		result.setStatus(1);
		result.setMsg("查找成功!");
	
	System.out.println(score);
	
		}
	

	}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#findAllComment()
	 */
	public Result findAllComment(String baseno) {
		
		Result result = new Result();
		System.out.println(baseno+"baseno");
		List<Comment> user= commentDao.findAllComment(Integer.parseInt(baseno) );

		
		if(user!=null){
			System.out.println(user);
			if(user.size() == 0){
				
				result.setStatus(0);
				result.setMsg("对不起，暂时没有评论呢！");
				
			}else{
				System.out.println(user);
				result.setStatus(1);
				result.setMsg("查找成功");
				result.setData(user);
			}
			}else{
				
				result.setStatus(0);
				result.setMsg("对不起，暂时没有评论呢！");
				
			}

	
	
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#findAssessByType(java.lang.String)
	 */
	public Result findAssessByType(String type) {
		Result result = new Result();
		System.out.println(type+"ssss");
		List<BaseBean> user= assessExpertDao.findByType(type);
		System.out.println(user);
		if(user.size() == 0){
			
			
			result.setMsg("无此用户！");
			result.setStatus(0);
			
		}else{//登陆成功
			
			result.setMsg("登陆成功！");
			result.setStatus(1);
			result.setData(user);
		}
		
		return result;
		
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#insertVideo(java.lang.String, java.lang.String)
	 */
	public Result insertVideo(String userName, String url) {
		Result result = new Result();
		String expertId =assessDao.findVideo(userName);
		System.out.println(url+"ssssss");
		if (expertId==null) {
			int re = assessDao.insertVideo(userName,url);
			System.out.println(re+"re");
			System.out.println(userName);
			if (re==0) {
				result.setMsg("插入失败!");
			}else {
				result.setMsg("插入成功！");
				result.setStatus(re);
			}
		}else {
		
//			System.out.println(assessDao.updateVideo(userName,url));
			  assessDao.updateVideo(userName,url);
//			System.out.println(assessDao.updateVideo(userName,url));
			System.out.println(userName);
			
				result.setMsg("修改成功！");
				result.setStatus(1);
			
			
			
		}
	
	return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#insertComment(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result insertComment(String userid,String baseno, String content,String time ) {

			System.out.println(content);	
//			solveGoodKeyword(content);
//			//badkeyword
//			solveBadKeyword(content);
			
			Result result = new Result();
			System.out.println(userid+"ssssss");
			Comment expertId =commentDao.findByUserName(Integer.parseInt(userid),Integer.parseInt(baseno));
		
			System.out.println(expertId+"expertId");
			if (expertId==null) {
				int re = commentDao.inserttoComment(Integer.parseInt(userid) ,Integer.parseInt(baseno),content,time);
				System.out.println(re+"re");
				
				if (re==0) {
					result.setMsg("插入失败!");
				}else {
					result.setMsg("评论成功！");//插入成功再做处理
					Comment com =commentDao.findByUserName(Integer.parseInt(userid),Integer.parseInt(baseno));
					int emotiong = solveGoodKeyword(content, Integer.parseInt(baseno) , com.getId());
					System.out.println(emotiong);
					int emotionb = solveBadKeyword(content, Integer.parseInt(baseno) , com.getId());
					int emtion = emotionb+emotiong;
					System.err.println(emtion+"emotion");
//					updateEmotion
					commentDao.updateEmotion(com.getId(),emtion);
					
					
					
					
					
					
					
					
					
					
					
					result.setStatus(re);
				}
			}else {
				result.setMsg("您已评论过，请勿重复评论！");}
		
		
			return result;
			
		
	
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#findCommentByBasenoAndEmotion(int, int)
	 */
	public Result findCommentByBasenoAndEmotion(int parseInt, int parseInt2) {
		Result result = new Result();
		System.out.println(parseInt+"baseno");
		List<Comment> user= commentDao.findCommentByBasenoAndEmotion(parseInt,parseInt2 );

		
		if(user!=null){
			System.out.println(user);
			if(user.size() == 0){
				
				result.setStatus(0);
				result.setMsg("对不起，暂时没有评论呢！");
				
			}else{
				System.out.println(user);
				result.setStatus(1);
				result.setMsg("查找成功");
				result.setData(user);
			}
			}else{
				
				result.setStatus(0);
				result.setMsg("对不起，暂时没有评论呢！");
				
			}

	
	
		return result;
	}
		
}
