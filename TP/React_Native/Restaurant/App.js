import { StyleSheet } from 'react-native'
import React from 'react'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import { NavigationContainer } from '@react-navigation/native'
import HomeScreen from "./component/HomePage"
import Recipes from './component/Recipes'

const Stack = createNativeStackNavigator()

export default function App() {
  return (
    <NavigationContainer>
            <Stack.Navigator initialRouteName="HomePage">
                <Stack.Screen name="All Categories" component={HomeScreen} /> 
                <Stack.Screen name="MealsOverview" component={Recipes} />
            </Stack.Navigator>
    </NavigationContainer>
  )
}

const styles = StyleSheet.create({})