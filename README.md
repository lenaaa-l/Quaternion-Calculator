# Taschenrechner für Quaternionen 
Die Taschenrechner-App besteht aus drei Reitern, die in der Navigationsleiste aufgelistet sind: Elementary Arithmetic (Grundrechenarten), Features (Eigenschaften) und Rotation (Rotation). Bewusst wurde die App auf Englisch geschrieben, damit sie international genutzt werden kann. Das bedeutet auch, dass anstelle von Kommas bei Dezimalzahlen ein Punkt verwendet wird. Jeder Reiter deckt also unterschiedliche Themengebiete ab. Die einzelnen Inhalte werden im Folgenden genauer erläutert.
## Grundrechenoperationen (Elementary Arithmetic) 
Der Nutzer gibt zwei Quaternionen ein. Dabei sind die Koeffizienten double-Werte, das heißt Fließkommazahlen. 
Anschließend wählt der Nutzer eine Rechenoperation aus. Der Button zur ausgewählten Operation wird farblich hervorgehoben. Durch einen Klick auf den "="-Button kann sich der Nutzer das Ergebnis der entsprechenden Rechnung anzeigen lassen. 
Es gibt zusätzlich eine Besonderheit für die Division. Da die Multiplikation für Quaternionen nicht kommutativ ist, sind die Rechnungen q*p^{-1} und p^{-1}*q nicht äquivalent. Aus diesem Grund erscheinen bei der Auswahl der Rechenoperation Division zwei Buttons mit diesen beiden Optionen. Der Nutzer entscheidet sich für eine der beiden Optionen, die dann farblich markiert wird. 

Abgesichert vor Fehlern durch eine falsche/nicht ausreichende Nutzereingabe ist diese Seite folgendermaßen: 
- [x] Es wird auf leere Eingabefelder überprüft und diese mit "0.0" gefüllt
- [x] Wurde keine Rechenoperation ausgewählt, wird der Nutzer darauf hingewiesen, dass er zuerst eine Rechenoperation auswählen muss 
- [x] Wurde bei der Division keine Option ausgewählt, wird der Nutzer auch darauf hingewiesen
- [x] Die zwei verschiedenen Buttons für die Division sind nur sichtbar, wenn die Division als Rechenoperation ausgewählt wurde
- [x] Die Eingabefelder sind so eingestellt, dass man in sie lediglich Zahlen und höchstens einen Punkt eingeben kann

Hier einige Screenshots der Seite: 
...

# Calculator for quaternions
English version

