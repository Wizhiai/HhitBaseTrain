function changeDateToString(Dateln){
	var Year=0;
	var Month=0;
	var Day=0;
	var CurrentDate="";
	Year=Dateln.getFullYear();
	Month=Dateln.getMonth()+1;
	Day=Dateln.getDate();
	CurrentDate=Year+"-";
	if(Month>=10){
		CurrentDate=CurrentDate+Month+"-";	
	}else{
		CurrentDate=CurrentDate+"0"+Month+"-";
	}
	if(Day>=0){
		CurrentDate=CurrentDate+Day;	
	}else{
		CurrentDate=CurrentDate+"0"+Day;
	}
  return CurrentDate;
 }