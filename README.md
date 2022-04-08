Opis

W pewnych miastach działa firma zajmująca się wypożyczaniem na godziny różnych urządzeń elektronicznych. Firma ta potrzebuje programu, do którego mogłaby wprowadzić dane o wypożyczeniach oraz cenniki wypożyczeń różnych przedmiotów, aby na koniec miesiąca przedstawić klientom zestawienie - ile powinni zapłacić.



Wymagania techniczne

Oczekiwalibyśmy programu stworzonego przy użyciu technologii Spring i potrafiącego konsumować REST API.

Pierwszy endpoint ma umożliwiać wprowadzenie wyceny produktów (cennik) – ile kosztuje minuta używania produktu XYZ (np.: PRALKA, ODKURZACZ, MYJKA, …)

Drugi z endpointów będzie służył do ładowania czasu użycia danego produktu przez klienta - w formacie JSON powinniśmy móc wyrazić identyfikator klienta, nazwę produktu np. PRALKA oraz dwie daty mówiące o dacie wypożyczenia i dacie oddania przedmiotu.

Po załadowaniu zużycia, powinno być ono natychmiast wycenione, a wycena i rekord zużycia powinny być zapisane w bazie danych (technologia dowolna).

Cennik może być zmieniany, a zmiany będą wpływać na przyszłe wyceny. Chcielibyśmy zatem, aby cenniki też były zapisywane w jakiejś bazie danych.

Ostatnim krokiem jest endpoint służący do raportowania/rozliczania - użytkownik systemu podając miesiąc oraz identyfikator klienta otrzyma w odpowiedzi zestawienie na temat tego, ile i za co dany klient powinien zapłacić.

Kwestie interfejsu graficznego, uwierzytelniania i autoryzacji należy pominąć.
