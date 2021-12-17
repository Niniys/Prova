import React, { useState, useEffect } from 'react'
import { View, Text, Image, TouchableOpacity } from 'react-native'
import style from './style.js'

export default function entregar({ navigation }) {

    const [entrega, setentrega] = useState([
        {
            "id_pedido": 0,
            "cliente": "Não foi possível carregar dados"
        }
    ])

    useEffect(()=>{
        fetch("http://10.87.202.131:3000/entregas/entregues", {
            "method": "GET",
            "headers": {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            return resp.json()
        }).then(data => {
            setentrega(data)
        }).catch(err => {
        })
    },[entrega])

    return (
        <View style={style.pag}>
            {entrega.map((item, index) => 
                <TouchableOpacity key={index} style={style.item} onPress={() => { navigation.navigate('Detalhes', item) }}>
                    <Text>{item.id}</Text>
                    <Text>{item.nome}</Text>
                    <Image style={style.icone} source={require('../../assets/favicon.png')} />
                </TouchableOpacity>
            )}
        </View>
    )
}