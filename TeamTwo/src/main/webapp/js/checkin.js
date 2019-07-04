
function getAllAttendance(){
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
	    
		if(xhr.readyState === 4 && xhr.status === 200) {
	        let attendance = JSON.parse(xhr.responseText);
	        displayAttendance(attendance);
	    }
		
		
	}
	
	xhr.open("GET", "student", true);
	
	xhr.send();//<----- takes in data for body of request
	}

	function displayAttendance(attendance){
	      const tBody = document.getElementById("displayAtt");
	      
	      tBody.innerHTML = "";
	     if(attendace.length === 0){
	    	 
	     }else{
	    for(i = 0; i < attendance.length; i++){
	        
	        const newRow = document.createElement("tr");
	        
	        const SubjectData = document.createElement("td");
	        SubjectData.innerText = attendance[i].subject;
	        newRow.appendChild(SubjectData);
	        
	        const loginStampData = document.createElement("td");
	        loginStampData.innerText = attendance[i].loginStamp;
	        newRow.appendChild(loginStampData);
	        
	        tBody.appendChild(newRow);
	    }
	}
	}

	let Checkin = function(subject){
		this.subject = subject;
	}
	

	//Second AJAX 

	function postAttendance(){
		//Get form information first
		event.preventDefault();
		
		  let subject = document.querySelector('select').value;
			  
		
		let newCheckin = new Checkin(subject);
		
		let xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4 && xhr.status === 200){
				getAllAttendance();
			}
		}
		
		xhr.open("POST", "student", true);
		
		
		xhr.send(JSON.stringify(newCheckin));	
	}
		

	window.onload = function(){
	    getAllAttendance();
	    document.getElementById("button").addEventListener("click", postAttendance);
	}
	





