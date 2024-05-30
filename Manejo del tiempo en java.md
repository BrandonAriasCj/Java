El manejo del tiempo en Java puede realizarse utilizando varias clases y bibliotecas proporcionadas por el lenguaje. Aquí te presento una visión general de las opciones más comunes para trabajar con fechas y horas en Java:

### 1. **Clases del Paquete `java.time` (Java 8 y posteriores)**

Desde Java 8, la biblioteca estándar de Java incluye el paquete `java.time`, que ofrece una forma moderna y robusta de manejar fechas y horas. Aquí te explico las clases más importantes:

#### **`LocalDate`**
Representa una fecha sin hora (como `2024-05-28`).

```java
import java.time.LocalDate;

public class EjemploLocalDate {
    public static void main(String[] args) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaEspecifica = LocalDate.of(2024, 5, 28);
        
        System.out.println("Fecha actual: " + fechaActual);
        System.out.println("Fecha específica: " + fechaEspecifica);
    }
}
```

#### **`LocalTime`**
Representa una hora sin fecha (como `10:15:30`).

```java
import java.time.LocalTime;

public class EjemploLocalTime {
    public static void main(String[] args) {
        LocalTime horaActual = LocalTime.now();
        LocalTime horaEspecifica = LocalTime.of(10, 15, 30);
        
        System.out.println("Hora actual: " + horaActual);
        System.out.println("Hora específica: " + horaEspecifica);
    }
}
```

#### **`LocalDateTime`**
Combina fecha y hora sin zona horaria (como `2024-05-28T10:15:30`).

```java
import java.time.LocalDateTime;

public class EjemploLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        LocalDateTime fechaHoraEspecifica = LocalDateTime.of(2024, 5, 28, 10, 15, 30);
        
        System.out.println("Fecha y hora actual: " + fechaHoraActual);
        System.out.println("Fecha y hora específica: " + fechaHoraEspecifica);
    }
}
```

#### **`ZonedDateTime`**
Representa una fecha y hora con una zona horaria (como `2024-05-28T10:15:30+01:00[Europe/Paris]`).

```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class EjemploZonedDateTime {
    public static void main(String[] args) {
        ZonedDateTime fechaHoraZonaActual = ZonedDateTime.now();
        ZonedDateTime fechaHoraZonaEspecifica = ZonedDateTime.of(2024, 5, 28, 10, 15, 30, 0, ZoneId.of("Europe/Paris"));
        
        System.out.println("Fecha y hora con zona actual: " + fechaHoraZonaActual);
        System.out.println("Fecha y hora con zona específica: " + fechaHoraZonaEspecifica);
    }
}
```

### 2. **Clases de la Biblioteca `java.util` (Antes de Java 8)**

Antes de Java 8, las clases principales para manejar fechas y horas eran `java.util.Date` y `java.util.Calendar`. Estas clases todavía están disponibles, pero se consideran obsoletas y menos recomendables en comparación con las nuevas clases en `java.time`.

#### **`java.util.Date`**
Representa una fecha y hora específica.

```java
import java.util.Date;

public class EjemploDate {
    public static void main(String[] args) {
        Date fechaActual = new Date();
        
        System.out.println("Fecha actual: " + fechaActual);
    }
}
```

#### **`java.util.Calendar`**
Ofrece más funcionalidades para manipular fechas y horas.

```java
import java.util.Calendar;

public class EjemploCalendar {
    public static void main(String[] args) {
        Calendar calendario = Calendar.getInstance();
        int año = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH) + 1; // Enero es 0
        int día = calendario.get(Calendar.DAY_OF_MONTH);
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto = calendario.get(Calendar.MINUTE);
        
        System.out.println("Fecha y hora actual: " + año + "-" + mes + "-" + día + " " + hora + ":" + minuto);
    }
}
```

### 3. **Parseo y Formateo de Fechas**

Para convertir entre cadenas de texto y objetos de fecha/hora, puedes usar `DateTimeFormatter` de `java.time`.

#### **Parseo**

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EjemploParseo {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse("28/05/2024", formatter);
        
        System.out.println("Fecha parseada: " + fecha);
    }
}
```

#### **Formateo**

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EjemploFormateo {
    public static void main(String[] args) {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fecha.format(formatter);
        
        System.out.println("Fecha formateada: " + fechaFormateada);
    }
}
```

### 4. **Medir Duraciones y Periodos**

Para medir duraciones entre fechas y horas, puedes usar `Duration` y `Period`.

#### **Duration**

```java
import java.time.Duration;
import java.time.LocalTime;

public class EjemploDuration {
    public static void main(String[] args) {
        LocalTime inicio = LocalTime.of(10, 0);
        LocalTime fin = LocalTime.of(12, 30);
        
        Duration duracion = Duration.between(inicio, fin);
        System.out.println("Duración: " + duracion.toHours() + " horas y " + duracion.toMinutesPart() + " minutos");
    }
}
```

#### **Period**

```java
import java.time.LocalDate;
import java.time.Period;

public class EjemploPeriod {
    public static void main(String[] args) {
        LocalDate inicio = LocalDate.of(2023, 1, 1);
        LocalDate fin = LocalDate.of(2024, 5, 28);
        
        Period periodo = Period.between(inicio, fin);
        System.out.println("Periodo: " + periodo.getYears() + " años, " + periodo.getMonths() + " meses, y " + periodo.getDays() + " días");
    }
}
```

Estas son algunas de las principales herramientas y técnicas para manejar el tiempo en Java. La API `java.time` introducida en Java 8 es particularmente poderosa y flexible, por lo que se recomienda utilizarla siempre que sea posible.