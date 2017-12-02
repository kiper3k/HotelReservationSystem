# Hotel Reservation System

### Budowanie projektu

#### Windows:

```bash
gradlew build
```

#### Linux/Unix
```bash
./gradlew build
```

### Uruchomienie aplikacji

#### Windows:

```bash
gradlew run
```

#### Linux/Unix
```bash
./gradlew run
```

### Pozostałe informacje
##### Wyorzystane wzorce
* Builder (Budowniczy) dla klasy `Client`  
Testy w klasie: `ClientBuilderTest`  
Fragment kodu budowniczego:
```java
public static class Builder {
        private String firstName;

        private String lastName;

        private String email;

        private String address;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Client build() {
            return new Client(firstName, lastName, email, address);
        }
    }
```

##### NetBeans IDE
Zalecana jest wtyczka [Gradle Support](http://plugins.netbeans.org/plugin/44510/gradle-support).
Wtyczka ta pozwala otworzyć folder zawierający plik `build.gradle` jako projekt.

### Autorzy:
* 
* 
