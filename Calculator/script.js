let num1="";
let num2="";           
let num="";
let operator="";                     
btn0.addEventListener("click",()=>{ 
    num+="0";
    document.getElementById("display").innerHTML=num;
});
btn00.addEventListener("click",()=>{
    num+="00";
    document.getElementById("display").innerHTML=num;
});
btnDot.addEventListener("click",()=>{
    num+=".";
    document.getElementById("display").innerHTML=num;
});
btn1.addEventListener("click",()=>{
    num+="1";
    document.getElementById("display").innerHTML=num;
});
btn2.addEventListener("click",()=>{
    num+="2";
    document.getElementById("display").innerHTML=num;
});
btn3.addEventListener("click",()=>{
    num+="3";
    document.getElementById("display").innerHTML=num;
});
btn4.addEventListener("click",()=>{
    num+="4";
    document.getElementById("display").innerHTML=num;
});
btn5.addEventListener("click",()=>{
    num+="5";
    document.getElementById("display").innerHTML=num;
});
btn6.addEventListener("click",()=>{
    num+="6";
    document.getElementById("display").innerHTML=num;
});
btn7.addEventListener("click",()=>{
    num+="7";
    document.getElementById("display").innerHTML=num;
});
btn8.addEventListener("click",()=>{
    num+="8";
    document.getElementById("display").innerHTML=num;
});
btn9.addEventListener("click",()=>{
    num+="9";
    document.getElementById("display").innerHTML=num;
});

btnDivide.addEventListener("click",()=>{
    num1=num;
    num="";
    operator="/";
    document.getElementById("display").innerHTML=operator;

});
btnAddition.addEventListener("click",()=>{
    num1=num;
    num="";
    operator="+";
    document.getElementById("display").innerHTML=operator;
});
btnMultiplication.addEventListener("click",()=>{
    num1=num;
    num="";
    operator="*";
    document.getElementById("display").innerHTML=operator;
});
btnSubtraction.addEventListener("click",()=>{
    num1=num;
    num="";
    operator="-";
    document.getElementById("display").innerHTML=operator;
});
btnModule.addEventListener("click",()=>{
    num1=num;
    num="";
    operator="%";
    document.getElementById("display").innerHTML=operator;
});
btnEqual.addEventListener("click",()=>{
    num2=num;
    let num01=parseFloat(num1);
    let num02=parseFloat(num2);
    
    switch(operator){
        case "%"    : 
            var result= num01%num02; 
            document.getElementById("display").innerHTML=result;
            break;
        case "/"    :   
            var result= num01/num02; 
            document.getElementById("display").innerHTML=result;
            break;
        case "+"    :   
            var result= num01+num02; 
            document.getElementById("display").innerHTML=result;
            break;
        case "-"    :   
            var result= num01-num02; 
            document.getElementById("display").innerHTML=result;
            break;
        case "*"    :   
            var result= num01*num02; 
            document.getElementById("display").innerHTML=result;
            break;
    }
});
btnAC.addEventListener("click",()=>{
   document.getElementById("display").innerHTML=0;
   num="";
   num1="";
   num2="";
});
btnArrow.addEventListener("click",()=>{
    n = document.getElementById("display");
    if(n==0){
        document.getElementById("display").innerHTML='';
    }else{
        let val=num;
        for (let index = 0; index < num.length; index++) {
            if(val.length=0){
                document.getElementById("display").innerHTML='';
            }else{
                document.getElementById("display").innerHTML=val.substring(0,val.length-1);
            }
        }
    }
 });