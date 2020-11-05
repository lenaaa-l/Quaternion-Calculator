# Taschenrechner für Quaternionen 
Die Taschenrechner-App besteht aus drei Reitern, die in der Navigationsleiste aufgelistet sind: Elementary Arithmetic (Grundrechenarten), Features (Eigenschaften) und Rotation (Rotation). Jeder Reiter deckt also unterschiedliche Themengebiete ab. Die einzelnen Inhalte werden im Folgenden genauer erläutert. Bewusst wurde die App auf Englisch geschrieben, damit sie international genutzt werden kann. Das bedeutet auch, dass anstelle von Kommas bei Dezimalzahlen ein Punkt verwendet wird.
## Grundrechenoperationen (Elementary Arithmetic) 
Der Sourcecode für diesen Reiter findet sich [hier](https://github.com/lenaaa-l/Quaternion-Calculator/blob/master/app/src/main/java/com/example/quaternion_calculator/ui/elementary_arithmetic/ElementaryArithmeticFragment.java).

Der Nutzer gibt zwei Quaternionen ein. Dabei sind die Koeffizienten double Werte, das heißt Fließkommazahlen. 
Anschließend wählt der Nutzer eine Rechenoperation aus. Der Button zur ausgewählten Operation wird farblich hervorgehoben. 

Durch einen Klick auf den "="-Button kann sich der Nutzer das Ergebnis der entsprechenden Rechnung anzeigen lassen. Die Koeffizienten des Erebnisses werden zusätzlich auf zwei Dezimalstellen angegeben, um eine übersichtliche Ausgabe zu ermöglichen. 

Es gibt zusätzlich eine Besonderheit für die Division. Da die Multiplikation für Quaternionen nicht kommutativ ist, sind die Rechnungen q*p^{-1} und p^{-1}*q nicht äquivalent. Aus diesem Grund erscheinen bei der Auswahl der Rechenoperation Division zwei Buttons mit diesen beiden Optionen. Der Nutzer entscheidet sich für eine der beiden Optionen, die dann farblich markiert wird. 

Abgesichert vor Fehlern durch eine falsche/nicht ausreichende Nutzereingabe ist diese Seite folgendermaßen: 
- [x] Es wird auf leere Eingabefelder geprüft und diese mit "0.0" gefüllt
- [x] Wurde keine Rechenoperation ausgewählt, wird der Nutzer darauf hingewiesen, dass er zuerst eine Rechenoperation auswählen muss 
- [x] Wurde bei der Division keine Option ausgewählt, wird der Nutzer auch darauf hingewiesen
- [x] Die zwei verschiedenen Buttons für die Division sind nur sichtbar, wenn die Division als Rechenoperation ausgewählt wurde
- [x] Die Eingabefelder sind so eingestellt, dass man in sie lediglich Zahlen und höchstens einen Punkt eingeben kann

Hier einige Screenshots der Seite: 

<img src="https://user-images.githubusercontent.com/56199607/92325235-3de63f80-f049-11ea-80d0-57c23dc64987.png" width="200"> .
<img src="https://user-images.githubusercontent.com/56199607/92325372-4b4ff980-f04a-11ea-94d2-30078ac8d7d3.png" width="200">

## Eigenschaften (Features)
Der Sourcecode für diesen Reiter findet sich [hier](https://github.com/lenaaa-l/Quaternion-Calculator/blob/master/app/src/main/java/com/example/quaternion_calculator/ui/features/FeaturesFragment.java).

Der Nutzer gibt eine Quaternion ein. Dabei sind die Koeffizienten erneut double Werte. Anschließend bestätigt der Nutzer seine Auswahl durch einen Klick auf den Button mit den Häckchen. 
Es werden folgende Eigenschaften ausgegeben 
- Realteil 
- Imaginärteil 
- Konjugiertes 
- Betrag/Länge
- Inverses 
- Normierte Quaternion

Die Koeffizienten des Konjugierten, des Inversen und der normierten Quaternion werden auf zwei Dezimalstellen angegeben, der Betrag (zur Erhöhung der Genauigkeit) auf 5. 

Abgesichert vor Fehlern durch eine falsche/nicht ausreichende Nutzereingabe ist diese Seite folgendermaßen:
- [x] Es wird auf leere Eingabefelder geprüft und diese mit "0.0" gefüllt
- [x] Die Eingabefelder sind so eingestellt, dass man in sie lediglich Zahlen und höchstens einen Punkt eingeben kann

Hier ein Screenshot der Seite:

<img src="https://user-images.githubusercontent.com/56199607/92325919-7e948780-f04e-11ea-9062-182f6ba7e9b1.png" width="200">

## Rotation (Rotation) 
Der Sourcecode für diesen Reiter befindet sich [hier](https://github.com/lenaaa-l/Quaternion-Calculator/blob/master/app/src/main/java/com/example/quaternion_calculator/ui/rotation/RotationFragment.java).

Der Nutzer gibt einen Punkt im dreidimensionalen Koordinatensystem, eine Rotationsachse, um die der Punkt gedreht werden soll (als dreidimensionaler Vektor) und den Winkel in Grad, um den der Punkt gegen den Uhrzeigersinn gedreht werden soll an. Durch einen Klick auf den Häckchen-Button bekommt der Nutzer die Koordinaten des neuen Punkts P' ausgegeben. 

Für die Rechnung wird als Rotationsachse ein normierter Vektor benötigt. Aus diesem Grund wird als erster Schritt der eingegebene Vektor normiert. Anschließend wird der passende Rotationsoperator r ausgerechnet und der eingegebene Punkt P(x; y; z) als Quaternion q = xi + yj + zk dargestellt. Die Multiplikation r*q*r^{-1} liefert dann die Quaternion p' = x'i + y'j + z'k. Dies entspricht dem Ergebnispunkt P'(x'; y'; z'). Die Koordinaten x', y' und z' werden aus Gründen der Übersichtlichkeit auf zwei Dezimalstellen genau angegeben. 

Abgesichert vor Fehlern durch eine falsche/nicht ausreichende Nutzereingabe ist diese Seite folgendermaßen:
- [x] Es wird auf leere Eingabefelder geprüft und diese mit "0.0" gefüllt (alle Eingabefelder)
- [x] Es wird geprüft, ob die Rotationsachse der Nullvektor ist. Ist dies der Fall, bekommt der Nutzer eine Meldung mit der Nachricht, eine andere Rotationsachse einzugeben
- [x] Die Eingabefelder sind so eingestellt, dass man in sie lediglich Zahlen und höchstens einen Punkt eingeben kann

Hier ein Screenshot der Seite:

<img src="https://user-images.githubusercontent.com/56199607/92326978-7fc9b280-f056-11ea-8e56-714bb1e02133.png" width="200">

