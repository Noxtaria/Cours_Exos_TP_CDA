import { Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'

export default function PageC({route}) {
    const { contact } = route.params;

    return (
    <View style={styles.container}>
    <Text style={styles.name}>
    {contact.firstName} {contact.lastName}
    </Text>
    <Text style={styles.phone}>{contact.phone}</Text>
    </View>
    );
    }
    
    const styles = StyleSheet.create({
    container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    },
    name: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 10,
    },
    phone: {
    fontSize: 18,
    },
    });