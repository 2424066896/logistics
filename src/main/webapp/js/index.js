$(document).ready(function(){
    $("#an").click(function () {
        var p = $("#sendnum").val();
        var senddate = $("#senddate").val();
        var flag= true;
        if(senddate==""||senddate==null){
            alert("日期不能为空")
            flag = false;
        }else  if(p==""||p==null){
            alert("货单号不能为空")
            flag = false;
        }else if(p!=null&&p!=""){
            $.getJSON("checkSendNum",{p:p},callback);
            function callback(data) {
                if(data=="fail"){
                    alert("货单号重复，请重新输入！")
                    flag=false;
                }else {
                    $("#yanzhen").submit();
                }
            }
        }

    })
});