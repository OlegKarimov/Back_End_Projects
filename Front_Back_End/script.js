const SERVER_URL = "http://localhost:8080"

async function addUser(email, password) {
    let newUser = {
        email : email,
        password : password
    }

    let response = (await fetch(SERVER_URL + "/api/users", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newUser)
    }));

    let createdUser = await response.json();

    addUserToTable(document.getElementById('users-table'), createdUser);
}

function addUserToTable(table, user) {

    let row = table.insertRow(-1)
    let cellId = row.insertCell(0)
    let cellEmail = row.insertCell(1)
    let cellRole = row.insertCell(2)
    let cellState = row.insertCell(3)

    cellId.innerHTML = user.id;
    cellEmail.innerHTML = user.email;
    cellRole.innerHTML = user.role;
    cellState.innerHTML = user.state;
}