package com.example.jumbaClass.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.jumbaClass.database.Database;
import com.exmaple.jumbaClass.model.Participant;

/**
 * Servlet implementation class AddParticipantServlet
 */
public class AddParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddParticipantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//	
		//Create a Participant object
		Participant sendToSqlP1 = new Participant(); 
		
		//Set my form data in my participant object
		 sendToSqlP1.setName(request.getParameter("name"));
		 sendToSqlP1.setPhone(request.getParameter("phone"));
		 sendToSqlP1.setEmail(request.getParameter("email"));
		 
		 int bidToInteger = Integer.parseInt(request.getParameter("batchId"));
			sendToSqlP1.setBatchId(bidToInteger);
//			sendToMySqlP1.setBid( Integer.parseInt(request.getParameter("bid") ));
		 
		 // Use the database singleton instance
	    Database db = Database.getInstance();
	
	    //Get your db connection
//	    db.getConnection();
	    
	 // SQL query to insert participant data into the database
	    
	   String insertParticipantSql = "INSERT INTO Participant(name, phone, email, batchId) VALUES (?, ?, ?, ?)";
	   
	   try(Connection connection = db.getConnection(); 
			   
	PreparedStatement ps = connection.prepareStatement(insertParticipantSql))
	   
	   {
		   
		// Set parameters for the participant insertion
					ps.setString(1,  sendToSqlP1.getName());
					ps.setString(2,  sendToSqlP1.getPhone());
					ps.setString(3,  sendToSqlP1.getEmail());
					ps.setInt(4,  sendToSqlP1.getbatchId()); 
					
					// Execute the update
			        int result = db.executeUpdate(ps);
								
				} catch (Exception e) {

					System.out.println("SQL Exception occured: ");
					e.printStackTrace(); 
				}
		   
	   				
	  
		    
	    //choose the .executeupdate method after writing a PreparedStatement
	    
	    // update your Db with an insert the Participant Object
	    
	    
		}
	
	

}
