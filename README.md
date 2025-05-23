﻿## Agendamento_trancas
 # Diagrama de Classes
```mermaid
classDiagram
    class Cliente {
        +Long id
        +String nome
        +String telefone
        +String email
        +String endereco
    }

    class ModeloTranca {
        +Long id
        +String nome
        +String descricao
        +Double precoBase
        +String imagemUrl
    }

    class Material {
        +Long id
        +String nome
        +String descricao
        +Boolean fornecidoPeloCliente
    }

    class LocalAtendimento {
        +Long id
        +String nome
        +String endereco
    }

    class Agendamento {
        +Long id
        +LocalDateTime dataAgendamento
        +Double valorTotal
        +Boolean sinalPago
    }

    class Pagamento {
        +Long id
        +Double valor
        +LocalDateTime dataPagamento
        +String metodo
        +Boolean confirmado
    }

    Cliente --> Agendamento : realiza
    ModeloTranca --> Agendamento : escolhido em
    Material --> Agendamento : utiliza
    LocalAtendimento --> Agendamento : ocorre em
    Agendamento --> Pagamento : gera

```
