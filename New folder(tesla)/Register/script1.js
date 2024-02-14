function submit(){

var user,passs;


user=document.getElementById("u1").value;
passs=document.getElementById("p1").value;
alert("hi"+ user);


if(user==""|passs=="")
{
    window.alert("Your Password Correct");
}
else if(user.length<6 | passs.length<8)
{
    window.alert("user name miniyam six caracters used and password miniyam 8 caracters used ");
}
else{
    window.alert("WelCome"+"M.r"+user);
}

}




