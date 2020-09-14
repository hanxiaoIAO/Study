$(function () {
    var map = new Map();
    $("#view").click(function(){
        view();
    });
    document.getElementById("import").addEventListener("change", function (event) {
        changeToAdd();

        let files = event.target.files;
        for (let i = 0; i < files.length; i++) {
            initOneFile(i,files[i].name,files[i].type,files[i].path,"");
        };
    }, false);

    function initOneFile(index,name,type,path,tag) {
        var file = new File(index,name,type,path);
        file.setTag(tag);
        map.set(index,file);
        //let item_tr = document.createElement("tr");
        let item_tr = $("<tr></tr>");
        let item_index = $("<td></td>").text(index);
        let item_file = $("<td></td>").text(name);
        let item_tag = $("<td></td>").text(tag).attr("contentEditable","true").prop("class","tag").blur(changeTag);
        item_tr.append(item_index, item_file, item_tag);
        $("tbody").append(item_tr);
    }
    
    function changeTag(){
        let index = parseInt($(this).parent().children(":first").html());
        let tag = $(this).html();
        let file = map.get(index);
        file.setTag(tag);
    };

    function changeToAdd(){
        $("#view").replaceWith("<input type=\"button\" class=\"btn btn-default btn-block\" id=\"add\" value=\"添加到系统\"/>");
        $("#add").click(function(){
            add();
        })
    }
    function changeToView(){
        $("#add").replaceWith("<input type=\"button\" class=\"btn btn-default btn-block\" id=\"view\" value=\"查看文件\"/>");
        $("#view").click(function(){
            view();
        })
    }

    function add() {
        var files = [];
        for(var file of map.values()){
            files.push(file.toJson());
        }
        $.ajax({
            type:"POST",
            url:"/addFile",
            data:JSON.stringify(files),
            contentType:"application/json;charset=UTF-8",
            success:successAdd()
        })
        //$.post("/addFile",JSON.stringify(files));
    }
    function view() {
        $.ajax({
            type:"GET",
            url:"/findFile",
            contentType:"application/json;charset=UTF-8",
            success:function(data) {
                showData(data)
            }
        })
    }

    function showData(jsonArray){
        $.each(jsonArray,function(Index,value){
            initOneFile(Index,value.name,"","",value.tag.toString());
        })
    }

    function successAdd(){
        changeToView();
        map.clear();
        $("#import").val("");
        $("tbody").empty();
    }

    function File(index,name,type,path){
        this.index = index;
        this.name=name;
        this.type = type;
        this.path = path;
        this.tag;
        this.setTag = function(tag){
            this.tag=tag;
        };
        this.toJson = function(){
            return {'name':this.name,'type':this.type,'path':this.path,'tag':this.tag};
        }
    }
})
