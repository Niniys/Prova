import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';


import Home from './pages/home/index';
import Entregas from './pages/entregas/index.js';
import Detalhes from './pages/detalhes/index.js';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Entregador" component={home} />
        <Stack.Screen name="Entrega" component={entregas} />
        <Stack.Screen name="Pedido" component={detalhes} />
      </Stack.Navigator>
    </NavigationContainer>
   
  );
}