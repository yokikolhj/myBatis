package com.shirly.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



/**
* @author shirly
* @CreateTime 2019年7月29日 下午5:52:25
* @description 
*/
public class Date {

	public static void main(String[] args) throws ParseException {
		getDay1();
		/*System.out.println("-------------------");
		getMonth();*/
	}
	
	public static void getDay() {
		DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");  
        List<SatisticsByCustomer> list=null;  
        try{  
            String beginTime="2012-01-01";  
            String endTime="2013-01-21";  
            Calendar startDay = Calendar.getInstance();  
            Calendar endDay = Calendar.getInstance();  
            startDay.setTime(FORMATTER.parse(beginTime));  
            endDay.setTime(FORMATTER.parse(endTime));  
            // 给出的日期开始日比终了日大则不执行打印  
            list=new ArrayList<SatisticsByCustomer>();  
            SatisticsByCustomer s1=new SatisticsByCustomer();  
            s1.setColumnName(beginTime);  
            list.add(s1);  
            if(!beginTime.equals(endTime)){  
                if(startDay.compareTo(endDay)<=0){  
                    //现在打印中的日期  
                    Calendar currentPrintDay = startDay;  
                    while (true){  
                        SatisticsByCustomer s=new SatisticsByCustomer();  
                        // 日期加一  
                        currentPrintDay.add(Calendar.DATE, 1);  
                        // 日期加一后判断是否达到终了日，达到则终止打印  
                        if (currentPrintDay.compareTo(endDay) == 0) {  
                            break;  
                        }  
                        s.setColumnName(FORMATTER.format(currentPrintDay.getTime()));  
                        list.add(s);  
                    }  
                    SatisticsByCustomer s2=new SatisticsByCustomer();  
                    s2.setColumnName(endTime);  
                    list.add(s2);  
                }  
            }  
            for (SatisticsByCustomer customer : list)  
            {  
                System.out.println(customer.getColumnName());  
            }  
        }catch (Exception e){  
            e.printStackTrace();  
        } 
	}

	public static void getMonth() throws ParseException {
		java.util.Date d1 = new SimpleDateFormat("yyyy-MM").parse("2014-6");//定义起始日期

		java.util.Date d2 = new SimpleDateFormat("yyyy-MM").parse("2016-5");//定义结束日期

		Calendar dd = Calendar.getInstance();//定义日期实例

		dd.setTime(d1);//设置日期起始时间

		while(dd.getTime().before(d2)){//判断是否到结束日期

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		String str = sdf.format(dd.getTime());

		System.out.println(str);//输出日期结果

		dd.add(Calendar.MONTH, 1);//进行当前日期月份加1

		}
	}
	
	public static void getDay1() throws ParseException {
		java.util.Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse("2015-4-01");//定义起始日期

		java.util.Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2016-5-15");//定义结束日期

		Calendar dd = Calendar.getInstance();//定义日期实例

		dd.setTime(d1);//设置日期起始时间

		while(dd.getTime().before(d2)){//判断是否到结束日期

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String str = sdf.format(dd.getTime());

		System.out.println(str);//输出日期结果

		dd.add(Calendar.DAY_OF_YEAR, 1);//进行当前日期月份加1

		}
	}
}
