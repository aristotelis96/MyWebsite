import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class formB extends HttpServlet {

   public void doPost( HttpServletRequest request,
                       HttpServletResponse response )
      throws ServletException, IOException
   {
      PrintWriter output;
      String category = request.getParameter( "category" );
	  String firstname = request.getParameter( "firstname");
	  String lastname = request.getParameter( "lastname");
//                             Replace the following 3 'cookie' lines
//Cookie c = new Cookie( conti, getCities( conti ) );
//c.setMaxAge( 120 );  // seconds until cookie removed
//response.addCookie( c );  // must precede getWriter
// BY
      //create a new session (with arg 'true')
		HttpSession session  = request.getSession(true);
		session.putValue(category, category);
		session.putValue(firstname, firstname);
		session.putValue(lastname, lastname);
 //
      
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
	  output.println( "<BODY></HEAD><h1 class='header' text-align='center'>Give us info about your order</h1><br><div align='center'>" );
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

   }

}
