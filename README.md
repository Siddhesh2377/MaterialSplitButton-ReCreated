# SplitButton Library

SplitButton is a re-creation of the Material3 Split Button, inspired by the [Material Components Android Button documentation](https://github.com/material-components/material-components-android/blob/master/docs/components/Button.md#split-button). This library provides a highly customizable implementation of the Material3 Split Button, which is currently not included in the stable Material library.
![split_button](https://github.com/user-attachments/assets/69734216-133f-4e46-a6d0-373f41e244fa)

## Features
- Fully customizable split button.
- Supports dynamic addition and removal of buttons.
- Implements Material Design principles.
- Easy to integrate into any Android project.
- Built-in fade-in and fade-out animations for adding and removing buttons dynamically.

---

## Add to project

[![JitPack Release](https://jitpack.io/v/Siddhesh2377/SplitButton.svg)](https://jitpack.io/#Siddhesh2377/SplitButton)

```kotlin
allprojects {
    repositories {
        maven("https://jitpack.io")
    }
}

implementation("com.github.Siddhesh2377:SplitButton:<version>")
```

---

## Usage
### XML Example
Include the SplitButton in your layout XML:
```xml
<com.dark.splitbutton.SplitButton
    android:id="@+id/splitButton"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:childBackgroundColor="@color/primary"
    app:childTextColor="@color/onPrimary"
    app:edgeCorner="16dp"
    app:childCorner="8dp"
    app:childSpacing="8dp">

    <com.google.android.material.button.MaterialButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="First" />

    <com.google.android.material.button.MaterialButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Middle" />

    <com.google.android.material.button.MaterialButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Last" />
</com.dark.splitbutton.SplitButton>
```

### Dynamic Button Management
You can add or remove buttons dynamically:

#### Add a Button
```kotlin
val splitButton = findViewById<SplitButton>(R.id.splitButton)
splitButton.addNewButton("New Button")
```

#### Remove a Button
```kotlin
splitButton.removeViewAt(1) // Removes the button at index 1
```

---

## Customization
### Available Attributes
| Attribute               | Format      | Description                                   |
|-------------------------|-------------|-----------------------------------------------|
| `childBackgroundColor`  | `color`     | Background color of the child buttons.       |
| `childTextColor`        | `color`     | Text color of the child buttons.             |
| `edgeCorner`            | `float`     | Corner radius for the first and last buttons. |
| `childCorner`           | `float `    | Corner radius for the middle buttons.         |
| `childSpacing`          | `dimension` | Spacing between the child buttons.           |

---

## Contributing
Contributions are welcome! If you find any issues or want to improve this library, feel free to open a pull request or issue on GitHub.

---

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
---

## Acknowledgements
This library is inspired by the [Material Components Android Split Button](https://github.com/material-components/material-components-android/blob/master/docs/components/Button.md#split-button) and aims to bring a similar experience to stable Material3 implementations.
