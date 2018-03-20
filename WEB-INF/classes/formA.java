// Using Session
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class formA extends HttpServlet {
   public void doPost( HttpServletRequest request,
                       HttpServletResponse response )
      throws ServletException, IOException
   {
      PrintWriter output;
      /*(String conti = request.getParameter( "continent" );

      HttpSession session  = request.getSession(true);
      session.putValue(conti, getCities( conti ));*/
      
      response.setContentType( "text/html" );
      output = response.getWriter();         
      output.println( "<HTML><HEAD><TITLE>E-shop</TITLE> <style>" );
      output.println( ".header{" );
	  output.println( "line-height: 200px;" );
	  output.println( "height: 200px;" );
	  output.println( "font-family:    TimesNewRoman;" );
	  output.println( "font-size:      120px;" );
	  output.println( "font-style:    italic; color: red;background-color : black; text-align: center;" );
	  output.println( "}.form-radio-item label, .form-checkbox-item label {white-space: normal; display: block; left: 14px; top: -14px; position relative; } </style>" );
	  output.println( "<BODY></HEAD><h1 class='header' text-align='center'>Let's begin!</h1><br><div align='center'>" );
	  output.println( "<FORM ACTION='http://localhost:8080/mywebsite/formB' method='post'>" );
	  output.println( "<h1 style='font-family: TimesNewRoman; color: Green'>First give us some info!</h1>" );
	  output.println( "First name:<br>" );
	  output.println( "<input type='text' name='firstname'><br>" );
	  output.println( "Last name:<br>" );
	  output.println( "<input type='text' name='lastname'><br><br><br>" );
	  output.println( "<h1 style='font-family: TimesNewRoman; color: Green'>Now select a category!</h1>" );
	  output.println( "<img style=' width: 200px; height: 150px' src='./console.png'>Consoles<input style='margin-right: 50px;' type='radio' name='category' value='console' />" );
	  output.println( "<img style='width: 250px; height: 150px' src='./pc.jpg'>Pc Components<input style='margin-right: 50px;' type='radio' name='category' value='pc' />" );
	  output.println( "<img style='width: 250px; height: 150px' src='./gameslibrary.png'>Games<input style='margin-right: 50px;' type='radio' name='category' value='Games' />" );
	  output.println( "<br><br><INPUT TYPE=submit VALUE='Submit'></FORM></div></BODY></HTML>" );
      output.close();    // close stream
   }
}
