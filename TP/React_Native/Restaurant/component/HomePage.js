import React from 'react';
import {
  View,
  Text,
  StyleSheet,
  TouchableOpacity,
  ScrollView,
} from 'react-native';

import {CATEGORIES} from '../data/data';

const HomeScreen = ({navigation}) => {
  return (
    <ScrollView contentContainerStyle={styles.scrollViewContent}>
      <View style={styles.screen}>
        <View style={styles.column}>
          {CATEGORIES.slice(0, Math.ceil(CATEGORIES.length / 2)).map(category =>
            renderCategoryItem(navigation, category),
          )}
        </View>
        <View style={styles.column}>
          {CATEGORIES.slice(Math.ceil(CATEGORIES.length / 2)).map(category =>
            renderCategoryItem(navigation, category),
          )}
        </View>
      </View>
    </ScrollView>
  );
};

const renderCategoryItem = (navigation, category) => {
  const {id, title, color} = category;
  return (
    <TouchableOpacity
      key={id}
      style={[styles.categoryItem, {backgroundColor: color}]}
      onPress={() => navigation.navigate('MealsOverview', {categoryId: id})}>
      <View style={styles.categoryItemContainer}>
        <Text style={styles.categoryItemTitle}>{title}</Text>
      </View>
    </TouchableOpacity>
  );
};


const styles = StyleSheet.create({
  screen: {
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginHorizontal: 10,
    marginVertical: 20,
  },
  column: {
    width: '48%',
    flexDirection: 'column',
    justifyContent: 'space-between',
  },
  categoryItem: {
    height: 140,
    borderRadius: 10,
  },
  categoryItemContainer: {
    flex: 1,
    borderRadius: 10,
    shadowColor: 'black',
    shadowOpacity: 0.26,
    shadowRadius: 10,
    padding: 15,
    alignItems: 'center',
    justifyContent: 'center',
  },
  categoryItemTitle: {
    fontFamily: 'open-sans-bold',
    fontSize: 22,
    color: 'black',
    textAlign: 'center',
  },
  scrollViewContent: {
    flexGrow: 1,
  },
});

export default HomeScreen;