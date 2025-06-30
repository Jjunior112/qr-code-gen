# 📦 Gerador de QR Code com Integração ao AWS S3

Este projeto é uma aplicação Java que gera códigos QR personalizados a partir de entradas fornecidas pelo usuário e os armazena automaticamente em um bucket da AWS S3. Ideal para aplicações que precisam gerar e armazenar QR codes de forma segura, escalável e automatizada.

## Funcionalidades

- Geração de QR Code a partir de texto, URLs ou qualquer entrada em string
- Upload automático da imagem gerada para um bucket S3
- Retorno da URL pública ou privada do QR Code armazenado
- Estrutura modular e escalável
- Utilização de variáveis de ambiente para maior segurança

## Tecnologias Utilizadas

- Java 21+
- Maven
- [ZXing](https://github.com/zxing/zxing) – Biblioteca para geração de QR Code
- AWS SDK for Java – Integração com o Amazon S3
- Docker (opcional)

## Estrutura do Projeto

```
qr-code-generator/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── qr_code_gen/
│   │   │       ├── controllers/
│   │   │       ├── dto/
│   │   │       │   └── qrcode/
│   │   │       ├── infrastructure/
│   │   │       ├── ports/
│   │   │       └── services/
│   │   └── resources/
│   └── test/
├── .env
├── Dockerfile
├── pom.xml
└── README.md

```

## Configuração

Antes de executar o projeto, configure as credenciais da AWS. Você pode fazer isso via variáveis de ambiente ou um arquivo `.env`.

Exemplo `.env`:

```env
AWS_ACCESS_KEY_ID=your_access_key
AWS_SECRET_ACCESS_KEY=your_secret_key

```
Por não se tratar de informaçẽos confidenciais, essas informações foram injetadas no `Dockerfile`.
```env
AWS_REGION=us-east-1
S3_BUCKET_NAME=your_bucket_name
```


## Executando o Projeto

### Usando Maven

```bash
mvn clean package
java -jar target/qr-code-generator.jar
```

### Usando Docker

```bash
docker build -t qr-code-generator:1.0 .
docker run --env-file .env qr-code-generator
```

## Exemplo de Funcionamento

1. Usuário envia uma string contendo a URL.
2. A aplicação gera um QR Code correspondente em formato PNG.
3. O arquivo é salvo localmente (temporariamente).
4. A imagem é enviada automaticamente ao bucket S3 especificado.
5. A URL do arquivo no S3 é retornada para uso ou exibição.

## QrCode gerado pelo projeto

![Captura de tela de 2025-06-30 20-26-11](https://github.com/user-attachments/assets/d195e134-9f05-42b9-95e5-8d911f7c1965)



## Licença

Distribuído sob a licença MIT. Veja o arquivo `LICENSE` para mais informações.
