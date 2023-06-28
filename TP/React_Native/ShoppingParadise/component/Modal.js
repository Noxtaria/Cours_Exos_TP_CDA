import { StyleSheet, Text, View, Modal, Button, TextInput } from 'react-native';
import React from 'react';

export default function Modall(props) {

  return (
    <Modal visible={props.visible} animationType="slide">
        <View>
            <Text>Taper votre article</Text>
            <TextInput onChangeText={props.onChangeText} value={props.value}/>
            <Button title='ajouter' onPress={props.ajouter} />
            <Button title='cancel' onPress={props.cancel} />
        </View>
    </Modal>
  )
}

const styles = StyleSheet.create({});