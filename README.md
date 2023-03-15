# react-native-replace-selected

Library provides native method for replacing selected text in TextInput with a new text

## Installation

```sh
npm install -S react-native-replace-selected
```

```sh
yarn add react-native-replace-selected
```

## Usage

```typescript
import { replaceSelected } from 'react-native-replace-selected';

replaceSelected(textInputRef.current, "new text");
```

```typescript
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
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
