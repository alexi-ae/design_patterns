# Patrón Abstract Factory - Servicios Bancarios

Este proyecto demuestra el uso del patrón **Abstract Factory** para gestionar la creación de servicios financieros (cuentas, tarjetas y préstamos) en un contexto bancario. Este enfoque permite manejar diferentes tipos de clientes (**personal** y **empresarial**) de manera flexible y extensible.

---

## Tabla de Contenidos

1. [Descripción General](#descripción-general)
2. [Estructura del Código](#estructura-del-código)
3. [Flujo de Implementación](#flujo-de-implementación)
4. [Ejemplo de Uso](#ejemplo-de-uso)
5. [Ventajas](#ventajas)

---

## Descripción General

El **Patrón Abstract Factory** es utilizado para crear familias de objetos relacionados sin especificar sus clases concretas. En este proyecto, el patrón facilita la creación de servicios financieros diferenciados para clientes personales y empresariales, manteniendo un bajo acoplamiento y garantizando consistencia en los productos.

---

## Estructura del Código

### 1. **Interfaces**

- `AccountService`: Define operaciones comunes para las cuentas bancarias.
- `CardService`: Define operaciones comunes para las tarjetas bancarias.
- `LoanService`: Define operaciones relacionadas con los préstamos.
- `FinancialProductAbstractFactory`: Proporciona métodos para crear productos financieros específicos.

### 2. **Implementaciones**

#### Personal
- `PersonalAccountServiceImpl`
- `PersonalCardServiceImpl`
- `PersonalLoanServiceImpl`

#### Empresarial
- `CompanyAccountServiceImpl`
- `CompanyCardServiceImpl`
- `CompanyLoanServiceImpl`

### 3. **Clase Fábrica**

- `PersonalProductFactory`: Genera productos para clientes personales.
- `CompanyProductFactory`: Genera productos para clientes empresariales.

### 4. **Clase Productor de Fábricas**

- `FactoryProducer`: Devuelve una fábrica concreta basada en el tipo de cliente.

---

## Flujo de Implementación

1. **Obtener la fábrica adecuada**:  
   Utilizar `FactoryProducer` para seleccionar la fábrica según el tipo de cliente (`PERSONAL` o `COMPANY`).

2. **Crear productos financieros**:  
   Usar métodos de la fábrica (`accountInstance`, `cardInstance`, `loadInstance`) para obtener las instancias de los productos deseados.

3. **Interactuar con los productos**:  
   Utilizar los métodos definidos en las interfaces para operar con los productos financieros.

---

## Ejemplo de Uso

``` java
public static void main(String[] args) {
    // Fábrica para clientes personales
    FinancialProductAbstractFactory personalFactory = FactoryProducer.getFactory("PERSONAL");
    AccountService personalAccountService = personalFactory.accountInstance();
    CardService personalCardService = personalFactory.cardInstance();
    LoanService personalLoanService = personalFactory.loadInstance(1000.00);

    // Operaciones con productos personales
    personalAccountService.deposit(800.00);
    personalAccountService.withdraw(200);
    System.out.println("Saldo personal: " + personalAccountService.getBalance());
    personalCardService.create();
    personalLoanService.process();

    System.out.println("****************************************");

    // Fábrica para clientes empresariales
    FinancialProductAbstractFactory companyFactory = FactoryProducer.getFactory("COMPANY");
    AccountService companyAccountService = companyFactory.accountInstance();
    CardService companyCardService = companyFactory.cardInstance();
    LoanService companyLoanService = companyFactory.loadInstance(500000.00);

    // Operaciones con productos empresariales
    companyAccountService.deposit(45000.00);
    companyAccountService.withdraw(30000.00);
    System.out.println("Saldo empresarial: " + companyAccountService.getBalance());
    companyCardService.create();
    companyLoanService.process();
}
```