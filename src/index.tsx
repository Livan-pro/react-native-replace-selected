import {
  findNodeHandle,
  NativeModules,
  Platform,
  TextInput,
} from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-replace-selected' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const ReplaceSelected = NativeModules.ReplaceSelected
  ? NativeModules.ReplaceSelected
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function replaceSelected(input: TextInput, text: string): void {
  ReplaceSelected.replaceSelected(findNodeHandle(input), text);
}
