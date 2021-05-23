function getAllEmps(){
    $.ajax({
        url:"http://localhost:9090/sv/ems/getEmployeeList",
        method: "GET",
        dataType: "json",
        success:function (data){
            const tableBody = $('#tblEmp tbody');
            tableBody.empty();
            $(data).each(function (index, elm){
                tableBody.append('<tr><td>'+(index+1)+'</td>' +
                    '<td>'+elm.personMaster.firstName+' '+elm.personMaster.lastName+'</td>' +
                    '<td>'+formatDate(elm.personMaster.birthDate)+'</td>' +
                    '<td>'+formatDate(elm.joiningDate)+'</td>' +
                    '<td>'+elm.salary+'</td>' +
                    '<td>'+elm.isFresherEmployee+'</td>' +
                    '<td><button type="button" class="btn btn-primary" onclick="getEmployee('+elm.id+')">Edit</button></td></tr>');
            })
        },
        error: function ($xhr){
            const tableBody = $('#tblEmp tbody');
            tableBody.empty();
            tableBody.append('<tr><td colspan="7" style="text-align: center;">'+$xhr.responseText+'</td></tr>');
        }
    })
}

function getQualificationList(){
    $.ajax({
        url:"http://localhost:9090/sv/ems/getQualifications",
        method: "GET",
        dataType: "json",
        success: function(data){
            const qualificationDW = $('#qualification');
            qualificationDW.empty();
            $(data).each(function (index, elm){
                const option = new Option(elm.qualification, elm.id);
                $(option).html(elm.qualification);
                qualificationDW.append(option);
            })
        },
        error: function ($xhr){
            alert($xhr.responseText);
        }
    })
}

function getEmployee(id){
    $.ajax({
        url:"http://localhost:9090/sv/ems/getEmployee/"+id,
        method: "GET",
        dataType: "json",
        success: function (data){
            $('#id').val(data.id);
            $('#personMasterId').val(data.personMaster.id);
            $('#firstName').val(data.personMaster.firstName);
            $('#lastName').val(data.personMaster.lastName);
            $('#birthDate').val(data.personMaster.birthDate);
            $('#joiningDate').val(data.joiningDate);
            $('#qualification').val(data.qualificationMaster.id);
            $('#salary').val(data.salary);
            $('input[name="gender"][value="'+data.personMaster.gender+'"]').prop('checked',true);
            $('input[name="isFresherEmp"][value="'+data.isFresherEmployee+'"]').prop('checked',true);

            getAllEmps();
        },
        error: function ($xhr){
            alert($xhr.responseText);
        }
    })
}

function saveOrUpdateEmp(){
    if(validationCheck()) {
        const empMaster = {};
        empMaster.id=$('#id').val();
        empMaster.joiningDate=$('#joiningDate').val();
        empMaster.salary=$('#salary').val();
        empMaster.isFresherEmployee=$("input[name='isFresherEmp']:checked").val();

        const personMaster = {};
        personMaster.id=$('#personMasterId').val();
        personMaster.firstName=$('#firstName').val();
        personMaster.lastName=$('#lastName').val();
        personMaster.birthDate=$('#birthDate').val();
        personMaster.gender=$("input[name='gender']:checked").val();

        const qualificationMaster = {};
        qualificationMaster.id=$('#qualification').val();
        empMaster.personMaster=personMaster;
        empMaster.qualificationMaster=qualificationMaster;
        console.log(JSON.stringify(empMaster));
        let url = "";
        let method = "";
        if ($('#id').val() === '') {
            url = "http://localhost:9090/sv/ems/addEmployee";
            method = "POST";
        } else {
            url = "http://localhost:9090/sv/ems/updateEmployee/"+$('#id').val();
            method = "PUT";
        }

        $.ajax({
            url: url,
            method: method,
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(empMaster),
            success: function (data) {
                getAllEmps();
                getQualificationList();
                reset();
            },
            error: function ($xhr) {
                alert($xhr.responseText);
            }
        })
    }
}

function reset(){
    $('#id').val('');
    $('#personMasterId').val('');
    $('#firstName').val('');
    $('#lastName').val('');
    $('#birthDate').val('');
    $('#joiningDate').val('');
    $('#qualification').val('');
    $('#salary').val('');
    $('input[name="gender"][value="Male"]').prop('checked',true);
    $('input[name="isFresherEmp"][value="No"]').prop('checked',true);
}

function validationCheck(){
    if($('#firstName').val()===''||$('#lastName').val()===''||$('#birthDate').val()===''||$('#joiningDate').val()===''||
        $('#qualification').val()===''||$('#salary').val()===''){
        alert("All inputs is mandatory. Please fill all filed.");
        return false;
    }else {
        return checkAgeGap();
    }
}

function checkAgeGap(){
    const birthDate = $('#birthDate').val();
    const joiningDate = $('#joiningDate').val();
    if ((new Date(joiningDate).getTime() - new Date(birthDate).getTime()) / (1000 * 3600 * 24 * 30 * 12) < 18) {
        alert("Difference between Joining Date and Birth Date is minimum 18 years");
        return false;
    }else{
        return true;
    }
}

function formatDate (input) {
    var datePart = input.split("-");
    year = datePart[0],
    month = datePart[1],
    day = datePart[2];

    return day+'-'+month+'-'+year;
}