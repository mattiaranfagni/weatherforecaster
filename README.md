# WeatherForecaster

Applicazione Spring Boot che raccoglie periodicamente i dati meteo di alcune città da
[Open-Meteo](https://open-meteo.com/) (API gratuita, senza chiave), li salva in un database e
espone delle API REST per consultare le **medie** delle misurazioni di ogni città.

## Tecnologie

- Java 21
- Spring Boot 4.1.2 (Web, Data JPA, Scheduling)
- Maven
- H2 (database su file)
- Lombok e MapStruct
- Docker / Docker Compose

## Come funziona

1. Uno scheduler interroga Open-Meteo ogni 15 minuti per ogni città presente nel database.
2. Ogni rilevazione (temperatura, vento, direzione del vento, codice meteo, unità di misura) viene salvata su H2.
3. Le API REST leggono le rilevazioni salvate e calcolano le medie per città.

Le città monitorate sono: Pistoia, Firenze, Roma, Milano, Napoli (inserite all'avvio se non esistono).

## Avvio

### Con Maven

```bash
mvn spring-boot:run
```

### Con Docker

```bash
docker compose up --build
```

L'applicazione risponde su `http://localhost:8080`.
I dati vengono salvati nella cartella `./data` e restano anche dopo il riavvio.

## API

| Metodo | Endpoint | Descrizione |
|--------|----------|-------------|
| GET | `/api/v1/weather/averages` | Medie di tutte le città |
| GET | `/api/v1/weather/averages/{city}` | Medie di una città (il nome non distingue maiuscole/minuscole) |

Se la città non esiste viene restituito `404`. Se per una città non ci sono ancora rilevazioni,
la risposta contiene `samples: 0` e nessuna media.

### Esempio

`GET /api/v1/weather/averages/pistoia`

```json
{
  "city": "Pistoia",
  "samples": 3,
  "from": "2026-11-22T09:45:00",
  "to": "2026-11-22T10:15:00",
  "temperature": {
    "value": 12.5,
    "unit": "°C"
  },
  "windSpeed": {
    "value": 0.8,
    "unit": "km/h"
  },
  "windDirection": {
    "value": 179.6,
    "unit": "°"
  },
  "mostFrequentWeatherCode": "61"
}
```

### Come sono calcolate le medie

- **Temperatura e velocità del vento**: media aritmetica delle rilevazioni salvate.
- **Direzione del vento**: media circolare. La media normale sarebbe sbagliata con gli angoli
  (la media di 350° e 10° deve essere 0°, non 180°).
- **Codice meteo (WMO)**: è una categoria e non un numero, quindi non si calcola la media ma si
  restituisce il valore più frequente.
- **Unità di misura**: sono quelle restituite da Open-Meteo e salvate insieme ai dati.

## Configurazione

In `application.properties`:

| Property | Default | Descrizione |
|----------|---------|-------------|
| `weatherforecaster.provider` | `openmeteo` | Provider meteo usato dallo scheduler |
| `openmeteo.api.url` | `https://api.open-meteo.com/v1/forecast` | URL dell'API |
| `openmeteo.api.polling.interval` | `900000` | Pausa tra una raccolta e la successiva (ms) |
| `openmeteo.api.polling.initial-delay` | `5000` | Attesa prima della prima raccolta (ms) |

Variabili d'ambiente per il database: `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`.
Per la console H2 impostare `H2_CONSOLE=true` e aprire `http://localhost:8080/h2-console`.
