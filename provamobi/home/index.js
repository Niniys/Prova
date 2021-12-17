import React from 'react'
import { View, Text, TouchableOpacity } from 'react-native'
import style from './style.js'
import { StatusBar } from 'expo-status-bar';
export default function Home({ navigation }) {
    return(
        <View style={style.pag}>

        <Text  style={style.menu}>Who Are You Deliverier</Text>
        <StatusBar style="menu" />

            <TouchableOpacity style={style.menu} onPress={() => { navigation.navigate('Entregador') }}>
                <Text style={{margin:12,fontSize:16,fontWeight:'bold'}}>Roberval</Text>
            </TouchableOpacity>

            <TouchableOpacity style={style.menu} onPress={() => { navigation.navigate('Entregador') }}>
                <Text style={{margin:12,fontSize:16,fontWeight:'bold'}}>Ricardo</Text>
            </TouchableOpacity>

            <TouchableOpacity style={style.menu} onPress={() => { navigation.navigate('Entregador') }}>
                <Text style={{margin:12,fontSize:16,fontWeight:'bold'}}>Manuel</Text>
            </TouchableOpacity>

            <TouchableOpacity style={style.menu} onPress={() => { navigation.navigate('Entregador') }}>
                <Text style={{margin:12,fontSize:16,fontWeight:'bold'}}>José</Text>
            </TouchableOpacity>

            <TouchableOpacity style={style.menu} onPress={() => { navigation.navigate('Entregador') }}>
                <Text style={{margin:12,fontSize:16,fontWeight:'bold'}}>Rosângela</Text>
            </TouchableOpacity>

        </View>
    )
}
/*
import React from 'react'
import { View, Text, Image, TouchableOpacity } from 'react-native'
import style from './style.js'
import { StatusBar } from 'expo-status-bar'
export default function Home({ navigation }) {
    return(
        <View style={style.pag}>

        <Text  style={style.menu}>Who Are You Deliverier</Text>
        <StatusBar style="menu" />

            <TouchableOpacity style={style.menu} onPress={() => { navigation.navigate('Entregador') }}>
            <Image style={style.icone} source={require('../../assets/favicon.png')}/>
                <Text style={{margin:12,fontSize:16,fontWeight:'bold'}}>Roberval</Text>
            </TouchableOpacity>

            <TouchableOpacity style={style.menu} onPress={() => { navigation.navigate('Entregador') }}>
            <Image style={style.icone} source={require('../../assets/favicon.png')}/>
                <Text style={{margin:12,fontSize:16,fontWeight:'bold'}}>Ricardo</Text>
            </TouchableOpacity>

            <TouchableOpacity style={style.menu} onPress={() => { navigation.navigate('Entregador') }}>
            <Image style={style.icone} source={require('../../assets/favicon.png')}/>
                <Text style={{margin:12,fontSize:16,fontWeight:'bold'}}>Manuel</Text>
            </TouchableOpacity>

            <TouchableOpacity style={style.menu} onPress={() => { navigation.navigate('Entregador') }}>
            <Image style={style.icone} source={require('../../assets/favicon.png')}/>
                <Text style={{margin:12,fontSize:16,fontWeight:'bold'}}>José</Text>
            </TouchableOpacity>

            <TouchableOpacity style={style.menu} onPress={() => { navigation.navigate('Entregador') }}>
            <Image style={style.icone} source={require('../../assets/favicon.png')}/>
                <Text style={{margin:12,fontSize:16,fontWeight:'bold'}}>Rosângela</Text>
            </TouchableOpacity>

        </View>
    )
}
*/