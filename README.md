# Patrones de Diseño de software

Los patrones de diseño son soluciones comunes y reutilizables a problemas recurrentes que surgen en el desarrollo de software. Se pueden considerar como plantillas que ayudan a abordar problemas específicos de diseño de manera efectiva y eficiente. Cada patrón actúa como un plano que se puede personalizar para resolver un problema particular en el código.


## Tabla de Contenidos

1. [Creaciona](#Creacional)
2. [Estructural](#Estructural)
3. [Comportamiento](#Comportamiento)
4. [Ejemplo de Uso](#ejemplo-de-uso)
5. [Ventajas](#ventajas)

---



# Creacional

## Patrón Abstract Factory

El **Patrón Abstract Factory** es utilizado para crear familias de objetos relacionados sin especificar sus clases concretas. En este proyecto, el patrón facilita la creación de servicios financieros diferenciados para clientes personales y empresariales, manteniendo un bajo acoplamiento y garantizando consistencia en los productos.

---
Estructura del Código

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

### Flujo de Implementación

1. **Obtener la fábrica adecuada**:  
   Utilizar `FactoryProducer` para seleccionar la fábrica según el tipo de cliente (`PERSONAL` o `COMPANY`).

2. **Crear productos financieros**:  
   Usar métodos de la fábrica (`accountInstance`, `cardInstance`, `loadInstance`) para obtener las instancias de los productos deseados.

3. **Interactuar con los productos**:  
   Utilizar los métodos definidos en las interfaces para operar con los productos financieros.

---

### Ejemplo de Uso

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
---

## Patrón Builder

El **Patrón Builder** separa la construcción de un objeto complejo de su representación final. Permite crear diferentes tipos y representaciones del objeto utilizando el mismo código de construcción. En este caso, facilita la creación de una **cuenta bancaria** con diversas configuraciones (titular, tipo de cuenta, saldo, tasa de interés, etc.) sin necesidad de múltiples constructores.

---

### Estructura del Código

#### 1. **Clase Principal**

- `BankAccount`: Representa la cuenta bancaria. Contiene las propiedades como titular, tipo de cuenta, saldo y tasa de interés, y está diseñada para ser inmutable.

#### 2. **Clase Interna Builder**

- `BankAccountBuilder`: Clase interna estática que sigue el enfoque de **métodos encadenados** para configurar las propiedades de la cuenta. Finaliza con el método `build()`, que crea una instancia de `BankAccount`.

---

### Flujo de Implementación

1. **Inicializar el Builder**:  
   Crear una instancia de `BankAccountBuilder`.

2. **Configurar las Propiedades**:  
   Utilizar los métodos del builder (`setHolder`, `setAccountType`, etc.) para establecer las propiedades de la cuenta.

3. **Construir la Cuenta**:  
   Llamar al método `build()` para obtener la instancia inmutable de `BankAccount`.

---

### Ejemplo de Uso

``` java
public static void main(String[] args) {
    // Crear una cuenta bancaria con el Builder
    BankAccount personalAccount = new BankAccount.BankAccountBuilder()
        .setHolder("John Doe")
        .setAccountType("Savings")
        .setBalance(1000.00)
        .setInterestRate(1.5)
        .build();

    // Mostrar la información de la cuenta
    System.out.println("Titular: " + personalAccount.getHolder());
    System.out.println("Tipo de cuenta: " + personalAccount.getAccountType());
    System.out.println("Saldo: " + personalAccount.getBalance());
    System.out.println("Tasa de interés: " + personalAccount.getInterestRate());
}
```
---

## Patrón Factory

El **Patrón Factory** proporciona una interfaz para crear objetos en una superclase, pero permite que las subclases alteren el tipo de objetos que se crean. En este caso, la implementación se centra en la creación de servicios para diferentes tipos de cuentas bancarias, como:
- **Cuenta Corriente** (`CurrentAccount`)
- **Cuenta de Nómina** (`PayRollAccount`)
- **Cuenta de Ahorros** (`SavingAccount`)
- **Cuenta a Plazo Fijo** (`TimeDepositAccount`)

---

### Estructura del Código

### 1. **Interfaces**

- `BankAccountService`: Define operaciones comunes para las cuentas bancarias.

### 2. **Implementaciones**
- `CurrentAccountServiceImpl`: Implementación de cuenta corriente.
- `PayRollAccountServiceImpl`: Implementación de cuenta sueldo.
- `SavingAccountServiceImpl`: Implementación de cuenta de ahorros.
- `TimeDepositAccountServiceImpl`: Implementación de cuenta de ahorros.

### 3. **Clase Fábrica**
- `BankAccountFactory`: Genera las cuentas para los clientes.

### Flujo de Implementación

- El cliente usa la fábrica (`BankAccountFactory`) para obtener una instancia de la cuenta bancaria. El tipo de cuenta se pasa como parámetro a la fábrica, y esta se encarga de devolver la implementación correcta de `BankAccountService`. El cliente solo interactúa con la interfaz `BankAccountService`, sin preocuparse de las clases concretas.

``` java
        // 1. Instanciar el factory
        BankAccountFactory accountFactory = new BankAccountFactory();
        // 2. Obtener el factory segun el tipo de cuenta
        BankAccountService accountService1 = accountFactory.getBankAccount("SAVING");
        // 3. Ejecutar los metodos relacionados
        accountService1.create(1);
        accountService1.deposit();

        BankAccountService accountService2 = accountFactory.getBankAccount("CURRENT");
        accountService2.create(1);

        BankAccountService accountService3 = accountFactory.getBankAccount("PAYROLL");
        accountService3.create(2);
        accountService3.deposit();

        BankAccountService accountService4 = accountFactory.getBankAccount("TIME_DEPOSIT");
        accountService4.create(3);
        accountService4.deposit();
        accountService4.withdraw();
```
---

## Patrón Prototype

El **Patrón Prototype** es un patrón de diseño creacional que permite la clonación de objetos, es decir, la creación de una copia exacta de un objeto existente. Este patrón es útil cuando se necesita crear muchas instancias de un objeto similar o cuando la creación de un objeto es costosa en términos de tiempo o recursos.

En lugar de crear nuevos objetos desde el principio, el **Patrón Prototype** permite duplicar un objeto existente y luego modificarlo según sea necesario. Este patrón es particularmente útil cuando se requieren variaciones de un mismo objeto, y la clonación puede ser más eficiente que la creación desde cero.

En este proyecto, se han implementado dos formas del **Patrón Prototype** para la clonación de objetos `BankAccount`:

---

### **Forma 1: Implementación con Interfaz `Prototype`**

En esta implementación, la clase `BankAccount` implementa una interfaz llamada `Prototype` que define el método `clone()`. Esta forma garantiza que cualquier clase que implemente esta interfaz pueda ser clonada.

#### **Componentes de la Implementación**

1. **Interfaz `Prototype`**:
   Define el método `clone()`, que debe ser implementado por cualquier clase que desee ser clonada.

2. **Clase `BankAccount`**:
   Implementa la interfaz `Prototype` y sobrescribe el método `clone()` para crear una nueva instancia de `BankAccount` con los mismos valores de sus propiedades.


### **Forma 2: Implementación con la Interfaz `Cloneable`**

En esta forma, la clase `BankAccountOptional` implementa la interfaz `Cloneable` de Java, que permite la clonación de objetos utilizando el método `clone()` heredado de la clase `Object`.

#### **Componentes de la Implementación**

1. **Interfaz `Cloneable`**:
   Esta es una interfaz marcada de Java que habilita la clonación de objetos utilizando el método `clone()` de la clase `Object`. Si una clase implementa `Cloneable`, significa que el método `clone()` puede ser utilizado para duplicar sus instancias.

2. **Clase `BankAccountOptional`**:
   Implementa la interfaz `Cloneable` y sobrescribe el método `clone()` para permitir la clonación utilizando el método `super.clone()`, que crea una copia superficial del objeto.

#### **Instrucciones para Insertar Código**

Forma 1:
``` java
public interface Prototype {
  Prototype clone();
}
public class BankAccount implements Prototype {

  private String owner;
  private String accountType;
  private double balance;

  public BankAccount(String owner, String accountType, double balance) {
    this.owner = owner;
    this.accountType = accountType;
    this.balance = balance;
  }

  @Override
  public Prototype clone() {
    return new BankAccount(this.owner, this.accountType, this.balance);
  }
  .
  ...
}
```

Forma 2:
``` java
public class BankAccountOptional implements Cloneable {

  private String owner;
  private String accountType;
  private double balance;

  public BankAccountOptional(String owner, String accountType, double balance) {
    this.owner = owner;
    this.accountType = accountType;
    this.balance = balance;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
  .
  ...
}
```

---

## **Patrón Singleton**

El **Patrón Singleton** es un patrón de diseño creacional que asegura que una clase tenga una única instancia y proporciona un punto global de acceso a esa instancia. Este patrón es útil cuando se necesita un control centralizado sobre el acceso a un recurso compartido, como una base de datos o una conexión de red.

El **Patrón Singleton** garantiza que solo haya una instancia de la clase a lo largo de toda la aplicación, evitando la creación de múltiples instancias que puedan generar inconsistencias o desperdicio de recursos.

### **Componentes del Patrón Singleton**

1. **Instancia Privada**: La clase `Connection` tiene una instancia privada estática de sí misma, llamada `instance`. Esta instancia es única y solo se crea cuando es solicitada por primera vez.

2. **Constructor Privado**: El constructor de la clase `Connection` es privado, lo que impide que se puedan crear instancias de la clase directamente desde fuera de ella utilizando `new`.

3. **Método `getInstance()`**: Este método estático proporciona acceso global a la única instancia de la clase. Si la instancia no existe, se crea; si ya existe, se retorna la instancia existente.

4. **Métodos `connect()` y `disconnect()`**: Estos métodos simulan la conexión y desconexión de una base de datos. Son ejemplos de operaciones que pueden realizarse utilizando la instancia única.

### **Instrucciones para Insertar Código**

``` java
    public static void main(String[] args) {
        System.out.println("They are the same instance");
        Connection connection = Connection.getInstance();
        connection.connect();
        connection.disconnect();
        System.out.println(connection);

        Connection otherConnection = Connection.getInstance();
        otherConnection.connect();
        otherConnection.disconnect();
        System.out.println(otherConnection);

        boolean rpta = connection instanceof Connection;
        System.out.println(rpta);
    }
```

---

# Estructural

## **Patrón Adapter**

El **Patrón Adapter** es un patrón de diseño estructural que permite que clases con interfaces incompatibles trabajen juntas. Actúa como un puente entre dos interfaces, adaptando una interfaz existente a otra interfaz que es esperada por el cliente.

En este caso, la clase `PaymentAdapter` actúa como un adaptador entre la interfaz `AccountService` y la interfaz `PaymentService`, permitiendo que se realicen pagos usando una cuenta bancaria.

### **Componentes del Patrón Adapter**

1. **AccountService**: Esta interfaz define las operaciones que pueden realizarse con una cuenta bancaria, como depositar, retirar y obtener el saldo.

2. **PaymentService**: Esta interfaz define el método `make` para realizar pagos, que será utilizado por el cliente para procesar pagos.

3. **SavingsAccount**: Esta clase implementa la interfaz `AccountService`, proporcionando la funcionalidad básica de una cuenta de ahorros, como depósitos, retiros y consulta de saldo.

4. **ExternalPayment**: Esta clase simula un sistema de pago externo que procesa pagos de una cantidad determinada.

5. **PaymentAdapter**: Esta clase adapta la interfaz de pago externa (`ExternalPayment`) para que sea compatible con la interfaz `PaymentService`, permitiendo que se utilice el método `make` para realizar pagos a través de una cuenta.

### **Flujo de Operación**

1. **Crear una cuenta**: Se crea una instancia de `SavingsAccount`, que implementa la interfaz `AccountService`.

2. **Depositar dinero en la cuenta**: El cliente deposita una cantidad en su cuenta usando el método `deposit` de `SavingsAccount`.

3. **Crear un pago externo**: Se crea una instancia de `ExternalPayment`, que simula el procesamiento de pagos.

4. **Adaptar el pago**: Se crea una instancia de `PaymentAdapter`, que adapta la interfaz de `ExternalPayment` para que se pueda usar con la interfaz `PaymentService`.

5. **Realizar un pago**: El cliente usa `PaymentAdapter` para realizar pagos. El adaptador hace uso de `ExternalPayment` para procesar el pago y de `AccountService` para retirar el monto correspondiente de la cuenta.

### **Instrucciones para Insertar Código**

``` java
  public static void main(String[] args) {
    AccountService accountService = new SavingsAccount();
    accountService.deposit(1500.00);
    ExternalPayment externalPayment = new ExternalPayment();

    PaymentAdapter paymentAdapter = new PaymentAdapter(externalPayment, accountService);
    paymentAdapter.make(500.00);
    paymentAdapter.make(2000.00);
  }
```
---

## **Patrón Decorator**

El **Patrón Decorator** es un patrón estructural que permite agregar funcionalidades adicionales a un objeto de manera dinámica. Los decoradores permiten añadir responsabilidades sin modificar el código del objeto original. En este caso, el patrón se utiliza para añadir características como comisiones y intereses a las cuentas bancarias.

### **Componentes del Patrón Decorator**

1. **AccountService**: Esta interfaz define las operaciones que se pueden realizar sobre una cuenta bancaria, como depositar dinero, retirar dinero y consultar el saldo.

2. **AccountServiceImpl**: Esta clase implementa la interfaz `AccountService` y proporciona una implementación básica de una cuenta bancaria, que permite depósitos, retiros y consulta de saldo.

3. **AccountDecorator**: Esta clase abstracta implementa `AccountService` y recibe un objeto de tipo `AccountService` como parámetro. Su función principal es delegar las operaciones del servicio de la cuenta al objeto original.

4. **AccountWithCommission**: Esta clase decoradora agrega una funcionalidad adicional de comisión a la operación de retiro. Cuando se realiza un retiro, también se aplica una comisión.

5. **AccountWithInterest**: Esta clase decoradora agrega la funcionalidad de interés. Permite aplicar intereses sobre el saldo de la cuenta.

### **Flujo de Operación**

1. **Crear una cuenta**: Se crea una instancia de `AccountServiceImpl`, que implementa la interfaz `AccountService` y proporciona la funcionalidad básica de una cuenta bancaria.

2. **Depósito inicial**: Se realiza un depósito inicial en la cuenta.

3. **Agregar interés**: Se crea una instancia de `AccountWithInterest` para decorar la cuenta con la capacidad de aplicar un interés sobre el saldo de la cuenta.

4. **Aplicar interés**: Se llama al método `applyInterest` en la cuenta decorada para aplicar el interés calculado sobre el saldo actual.

5. **Agregar comisión**: Se crea una instancia de `AccountWithCommission` para decorar la cuenta con la capacidad de aplicar una comisión adicional sobre los retiros.

6. **Realizar un retiro**: Se realiza un retiro de dinero de la cuenta decorada. Además de retirar el dinero, se aplica una comisión, y se muestra el saldo actualizado después de cada operación.

### **Instrucciones para Insertar Código**

``` java
    AccountService accountService = new AccountServiceImpl();
    accountService.deposit(1000.00);

    AccountWithInterest accountWithInterest = new AccountWithInterest(accountService, 0.05);
    accountWithInterest.applyInterest();

    AccountWithCommission accountWithCommission = new AccountWithCommission(accountWithInterest,
        4.0);
    accountWithCommission.withdraw(500.0);
```
--- 

## **Patrón Facade**

El **Patrón Facade** es un patrón estructural cuyo objetivo es proporcionar una interfaz unificada y simplificada a un conjunto de interfaces más complejas en un subsistema. En este proyecto, el patrón Facade se utiliza para ocultar la complejidad de los servicios bancarios, como la creación de cuentas, las transacciones y el envío de notificaciones, bajo una interfaz sencilla.

### **Componentes del Patrón Facade**

1. **AccountService**: Esta clase proporciona la funcionalidad para crear cuentas bancarias. Tiene un método `create` que permite la creación de una cuenta para un titular específico y un tipo de cuenta.

2. **NotificationService**: Esta clase se encarga de enviar notificaciones a los usuarios. Tiene un método `send` para enviar un mensaje a una dirección de correo electrónico.

3. **TransactionService**: Esta clase maneja las transacciones entre cuentas bancarias. Tiene un método `carryOut` que realiza una transferencia de dinero de una cuenta a otra.

4. **BankingProcessFacade**: Esta es la clase Facade que centraliza las operaciones complejas de las clases `AccountService`, `TransactionService` y `NotificationService`. Proporciona dos métodos:
    - `openAccount`: para crear una cuenta bancaria y enviar una notificación de confirmación.
    - `transferFunds`: para realizar una transferencia de fondos entre cuentas y notificar al usuario.

### **Flujo de Operación**

1. **Abrir una Cuenta**: Cuando un usuario desea abrir una cuenta, la fachada `BankingProcessFacade` se encarga de llamar al servicio de creación de cuenta (`AccountService`), así como al servicio de notificación (`NotificationService`) para enviar un correo de confirmación.

2. **Transferir Fondos**: Cuando un usuario realiza una transferencia, la fachada gestiona la interacción con el servicio de transacciones (`TransactionService`) y luego notifica al usuario sobre la transferencia realizada mediante `NotificationService`.

### **Instrucciones para Insertar Código**

``` java
    BankingProcessFacade bankingProcessFacade = new BankingProcessFacade();
    bankingProcessFacade.openAccount("test user", "Ahorro", "test@gmail.com");
    bankingProcessFacade.transferFunds("123456", "987654", 250.00, "test@gmail.com");

    BankingProcessFacade bankingProcessFacade2 = new BankingProcessFacade();
    bankingProcessFacade2.openAccount("test user 2", "Ahorro", "test2@gmail.com");
    bankingProcessFacade2.transferFunds("456456", "987654", 600, "test2@gmail.com");
```

---

## **Patrón Proxy**

El **Patrón Proxy** es un patrón estructural cuyo objetivo es proporcionar un sustituto o intermediario para un objeto real. El Proxy controla el acceso a un objeto real, permitiendo o denegando el acceso según ciertas condiciones. En este proyecto, el patrón Proxy se utiliza para gestionar el acceso a la consulta de saldo de una cuenta bancaria, verificando si el usuario tiene permiso para ver la información.

### **Componentes del Patrón Proxy**

1. **ConsultAccountService**: Es una interfaz que define los métodos que el servicio real y el proxy deben implementar. Incluye métodos como `showData` para mostrar la información de la cuenta y `getBalance` para obtener el saldo.

2. **ConsultAccountServiceImpl**: Es la implementación real del servicio que gestiona la consulta del saldo de una cuenta bancaria. Al crear una instancia de esta clase, se simula un cliente con un saldo determinado.

3. **ConsultAccountServiceProxy**: Es el Proxy que controla el acceso al servicio real `ConsultAccountServiceImpl`. Verifica si el usuario tiene permiso para consultar el saldo de una cuenta y, si no tiene permiso, deniega el acceso. Si tiene permiso, delega la consulta al servicio real.

### **Flujo de Operación**

1. **Acceso Controlado**: Cuando un usuario intenta acceder a los datos de una cuenta bancaria, el proxy verifica si el usuario tiene permisos para realizar la consulta.

2. **Consulta con Permiso**: Si el usuario tiene permisos, el proxy delega la consulta al servicio real, que obtiene y muestra el saldo de la cuenta.

3. **Consulta Sin Permiso**: Si el usuario no tiene permisos, el proxy muestra un mensaje de acceso denegado sin acceder a la información real del servicio.

### **Instrucciones para Insertar Código**

``` java
  ..
  @Override
  public void showData() {
    if (Boolean.FALSE.equals(permission)) {
      System.out.println(
          "Acceso denegado: no tiene permiso para consultar el saldo del cliente: " + client);
      return;
    }

    if (consultAccountService == null) {
      consultAccountService = new ConsultAccountServiceImpl(client); // Saldo simulado
    }

    System.out.println("El saldo del cliente: " + client + " es: " + getBalance());
  }
  ..
  
  public static void main(String[] args) {
    ConsultAccountService consultAccountService = new ConsultAccountServiceProxy("123456", true);
    consultAccountService.showData();

    ConsultAccountService consultAccountServiceProxy2 = new ConsultAccountServiceProxy("987654",
        false);
    consultAccountServiceProxy2.showData();
  }

```

---

# Comportamiento

## **Patrón Command**

El **Patrón Command** es un patrón de comportamiento que convierte una solicitud en un objeto, lo que permite parametrizar a los clientes con diferentes solicitudes, colas de solicitudes y registro de solicitudes. En este proyecto, las operaciones sobre la cuenta bancaria (depósitos y retiros) se implementan como comandos que pueden ser invocados sin necesidad de que el cliente interactúe directamente con el código que realiza las operaciones.

### **Componentes del Patrón Command**

1. **IOperation**: Es una interfaz funcional que declara el método `execute`, que se implementa en cada comando (por ejemplo, depósito o retiro). Todos los comandos deben implementar este método.

2. **DepositImpl**: Es una implementación del comando que realiza un depósito en una cuenta. Implementa la interfaz `IOperation` y define el comportamiento de la operación de depósito.

3. **WithDrawImpl**: Es una implementación del comando que realiza un retiro de una cuenta. Implementa la interfaz `IOperation` y define el comportamiento de la operación de retiro.

4. **Invoker**: Es el invocador de los comandos. Recibe los objetos de comando y los almacena en una lista. Luego, puede ejecutar todas las operaciones almacenadas llamando a su método `execute`. El invocador se encarga de ejecutar las operaciones en el orden que fueron recibidas.

5. **Account**: Es la clase que representa una cuenta bancaria. Contiene métodos para realizar operaciones de depósito y retiro, que son invocados por los comandos `DepositImpl` y `WithDrawImpl`.

### **Flujo de Operación**

1. **Creación de la Cuenta**: Se crea una cuenta con un saldo inicial.
2. **Creación de los Comandos**: Se crean los objetos de comando `DepositImpl` y `WithDrawImpl` con los parámetros necesarios (la cuenta y el monto).
3. **Recepción de los Comandos**: El invocador recibe los comandos y los almacena en una lista.
4. **Ejecución de las Operaciones**: El invocador ejecuta todas las operaciones almacenadas llamando a su método `execute`, lo que realiza las operaciones de depósito y retiro en la cuenta.

### **Instrucciones para Insertar Código**

``` java
  public static void main(String[] args) {
    Account account = new Account(1, 200);

    DepositImpl deposit = new DepositImpl(account, 500);
    WithDrawImpl withDraw = new WithDrawImpl(account, 280);

    Invoker invoker = new Invoker();
    invoker.receiveOperation(deposit);
    invoker.receiveOperation(withDraw);

    invoker.executeOperations();
  }
```

--- 

## **Patrón Memento**

El **Patrón Memento** es un patrón de comportamiento que permite capturar y almacenar el estado interno de un objeto sin alterar su estructura. Posteriormente, el estado guardado puede ser restaurado. En este proyecto, el patrón se usa para almacenar el estado de una cuenta bancaria y restaurarlo en caso de que sea necesario (por ejemplo, si el usuario quiere deshacer ciertas operaciones).

### **Componentes del Patrón Memento**

1. **Transaction**: Representa una transacción realizada en la cuenta bancaria, que puede ser un depósito o un retiro. Guarda el tipo de transacción y el monto asociado.

2. **MementoTransaction**: Es el memento que guarda el estado de la cuenta bancaria en un momento dado, incluyendo el saldo y las transacciones realizadas hasta ese momento. Proporciona métodos para acceder a este estado guardado.

3. **BankAccount**: Representa la cuenta bancaria. Permite realizar depósitos y retiros, y tiene la capacidad de guardar su estado mediante el memento y restaurarlo cuando sea necesario.

4. **Main**: En el `main`, se crean objetos de la cuenta bancaria, se realizan operaciones y luego se restaura el estado utilizando el memento guardado.

### **Flujo de Operación**

1. **Creación de la Cuenta Bancaria**: Se crea una cuenta bancaria con un saldo inicial.
2. **Guardar el Estado de la Cuenta**: Se guarda el estado de la cuenta en un memento antes de realizar operaciones.
3. **Realizar Operaciones**: Se realizan operaciones de depósito y retiro en la cuenta bancaria.
4. **Restaurar el Estado**: Se restaura el estado de la cuenta desde el memento guardado, lo que revierte las operaciones realizadas.

### **Instrucciones para Insertar Código**

``` java
  public static void main(String[] args) {
    BankAccount bankAccount = new BankAccount(10000);
    MementoTransaction mementoTransaction = bankAccount.saveState();

    bankAccount.deposit(1500);
    bankAccount.withdraw(3800);

    bankAccount.restoreState(mementoTransaction);
  }

```
---


## **Patrón  Observer**

El **Patrón Observer** es un patrón de comportamiento que define una relación de uno a muchos entre objetos, de modo que cuando un objeto cambia su estado, todos los objetos dependientes (observadores) son notificados y actualizados automáticamente.

### **Componentes del Patrón Observer**

1. **Subject (Sujeto)**: El objeto que mantiene el estado (en este caso, el monto en dólares) y notifica a los observadores cuando este estado cambia. En este ejemplo, el `Subject` es la clase que gestiona el monto de los dólares.

2. **ObserverAbs (Observador Abstracto)**: La clase abstracta que define el método `update()`, el cual será implementado por los observadores concretos. Los observadores reciben las notificaciones cuando el `Subject` cambia su estado.

3. **SolPerObserver, PesoMexObserver, PesoArgObserver (Observadores Concretos)**: Estas son las clases concretas de observadores que implementan el método `update()` y realizan los cálculos de conversión en diferentes monedas. Cada uno tiene un valor de tipo de cambio específico para convertir los dólares en su respectiva moneda.

4. **Main**: El método `main` crea una instancia del `Subject`, suscribe a varios observadores (que representan diferentes monedas) y actualiza el monto en dólares. Luego, cada observador calcula y muestra el monto en la moneda correspondiente.

### **Flujo de Operación**

1. **Creación del Sujeto**: Se crea un objeto `Subject` que contiene el monto en dólares.
2. **Creación de los Observadores**: Se crean varios observadores (por ejemplo, `SolPerObserver`, `PesoMexObserver`, `PesoArgObserver`), los cuales se suscriben al `Subject` para ser notificados cuando el monto cambie.
3. **Cambio del Estado del Sujeto**: Se actualiza el monto en dólares a través del método `setAmount()`, lo que provoca que todos los observadores reciban una notificación.
4. **Notificación de los Observadores**: Cada observador calcula el monto correspondiente en su moneda y muestra el resultado.

### **Instrucciones para Insertar Código**

``` java
    public static void main(String[] args) {
        Subject subject = new Subject();
        new SolPerObserver(subject);
        new PesoArgObserver(subject);
        new PesoMexObserver(subject);
        System.out.println("Si desea cambiar 10 d�lares obtendr� : ");
        subject.setAmount(10.0);
        System.out.println("-----------------");
        System.out.println("Si desea cambiar 100 d�lares obtendr� : ");
        subject.setAmount(100.0);
    }
```
---

## **Strategy**

El **Patrón Strategy** es un patrón de comportamiento que permite a un objeto seleccionar un algoritmo de manera dinámica. Se utiliza cuando se tienen varias formas de realizar una tarea y se desea cambiar entre ellas sin modificar el código que usa la estrategia.

### **Componentes del Patrón Strategy**

1. **Strategy (Interfaz de Estrategia)**: Define el comportamiento común para las distintas estrategias. En este caso, la interfaz `TransactionStrategyService` define un método común `doTransaction()` que las clases concretas implementarán.

2. **Concrete Strategy (Estrategias Concretas)**: Las clases concretas implementan la interfaz de estrategia y definen el comportamiento específico. En este ejemplo, las clases `WithdrawalServiceImpl` (para retiros) y `DepositServiceImpl` (para depósitos) son las estrategias concretas.

3. **Context (Contexto)**: La clase `TransactionProcess` utiliza un objeto que implementa la interfaz de estrategia. El contexto puede cambiar la estrategia de manera dinámica mediante el método `setStrategy()`, y luego delega la ejecución de la transacción a la estrategia activa.

### **Flujo de Operación**

1. **Definir Estrategias**: Se definen las estrategias concretas, como `WithdrawalServiceImpl` y `DepositServiceImpl`, que contienen la lógica específica para realizar depósitos y retiros, respectivamente.

2. **Configurar Estrategia en Contexto**: La clase `TransactionProcess` actúa como el contexto y tiene un objeto de tipo `TransactionStrategyService`. Se configura la estrategia en tiempo de ejecución mediante el método `setStrategy()`.

3. **Ejecutar Estrategia**: Cuando se invoca el método `doTransaction()` en el contexto, se delega la ejecución a la estrategia activa (ya sea de depósito o retiro).

### **Instrucciones para Insertar Código**

``` java
  public static void main(String[] args) {
    TransactionProcess transactionProcess = new TransactionProcess();
    // init strategy
    transactionProcess.setStrategy(new DepositServiceImpl());
    transactionProcess.doTransaction(500.00);

    // change strategy
    transactionProcess.setStrategy(new WithdrawalServiceImpl());
    transactionProcess.doTransaction(300.00);
  }
```

---

## Autor

- **Nombre**: Alexi Acuña
- **Rol**: Desarrollador Principal
- **Descripción**: Desarrollador de software con experiencia en aplicaciones Java y Spring Boot.
  Apasionado por la creación de soluciones eficientes y escalables.
- **GitHub**: [github.com/alexi-ae](https://github.com/alexi-ae)
- **LinkedIn**: [linkedin.com/in/ronald-alexi-ae](https://www.linkedin.com/in/ronald-alexi-ae/)