import React from 'react';
import { View, Text, StyleSheet, FlatList } from 'react-native';

import { MEALS } from '../data/data';

export default function Recipes ({route}) {
    const categoryId = route.params.categoryId
    const displayedMeals = MEALS.filter(
      meal => meal.categoryIds.indexOf(categoryId) >= 0
    );
  
    return (
      <View style={styles.screen}>
        <FlatList
          data={displayedMeals}
          renderItem={({ item }) => <Text>{item.title}</Text>}
          keyExtractor={item => item.id}
        />
      </View>
    );
  };


const styles = StyleSheet.create({
  screen: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center'
  }
});

