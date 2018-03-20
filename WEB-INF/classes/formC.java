import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class formC extends HttpServlet {

   public void doPost( HttpServletRequest request,
                       HttpServletResponse response )
      throws ServletException, IOException
   {
      PrintWriter output;
      	  //                             Replace the following 3 'cookie' lines
//Cookie c = new Cookie( conti, getCities( conti ) );
//c.setMaxAge( 120 );  // seconds until cookie removed
//response.addCookie( c );  // must precede getWriter
// BY
      //create a new session (with arg 'true')
		HttpSession session  = request.getSession(false);
		String customerinfo[];
		
		if (session!=null)
			customerinfo = session.getValueNames();
		else {
			customerinfo = null;
		}
		
		      
		response.setContentType( "text/html" );
		output = response.getWriter();         

      // send HTML page to client
      output.println( "<HTML><HEAD><TITLE>E-shop</TITLE> <style>" );
      output.println( ".header{" );
	  output.println( "line-height: 200px;" );
	  output.println( "height: 200px;" );
	  output.println( "font-family:    TimesNewRoman;" );
	  output.println( "font-size:      120px;" );
	  output.println( "font-style:    italic; color: red;background-color : black; text-align: center;" );
	  output.println( "}.form-radio-item label, .form-checkbox-item label {white-space: normal; display: block; left: 14px; top: -14px; position relative; } </style>" );
	  output.println( "<BODY></HEAD><h1 class='header' text-align='center'>Final step! Check your form before submit!</h1><br><div align='center'>" );
	  
		if (session!=null){
			String category = (String)session.getValue(customerinfo[0]);
			String firstname = (String)session.getValue(customerinfo[1]);
			String lastname = (String)session.getValue(customerinfo[2]);
			String phone = (String)session.getValue(customerinfo[3]);
			String mail = (String)session.getValue(customerinfo[4]);	
			output.println( "<h1 style='font-family: TimesNewRoman; color: red;'>Review your info and submit the form</h1>" );
			output.print( "<h2>First name:</h2>");
			output.print( category);		
			output.print( "<h2>Last name:</h2>");
			output.print( lastname);
			output.print( "<h2>Phone number:</h2>");
			output.print( phone);
			output.print( "<h2>E-mail:</h2>");
			output.print( mail);
			output.print( "<br><br><br><br>");
			output.println( "<h1 style='font-family: TimesNewRoman; color: red;'>Order information:</h1>" );
			if (category.equals("pc")){
				String component = request.getParameter( "component" );
				String message = request.getParameter( "message" );
				output.print( "<h2>Pc component category:</h2>");
				output.print( component);		
				output.print( "<h2>Model:</h2>");
				output.print( message);		
				
			}
			if (category.equals("games")){
				
			}
			if (category.equals("console")){
				
			}
			output.println( "<FORM ACTION='http://localhost:8080/mywebsite'>" );			
			output.println( "<INPUT style='background-color: red;' TYPE=submit VALUE='Start over'><br><br>" );
			output.println( "<FORM ACTION='http://localhost:8080/mywebsite/formC' method='GET'>" );			
			output.println( "<INPUT style='width: 300px; height: 100px;' TYPE=submit VALUE='Submit'>" );


			
		}
		else {
			output.println( "<h1 style='font-family: TimesNewRoman; color: red;'>Something went wrong!</h1><br>" );
			output.println( "<h3 style='font-family: TimesNewRoman; color: red;'>Your session has expired</h3>" );			 
			output.println( "<FORM ACTION='http://localhost:8080/mywebsite'>" );
			output.println( "<br><INPUT TYPE=submit VALUE='Start over!'>" );

			
		}
		/*
	  output.println( "<FORM ACTION='http://localhost:8080/mywebsite/formC' method='post'>" );
	  if (category.equals("pc")){
			 output.println( "<h1 style='font-family: TimesNewRoman; color: red;'>Lets find the best pc component</h1>" );
			 output.println( "  <select style='font-family: TimesNewRoman; font-size: 30px' name='component'>");
			 output.println( "<option value='graphicscard'>Graphics card</option> ");
			 output.println( "<option value='cpu'>CPU</option> ");
			 output.println( "<option value='motherboard'>Motherboard</option>  ");
			 output.println( "<option value='case'>Case</option>  ");
			 output.println( "<option value='psu'>PSU</option>  ");
			 output.println( " </select><br><br><br>");
			 output.println( "<textarea style='font-family: TimesNewRoman; font-size: 20px;' name='message' rows='10' cols='30'>" );
			 output.println( "Please name your product" );
			 output.println( "</textarea><br><br>" );
			 output.println( "<INPUT TYPE='reset'> <br>" );
			 output.println( "<INPUT TYPE=submit VALUE='Submit'>" );
			 output.println( "" );
			 output.println( "" );
			 output.println( "" );
	  }	
	  if (category.equals("Games")){
		  output.println( "");
		  output.println( " ");
		  output.println( " ");
		  output.println( " ");
		  output.println( " ");
		  output.println( " ");
		  output.println( " ");
		  output.println( " ");
	  }
	  if(category.equals("console")){
		  output.println( "<h1 style='font-family: TimesNewRoman; color: red;'>Please select consoles you are interested in</h1>");		  
		  output.println( "<img style=' width: 200px; height: 150px' src='./ps3.jpg'><input type='checkbox' name='Playstation3' value='Playstation3'> Playstation3 <br>");
		  output.println( "<img style=' width: 200px; height: 150px' src='./playstation4.jpg'><input type='checkbox' name='Playstation4' value='Playstation4'> Playstation4 <br>");
		  output.println( "<img style=' width: 200px; height: 150px' src='./xboxone.png'><input type='checkbox' name='XboxOne' value='XboxOne'> Xbox One <br>");
		  output.println( "<img style=' width: 200px; height: 150px' src='./xbox360.jpg'><input type='checkbox' name='Xbox360' value='Xbox360'> Xbox 360 <br>");
		  output.println( "<img style=' width: 200px; height: 150px' src='./wii.jpg'><input type='checkbox' name='Wii' value='Wii'> Wii <br>");
		  output.println( "<INPUT TYPE='reset'> <br>");
		  output.println( "<INPUT TYPE=submit VALUE='Submit'>" );

	  }
		output.close();    // close stream
*/
   }
}
