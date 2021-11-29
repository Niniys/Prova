const mysql = require('mysql')
const con = mysql.createConnection({
    'user':'root',
    'database':'funcionarios',
    'host':'localhost'
})

module.exports = {
    con
}