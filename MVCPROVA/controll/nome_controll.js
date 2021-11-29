const { con } = require("./mysql_controll.js")
const modelo = require('./model/nome_model.js')

const get_id = (req,res) => {
    let string = 'select * from nomes where id ='+ req.params.id
    con.query(string, (err, result)=>{
        res.json(result)
    })
}

module.exports = {
    get_id,
}