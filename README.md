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

## Installation
### Clone the Repository
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/Siddhesh2377/MaterialSplitButton-ReCreated.git
   ```

2. Copy the `splitBtn` library module into your Android Studio project.

### Include the Library in Your Project
1. In your `settings.gradle` file, include the `splitBtn` module:
   ```kotlin
   include(":splitBtn")
   project(":splitBtn").projectDir = file("path-to-splitBtn-module")
   ```

2. In your app module's `build.gradle` file, add the library as a dependency:
   ```kotlin
   dependencies {
       implementation project(":splitBtn")
   }
   ```

---

## Usage
### XML Example
Include the SplitButton in your layout XML:
```xml
<com.dark.splitbtn.SplitButton
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
</com.dark.splitbtn.SplitButton>
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
| Attribute               | Format    | Description                                   |
|-------------------------|-----------|-----------------------------------------------|
| `childBackgroundColor`  | `color`   | Background color of the child buttons.       |
| `childTextColor`        | `color`   | Text color of the child buttons.             |
| `edgeCorner`            | `dimension` | Corner radius for the first and last buttons. |
| `childCorner`           | `dimension` | Corner radius for the middle buttons.         |
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
