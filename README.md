## SI-ECHO-2019-BACKEND
# Modul za generisanje i optimizaciju raspreda nastave

Za optimizaciju rasporeda korišten **genetički algoritam**. Prilikom kreiranja rasporeda nastave, potrebno je u obzir uzeti sljedeće ograničenja: broj profesora, željenih termina odvijanja nastave, broj studenata, predavanja, sale, kapacitete sale, opremljenosti i namjene sala.
Ova ograničenja se mogu podijeliti u nekoliko grupa prema njihovoj važnosti. 
  1. Jaka ograničenja - ako ograničenje nije zadovoljeno, raspored se neće moći kreirati,
      - Profesor mora imati minimalan broj unesenih željenih termina za održavanje nastave, 
      - Profesor i studentska grupa se ne mogu dodijeliti na dva ili više različitih predavanja istovremeno,
      - Mora postojati dovoljan broj sala,
      - Sala mora imati dovoljan kapacitet da bi primila sve studenta,
      - Sala mora imati odgovarajuću opremu za održavaje nastave

  2. Slaba ograničenja - ako ograničenje nije zadovoljeno, kreirat će se raspored koji nije optimalno rješenje.
      - Željeni termini nastavnog osoblja,
      - Ravnomjerna distribucija nastave tokom radne sedmice
     
Kao primjer izvršavanja algoritma kreira se raspored nastave za zimski/ljetni semestar treće godine Elektrotehničkog fakulteta, odsjek Računarstvo i informatika. 
