const express = require('express')
const router = express.Router()

const nome_controll = require('../controll/nome_controll.js')
router.get('/api/:id', nome_controll.get_id)
module.exports = router