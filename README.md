# Calculus Project – Rozwiązywanie równań różniczkowych metodą MES (1D)

Projekt zrealizowany w ramach przedmiotu na AGH (katedra Informatyki / `agh.ics.oop`), implementujący **Metodę Elementów Skończonych (MES / FEM – Finite Element Method)** dla jednowymiarowego problemu brzegowego wraz z graficzną wizualizacją otrzymanych wyników.

---

## 📌 Opis zagadnienia

Program rozwiązuje jednowymiarowe równanie różniczkowe na przedziale $[0, 2]$ przy użyciu sformułowania wariacyjnego:
- **Dyskretyzacja:** podział odcinka $[0, 2]$ na $n$ elementów skończonych o równej długości $h = \frac{2}{n}$.
- **Funkcje bazowe:** liniowe funkcje kształtu (tzw. funkcje daszkowe) na każdym elemencie.
- **Całkowanie numeryczne:** dwupunktowa kwadratura Gaussa-Legendre'a do wyznaczania elementów macierzy sztywności $B$ oraz wektora obciążeń $L$.
- **Warunki brzegowe:**
  - Warunek Dirichleta w punkcie $x = 0$ ($u(0) = 1$).
  - Warunek brzegowy w punkcie $x = 2$ uwzględniony w sformułowaniu słabym.
- **Rozwiązywanie układu równań:** układ równań liniowych $B \cdot u = L$ jest rozwiązywany za pomocą zaimplementowanej metody eliminacji Gaussa z podstawieniem wstecznym.

---

## 🛠️ Technologie

- **Java** (JDK 21+)
- **JavaFX 21** (wizualizacja wykresu w FXML / `LineChart`)
- **Swing / AWT** (alternatywny moduł rysowania wykresu)
- **Gradle** (narzędzie do budowania i zarządzania zależnościami)

---

## 📁 Struktura projektu

```text
Calculus_project/
├── gradle/wrapper/             # Wrapper Gradle
├── src/
│   └── main/
│       ├── java/agh/ics/oop/
│       │   ├── Calculus.java         # Główny algorytm MES oraz eliminacja Gaussa
│       │   ├── MainApp.java          # Punkt wejścia aplikacji JavaFX
│       │   ├── PlotController.java   # Kontroler widoku JavaFX generujący wykres
│       │   ├── Main.java             # Punkt wejścia dla wersji Swing/AWT
│       │   ├── PlotFrame.java        # Okno Swing dla wykresu
│       │   └── PlotPanel.java        # Komponent rysujący wykres u(x) w Swing/AWT
│       └── resources/agh.ics.oop/
│           └── plot.fxml             # Definicja interfejsu użytkownika w JavaFX
├── build.gradle                # Konfiguracja projektu Gradle
├── settings.gradle             # Ustawienia projektu Gradle
├── .gitignore                  # Ignorowane pliki i katalogi
└── README.md                   # Dokumentacja projektu
```

---

## 🚀 Uruchomienie projektu

### Wymagania wstępne
- Zainstalowane środowisko **Java JDK 21** lub nowsze.

### Uruchomienie aplikacji JavaFX
Główną aplikacją z interfejsem graficznym JavaFX jest `MainApp`. Można ją uruchomić za pomocą Gradle:

**Linux / macOS:**
```bash
./gradlew run
```

**Windows (PowerShell / CMD):**
```powershell
.\gradlew.bat run
```

### Uruchomienie wersji Swing
Alternatywny punkt wejścia korzystający z biblioteki Swing (`agh.ics.oop.Main`) można uruchomić bezpośrednio ze środowiska IDE (np. IntelliJ IDEA) lub konfigurując odpowiedni `mainClass` w `build.gradle`.

### Budowanie projektu
Aby zbudować cały projekt i uruchomić testy:
```bash
./gradlew build
```
lub na Windowsie:
```powershell
.\gradlew.bat build
```
