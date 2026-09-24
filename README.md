# Bibliotekshanteraren

## Beskrivning
Konsolapp med meny som kan hantera böcker, medlemmar och utlåning av böcker till medlemmar.
Menu.java är ansvarig för kontakt med användaren, Library.java för logiken.
Appen består av 3 arrayer med fast storlek [10].
Böcker representeras av recorden Book,
medlemmar av klassen Member,
och varje utlåning av recorden Loan, som håller en bok och den medlem som lånat den.

## Varför Book är en record
En book kommer inte att ändras efter att den skapats,
titeln är densamma, författaren densamma och även id(ISBN).
Och när man jobbar med fasta värden så passar en oföränderlig(immutable) bra. 
Records ger även gratis tillgång till equals och toString.
Equals kom till användning för att leta upp lånet för en book i metoden(findBookInLoan),
toString kom till användning när jag skulle skriva ut böckerna.


## Designval
Member är en klass eftersom den har tillstånd som ändras under programmets gång,
t.ex. activeLoans. Det hade inte fungerat med en record, vars fält är oföränderliga.

Fälten är private för att skydda datan från oavsiktliga ändringar.
Bara klassen själv kan ändra sina fält, och andra klasser måste gå via metoder.
Om till exempel Menu kunde ändra i arrayen direkt skulle bookCount inte längre stämma med innehållet.

