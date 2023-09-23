let image = new Image();
//The below function is used to view all the students in the table
let view_all_students = document.getElementById('view-all-students');
view_all_students.addEventListener("click", event =>{
  fetch("http://localhost:8080/view-student")
  .then(response => response.json())
  .then(json => {
      let tableRow = `<tr>
                      <th>Student's Full Name</th>
                      <th>Student's Address</th>
                      <th>Student's Email</th>
                      <th>Student's Contact</th>
                      <th>Student's School</th>
                      <th>Student's Grade</th>
                      </tr>`;
      json.forEach(element => {
        image = element.studentImage;
        console.log(image);
          tableRow +=
           `<tr id="row" class="hover" onclick="displayStudentInformation()">
              <td>${element.studentFullName}</td>
              <td>${element.studentAddress}</td>
              <td>${element.studentEmail}</td>
              <td>${element.studentContact}</td>
              <td>${element.studentSchool}</td>
              <td>${element.studentGrade}</td>
            </tr>`
          
      });

      document.getElementById('load-all-students').innerHTML = tableRow;

  })
});
let displayStudentInformation = () =>{
  var table = document.getElementById("load-all-students");
  var tr = document.getElementById("row");
  for (i = 0; i < tr.length; i++) {
    var currentRow = table.tr[i];
    var createClickHandler = function(tr) {
      return function() { 
        let studentInformation = "";
        studentInformation += 
              `<div class="Information">
              <div>
                <p class="information">${tr.getElementsByTagName('td')[0].textContent}</p>
                <p class="information">${tr.getElementsByTagName('td')[1].textContent}</p>
                <p class="information">${tr.getElementsByTagName('td')[2].textContent}</p>
                <p class="information">${tr.getElementsByTagName('td')[3].textContent}</p>
                <p class="information">${tr.getElementsByTagName('td')[4].textContent}</p>
                <p class="information">${tr.getElementsByTagName('td')[5].textContent}</p>
              </div>
              <div>
                <img src="${image}" alt="Image" id="decoded">
              </div>`
          document.getElementById('studentInformation').innerHTML = studentInformation;
        };
      };
    currentRow.onclick = createClickHandler(currentRow);
  }
}