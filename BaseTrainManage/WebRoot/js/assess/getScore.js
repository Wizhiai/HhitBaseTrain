











function getScore(){
					
	var dataArr1 = new Array();
	var dataArr2 = new Array();
	var dataArr3 = new Array();
	var dataArr4 = new Array();
	var dataArr5 = new Array();
	var dataArr6 = new Array();
	var dataArrAllScore = new Array();
	var optionT;
	  $.ajax({
	  			url:"/BaseTrainManage/assess/getAssessScore.do",
					type:"post",

    	
     

			dataType:"json",
			  beforeSend: function(XMLHttpRequest) {
		  var height = document.body.scrollWidth + "px";//滚动位置可能大于屏幕高度
	$('#uploadresult').css("display","block").css("height",height).css("text-align","center").html('<img style="padding-top:300px;" 	src="./loading.gif\" />');
                    $("#uploadresult").html("<img src=\"./loading2.gif\" alt=\"图片上传中中...\" />");
                  },
			success:function(result){
				if(result.status == 1){
					 $("#uploadresult").html("");
					var data = result.data;
					var si = 0;

					
					//
													
					//
					for(var  di = 0; di< data.length; di++){
								var s11=0;var s12=0;var s13=0;var s21=0;var s22=0;var s23=0;var s24=0;var s25=0;var s26=0;var s27=0;var s31=0;var s32=0;var s33=0;var s34=0;var s35=0;var s36=0;var s41=0;var s42=0;var s43=0;var s44=0;var s45=0;var s51=0;var s52=0;var s53=0;var s54=0;var s55=0;var s61=0;var s62=0;var s63=0;var s64=0;var s65=0;var s66 = 0;
					var allscore = 0;
					var s1=0;var s2=0;var s3=0;var s4=0;var s5=0;var s6=0;
					var dataLS = data[di];    //每个基地的成绩集合
						myBase[di] = dataLS[0].basename;//基地名
						var s11Arr = new Array();
						var s12Arr = new Array();
						var s13Arr = new Array();
						var s21Arr = new Array();
						var s22Arr = new Array();
						var s23Arr = new Array();
						var s24Arr = new Array();
						var s25Arr = new Array();
						var s26Arr = new Array();
						var s27Arr = new Array();
						var s31Arr = new Array();
						var s32Arr = new Array();
						var s33Arr = new Array();
						var s34Arr = new Array();
						var s35Arr = new Array();
						var s36Arr = new Array();
						var s41Arr = new Array();
						var s42Arr = new Array();
						var s43Arr = new Array();
						var s44Arr = new Array();
						var s45Arr = new Array();
						var s51Arr = new Array();
						var s52Arr = new Array();
						var s53Arr = new Array();
						var s54Arr = new Array();
						var s55Arr = new Array();
						var s61Arr = new Array();
						var s62Arr = new Array();
						var s63Arr = new Array();
						var s64Arr = new Array();
						var s65Arr = new Array();
						var s66Arr = new Array();
						var sAllScoreArr = new Array();
						for(var  j = 0; j<dataLS.length; j++){//每个集合的单个成绩表
			
s11Arr[j] = dataLS[j].oone;s12Arr[j]= dataLS[j].otwo;s13Arr[j]= dataLS[j].othree;s21Arr[j]= dataLS[j].tone;s22Arr[j]= dataLS[j].ttwo;
s23Arr[j]= dataLS[j].tthree;s24Arr[j] = dataLS[j].tfour;s25Arr[j]= dataLS[j].tfive;s26Arr[j]= dataLS[j].tsix;s27Arr[j]= dataLS[j].tseven;
	s31Arr[j]= dataLS[j].threeone;s32Arr[j]= dataLS[j].threetwo;s33Arr[j]= dataLS[j].threethree;s34Arr[j]= dataLS[j].threefour;s35Arr[j]= dataLS[j].threefive;
	s36Arr[j]= dataLS[j].threesix;s41Arr[j]= dataLS[j].fourone;s42Arr[j]= dataLS[j].fourtwo;s43Arr[j]= dataLS[j].fourthree;s44Arr[j]= dataLS[j].fourfour;
	s45Arr[j]= dataLS[j].fourfive;s51Arr[j]= dataLS[j].fiveone;s52Arr[j]= dataLS[j].fivetwo;s53Arr[j]= dataLS[j].fourthree;s54Arr[j]= dataLS[j].fivefour;
	s55Arr[j]= dataLS[j].fivefive;s61Arr[j]= dataLS[j].sixone;s62Arr[j]= dataLS[j].sixtwo;s63Arr[j]= dataLS[j].sixthree;s64Arr[j]= dataLS[j].sixfour;
	s65Arr[j]= dataLS[j].sixfive;s66Arr[j]= dataLS[j].sixsix;sAllScoreArr[j]=dataLS[j].allScore;
			s1=(s11+s12+s13)/3;
			s2=(s21+s22+s23+s24+s25+s26+s27)/7;
			s3=(s31+s32+s33+s34+s35+s36)/6;
			s4=(s41+s42+s43+s44+s45)/5;
			s5=(s51+s52+s53+s54+s55)/5;
			s6=(s61+s62+s63+s64+s65+s66)/6;
	
			if(j==(dataLS.length-1)){
				checkR(s11Arr);checkR(s12Arr);checkR(s13Arr);
				checkR(s21Arr);checkR(s22Arr);checkR(s23Arr);checkR(s24Arr);checkR(s25Arr);checkR(s26Arr);checkR(s27Arr);
				checkR(s31Arr);checkR(s32Arr);checkR(s33Arr);checkR(s34Arr);checkR(s35Arr);checkR(s36Arr);
				checkR(s41Arr);checkR(s42Arr);checkR(s43Arr);checkR(s44Arr);checkR(s45Arr);
				checkR(s51Arr);checkR(s52Arr);checkR(s53Arr);checkR(s54Arr);checkR(s55Arr);
				checkR(s61Arr);checkR(s62Arr);checkR(s63Arr);checkR(s64Arr);checkR(s65Arr);checkR(s66Arr);
				checkR(sAllScoreArr);
					tArray[di][1]=(checkR(s11Arr)+checkR(s12Arr)+checkR(s13Arr))/3;				
					tArray[di][2]=(checkR(s21Arr)+checkR(s22Arr)+checkR(s23Arr)+checkR(s24Arr)+checkR(s25Arr)+checkR(s26Arr)+checkR(s27Arr))/7;
					tArray[di][3]=(checkR(s31Arr)+checkR(s32Arr)+checkR(s33Arr)+checkR(s34Arr)+checkR(s35Arr)+checkR(s36Arr))/6;
					tArray[di][4]=(checkR(s41Arr)+checkR(s42Arr)+checkR(s43Arr)+checkR(s44Arr)+checkR(s45Arr))/5;
					tArray[di][5]=(checkR(s51Arr)+checkR(s52Arr)+checkR(s53Arr)+checkR(s54Arr)+checkR(s55Arr))/5;
					tArray[di][6]=(checkR(s61Arr)+checkR(s62Arr)+checkR(s63Arr)+checkR(s64Arr)+checkR(s65Arr)+checkR(s66Arr))/6;
					
					checkR(sAllScoreArr);
					console.log(sAllScoreArr);
					tArray[di][7]=checkR(sAllScoreArr);
					
					tArray[di][8]=checkR(s11Arr);
					tArray[di][9]=checkR(s12Arr);
					tArray[di][10]=checkR(s13Arr);
					tArray[di][11]=checkR(s21Arr);
					tArray[di][12]=checkR(s22Arr);
					tArray[di][13]=checkR(s23Arr);
					tArray[di][14]=checkR(s24Arr);
					tArray[di][15]=checkR(s25Arr);
					tArray[di][16]=checkR(s26Arr);
					tArray[di][17]=checkR(s27Arr);
					tArray[di][18]=checkR(s31Arr);
					tArray[di][19]=checkR(s32Arr);
					tArray[di][20]=checkR(s33Arr);
					tArray[di][21]=checkR(s34Arr);
					tArray[di][22]=checkR(s35Arr);
					tArray[di][23]=checkR(s36Arr);
					tArray[di][24]=checkR(s41Arr);
					tArray[di][25]=checkR(s42Arr);
					tArray[di][26]=checkR(s43Arr);
					tArray[di][27]=checkR(s44Arr);
					tArray[di][28]=checkR(s45Arr);
					tArray[di][29]=checkR(s51Arr);
					tArray[di][30]=checkR(s52Arr);
					tArray[di][31]=checkR(s53Arr);
					tArray[di][32]=checkR(s54Arr);
					tArray[di][33]=checkR(s55Arr);
					tArray[di][34]=checkR(s61Arr);
					tArray[di][35]=checkR(s62Arr);
					tArray[di][36]=checkR(s63Arr);
					tArray[di][37]=checkR(s64Arr);
					tArray[di][38]=checkR(s65Arr);
					tArray[di][39]=checkR(s66Arr);
dataArr1[di]=get(tArray[di][1]);
dataArr2[di]=get(tArray[di][2]);
dataArr3[di]=get(tArray[di][3]);
dataArr4[di]=get(tArray[di][4]);
dataArr5[di]=get(tArray[di][5]);
dataArr6[di]=get(tArray[di][6]);
dataArrAllScore[di]=get(tArray[di][7]);
}
			
			
														var optionT1	 =	 {
            name:	myBase[di],
            type:'line',
            data:[get(tArray[di][1])	,get(tArray[di][2]),get(tArray[di][3]),get(tArray[di][4]),get(tArray[di][5]),get(tArray[di][6])],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };
														series[di]=optionT1;
														//分组参数配置
														var optionG1	 =	 {
            name:	myBase[di],
            type:'line',
            data:[get(tArray[di][8])	,get(tArray[di][9]),get(tArray[di][10])],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };
			var optionG2	 =	 {
            name:	myBase[di],
            type:'line',
            data:[get(tArray[di][16])	,get(tArray[di][17]),get(tArray[di][11])	,get(tArray[di][12]),get(tArray[di][13])	,get(tArray[di][14]),get(tArray[di][15])],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };
				var optionG3	 =	 {
            name:	myBase[di],
            type:'line',
            data:[get(tArray[di][18])	,get(tArray[di][19]),get(tArray[di][20])	,get(tArray[di][21]),get(tArray[di][22])	,get(tArray[di][23])],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };
			var optionG4	 =	 {
            name:	myBase[di],
            type:'line',
            data:[get(tArray[di][24])	,get(tArray[di][25]),get(tArray[di][26])	,get(tArray[di][27]),get(tArray[di][28])	],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };var optionG5	 =	 {
            name:	myBase[di],
            type:'line',
            data:[get(tArray[di][29])	,get(tArray[di][30]),get(tArray[di][31])	,get(tArray[di][32]),get(tArray[di][33])],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };var optionG6	 =	 {
            name:	myBase[di],
            type:'line',
            data:[get(tArray[di][34])	,get(tArray[di][35]),get(tArray[di][36])	,get(tArray[di][37]),get(tArray[di][38])	,get(tArray[di][39])],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };
															
															
															
															

															
								group1[di]=optionG1;group2[di]=optionG2;group3[di]=optionG3;
								group4[di]=optionG4;group5[di]=optionG5;group6[di]=optionG6;
														
														
														
//													分组参数配置结尾	
							}
							//为单个基地成绩集合做出理
						//为所有基地成绩做处理
	
						}//循环结束
					var z= ['实践教学体系','基地建设','教学过程','师资建设','教学效果','第三方评论'];

				
											   var myChartz = echarts.init(document.getElementById('zhexian'));

													
var optionz2 = {
    title : {
        text: '基地指标评分折线分布图',
        subtext: ''
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data: myBase
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data :['实践教学体系','基地建设','教学过程','师资建设','教学效果','第三方评论']
        }
    ],
    yAxis : [
        {
            type : 'value',
            axisLabel : {
                formatter: '{value}分'
            }
        }
    ],
    series :series
};

myChartz.on('click', function (optionz2) {
    // 控制台打印数据的名称
	switch(optionz2.name){
	case "基地建设":{
			setGroup(myBase,gb2,group2);
		break;
	}
	case "教学过程":{
			setGroup(myBase,gb3,group3);
			break;
	}
	case "师资建设":{
			setGroup(myBase,gb4,group4);
			break;
	}
	case "教学效果":{
			setGroup(myBase,gb5,group5);
			break;
	}
	case "第三方评论":{
			setGroup(myBase,gb6,group6);
			break;
	}
	default:{
			setGroup(myBase,gb1,group1);
			break;
	}
	
	
	}
	var $wrap = $('.section-wrap');
		var $arrow = $('.arrow');

		i=2;
			var $btn = $('.section-btn li');
				$btn.eq(i).addClass('on').siblings().removeClass('on');	
			$wrap.attr("class","section-wrap").addClass(function() { return "put-section-"+i; }).find('.section').eq(i).find('.title').addClass('active');
	
});

        // 使用刚指定的配置项和数据显示图表。折线图
        myChartz.setOption(optionz2);
					
					//柱形图
     
					  // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('section-3'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '各基地成绩评分结果'
            },
            tooltip: {},
            legend: {
                data:['评分']
            },
            xAxis: {
                data:myBase
            },
            yAxis: {},
            series: [{
                name: '评分',
                type: 'bar',
                 itemStyle: {
                normal: {
                  color:"#808080",
                }
             },
                data:dataArrAllScore
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
					


//group图表配置



        
  		setGroup(myBase,gb1,group1);

							
						}else{
							alert("数据出错！");
						}
					},
					error:function(){
							alert("程序出错");
							
							
					}
				});
	
}



function get(s)
{
    var s = s + "";
    var str = s.substring(0,s.indexOf(".") + 3);
    return str;
}
function setGroup(a,b,c){
	
											   var myChartG = echarts.init(document.getElementById('group'));

													
var optionG = {
    title : {
        text: '具体指标分析图',
        subtext: ''
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data: a
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },

    calculable : true,
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data :b
        }
    ],
    yAxis : [
        {
            type : 'value',
            axisLabel : {
                formatter: '{value}分'
            }
        }
    ],
    series :c
};



        // 使用刚指定的配置项和数据显示图表。折线图
        myChartG.setOption(optionG);

	
	
}
function removeByValue(arr, val) {
  for(var i=0; i<arr.length; i++) {
    if(arr[i] == val) {
      arr.splice(i, 1);
      break;
    }
  }
  return arr;
}
function checkR(r){
	
var min = 	r[0];
	

var max = r[0];

for(var i=1;i<r.length;i++){ 

  if(max<r[i])max=r[i];}
for(var i=1;i<r.length;i++){ 

  if(min>r[i])min=r[i];}
	
	if((max-min)>60){

var ave =	getAve(r);


if((max-ave)>(ave-min)){

	r =	removeByValue(r,max);

}else{
		r =	removeByValue(r,min);
}
	
		checkR(r);
		
	}else{
		var rT = 0;
		for(var ri = 0; ri<r.length;ri++){
			rT = rT + r[ri];
		}
		rT = rT/r.length;
		if(r.length == 2){
		
	}
		
		return rT;
	}
	
	
}

function getAve(array){
    var ave = 0;
   
       
    for(var i=0;i<array.length;i++){
    	
        ave+=array[i];
    }
    
    ave=ave/array.length;
  
    return ave;
}
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 	var optionT1	 =	 {
            name:		z[0],
            type:'line',
            data:dataArr1,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };
								var optionT2	 =	 {
            name:		z[1],
            type:'line',
            data:dataArr2,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };
									var optionT3	 =	 {
            name:		z[2],
            type:'line',
            data:dataArr3,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };
															var optionT4	 =	 {
            name:		z[3],
            type:'line',
            data:dataArr4,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };
																					var optionT5	 =	 {
            name:		z[4],
            type:'line',
            data:dataArr5,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };
																											var optionT6	 =	 {
            name:		z[5],
            type:'line',
            data:dataArr6,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        };
							
 * */
 
