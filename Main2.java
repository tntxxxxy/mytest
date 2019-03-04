import java.awt.MouseInfo;


import java.awt.Point;


import java.awt.PointerInfo;


import java.awt.Robot;
import java.awt.event.KeyEvent;


import java.text.DateFormat;


import java.text.ParseException;


import java.text.SimpleDateFormat;


import java.util.Calendar;


import java.util.Date;


import java.util.TimeZone;


public class Main {


	


	



	public static void main(String[] args) {

		try {


			long eachTimeSleep = 20000;


			Date d = new Date();


			Calendar c = Calendar.getInstance();


			c.setTime(d);

			c.set(Calendar.DAY_OF_MONTH, 31);
			c.set(Calendar.HOUR_OF_DAY, 6);


			c.set(Calendar.MINUTE, 0);


			float time = (c.getTime().getTime()-d.getTime())/1000/60;


			System.out.println(time);


			int number = new Float(time/(eachTimeSleep*2/1000/60)).intValue();


			System.out.println(number);


			for(int i=0; i<number; i++) {


				{


					Robot robot = new Robot();


//					robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);


//					robot.keyPress(java.awt.event.KeyEvent.VK_ALT);


//					robot.keyPress(java.awt.event.KeyEvent.VK_DELETE);


					PointerInfo a = MouseInfo.getPointerInfo();


		            Point b = a.getLocation();


		            int x = (int) b.getX();


		            int y = (int) b.getY();


		            


		            robot.mouseMove(x, y+1);


		            



		            System.out.println(i + "=100, 300");


				}


	            	Thread.sleep(eachTimeSleep);


	            {


	            	Robot robot = new Robot();


	            	PointerInfo a = MouseInfo.getPointerInfo();


		            Point b = a.getLocation();


		            int x = (int) b.getX();


		            int y = (int) b.getY();


		            

		            if(i%2==0) {
		            	robot.mouseMove(x-20, y-20);
		            } else {
		            	robot.mouseMove(x+20, y+20);
		            }
		            
		            robot.mousePress(KeyEvent.BUTTON1_MASK);
		            robot.mouseRelease(KeyEvent.BUTTON1_MASK);

		            


	            	Thread.sleep(eachTimeSleep);


	            }


	            Date d2 = new Date();


	            


	            System.out.println(d + "--> " + (d2.getTime()-d.getTime())/1000f/60f);


			}


//			testRestart();


			System.exit(0);


            


        } catch (Exception e) {


            e.printStackTrace();


        }



	}


	


	


	


	


	public static void test(Date testDate, String localZone, String toZone) throws ParseException {


		DateFormat df_A = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


		String originalDateStr = df_A.format(testDate);


		


		df_A.setTimeZone(TimeZone.getDefault());


		Date localDate = df_A.parse(originalDateStr);


		System.out.println(TimeZone.getDefault().getDisplayName() + "--localZone: " + localDate);


		


		df_A.setTimeZone(TimeZone.getTimeZone(toZone));


		System.out.println("toZone: " + df_A.format(localDate));


	}


	


	private static void testRestart() throws Exception {


		Robot robot = new Robot();


		Thread.sleep(2000);


		System.out.println("aaaaaaaaaaasssssccl");


//		robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);


//		robot.keyPress(java.awt.event.KeyEvent.vk);


//		robot.keyRelease(java.awt.event.KeyEvent.VK_SLASH);


//		robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);


		robot.keyPress(java.awt.event.KeyEvent.VK_WINDOWS);


		robot.delay(100);


		robot.keyPress(java.awt.event.KeyEvent.VK_L);


		robot.delay(200);


		System.out.println("cccc");


		


		


		


		robot.keyRelease(java.awt.event.KeyEvent.VK_L);


		robot.delay(100);


		robot.keyRelease(java.awt.event.KeyEvent.VK_WINDOWS);


	}



	


}
