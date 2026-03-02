# Airports API
A API oferece três serviços ***REST*** distintos para a busca de aeroportos, cada um especializado em um critério de pesquisa: cidade, país ou código IATA. As buscas retornam uma lista de aeroportos correspondentes em formato JSON. Em caso de sucesso, a lista contém um ou mais aeroportos. Se a busca não encontrar resultados, a resposta é vazia.

## Arquitetura
### *Endpoint* Airport
Retorna os dados completos de TODOS os aeroportos cadastrados na base de dados. Utiliza a URI ***/airports/airport***.

### *Endpoint CitySearch*
Lida com buscas por cidade, utilizando a URI ***/airports/city/{cidade}***. O parâmetro *{cidade}* representa o nome da cidade desejada, e a busca é realizada de forma ***case-insensitive***, ou seja, "Brasilia", "brasilia" e "BRASILIA" retornam o mesmo resultado.

### *Endpoint CountrySearch*
Similar ao *CitySearch*, lida com buscas por país, utilizando a URI ***/airports/country/{pais}***. Iremos retornar apenas o nome do aeroporto, código IATA e a cidade.

### *Endpoint IataCodeSearch*
Lida com buscas pro código IATA, utilizando a URI ***/airports/iata/{iataCode}***. Iremos devolver os dados completo do aeroporto.

### *Endpoint nearMe* (próximos a mim)
Este *endpoint* buscará o aeroporto mais próximo, utilizando a URI: ***/airports/nearme***. O *endpoint* irá receber dados da sua latitude e longitude (no corpo da requisição) e irá devolver uma lista de aeroportos ordenada por distância referente ao seu ponto, do mais próximo até o mais distante, limitado a 10 aeroportos.

## Novos Comandos Aprendidos
### ResponseEntity<Objeto>
É uma classe utilizada pelo Spring Framework, representando toda a resposta HTTP em métodos de um ***@RestController***. Ela permite o controle total e, especialmente, o corpo da resposta (*body*), o código de status HTTP (*status code*) e os cabeçalhos (*headers*) 

### @RestController
Anuncia ao Spring que aquela classe vai ser um *Controller*, e que haverá *endpoints* nela.

### @Service
O comando ***@Service*** antes de uma classe, indica que ela contém uma lógica de negócio.

### @Autowired
O comando ***@Autowired*** injeta automaticamente, neste caso, a interface *AirportRepository*. Seria uma abreviação de ``AirportRepository airportRepository = new AirportRepository();``. Ele injeta a dependência dentro da classe.

### @PathVariable
Mapeia a variável recebida na URI *cityName* como uma String. Assim ela pode ser utilizada dentro do método. é obrigatório o mesmo nome declarado entre {} do ***@GetMapping***.

### @GetMapping
Indica que o método a seguir corresponde ao *endpoint* do caminho estipulado.

### @RequestBody
É utilizada para mapear o corpo de uma requisição HTTP diretamente para um objeto JAVA. Ela é fundamental na criação de APIs RESTful, permitindo que o framework converta automaticamente os dados enviados pelo cliente no formato de rede para um objeto manipulável no *Controller*.

### @RequestParam
É utilizada para extrair parâmetros de consulta (query parameters) da URL ou dados de formulário enviados em uma requisição HTTP e vinculá-los aos parâmetros de um método no seu *Controller*.