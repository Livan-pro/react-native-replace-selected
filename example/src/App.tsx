import React, { useState, useRef } from 'react';

import { StyleSheet, View, Button, TextInput } from 'react-native';
import { useReplaceSelected } from 'react-native-replace-selected';

export default function App() {
  const [text, setText] = useState('Example Text');
  const textInputRef = useRef<TextInput>(null);
  const replaceSelected = useReplaceSelected(textInputRef);

  const replaceText = () => replaceSelected('😀');

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
