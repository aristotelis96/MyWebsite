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
	  output.println( "font-size:      80px;" );
	  output.println( "font-style:    italic; color: red;background-color : black; text-align: center;" );
	  output.println( "}.form-radio-item label, .form-checkbox-item label {white-space: normal; display: block; left: 14px; top: -14px; position relative; } </style>" );
	  output.println( "<BODY  text='white' background='./backgroundIntro.png'></HEAD><h1 class='header' text-align='center'>Final step! Check your form before submit!</h1><br><div align='center'>" );
	  
		if (session!=null){
			String category="pc",firstname=null,lastname=null,phone=null,mail=null;
			category = (String)session.getValue("category");
			firstname = (String)session.getValue("firstname");
			lastname = (String)session.getValue("lastname");
			phone = (String)session.getValue("phone");
			mail = (String)session.getValue("mail");
			
			/*for ( int i = 0; i < customerinfo.length; ++i ){
				if (  ){
					category = (String)session.getValue(customerinfo[i]);
					output.println("<h1>TEST</h1>");
				}
				if ( customerinfo[i].equals( "firstname" ) )
					firstname = (String)session.getValue(customerinfo[i]);
				if ( customerinfo[i].equals( "lastname" ) )
					lastname = (String)session.getValue(customerinfo[i]);
				if ( customerinfo[i].equals( "phone" ) )
					phone = (String)session.getValue(customerinfo[i]);
				if ( customerinfo[i].equals( "mail" ) )
					mail = (String)session.getValue(customerinfo[i]);

				}*/
			output.println( "<h1 style='font-family: TimesNewRoman; color: red;'>Review your info and submit the form</h1>" );
			output.print( "<h2>First name:</h2>");
			output.print( firstname);	
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
				output.print( "<h3>" + component + "</h3>");		
				output.print( "<h2>Model:</h2>");
				output.print( "<h3>" + message + "</h3>");	
				output.print( "<br><br><br><br>");		
				
				
			}
			if (category.equals("Games")){
				String gamecategory = request.getParameter( "gamecategory" );
				String message = request.getParameter( "message" );
				output.print( "<h2>Game category:</h2>");
				output.print( "<h3>" + gamecategory + "</h3>");		
				output.print( "<h2>Game description:</h2>");
				output.print( "<h3>" + message + "</h3>");		
				output.print( "<br><br><br><br>");		
					
				
			}
			if (category.equals("console")){
				output.print( "<h2>Consoles to be ordered:</h2>");
				if(request.getParameter("Playstation3")!=null)
					output.print( "<h2>Playstation 3</h2>");
				if(request.getParameter("Playstation4")!=null)
					output.print( "<h2>Playstation 4</h2>");
				if(request.getParameter("XboxOne")!=null)
					output.print( "<h2>Xbox One</h2>");
				if(request.getParameter("Xbox360")!=null)
					output.print( "<h2>Xbox 360</h2>");
				if(request.getParameter("Wii")!=null)
					output.print( "<h2>Wii</h2>");

				output.print( "<br><br><br><br>");	
			}
			output.println( "<FORM ACTION='http://localhost:8080/mywebsite'>" );			
			output.println( "<INPUT style='background-color: red;' TYPE=submit VALUE='Start over'><br><br></FORM>" );
			output.println( "<FORM ACTION='http://localhost:8080/mywebsite/final.html'>" );			
			output.println( "<INPUT style='width: 300px; height: 100px;' TYPE=submit VALUE='Submit'></FORM>" );


			
		}
		else {
			output.println( "<h1 style='font-family: TimesNewRoman; color: red;'>Something went wrong!</h1><br>" );
			output.println( "<h3 style='font-family: TimesNewRoman; color: red;'>Your session has expired</h3>" );			 
			output.println( "<FORM ACTION='http://localhost:8080/mywebsite'>" );
			output.println( "<br><INPUT TYPE=submit VALUE='Start over!'>" );

			
		}
   }
}
