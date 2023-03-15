import React, { useState, useRef } from 'react';

import { StyleSheet, View, Button, TextInput } from 'react-native';
import { replaceSelected } from 'react-native-replace-selected';

export default function App() {
  const [text, setText] = useState('Example Text');
  const textInputRef = useRef<TextInput>(null);

  const replaceText = () => {
    if (!textInputRef.current) return;

    replaceSelected(textInputRef.current, '😀');
  };

  return (
    <View style={styles.container}>
      <TextInput ref={textInputRef} onChangeText={setText} value={text} />
      <Button title="Replace selected text with 😀" onPress={replaceText} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
