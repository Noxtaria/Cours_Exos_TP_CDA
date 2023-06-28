import { Button, StyleSheet, Text, View } from 'react-native'
import React from 'react'

export default function PageA({navigation}) {
    const contacts = [
        {id: 1, firstName: 'John', lastName: 'Doe', phone: '0710456798'},
        {id: 2, firstName: 'Jane', lastName: 'Doe', phone: '0675643124'},
      ];
      return (
        <View style={styles.container}>
          {contacts.map(contact => (
            <View key={contact.id} style={styles.contact}>
              <Text style={styles.name}>
                {contact.firstName} {contact.lastName}
              </Text>
              <Button
                title="Go to Page C"
                onPress={() => navigation.navigate('PageC', {contact})}
              />
            </View>
          ))}
        </View>
      );
    }
    
    const styles = StyleSheet.create({
      container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
      },
      contact: {
        marginBottom: 20,
      },
      name: {
        fontSize: 18,
        fontWeight: 'bold',
        marginBottom: 5,
      },
    });