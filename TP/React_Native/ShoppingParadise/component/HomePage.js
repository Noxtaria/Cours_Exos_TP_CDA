import {
  Button,
  FlatList,
  StyleSheet,
  Text,
  View,
  TextInput,
  Pressable,
} from 'react-native';
import React, {useState} from 'react';
import Modall from './Modal';

export default function HomePage() {
  const [articles, setArticles] = useState([
    {text: 'Pomme', id: 1},
    {text: 'Poire', id: 2},
    {text: 'Banane', id: 3},
  ]);

  const [modalVisible, setModalVisible] = useState(false);
  const [textInput, setTextInput] = useState('');

  const ajouter = () => {
    const nouvelArticle = {text: textInput, id: articles.length + 1};
    const nouveauxArticles = [...articles, nouvelArticle];
    setArticles(nouveauxArticles);
    cancel();
  };

  const cancel = () => {
    setModalVisible(false);
  };

  const ajouterCourse = () => {
    setModalVisible(true);
  };

  const supprArticle = (id) => {
    const nouveauxArticles = articles.filter(article => article.id !== id);
    setArticles(nouveauxArticles);
  };

  return (
    <View>
      <Button title="ajouter article" onPress={ajouterCourse} />

      <FlatList
        data={articles}
        renderItem={itemData => {
          return (
            <View>
              <Pressable onPress={() => supprArticle(itemData.item.id)}>
                <Text style={styles.mesArticles}>
                  {itemData.item.text} {itemData.item.id}
                </Text>
              </Pressable>
            </View>
          );
        }}
        keyExtractor={item => {
          return item.id;
        }}
      />

      <Modall
        visible={modalVisible}
        cancel={cancel}
        ajouter={ajouter}
        onChangeText={setTextInput}
        value={textInput}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  mesArticles: {
    margin: 5,
    textAlign: 'center',
    borderWidth: 1,
    borderRadius: 12,
  },
});
