'use strict' 
//The line above is used to then check in the console some errors which VS Code can't detect.
var reader1 = new FileReader();
reader1.addEventListener('load', e => {
  document.querySelector('#img').src = e.target.result;
  student.studentImage = document.querySelector('#img').src;
});
document.forms.pickfile.file.addEventListener('change', e => {
    reader1.readAsDataURL(e.target.files[0]);
});
//Below an object to store all values.
let student = {
  studentFullName: undefined,
  studentAddress: undefined,
  studentEmail: undefined,
  studentContact: undefined,
  studentSchool: undefined,
  studentGrade: undefined,
  studentImage: undefined
}
//The code below is used to register the student and post the object to server.
const registerTheStudent = () => {
  fetch("http://localhost:8080/post-student", { 
    method: 'POST',
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(student) 
  }).then(
    response => response.json() // if the response is a JSON object
  ).then(
    success => console.log(success) // Handle the success response object
  ).catch(
    error => console.log(error) // Handle the error response object
  );
};
let register = () =>{
  //Assigning values to students' and guardians' informations.
  let studentFullName = document.getElementById("studentFullName").value;
  let studentAddress = document.getElementById("studentAddress").value;
  let studentEmail = document.getElementById("studentEmail").value;
  let studentContact = document.getElementById("studentContact").value;
  let studentSchool = document.getElementById("studentSchool").value;
  let studentGrade = document.getElementById("studentGrade").value;
  let guardianFullName = document.getElementById("guardianFullName").value;
  let guardianAddress = document.getElementById("guardianAddress").value;
  let guardianEmail = document.getElementById("guardianEmail").value;
  let guardianContact = document.getElementById("guardianContact").value;
  //We create an array to then check one by one whether one of the variables are empty.
  let array = [studentFullName,studentAddress,studentEmail,studentContact,studentSchool,studentGrade,guardianFullName,guardianAddress,guardianEmail,guardianContact]
  for (let index = 0; index < array.length; index++) {
    const element = array[index];
    if(element == ""){
      return alert("TextFields cannot be empty! Please fill them!"); 
      //Above, the if statements an alert which says to fill the empty textfields.
    }
  }
  //The below lines will be executed if textfields aren't empty.
  student.studentFullName = studentFullName;
  student.studentAddress = studentAddress;
  student.studentEmail = studentEmail;
  student.studentContact = studentContact;
  student.studentSchool = studentSchool;
  student.studentGrade = studentGrade;
  return registerTheStudent();
}
//The code below is used for the clear button to clear all inputs with type text.
let clear = document.getElementById('clear');
clear.addEventListener("click", () =>{
  document.getElementById('studentFullName').value = "";
  document.getElementById('studentAddress').value = "";
  document.getElementById('studentEmail').value = "";
  document.getElementById('studentContact').value = "";
  document.getElementById('studentSchool').value = "";
  document.getElementById('studentGrade').value = "";
  document.getElementById('guardianFullName').value = "";
  document.getElementById('guardianAddress').value = "";
  document.getElementById('guardianEmail').value = "";
  document.getElementById('guardianContact').value = "";
});