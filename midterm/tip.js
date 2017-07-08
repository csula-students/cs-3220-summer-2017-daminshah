
var $=function(id)
{
       return document.getElementById(id);
}
 
var calculate = function()
{
       var bill=parseInt($("bill").value);
       var percent=parseInt($("per").value);
 
       var tip=bill*(percent/100);
       var total=tip+bill;
       $("tip").value=tip;
       $("bill").value=total;
}
 
window.onload=function()
{
       $("calculate").onclick=calculate;
       $("bill").focus();
}