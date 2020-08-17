$(function () {
    document.getElementById("filepicker").addEventListener("change", function (event) {
        let files = event.target.files;
        for (let i = 0; i < files.length; i++) {
            //let item_tr = document.createElement("tr");
            let item_tr = $("<tr></tr>");
            let item_file = $("<td></td>").text(files[i].webkitRelativePath);
            let item_tag = $("<td></td>").attr("contentEditable","true");
            item_tr.append(item_file, item_tag);
            $("tbody").append(item_tr);
        };
    }, false);
})
