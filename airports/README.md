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


### @RestController


### @Service
O comando ***@Service*** antes de uma classe, indica que ela contém uma lógica de negócio;

### @Autowired
O comando ***@Autowired*** injeta automaticamente, neste caso, a interface *AirportRepository*. Seria uma abreviação de ``AirportRepository airportRepository = new AirportRepository();``. Ele injeta a dependência dentro da classe.

### @PathVariable


### @GetMapping


### @RequestBody


### @RequestParam