let usersTable = $('.table');

function Add() {
    let rawName = $('#inputName').val();
    let rawLastName = $('#inputLastName').val();
    let rawAge = $('#inputAge').val();
    let rawEmail = $('#inputEmail').val();
    let rawPhone = $('#inputPhone').val();

    let User = {
        name: rawName,
        lastName: rawLastName,
        age : rawAge,
        email: rawEmail,
        phone : rawPhone
    }

    $.ajax({
        type: 'POST',
        url: 'MainServlet',
        data: JSON.stringify(User),
        dataType: 'json',
        contentType: 'application/json',
        success: function(data) {},
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);
        }
    });

    $('#inputName').val('');
    $('#inputLastName').val('');
    $('#inputAge').val('');
    $('#inputEmail').val('');
    $('#inputPhone').val('');
}

function Update() {
    $.ajax({
        url: 'MainServlet',
        type: "GET",
        dataType: "json",
        success: function(data) {
            $.each(data, function(i, user) {
                let row = $("<tr>");

                let tdName = document.createElement("td");
                tdName.innerText = user.name;
                row.append(tdName);

                let tdlastName = document.createElement("td");
                tdlastName.innerText = user.lastName;
                row.append(tdlastName);

                let tdAge = document.createElement("td");
                tdAge.innerText = user.age;
                row.append(tdAge);

                let tdEmail = document.createElement("td");
                tdEmail.innerText = user.email;
                row.append(tdEmail);

                let tdPhone = document.createElement("td");
                tdPhone.innerText = user.phone;
                row.append(tdPhone);

                usersTable.find('tbody').append(row);
            });

        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);
        }
    });
}