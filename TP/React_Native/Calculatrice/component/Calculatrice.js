import React, { useState } from 'react';
import { StyleSheet, Text, View, TouchableOpacity } from 'react-native';

export default function Calculatrice() {
    const [inputValue, setInputValue] = useState("");

    const pressedButton = (value) => {
            setInputValue(inputValue + value);
    }
    const delPressedButton = (value) => {
        if (value === "Del") {
            setInputValue(inputValue.slice(0, -1));
        }
    }
    const allDelPressedButton = (value) => {
        if (value === "AC") {
            setInputValue("");
        }
    }

    const calculate = () => {
        const result = eval(inputValue);
        setInputValue(result.toString());
      };
    

  return (
    <View style={styles.container}>
      <Text style={styles.result}>{inputValue}</Text>
      <View style={styles.buttonRow}>
        <TouchableOpacity onPress={() => allDelPressedButton("AC")} style={styles.buttonCommand}>
          <Text style={styles.buttonTextCommand}>AC</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("^")} style={styles.buttonCommand}>
          <Text style={styles.buttonTextCommand}>^</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("%")} style={styles.buttonCommand}>
          <Text style={styles.buttonTextCommand}>%</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("/")} style={styles.buttonOperator}>
          <Text style={styles.buttonTextOperator}>/</Text>
        </TouchableOpacity>
      </View>
      <View style={styles.buttonRow}>
        <TouchableOpacity onPress={() => pressedButton("7")} style={styles.button}>
          <Text style={styles.buttonText}>7</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("8")} style={styles.button}>
          <Text style={styles.buttonText}>8</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("9")} style={styles.button}>
          <Text style={styles.buttonText}>9</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("X")} style={styles.buttonOperator}>
          <Text style={styles.buttonTextOperator}>X</Text>
        </TouchableOpacity>
      </View>
      <View style={styles.buttonRow}>
        <TouchableOpacity onPress={() => pressedButton("4")} style={styles.button}>
          <Text style={styles.buttonText}>4</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("5")} style={styles.button}>
          <Text style={styles.buttonText}>5</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("6")} style={styles.button}>
          <Text style={styles.buttonText}>6</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("-")} style={styles.buttonOperator}>
          <Text style={styles.buttonTextOperator}>-</Text>
        </TouchableOpacity>
      </View>
      <View style={styles.buttonRow}>
        <TouchableOpacity onPress={() => pressedButton("1")} style={styles.button}>
          <Text style={styles.buttonText}>1</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("2")} style={styles.button}>
          <Text style={styles.buttonText}>2</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("3")} style={styles.button}>
          <Text style={styles.buttonText}>3</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("+")} style={styles.buttonOperator}>
          <Text style={styles.buttonTextOperator}>+</Text>
        </TouchableOpacity>
      </View>
      <View style={styles.buttonRow}>
        <TouchableOpacity onPress={() => pressedButton(".")} style={styles.button}>
          <Text style={styles.buttonText}>.</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => pressedButton("0")} style={styles.button}>
          <Text style={styles.buttonText}>0</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => delPressedButton("Del")} style={styles.button}>
          <Text style={styles.buttonText}>Del</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => calculate("=")} style={styles.buttonOperator}>
          <Text style={styles.buttonTextOperator}>=</Text>
        </TouchableOpacity>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: 'black',
        alignItems: 'center',
        justifyContent: 'center',
      },
      result: {
        fontSize: 36,
        marginBottom: 20,
        color: "white"
      },
      buttonRow: {
        flexDirection: 'row',
        marginBottom: 10,
      },
      button: {
        alignItems: 'center',
        justifyContent: 'center',
        width: 80,
        height: 80,
        backgroundColor: "white",
        borderRadius: 50,
        margin: 5,
      },
      buttonOperator: {
        alignItems: 'center',
        justifyContent: 'center',
        width: 80,
        height: 80,
        backgroundColor: "#A0A0A0",
        borderRadius: 10,
        margin: 5,
      },
      buttonCommand: {
        alignItems: 'center',
        justifyContent: 'center',
        width: 80,
        height: 80,
        backgroundColor: "#696969",
        borderRadius: 10,
        margin: 5,
      },
      buttonText: {
        fontSize: 24,
      },
      buttonTextOperator: {
        fontSize: 24,
        color: "white"
      },
      buttonTextCommand: {
        fontSize: 24,
        color: "white"
      },
})