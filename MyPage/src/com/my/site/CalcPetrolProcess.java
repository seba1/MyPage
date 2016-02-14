package com.my.site;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/* TODO 
 * 1. Validate if input is numerical/not empty and output error if necessary
 * 2. Error messages
 * 3. First for loop have to be modified so it takes only 0,1,2,4,6,8,10 (if 0 or/and 1 not entered error message)
 * 4. There's section of if's else if's that should be done in better way(add loops and maybe new methods)
 * */
@WebServlet("/calcualte")
public class CalcPetrolProcess  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CalcPetrolProcess(){
    	super();
    }
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	final int SIZE = 5;
    	Map <String, Object> map = new HashMap<String, Object>();
    	String[] passedElems = {"costPerL", "avgFuelCost", "kmPerDay", "kmPerDayCost", "kmPerWeek", "kmPerWeekCost", "kmPerMnyh", "kmPerMnyhCost", "kmPerYr", "kmPerYrCost", "tripDist", "tripDistCost"};
    	String passedElem = "";
    	boolean isValid=false;
    	double petCostperL = 0.0;
    	double distance = 0.0;
    	double avgFcon = 0.0;
    	int savedI = 0;
    	int count = 0;
    	double[] distnaces = new double[SIZE];
    	double[] totalCost = new double[SIZE];
    	CalcDistance calc = new CalcDistance(7);
    	
    	//this for loop get all values from form
    	for (int i = 0; i < passedElems.length; i++){
    		passedElem = request.getParameter(passedElems[i]); // get value
	    	if (passedElem != "" && passedElem != null && isNumeric(passedElem)){
	    		if(i==0)
	    			petCostperL = Double.parseDouble(passedElem.trim());
	    		else if (i==1)
	    			avgFcon = Double.parseDouble(passedElem.trim());
	    		else{
	    			count +=1; //TODO count and in case there are more than one value inputted alert user
	    			savedI = i;
	    			distance = Double.parseDouble(passedElem.trim());
	    		}
	    	}
	    	passedElem = "";
    	}//end for
    	
    	//TODO this should be wrapped around loops
    	//calculate all distances
    	//daily entered
    	if(savedI==2){
    		distnaces[0] = distance;
    		distnaces[1] = calc.DtoW(distance);
    		distnaces[2] = calc.DtoM(distnaces[0]);
    		distnaces[3] = calc.DtoYr(distnaces[0]);
    	}//weeekly entered
    	else if(savedI==4){
    		distnaces[0] = calc.WtoD(distance);
    		distnaces[1] = distance;
    		distnaces[2] = calc.DtoM(distnaces[0]);
    		distnaces[3] = calc.DtoYr(distnaces[0]);
    	}//monthly entered
		else if(savedI==6){
			distnaces[0] = calc.MtoD(distance);
			distnaces[1] = calc.DtoW(distnaces[0]);
			distnaces[2] = distance;
			distnaces[3] = calc.DtoYr(distnaces[0]);
		}//yearly entered
		else if(savedI==8){
			distnaces[0] = calc.YrtoD(distance);
			distnaces[1] = calc.DtoW(distnaces[0]);
			distnaces[2] = calc.DtoM(distnaces[0]);
			distnaces[3] = distance;
    	}
		else if(savedI==10){
    		//TODO Trip distance
			distnaces[0]=0;
			distnaces[1]=0;
			distnaces[2]=0;
			distnaces[3]=0;
			distnaces[4]=distance;
    	}
//    	System.out.println("*******: "+distnaces[i]);
    	int c=0;
    	for(int i = 2; i < passedElems.length; i++){
    		if(i%2==0){
    			map.put(passedElems[i], ChckIfZeroAndConvToStr(distnaces[c]));
    		}
    		else{
    			//calculate cost for each distance
    			totalCost[c] = calculateFuelCost(distnaces[c], avgFcon, petCostperL);
    			map.put(passedElems[i], ChckIfZeroAndConvToStr(totalCost[c]));
    			c++;
    		}    		
    		//TODO This has to be moved somewhre else (outside for loop)[isValid=true;]:
    		isValid=true;
    	}
    	
    	map.put("isValid", isValid);
    	write(response, map);
    }
    
    public static String ChckIfZeroAndConvToStr(double value){
    	//take in double and return string format of it, also if taken value is less than 0 return empty string
    	if (value<=0)
    		return "";
    	else
    		return Double.toString(round(value, 2));
    }
    public static double calculateFuelCost(double d, double avgCon, double costPerL){
    	//  The fuel calculation formula:
		//	distance / 100 = res
		//	res * consLtPer100km  = res2
		//	res2 * price   = totalCost
	    double res  = d/100;
		double res2 = res * avgCon;
		double totalCost = round(res2 * costPerL,2);
		return totalCost;
    }
    public static boolean isNumeric(String str){  
		try {  
			Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe){  
			return false;  
		}  
		return true;
	}
    private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(new Gson().toJson(map));
    }
    public static double round(double d, int decimalPlace) {
    	 return BigDecimal.valueOf(d).setScale(decimalPlace,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
